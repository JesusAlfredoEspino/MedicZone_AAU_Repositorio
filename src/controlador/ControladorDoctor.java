/*
 Controlador con el cual se manejan todos los enventos, datos y validaciones 
    para las pantallas del usuario Doctor
 */
package controlador;

import controlador.ControladorDoctor;
import modelo.ModeloDoctor;
import vista.Desktop_Doctor;
import vista.IF_DoctorCita;
import vista.IF_DoctorDatosPacientes;
import vista.IF_DoctorEditarPacientes;
import vista.IF_DoctorHistorialMedico;
import vista.IF_DoctorAgenda;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.*;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import org.joda.time.*;
/**
 *
 * @author marco
 */
public class ControladorDoctor implements ActionListener, MouseListener {

    private ModeloDoctor modDoc;
    private Desktop_Doctor DeskD;
    private IF_DoctorCita DC;
    private IF_DoctorDatosPacientes DDP;
    private IF_DoctorEditarPacientes DEP;
    private IF_DoctorHistorialMedico DHM;
    private IF_DoctorAgenda DI;
    private ControladorDoctor contrDoc;
    private String[] idArticulos;
    private String[] Articulos;
    private String[] ArticulosExistencia;
    public String idEmpleado; 
    public int banderaSalida;
    
    
    public ControladorDoctor (
        ModeloDoctor modDoc,
        Desktop_Doctor DeskD,
        IF_DoctorCita DC,
        IF_DoctorDatosPacientes DDP,
        IF_DoctorEditarPacientes DEP,
        IF_DoctorHistorialMedico DHM,
        IF_DoctorAgenda DI,
        String NombreEmpleado,
        String idEmpleado){
     
        this.modDoc = modDoc;
        this.DC = DC;
        this.DeskD = DeskD;
        this.DDP = DDP;
        this.DEP = DEP;
        this.DHM = DHM;
        this.DI = DI;
        this.contrDoc = contrDoc;
        this.banderaSalida = 0;
    
        this.DeskD.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoInicio.png")).getImage());
        
        this.DeskD.Doctor_Nombre_Lbl.setText(NombreEmpleado);
        
        this.DeskD.Desktop_EditarPaciente_Btn.addActionListener(this);
        this.DeskD.Desktop_HistorialMedico_Btn.addActionListener(this);
        this.DeskD.Desktop_Agenda_Btn.addActionListener(this);
        this.DeskD.Desktop_PacientesDatos_Btn.addActionListener(this);
        this.DeskD.Desktop_Salir_Btn.addActionListener(this);
        this.DeskD.Desktop_Cita_Btn.addActionListener(this);
        
        this.DeskD.Doctor_Doctor_Desktop.add(this.DC);
        this.DeskD.Doctor_Doctor_Desktop.add(this.DDP);
        this.DeskD.Doctor_Doctor_Desktop.add(this.DEP);
        this.DeskD.Doctor_Doctor_Desktop.add(this.DHM);
        this.DeskD.Doctor_Doctor_Desktop.add(this.DI);
        
        this.DC.show();
        this.DDP.show();
        this.DEP.show();
        this.DHM.show();
        this.DI.show();
        
        this.DC.setLocation(-6 , -25);
        this.DDP.setLocation(-6 , -25);
        this.DEP.setLocation(-6 , -25);
        this.DHM.setLocation(-6 , -25);
        this.DI.setLocation(-6 , -25);
        
        this.DI.toFront();
        
        this.DI.Doctor_Inicio_Filtrar_CBox.addActionListener(this);
        this.DI.Doctor_Inicio_TomarCita_Btn.addActionListener(this);
        this.DI.Doctor_Inicio_tableAgenda_Table.addMouseListener(this);
        
        this.DDP.Doctor_DatosPacientes_Mostrar_CBox.addActionListener(this);
        this.DDP.Doctor_DatosPacientes_TablaDatos_Table.addMouseListener(this);
        this.DDP.Doctor_DatosPacientes_TablaPacientes_Table.addMouseListener(this);
        
        this.DEP.Doctor_EditarPacientes_EstadoC_CBox.addActionListener(this);
        this.DEP.Doctor_EditarPacientes_Genero_CBox.addActionListener(this);
        this.DEP.Doctor_EditarPacientes_GuardarCambios_Btn.addMouseListener(this);
        this.DEP.Doctor_EditarPacientes_Mostrar_CBox.addActionListener(this);
        this.DEP.Doctor_EditarPacientes_Ordenar_CBox.addActionListener(this);
        this.DEP.Doctor_EditarPacientes_TablaCitas_table.addMouseListener(this);
        PropertyChangeListener listener = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    DEP.Doctor_EditarPacientes_Edad_Txt.setText(obtenerEdadDeJXDate(DEP.Doctor_EditarPacientes_FechaN_DPicker));
                }
            }
        };
        this.DEP.Doctor_EditarPacientes_FechaN_DPicker.addPropertyChangeListener(listener);
        this.DEP.Doctor_EditarPacientes_GuardarCambios_Btn.addActionListener(this);
        
        this.DHM.Doctor_HistorialM_Mostrar_CBox.addActionListener(this);
        this.DHM.Doctor_HistorialM_OrdenarPor_CBox.addActionListener(this);
        this.DHM.Doctor_HistorialM_TablaDatos_Table.addMouseListener(this);
        this.DHM.Doctor_HistorialM_TablaPacientes_Table.addMouseListener(this);
        
        this.DC.Doctor_Cita_Articulo_CBox.addActionListener(this);
        
        this.DC.Doctor_Cita_EliminarArticulo_Btn.addActionListener(this);
        this.DC.Doctor_Cita_EliminarDato_Btn.addActionListener(this);
        this.DC.Doctor_Cita_EliminarServicio_Btn.addActionListener(this);
        this.DC.Doctor_Cita_InsertarArticulo_Btn.addActionListener(this);
        this.DC.Doctor_Cita_InsertarDato_Btn.addActionListener(this);
        this.DC.Doctor_Cita_InsertarServicio_Btn.addActionListener(this);
        this.DC.Doctor_Cita_LimpiarArticulo_Btn.addActionListener(this);
        this.DC.Doctor_Cita_LimpiarDato_Btn.addActionListener(this);
        this.DC.Doctor_Cita_LimpiarServicio_Btn.addActionListener(this);
        
        this.DC.Doctor_Cita_TablaDatosCita_Table.addMouseListener(this);        
        this.DC.Doctor_Cita_TablaServicios_Table.addMouseListener(this);
        this.DC.Doctor_Cita_TablaUtensilios_Table.addMouseListener(this);
        
        this.DC.Doctor_Cita_Terminar_Btn.addActionListener(this);
        
        this.ArticulosExistencia = modDoc.obtenerCantidadArticulos(3);
        this.Articulos = modDoc.obtenerCantidadArticulos(2);
        this.idArticulos = modDoc.obtenerCantidadArticulos(1);
        
        for (String Articulo : this.Articulos) {
            this.DC.Doctor_Cita_Articulo_CBox.addItem(Articulo);
        }
        
        DC.Doctor_Cita_Cantidad_Spinner.setModel(new SpinnerNumberModel(0, 0, Integer.parseInt(this.ArticulosExistencia[DC.Doctor_Cita_Articulo_CBox.getSelectedIndex()]), 1));
        
    }
        
        public void iniciarVista(){
            DeskD.setTitle("Medic-Zone - Doctor");
            DeskD.pack();
            DeskD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            DeskD.setLocationRelativeTo(null);
            DI.Doctor_Inicio_tableAgenda_Table.setModel(modDoc.DoctorInicioConsultar());
            DeskD.setVisible(true);
        }
        public void finalizarVista()
        {
            this.banderaSalida = 1;
            this.DeskD.setVisible(false);
            this.DeskD.dispose();
        }
        
        public void citasLimpiarCampos(){
            DC.Docor_Cita_Conclusion_Txt.setText("");
            DC.Doctor_Cita_Descripcion_Txt.setText("");
            DC.Doctor_Cita_IdDoctor_Txt.setText("");
            DC.Doctor_Cita_IdPaciente_Txt.setText("");
            DC.Doctor_Cita_Dato_Txt.setText("");
            
        }
        
        public void historialLimpiarCampos(){
            DHM.Doctor_HistorialM_Conclusion_Txt.setText("");
        }
        public void EditarPacientesLimpiar()
        {
            DEP.Doctor_EditarPacientes_Id_Txt.setText("");
            DEP.Doctor_EditarPacientes_Nombre_Txt.setText("");
            DEP.Doctor_EditarPacientes_PApell_Txt.setText("");
            DEP.Doctor_EditarPacientes_MApell_Txt.setText("");
            DEP.Doctor_EditarPacientes_Edad_Txt.setText("");
            DEP.Doctor_EditarPacientes_Correo_Txt.setText("");
            DEP.Doctor_EditarPacientes_Direccion_Txt.setText("");
            DEP.Doctor_EditarPacientes_Telefono_Txt.setText("");
            DEP.Doctor_EditarPacientes_Celular_Txt.setText("");
            DEP.Doctor_EditarPacientes_Curp_Txt.setText("");
        }
        public void CitasLimpiarDatos()
        {
            DC.Doctor_Cita_Dato_Txt.setText("");
            DC.Doctor_Cita_Descripcion_Txt.setText("");
        }
        public void CitasLimpiarServicios()
        {
            DC.Doctor_Cita_Servicio_Txt.setText("");
            DC.Doctor_Cita_Precio_Txt.setText("");
        }
        public void CitasLimpiarArticulos()
        {
            DC.Doctor_Cita_Articulo_CBox.setSelectedIndex(0);
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == DeskD.Desktop_EditarPaciente_Btn)
        {
            String mostrar = DEP.Doctor_EditarPacientes_Mostrar_CBox.getSelectedItem().toString();
            String ordpor = DEP.Doctor_EditarPacientes_Ordenar_CBox.getSelectedItem().toString();
            DEP.Doctor_EditarPacientes_TablaCitas_table.setModel(modDoc.DoctorEditarPaciente(mostrar, ordpor));
            DEP.toFront();
        }
         if(ae.getSource() == DeskD.Desktop_HistorialMedico_Btn)
         {
             String mostrar = DHM.Doctor_HistorialM_Mostrar_CBox.getSelectedItem().toString();
             String ordPor = DHM.Doctor_HistorialM_OrdenarPor_CBox.getSelectedItem().toString();
             DHM.Doctor_HistorialM_TablaPacientes_Table.setModel(modDoc.DoctorHistorialConsultar(mostrar, ordPor));
             DHM.toFront();
         }
         if(ae.getSource() == DeskD.Desktop_Agenda_Btn)
         {
                String filtro = DI.Doctor_Inicio_Filtrar_CBox.getSelectedItem().toString();
                DI.Doctor_Inicio_tableAgenda_Table.setModel(modDoc.DoctorInicioConsultar(filtro));
                DI.toFront();
         }
         if(ae.getSource() == DeskD.Desktop_PacientesDatos_Btn)
         {
             String mostrar = DDP.Doctor_DatosPacientes_Mostrar_CBox.getSelectedItem().toString();
             DDP.Doctor_DatosPacientes_TablaPacientes_Table.setModel(modDoc.DoctorDatosConsultar(mostrar));
             DDP.toFront();
         }
         if(ae.getSource() == DeskD.Desktop_Cita_Btn)
         {
             if(vaciosONoTxt(DC.Doctor_Cita_IdCita_Txt))
             {
                DC.toFront();
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "Tome una cita en el menú de Inicio para poder llevar a cabo una cita");
                 DI.toFront();
             }
         }
         if(ae.getSource() == DeskD.Desktop_Salir_Btn)
         {
             this.finalizarVista();
         }
         
         
        if(ae.getSource() == DI.Doctor_Inicio_Filtrar_CBox)
        {
            String filtrarPor = DI.Doctor_Inicio_Filtrar_CBox.getSelectedItem().toString();
            DI.Doctor_Inicio_tableAgenda_Table.setModel(modDoc.DoctorInicioConsultar(filtrarPor));
        }
        if(ae.getSource() == DHM.Doctor_HistorialM_Mostrar_CBox || ae.getSource() == DHM.Doctor_HistorialM_OrdenarPor_CBox){
            String filtrarPor = DHM.Doctor_HistorialM_Mostrar_CBox.getSelectedItem().toString();
            String OrdenarPor = DHM.Doctor_HistorialM_OrdenarPor_CBox.getSelectedItem().toString();
            DHM.Doctor_HistorialM_TablaPacientes_Table.setModel(modDoc.DoctorHistorialConsultar(filtrarPor,OrdenarPor));
            
        }
        if(ae.getSource() == DEP.Doctor_EditarPacientes_Mostrar_CBox || ae.getSource() == DEP.Doctor_EditarPacientes_Ordenar_CBox)
        {
            String mostrar = DEP.Doctor_EditarPacientes_Mostrar_CBox.getSelectedItem().toString();
            String ordpor = DEP.Doctor_EditarPacientes_Ordenar_CBox.getSelectedItem().toString();
            DEP.Doctor_EditarPacientes_TablaCitas_table.setModel(modDoc.DoctorEditarPaciente(mostrar, ordpor));
        }
        if(ae.getSource() == DEP.Doctor_EditarPacientes_GuardarCambios_Btn)
        {
            if(vaciosONoTxt(DEP.Doctor_EditarPacientes_Id_Txt, DEP.Doctor_EditarPacientes_Nombre_Txt, DEP.Doctor_EditarPacientes_PApell_Txt, DEP.Doctor_EditarPacientes_MApell_Txt, DEP.Doctor_EditarPacientes_Edad_Txt, DEP.Doctor_EditarPacientes_Correo_Txt, DEP.Doctor_EditarPacientes_Direccion_Txt, DEP.Doctor_EditarPacientes_Telefono_Txt, DEP.Doctor_EditarPacientes_Celular_Txt, DEP.Doctor_EditarPacientes_Curp_Txt))
            {
                if(modDoc.pacientesActualizar(DEP.Doctor_EditarPacientes_Id_Txt.getText(), DEP.Doctor_EditarPacientes_Nombre_Txt.getText(), DEP.Doctor_EditarPacientes_PApell_Txt.getText(), DEP.Doctor_EditarPacientes_MApell_Txt.getText(), FechaAFormatoBD(DEP.Doctor_EditarPacientes_FechaN_DPicker), DEP.Doctor_EditarPacientes_Edad_Txt.getText(), DEP.Doctor_EditarPacientes_Correo_Txt.getText(), DEP.Doctor_EditarPacientes_Direccion_Txt.getText(), DEP.Doctor_EditarPacientes_Telefono_Txt.getText(), DEP.Doctor_EditarPacientes_Celular_Txt.getText(), DEP.Doctor_EditarPacientes_Genero_CBox.getSelectedItem().toString(), DEP.Doctor_EditarPacientes_Curp_Txt.getText(),DEP.Doctor_EditarPacientes_EstadoC_CBox.getSelectedItem().toString()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro actualizado exitosamente");
                    String mostrar = DEP.Doctor_EditarPacientes_Mostrar_CBox.getSelectedItem().toString();
                    String ordpor = DEP.Doctor_EditarPacientes_Ordenar_CBox.getSelectedItem().toString();
                    DEP.Doctor_EditarPacientes_TablaCitas_table.setModel(modDoc.DoctorEditarPaciente(mostrar, ordpor));
                    this.EditarPacientesLimpiar();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
        if(ae.getSource() == DDP.Doctor_DatosPacientes_Mostrar_CBox)
        {
            String mostrar = DDP.Doctor_DatosPacientes_Mostrar_CBox.getSelectedItem().toString();
            DDP.Doctor_DatosPacientes_TablaPacientes_Table.setModel(modDoc.DoctorDatosConsultar(mostrar));
        }
        if(ae.getSource() == DI.Doctor_Inicio_TomarCita_Btn)
        {
            String idCita = DI.Doctor_Inicio_Id_Txt.getText();
            DC.Doctor_Cita_IdCita_Txt.setText(DI.Doctor_Inicio_Id_Txt.getText());
            DC.Doctor_Cita_IdDoctor_Txt.setText(modDoc.citasObtenerDato("Id", idCita, "Id doctor"));
            DC.Doctor_Cita_IdPaciente_Txt.setText(modDoc.citasObtenerDato("Id", idCita, "Id paciente"));
            DC.Doctor_Cita_Fecha_DPicker.setDate(StringBD_a_DateParaInput(modDoc.citasObtenerDato("Id", idCita, "Fecha")));
            DC.toFront();
            
        }
        if(ae.getSource() == DC.Doctor_Cita_LimpiarDato_Btn)
        {
            CitasLimpiarDatos();
        }
        if(ae.getSource() == DC.Doctor_Cita_InsertarDato_Btn)
        {
            DefaultTableModel model = (DefaultTableModel)DC.Doctor_Cita_TablaDatosCita_Table.getModel();
            if(vaciosONoTxt(DC.Doctor_Cita_Dato_Txt,DC.Doctor_Cita_Descripcion_Txt))
            {
                model.addRow(new Object[]{DC.Doctor_Cita_Dato_Txt.getText(),DC.Doctor_Cita_Descripcion_Txt.getText()});
                CitasLimpiarDatos();
            }
            else
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                
        }
        if(ae.getSource() == DC.Doctor_Cita_EliminarDato_Btn)
        {
            DefaultTableModel model = (DefaultTableModel)DC.Doctor_Cita_TablaDatosCita_Table.getModel();
            try{
            int selectedrow = DC.Doctor_Cita_TablaDatosCita_Table.getSelectedRow();
            model.removeRow(selectedrow);
            }catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Error: Seleccione un registro de la tabla");
            }
        }
        
        if(ae.getSource() == DC.Doctor_Cita_LimpiarServicio_Btn)
        {
            CitasLimpiarServicios();
        }
        if(ae.getSource() == DC.Doctor_Cita_InsertarServicio_Btn)
        {
            DefaultTableModel model = (DefaultTableModel)DC.Doctor_Cita_TablaServicios_Table.getModel();
            if(vaciosONoTxt(DC.Doctor_Cita_Servicio_Txt,DC.Doctor_Cita_Precio_Txt))
            {
                model.addRow(new Object[]{DC.Doctor_Cita_Servicio_Txt.getText(),DC.Doctor_Cita_Precio_Txt.getText()});
                CitasLimpiarServicios();
            }
            else
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                
        }
        if(ae.getSource() == DC.Doctor_Cita_EliminarServicio_Btn)
        {
            DefaultTableModel model = (DefaultTableModel)DC.Doctor_Cita_TablaServicios_Table.getModel();
            try{
            int selectedrow = DC.Doctor_Cita_TablaServicios_Table.getSelectedRow();
            model.removeRow(selectedrow);
            }catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Error: Seleccione un registro de la tabla");
            }
        }
        
        if(ae.getSource() == DC.Doctor_Cita_LimpiarArticulo_Btn)
        {
            CitasLimpiarArticulos();
        }
        if(ae.getSource() == DC.Doctor_Cita_InsertarArticulo_Btn)
        {
            DefaultTableModel model = (DefaultTableModel)DC.Doctor_Cita_TablaUtensilios_Table.getModel();
            if(!DC.Doctor_Cita_Cantidad_Spinner.getValue().toString().equals("0"))
            {
                model.addRow(new Object[]{DC.Doctor_Cita_Articulo_CBox.getSelectedItem().toString(),DC.Doctor_Cita_Cantidad_Spinner.getValue().toString()});
                CitasLimpiarArticulos();
            }
            else
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                
        }
        if(ae.getSource() == DC.Doctor_Cita_EliminarArticulo_Btn)
        {
            DefaultTableModel model = (DefaultTableModel)DC.Doctor_Cita_TablaUtensilios_Table.getModel();
            try{
            int selectedrow = DC.Doctor_Cita_TablaUtensilios_Table.getSelectedRow();
            model.removeRow(selectedrow);
            }catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Error: Seleccione un registro de la tabla");
            }
        }
        if(ae.getSource() == DC.Doctor_Cita_Articulo_CBox)
        {
            DC.Doctor_Cita_Cantidad_Spinner.setModel(new SpinnerNumberModel(0, 0, Integer.parseInt(this.ArticulosExistencia[DC.Doctor_Cita_Articulo_CBox.getSelectedIndex()]), 1));
        }
        if(ae.getSource() == DC.Doctor_Cita_Terminar_Btn)
        {
            if(vaciosONoTxt(DC.Doctor_Cita_IdCita_Txt,DC.Doctor_Cita_IdPaciente_Txt,DC.Doctor_Cita_IdDoctor_Txt,DC.Docor_Cita_Conclusion_Txt))
            {
                //ya se checo que este bien todo
                //se tiene que insertar datoscita, servicios, articulos
                
                int filas = DC.Doctor_Cita_TablaDatosCita_Table.getRowCount();
                for (int i=0; i<filas;i++)
                {
                    String dato = (String)DC.Doctor_Cita_TablaDatosCita_Table.getValueAt(i, 0);
                    String descripcion = (String)DC.Doctor_Cita_TablaDatosCita_Table.getValueAt(i, 1);
                    modDoc.datoscitaInsertar(DC.Doctor_Cita_IdCita_Txt.getText(), dato, descripcion);
                }
                
                filas = DC.Doctor_Cita_TablaServicios_Table.getRowCount();
                String[] servicios = new String[filas];
                String[] precios = new String[filas];
                for(int i=0; i<filas;i++)
                {
                    servicios[i] = (String)DC.Doctor_Cita_TablaServicios_Table.getValueAt(i, 0);
                    precios[i] = (String)DC.Doctor_Cita_TablaServicios_Table.getValueAt(i, 1);
                }
                
                filas = DC.Doctor_Cita_TablaUtensilios_Table.getRowCount();
                for(int i=0; i<filas;i++)
                {
                    String idArt = (String)DC.Doctor_Cita_TablaUtensilios_Table.getValueAt(i, 0);
                    String cant = (String)DC.Doctor_Cita_TablaUtensilios_Table.getValueAt(i, 1);
                    modDoc.utensiliosInsertar(DC.Doctor_Cita_IdCita_Txt.getText(), idArt, cant);
                }
                if(modDoc.citaActualizar(this.idEmpleado, DC.Docor_Cita_Conclusion_Txt.getText(), DC.Doctor_Cita_IdCita_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Cita terminada exitosamente");
                }
                DC.Doctor_Cita_IdCita_Txt.setText("");
                DI.toFront();
                //falta borrar inputs
              
                
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        if(me.getSource() == DEP.Doctor_EditarPacientes_TablaCitas_table)
        {
            int fila = DEP.Doctor_EditarPacientes_TablaCitas_table.rowAtPoint(me.getPoint());
            String curpPac = String.valueOf(DEP.Doctor_EditarPacientes_TablaCitas_table.getValueAt(fila, 3));
            String idPac = modDoc.pacientesObtenerDato("CURP", "'"+curpPac+"'", "Id");
            DEP.Doctor_EditarPacientes_Id_Txt.setText(modDoc.pacientesObtenerDato("Id", idPac, "Id"));
           DEP.Doctor_EditarPacientes_Nombre_Txt.setText(modDoc.pacientesObtenerDato("Id", idPac, "Nombre"));
           DEP.Doctor_EditarPacientes_PApell_Txt.setText(modDoc.pacientesObtenerDato("Id", idPac, "Paterno"));
           DEP.Doctor_EditarPacientes_MApell_Txt.setText(modDoc.pacientesObtenerDato("Id", idPac, "Materno"));
           DEP.Doctor_EditarPacientes_FechaN_DPicker.setDate(StringBD_a_DateParaInput(modDoc.pacientesObtenerDato("Id", idPac, "Fecha")));
           DEP.Doctor_EditarPacientes_Edad_Txt.setText(modDoc.pacientesObtenerDato("Id", idPac, "Edad"));
           DEP.Doctor_EditarPacientes_Correo_Txt.setText(modDoc.pacientesObtenerDato("Id", idPac, "Correo"));
           DEP.Doctor_EditarPacientes_Direccion_Txt.setText(modDoc.pacientesObtenerDato("Id", idPac, "Direccion"));
           DEP.Doctor_EditarPacientes_Telefono_Txt.setText(modDoc.pacientesObtenerDato("Id", idPac, "Telefono"));
           DEP.Doctor_EditarPacientes_Celular_Txt.setText(modDoc.pacientesObtenerDato("Id", idPac, "Celular"));
           DEP.Doctor_EditarPacientes_Genero_CBox.setSelectedItem(modDoc.pacientesObtenerDato("Id", idPac, "Genero"));
           DEP.Doctor_EditarPacientes_Curp_Txt.setText(modDoc.pacientesObtenerDato("Id", idPac, "CURP"));
           DEP.Doctor_EditarPacientes_EstadoC_CBox.setSelectedItem(modDoc.pacientesObtenerDato("Id", idPac, "ECiv"));
        }
        if(me.getSource() == DDP.Doctor_DatosPacientes_TablaPacientes_Table)
        {
            int fila = DDP.Doctor_DatosPacientes_TablaPacientes_Table.rowAtPoint(me.getPoint());
            String idCita = String.valueOf(DDP.Doctor_DatosPacientes_TablaPacientes_Table.getValueAt(fila, 0));
            DDP.Doctor_DatosPacientes_TablaDatos_Table.setModel(modDoc.DoctorDatosConsultar(Integer.parseInt(idCita)));
        }
        if(me.getSource() == DHM.Doctor_HistorialM_TablaPacientes_Table)
        {
            int fila = DHM.Doctor_HistorialM_TablaPacientes_Table.rowAtPoint(me.getPoint());
            String idCita = String.valueOf(DHM.Doctor_HistorialM_TablaPacientes_Table.getValueAt(fila, 0));
            DHM.Doctor_HistorialM_TablaDatos_Table.setModel(modDoc.DoctorHistorialConsultar(idCita));
        }
        if(me.getSource() == DHM.Doctor_HistorialM_TablaDatos_Table)
        {
            int fila = DHM.Doctor_HistorialM_TablaDatos_Table.rowAtPoint(me.getPoint());
            String idCita = String.valueOf(DHM.Doctor_HistorialM_TablaDatos_Table.getValueAt(fila, 0));
            DHM.Doctor_HistorialM_Conclusion_Txt.setText(modDoc.citasObtenerDato("Id", idCita, "Conclusion"));
        }
        if(me.getSource() == DI.Doctor_Inicio_tableAgenda_Table)
        {
            int fila = DI.Doctor_Inicio_tableAgenda_Table.rowAtPoint(me.getPoint());
            String idCita = String.valueOf(DI.Doctor_Inicio_tableAgenda_Table.getValueAt(fila, 0));
            DI.Doctor_Inicio_Id_Txt.setText(idCita);
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
        
        try{
            date1 = formato.parse(HoraParaLaCosa);
            return date1;
            
        }catch (ParseException ex) {
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
    public boolean vaciosONoTxt(javax.swing.JTextField... args){
        
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9@.ñ _]*$");
        Matcher matcher;
        for(javax.swing.JTextField arg : args){
            matcher = pattern.matcher(arg.getText());
            if(!arg.getText().equals("") && matcher.matches())
                ;
            else
                return false;
        }
        return true;
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
    
    
}
