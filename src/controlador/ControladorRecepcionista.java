/*
 Controlador con el cual se manejan todos los enventos, datos y validaciones 
    para las pantallas del usuario Recepcionista
 */
package controlador;

import modelo.ModeloRecepcionista;
import vista.Desktop_Recepcionista;
import vista.IF_RecepcionistaAgregarPaciente;
import vista.IF_RecepcionistaEditarPaciente;
import vista.IF_RecepcionistaCitas;
import vista.IF_RecepcionistaNuevaCita;
import vista.IF_RecepcionistaPacientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.*;
import javax.swing.ImageIcon;
import org.joda.time.*;

/**
 *
 * @author jose_
 */
public class ControladorRecepcionista implements ActionListener, MouseListener {
    private ModeloRecepcionista modelo;
    private Desktop_Recepcionista vistaDesktop;
    private IF_RecepcionistaAgregarPaciente AP2;
    private IF_RecepcionistaEditarPaciente REP;
    private IF_RecepcionistaCitas I;
    private IF_RecepcionistaNuevaCita NC;
    private IF_RecepcionistaPacientes RP;
    private int IDCITA;
    public int banderaSalida;
    private String idEmp;
    private String nomEmp;
    
    public ControladorRecepcionista(ModeloRecepcionista modelo, Desktop_Recepcionista vistaDesktop, IF_RecepcionistaAgregarPaciente AP, IF_RecepcionistaEditarPaciente REP, IF_RecepcionistaCitas I, IF_RecepcionistaNuevaCita NC, IF_RecepcionistaPacientes RP, String nombreRec, String idRec){
        this.modelo = modelo;
        this.vistaDesktop = vistaDesktop;
        this.AP2 = AP;
        this.REP = REP;
        this.I = I;
        this.NC = NC;
        this.RP = RP;
        this.IDCITA = -1;
        this.banderaSalida = 0;
        this.idEmp = idRec;
        this.nomEmp = nombreRec;
        this.vistaDesktop.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoInicio.png")).getImage());
        
        this.vistaDesktop.Recepcionista_Recepcionista_Nombre_Lbl.setText(nombreRec);
        
        this.vistaDesktop.Recepcionista_Desktop_Agregar_Btn.addActionListener(this);
        this.vistaDesktop.Recepcionista_Desktop_Cita_Btn.addActionListener(this);
        this.vistaDesktop.Recepcionista_Desktop_Editar_Btn.addActionListener(this);
        this.vistaDesktop.Recepcionista_Desktop_Inicio_Btn.addActionListener(this);
        this.vistaDesktop.Recepcionista_Desktop_Pacientes_Btn.addActionListener(this);
        this.vistaDesktop.Recepcionista_Recepcionista_Salir_Btn.addActionListener(this);
        
        this.vistaDesktop.Recepcionista_Inicio_Escritorio_Desktop.add(AP);
        this.vistaDesktop.Recepcionista_Inicio_Escritorio_Desktop.add(REP);
        this.vistaDesktop.Recepcionista_Inicio_Escritorio_Desktop.add(I);
        this.vistaDesktop.Recepcionista_Inicio_Escritorio_Desktop.add(NC);
        this.vistaDesktop.Recepcionista_Inicio_Escritorio_Desktop.add(RP);
        
        this.AP2.show();
        this.REP.show();
        this.I.show();
        this.NC.show();
        this.RP.show();
        
        this.AP2.setLocation(-6, -25);
        this.REP.setLocation(-6, -25);
        this.I.setLocation(-6, -35);
        this.NC.setLocation(-6, -35);
        this.RP.setLocation(-6, -35);
        this.I.toFront();
        
        this.I.Recepcionista_Inicio_Filtrar_CBox.addActionListener(this);
        this.I.Recepcionista_Inicio_Finalizar_Btn.addActionListener(this);
        this.AP2.Recepcionista_Agregar_Agregar_Btn.addActionListener(this);
        this.AP2.Recepcionista_Agregar_Limpiar_Btn.addActionListener(this);
        this.REP.Recepcionista_Editar_GuardarCambios_Btn.addActionListener(this);
        this.NC.Recepcionista_Cita_Agendar_Btn.addActionListener(this);
        this.NC.Recepcionista_Cita_TablaCita_Table.addMouseListener(this);
        this.I.Recepcionista_Inicio_TablaInicio_Table.addMouseListener(this);
        this.REP.Recepcionista_Editar_TablaEditar_Table.addMouseListener(this);
        this.RP.Recepcionista_Pacientes_TablaPacientes_Table.addMouseListener(this);
        
        
    }
    public void IniciarVista(){
        vistaDesktop.setTitle("Medic-Zone - Recepcionista");
        vistaDesktop.pack();
        vistaDesktop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        I.Recepcionista_Inicio_TablaInicio_Table.setModel(modelo.CitasConsultar("De hoy"));
        vistaDesktop.setLocationRelativeTo(null);
        vistaDesktop.setVisible(true);  
    }
    
    public void finalizarVista()
    {
        this.banderaSalida = 1;
        this.vistaDesktop.setVisible(false);
        this.vistaDesktop.dispose();
    }
    
    public void LimpiarCampos(){
        AP2.Agregar_ApellidoM_Txt.setText("");
        AP2.Agregar_ApellidoP_Txt.setText("");
        AP2.Agregar_Celular_Txt.setText("");
        AP2.Agregar_Correo_Txt.setText("");
        AP2.Agregar_Curp_Txt.setText("");
        AP2.Agregar_Direccion_Txt.setText("");
        AP2.Agregar_Nombres_Txt.setText("");
        AP2.Agregar_Telefono_Txt.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== vistaDesktop.Recepcionista_Desktop_Inicio_Btn)
        {
            I.Recepcionista_Inicio_TablaInicio_Table.setModel(modelo.CitasConsultar(I.Recepcionista_Inicio_Filtrar_CBox.getSelectedItem().toString()));
            I.toFront();
        }
        if(e.getSource()== vistaDesktop.Recepcionista_Desktop_Cita_Btn)
        {
            NC.Recepcionista_Cita_TablaCita_Table.setModel(modelo.NuevaCitaConsultar());
            NC.toFront();
        }
        if(e.getSource()== AP2.Recepcionista_Agregar_Agregar_Btn){
            if(vaciosONoTxt(AP2.Agregar_ApellidoM_Txt, AP2.Agregar_ApellidoP_Txt, AP2.Agregar_Celular_Txt, AP2.Agregar_Correo_Txt, AP2.Agregar_Curp_Txt, AP2.Agregar_Curp_Txt, AP2.Agregar_Direccion_Txt, AP2.Agregar_Nombres_Txt, AP2.Agregar_Telefono_Txt))
            {
                
                if(modelo.InsertarPacientes(AP2.Agregar_Nombres_Txt.getText(), AP2.Agregar_ApellidoP_Txt.getText(),AP2.Agregar_ApellidoM_Txt.getText(), FechaAFormatoBD(AP2.Agregar_FechaN_CBox), obtenerEdadDeJXDate(AP2.Agregar_FechaN_CBox), AP2.Agregar_Correo_Txt.getText(), AP2.Agregar_Direccion_Txt.getText(), AP2.Agregar_Telefono_Txt.getText(), AP2.Agregar_Celular_Txt.getText(), AP2.Agregar_Genero_CBox.getSelectedItem().toString(), AP2.Agregar_Curp_Txt.getText(), AP2.Agregar_EstadoCivil_CBox.getSelectedItem().toString()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro insertado exitosamente");
                    this.LimpiarCampos();
                }
            }
            else{
                 JOptionPane.showMessageDialog(null, " ¡ERROR!: Campos vacios o caracteres invalidos");
            }
        }
        if(e.getSource()== NC.Recepcionista_Cita_Agendar_Btn)
        {
            if(vaciosONoTxt(NC.Recepcionista_Cita_Descripcion_Txt,NC.Recepcionista_Cita_Curp_Txt,NC.Recepcionista_Cita_idPaciente_Txt))
            {
                if(modelo.InsertarCita(FechaAFormatoBD(NC.Recepcionista_Cita_FechaN_CBox), HoraAFormatoBD(NC.Recepcionista_Cita_Hora_Spinner), NC.Recepcionista_Cita_idPaciente_Txt.getText(),this.idEmp,NC.Recepcionista_Cita_Descripcion_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro insertado exitosamente");
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Error: Llene todos los campos y con caracteres validos");
            
        }
        if(e.getSource()== I.Recepcionista_Inicio_Filtrar_CBox){
            String filtrarpor = I.Recepcionista_Inicio_Filtrar_CBox.getSelectedItem().toString();
            I.Recepcionista_Inicio_TablaInicio_Table.setModel(modelo.CitasConsultar(filtrarpor));
        }
        if(e.getSource()== I.Recepcionista_Inicio_Finalizar_Btn){
            System.out.println(IDCITA);
            if(IDCITA!=-1){
                
                if(modelo.cambiarcita(IDCITA))
                {
                    JOptionPane.showMessageDialog(null, "Cita finalizada");
                    String filtrarpor = I.Recepcionista_Inicio_Filtrar_CBox.getSelectedItem().toString();
                    I.Recepcionista_Inicio_TablaInicio_Table.setModel(modelo.CitasConsultar(filtrarpor));
                    IDCITA = -1;
                }
            }
        }
        if(e.getSource()== AP2.Recepcionista_Agregar_Limpiar_Btn){
            this.LimpiarCampos();
        }
        if(e.getSource()== vistaDesktop.Recepcionista_Desktop_Agregar_Btn)
        {
            AP2.toFront();
        }
        if(e.getSource()== vistaDesktop.Recepcionista_Desktop_Editar_Btn)
        {
            REP.Recepcionista_Editar_TablaEditar_Table.setModel(modelo.RecepcionistaPacientesConsultar());
            REP.toFront();
        }
        
        if(e.getSource() == REP.Recepcionista_Editar_GuardarCambios_Btn){
            if(modelo.PacientesActualizar(REP.Recepcionista_Editar_Id_Txt.getText(),REP.Recepcionista_Editar_Nombre_Txt.getText(),REP.Recepcionista_Editar_ApellidoPaterno_Txt.getText(),REP.Recepcionista_Editar_ApellidoMaterno_Txt.getText(),FechaAFormatoBD(REP.Recepcionista_Editar_FechaN_DPicker),REP.Recepcionista_Editar_Correo_Txt.getText(),REP.Recepcionista_Editar_Direccion_Txt.getText(),REP.Recepcionista_Editar_Telefono_Txt.getText(),REP.Recepcionista_Editar_Celular_Txt.getText(),REP.Recepcionista_Editar_Genero_CBox.getSelectedItem().toString(),REP.Recepcionista_Editar_Curp_Txt.getText(),REP.Recepcionista_Editar_EstadoCivil_CBox.getSelectedItem().toString()));
            {
                JOptionPane.showMessageDialog(null, "Resgistro modificado exitosamente");
                REP.Recepcionista_Editar_TablaEditar_Table.setModel(modelo.RecepcionistaPacientesConsultar());
            }
        }
        
        if(e.getSource()== vistaDesktop.Recepcionista_Desktop_Pacientes_Btn)
        {
            RP.Recepcionista_Pacientes_TablaPacientes_Table.setModel(modelo.RecepcionistaPacientesConsultar());
            RP.toFront();
        }
        if(e.getSource()== vistaDesktop.Recepcionista_Recepcionista_Salir_Btn){
            finalizarVista();
        }
    }
    public boolean vaciosONoTxt(javax.swing.JTextField... args)
    {
        
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9@. _]*$");
        Matcher matcher;
        for(javax.swing.JTextField arg : args){
            System.out.println(arg.getText());
            matcher = pattern.matcher(arg.getText());
            if(!arg.getText().equals("") && matcher.matches())
                ;
            else
                return false;
        }
        return true;
    }
    public Date StringBD_a_HoraParaInput(String horaDeBD){
        
        String[] fechaHora = new String[2];
        fechaHora = horaDeBD.split(" ");
        
        String[] HoraBasura = new String[3];
        HoraBasura = fechaHora[1].split(":");
        
        String HoraBien = HoraBasura[0];
        String MinutoBien = HoraBasura[1];

        int horaN = Integer.parseInt(HoraBien);
        String AMoPM = " AM";
        
        if(horaN>11)// 00 son las 12 am, entonces si es mayor a 11 debe ser pm
        AMoPM = " PM";
        
        if(horaN>12)// si es mayor a 12 (ya sera pm por el if anterior), si es mayor a 12 se le resta 12 para que sea 5 en vez de 17
        horaN = horaN - 12;
        
        if(horaN==0)// si es 00 pues en realidad seran las 12 AM
        horaN = 12;
        
        String HoraParaLaCosa = Integer.toString(horaN) + ":" + MinutoBien + AMoPM;
                
        SimpleDateFormat formato = new SimpleDateFormat("h:mm a");
        Date date1 = null;
        
        try {
            date1 = formato.parse(HoraParaLaCosa);
            return date1;
            
        } catch (ParseException ex) {
            return null;
        }
    }
    public String HoraAFormatoBD( javax.swing.JSpinner horaSpinner){
        DateTime dt = new DateTime(horaSpinner.getValue());
        int horaN = dt.getHourOfDay();
        int minutoN = dt.getMinuteOfHour();
        String hora = Integer.toString(horaN);
        String minuto = Integer.toString(minutoN);
        
        if(horaN<10)
            hora = "0" + hora;
        if(minutoN<10)
            minuto = "0" + minuto;
        
        return "0000-00-00 " + hora + ":" + minuto;
        
    }
    public Date StringBD_a_DateParaInput(String fechaDeBD){
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        
        try {
            date1 = formato.parse(fechaDeBD);
            return date1;
            
        } catch (ParseException ex) {
            return null;
        }
        
    }
    public String FechaAFormatoBD( org.jdesktop.swingx.JXDatePicker fecha){
        
        DateTime dt = new DateTime(fecha.getDate());
        int anoN = dt.getYear();
        int mesN = dt.getMonthOfYear();
        int diaN = dt.getDayOfMonth();
        String anoS = Integer.toString(anoN);
        String mesS = Integer.toString(mesN);
        String diaS = Integer.toString(diaN);
        
        //para que salga 0 si es menor a 10 el dia o el mes
        if(mesN<10)
            mesS = "0" + mesS;
        if(diaN<10)
            diaS = "0" + diaS;
        
        return anoS + "-" + mesS + "-" + diaS;
    }
    public String obtenerEdadDeJXDate( org.jdesktop.swingx.JXDatePicker fechaJXDate1)
    {
        long nac = fechaJXDate1.getDateInMillis();
        long hoy = new Date().getTime();
        LocalDate fechaNac = new LocalDate(nac);
        LocalDate fechaHoy = new LocalDate(hoy);
        Years edad  = Years.yearsBetween(fechaNac, fechaHoy);
        return Integer.toString(edad.getYears());
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(NC.Recepcionista_Cita_TablaCita_Table == me.getSource())
        {
            int fila = NC.Recepcionista_Cita_TablaCita_Table.rowAtPoint(me.getPoint());
            if(fila > -1)
            {
                NC.Recepcionista_Cita_Paciente_Txt.setText(NC.Recepcionista_Cita_TablaCita_Table.getValueAt(fila, 0).toString());
                NC.Recepcionista_Cita_Curp_Txt.setText(NC.Recepcionista_Cita_TablaCita_Table.getValueAt(fila, 3).toString());
                NC.Recepcionista_Cita_idPaciente_Txt.setText(modelo.PacientesObtenerDato("CURP",NC.Recepcionista_Cita_Curp_Txt.getText(),"Id"));
            }
        }
        if(I.Recepcionista_Inicio_TablaInicio_Table == me.getSource()){
            int fila = I.Recepcionista_Inicio_TablaInicio_Table.rowAtPoint(me.getPoint());
            System.out.println(fila + 0);
            IDCITA = Integer.parseInt(String.valueOf(I.Recepcionista_Inicio_TablaInicio_Table.getValueAt(fila, 0)));
            System.out.println("Id: "+IDCITA );
        }
        if(me.getSource() == REP.Recepcionista_Editar_TablaEditar_Table){
            int fila = REP.Recepcionista_Editar_TablaEditar_Table.rowAtPoint(me.getPoint());
            String idBusqueda = String.valueOf(REP.Recepcionista_Editar_TablaEditar_Table.getValueAt(fila, 1));
            REP.Recepcionista_Editar_Id_Txt.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Id"));
            REP.Recepcionista_Editar_Nombre_Txt.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Nombre"));
            REP.Recepcionista_Editar_ApellidoPaterno_Txt.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Apellido paterno"));
            REP.Recepcionista_Editar_ApellidoMaterno_Txt.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Apellido materno"));
            REP.Recepcionista_Editar_Genero_CBox.setSelectedItem(modelo.PacientesObtenerDato("CURP", idBusqueda, "Genero"));
            REP.Recepcionista_Editar_EstadoCivil_CBox.setSelectedItem(modelo.PacientesObtenerDato("CURP", idBusqueda, "Estado civil"));
            REP.Recepcionista_Editar_Curp_Txt.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "CURP"));
            REP.Recepcionista_Editar_Correo_Txt.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Correo"));
            REP.Recepcionista_Editar_Direccion_Txt.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Direccion"));
            REP.Recepcionista_Editar_Telefono_Txt.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Telefono"));
            REP.Recepcionista_Editar_Celular_Txt.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Celular"));
            Date fecha = new Date();
            String fech = modelo.PacientesObtenerDato("CURP", idBusqueda, "Fecha");
            String[] tres = new String[3];
            tres = fech.split("-");
            String fechabien = tres[2]+"/"+tres[1]+"/"+tres[0];
            REP.Recepcionista_Editar_FechaN_DPicker.setFormats(fechabien);
        }
        
        if(me.getSource() == RP.Recepcionista_Pacientes_TablaPacientes_Table)
        {
            int fila = RP.Recepcionista_Pacientes_TablaPacientes_Table.rowAtPoint(me.getPoint());
            String idBusqueda = String.valueOf(RP.Recepcionista_Pacientes_TablaPacientes_Table.getValueAt(fila, 1));
            RP.Recepcionista_Pacientes_Nombre_Lbl.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Nombre"));
            RP.Recepcionista_Pacientes_ApellidoPaterno_Lbl.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Apellido paterno"));
            RP.Recepcionista_Pacientes_ApellidoMaterno_Lbl.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Apellido materno"));
            RP.Recepcionista_Pacientes_Genero_Lbl.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Genero"));
            RP.Recepcionista_Pacientes_EstadoCivil_Lbl.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Estado civil"));
            RP.Recepcionista_Pacientes_Curp_Lbl.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "CURP"));
            RP.Recepcionista_Pacientes_Correo_Lbl.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Correo"));
            RP.Recepcionista_Pacientes_Direccion_Lbl.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Direccion"));
            RP.Recepcionista_Pacientes_Telefono_Lbl.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Telefono"));
            RP.Recepcionista_Pacientes_Celular_Lbl.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Celular"));
            RP.Recepcionista_Pacientes_Edad_Lbl.setText(modelo.PacientesObtenerDato("CURP", idBusqueda, "Edad"));
            Date fecha = new Date();
            String fech = modelo.PacientesObtenerDato("CURP", idBusqueda, "Fecha");
            String[] tres = new String[3];
            tres = fech.split("-");
            String fechabien = tres[2]+"/"+tres[1]+"/"+tres[0];
            RP.Recepcionista_Pacientes_FechaN_Lbl.setText(fechabien);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
}
