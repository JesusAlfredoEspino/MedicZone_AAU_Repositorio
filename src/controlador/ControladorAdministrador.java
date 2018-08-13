/*
 Controlador con el cual se manejan todos los enventos, datos y validaciones 
    para las pantallas del usuario Administrador
 */
package controlador;

import modelo.ModeloAdministrador;
import vista.Desktop_Administrador;
import vista.IF_AdministradorArticulosCita;
import vista.IF_AdministradorCitas;
import vista.IF_AdministradorDatosCita;
import vista.IF_AdministradorDoctores;
import vista.IF_AdministradorEmpleados;
import vista.IF_AdministradorPacientes;
import vista.IF_AdministradorUsuarios;
import vista.IF_AdministradorUtensilios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.*;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import org.joda.time.*;
import java.lang.Object;
import javax.swing.AbstractSpinnerModel;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author office depot
 */
public class ControladorAdministrador implements ActionListener, MouseListener, FocusListener {

    private ModeloAdministrador modelo;
    private Desktop_Administrador vistaDesktop;
    private IF_AdministradorArticulosCita AAC;
    private IF_AdministradorCitas AC;
    private IF_AdministradorDatosCita ADC;
    private IF_AdministradorDoctores AD;
    private IF_AdministradorEmpleados AE;
    private IF_AdministradorPacientes AP;
    private IF_AdministradorUsuarios AUS;
    private IF_AdministradorUtensilios AUT;
    public int banderaSalida;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorAdministrador(ModeloAdministrador modelo, Desktop_Administrador vistaDesktop, IF_AdministradorArticulosCita AAC, IF_AdministradorCitas AC, IF_AdministradorDatosCita ADC, IF_AdministradorDoctores AD, IF_AdministradorEmpleados AE, IF_AdministradorPacientes AP, IF_AdministradorUsuarios AUS, IF_AdministradorUtensilios AUT, String NombreEmpleado) {
        this.modelo = modelo;
        this.vistaDesktop = vistaDesktop;
        this.AAC = AAC;
        this.AC = AC;
        this.ADC = ADC;
        this.AD = AD;
        this.AE = AE;
        this.AP = AP;
        this.AUS = AUS;
        this.AUT = AUT;
        this.banderaSalida = 0;
        this.vistaDesktop.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoInicio.png")).getImage());
        
        this.vistaDesktop.Administrador_Desktop_NombreUsuario_Lbl.setText(NombreEmpleado);
        
        this.vistaDesktop.Administrador_Desktop_Articulos_Btn.addActionListener(this);
        this.vistaDesktop.Administrador_Desktop_Citas_Btn.addActionListener(this);
        this.vistaDesktop.Administrador_Desktop_DatosCita_Btn.addActionListener(this);
        this.vistaDesktop.Administrador_Desktop_Doctores_Btn.addActionListener(this);
        this.vistaDesktop.Administrador_Desktop_Empleados_Btn.addActionListener(this);
        this.vistaDesktop.Administrador_Desktop_Pacientes_Btn.addActionListener(this);
        this.vistaDesktop.Administrador_Desktop_Salir_Btn.addActionListener(this);
        this.vistaDesktop.Administrador_Desktop_Usuarios_Btn.addActionListener(this);
        this.vistaDesktop.Administrador_Desktop_Utensilios_Btn.addActionListener(this);
        
        this.vistaDesktop.Administrador_Administrador_Desktop.add(this.AAC);
        this.vistaDesktop.Administrador_Administrador_Desktop.add(this.AC);
        this.vistaDesktop.Administrador_Administrador_Desktop.add(this.ADC);
        this.vistaDesktop.Administrador_Administrador_Desktop.add(this.AD);
        this.vistaDesktop.Administrador_Administrador_Desktop.add(this.AE);
        this.vistaDesktop.Administrador_Administrador_Desktop.add(this.AP);
        this.vistaDesktop.Administrador_Administrador_Desktop.add(this.AUS);
        this.vistaDesktop.Administrador_Administrador_Desktop.add(this.AUT);
        
        this.AAC.show();
        this.AC.show();
        this.ADC.show();
        this.AD.show();
        this.AE.show();
        this.AP.show();
        this.AUS.show();
        this.AUT.show();
        
        this.AAC.setLocation(-6, -25);
        this.AC.setLocation(-6, -25);
        this.ADC.setLocation(-6, -25);
        this.AD.setLocation(-6, -25);
        this.AE.setLocation(-6, -25);
        this.AP.setLocation(-6, -25);
        this.AUS.setLocation(-6, -25);
        this.AUT.setLocation(-6, -25);
        
        this.AUS.toFront();
        
        this.AAC.Administrador_Articulos_Mostrar_CBox.addActionListener(this);
        this.AAC.Administrador_Articulos_OrdenarPor_CBox.addActionListener(this);
        this.AAC.Administrador_Articulos_TablaArticulos_Table.addMouseListener(this);
        this.AAC.Administrador_Articulos_Limpiar_Btn.addActionListener(this);
        this.AAC.Administrador_Articulos_Eliminar_Btn.addActionListener(this);
        this.AAC.Administrador_Articulos_Actualizar_Btn.addActionListener(this);
        this.AAC.Administrador_Articulos_Insertar_Btn.addActionListener(this);
        
        this.AC.Administrador_Citas_Mostrar_CBox.addActionListener(this);
        this.AC.Administrador_Citas_OrdenarPor_CBox.addActionListener(this);
        this.AC.Administrador_Citas_Limpiar_Btn.addActionListener(this);
        this.AC.Administrador_Citas_TablaCitas_Table.addMouseListener(this);
        this.AC.Administrador_Citas_Eliminar_Btn.addActionListener(this);
        this.AC.Administrador_Citas_Insertar_Btn.addActionListener(this);
        this.AC.Administrador_Citas_Actualizar_Btn.addActionListener(this);
        
        this.AUS.Administrador_Usuarios_Mostrar_CBox.addActionListener(this);
        this.AUS.Administrador_Usuarios_OrdenarPor_CBox.addActionListener(this);
        this.AUS.Administrador_Usuarios_Eliminar_Btn.addActionListener(this);
        this.AUS.Administrador_Usuarios_TablaUsuarios_Table.addMouseListener(this);
        this.AUS.Administrador_Usuarios_Limpiar_Btn.addActionListener(this);
        this.AUS.Administrador_Usuarios_Insertar_Btn.addActionListener(this);
        this.AUS.Administrador_Usuarios_Actualizar_Btn.addActionListener(this);
        
        this.AE.Administrador_Empleados_Mostrar_CBox.addActionListener(this);
        this.AE.Administrador_Empleados_OrdenarPor_CBox.addActionListener(this);
        this.AE.Administrador_Empleados_TablaEmpleados_Table.addMouseListener(this);
        this.AE.Administrador_Empleados_Limpiar_Btn.addActionListener(this);
        this.AE.Administrador_Empleados_Insertar_Btn.addActionListener(this);
        this.AE.Administrador_Empleados_Actualizar_Btn.addActionListener(this);
        this.AE.Administrador_Empleados_Eliminar_Btn.addActionListener(this);
        PropertyChangeListener listener = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    AE.Administrador_Empleados_Edad_Txt.setText(obtenerEdadDeJXDate(AE.Administrador_Empleados_FechaNacimiento_DPicker));
                }
            }
        };
        this.AE.Administrador_Empleados_FechaNacimiento_DPicker.addPropertyChangeListener(listener);
        
        this.AD.Administrador_Doctores_OrdenarPor_CBox.addActionListener(this);
        this.AD.Administrador_Doctores_TablaDoctores_Table.addMouseListener(this);
        this.AD.Administrador_Doctores_Limpiar_Btn.addActionListener(this);
        this.AD.Administrador_Doctores_Actualizar_Btn.addActionListener(this);
        this.AD.Administrador_Doctores_Insertar_Btn.addActionListener(this);
        this.AD.Administrador_Doctores_Eliminar_Btn.addActionListener(this);
        
        this.AP.Administrador_Pacientes_Mostrar_CBox.addActionListener(this);
        this.AP.Administrador_Pacientes_OrdenarPor_CBox.addActionListener(this);
        this.AP.Administrador_Pacientes_TablaPacientes_Table.addMouseListener(this);
        PropertyChangeListener listener1 = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    AP.Administrador_Pacientes_Edad_Txt.setText(obtenerEdadDeJXDate(AP.Administrador_Empleados_FechaNacimiento_DPicker));
                }
            }
        };
        this.AP.Administrador_Empleados_FechaNacimiento_DPicker.addPropertyChangeListener(listener1);
        this.AP.Administrador_Pacientes_Limpiar_Btn.addActionListener(this);
        this.AP.Administrador_Pacientes_Insertar_Btn.addActionListener(this);
        this.AP.Administrador_Pacientes_Actualizar_Btn.addActionListener(this);
        this.AP.Administrador_Pacientes_Eliminar_Btn.addActionListener(this);
        
        this.ADC.Administrador_DatosCitas_OrdenarPor_CBox.addActionListener(this);
        this.ADC.Administrador_DatosCitas_TablaCitas_Table.addMouseListener(this);
        this.ADC.Administrador_DatosCitas_TablaDatosCitas_Table.addMouseListener(this);
        this.ADC.Administrador_DatosCitas_TablaDatosCitas_Table.addMouseListener(this);
        this.ADC.Administrador_DatosCitas_Limpiar_Btn.addActionListener(this);
        this.ADC.Administrador_DatosCitas_Eliminar_Btn.addActionListener(this);
        this.ADC.Administrador_DatosCitas_Actualizar_Btn.addActionListener(this);
        this.ADC.Administrador_DatosCitas_Insertar_Btn.addActionListener(this);
        
        this.AUT.Administrador_Utensilios_OrdenarPor_CBox.addActionListener(this);
        this.AUT.Administrador_Utensilios_TablaUtensilios_Table.addMouseListener(this);
        this.AUT.Administrador_Utensilios_TablaCitas_Table.addMouseListener(this);
        this.AUT.Administrador_Utensilios_Limpira_Btn.addActionListener(this);
        this.AUT.Administrador_Utensilios_Eliminar_Btn.addActionListener(this);
        this.AUT.Administrador_Utensilios_Insertar_Btn.addActionListener(this);
        this.AUT.Administrador_Utensilios_Actualizar_Btn.addActionListener(this);
        this.AUT.Administrador_Utensilios_Existencia_Txt.addFocusListener(this);
        
        this.vistaDesktop.Administrador_Desktop_Reporte_Btn.addActionListener(this);
        
    }
    
    public void iniciarVista(){
        vistaDesktop.setTitle("Medic-Zone - Administrador");
        vistaDesktop.pack();
        vistaDesktop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaDesktop.setLocationRelativeTo(null);
        AUS.Administrador_Usuarios_TablaUsuarios_Table.setModel(modelo.usuariosUsuariosConsultar());
        vistaDesktop.setVisible(true);        
    }
    public void finalizarVista()
    {
        this.banderaSalida = 1;
        this.vistaDesktop.setVisible(false);
        this.vistaDesktop.dispose();
    }
    
    public void articulosLimpiarCampos(){
        AAC.Administrador_Articulos_Id_Txt.setText("");
        AAC.Administrador_Articulos_NombreArticulo_Txt.setText("");
        AAC.Administrador_Articulos_ExistenciaArticulo_Txt.setText("");
        AAC.Administrador_Articulos_Id_Txt.setEnabled(false);
        AAC.Administrador_Articulos_NombreArticulo_Txt.setEnabled(true);
        AAC.Administrador_Articulos_ExistenciaArticulo_Txt.setEnabled(true);
    }
    public void citasLimpiarCampos(){
        AC.Administrador_Citas_Id_Txt.setText("");
        AC.Administrador_Citas_NombreDoctor_Txt.setText("");
        AC.Administrador_Citas_NombrePaciente_Txt.setText("");
        AC.Administrador_Citas_NombreRecepcionista_Txt.setText("");
        
        AC.Administrador_Citas_Descripcion_Txt.setText("");
        AC.Administrador_Citas_Conclusion_Txt.setText("");
        AC.Administrador_Citas_Estado_Txt.setText("");
        
        AC.Administrador_Citas_NombreDoctor_Txt.setEnabled(true);
        AC.Administrador_Citas_NombrePaciente_Txt.setEnabled(true);
        AC.Administrador_Citas_NombreRecepcionista_Txt.setEnabled(true);
    }
    public void usuariosLimpiarCampos(){
        AUS.Administrador_Usuarios_Id_Table.setText("");
        AUS.Administrador_Usuarios_IdEmpleado_Txt.setText("");
        AUS.Administrador_Usuarios_Usuario_Txt.setText("");
        AUS.Administrador_Usuarios_Contrasena_Txt.setText("");
        AUS.Administrador_Usuarios_Tipo_Txt.setSelectedIndex(0);
        AUS.Administrador_Usuarios_TablaUsuarios_Table.setModel(modelo.usuariosUsuariosConsultar());
    }
    public void empleadosLimpiarCampos(){
            AE.Administrador_Empleados_Id_Txt.setText("");
            AE.Administrador_Empleados_Nombre_Txt.setText("");
            AE.Administrador_Empleados_ApellidoPaterno_Txt.setText("");
            AE.Administrador_Empleados_ApellidoMaterno_Txt.setText("");
            AE.Administrador_Empleados_Edad_Txt.setText("");
            AE.Administrador_Empleados_Correo_Txt.setText("");
            AE.Administrador_Empleados_Direccion_Txt.setText("");
            AE.Administrador_Empleados_Telefono_Txt.setText("");
            AE.Administrador_Empleados_Celular_Txt.setText("");
            AE.Administrador_Empleados_Genero_CBox.setSelectedIndex(0);
            AE.Administrador_Empleados_Rfc_Txt.setText("");
            AE.Administrador_Empleados_Curp_Txt.setText("");
            AE.Administrador_Empleados_Tipo_Txt.setText("");
            AE.Administrador_Empleados_EstadoCivil_Txt.setText("");
            AE.Administrador_Empleados_Estado_CBox.setSelectedIndex(0);
    }
    public void doctoresLimpiarCampos(){
        AD.Administrador_Doctores_Id_Txt.setText("");
        AD.Administrador_Doctores_Especialidad_Txt.setText("");
        AD.Administrador_Doctores_NumeroCedula_Txt.setText("");
    }
    public void pacientesLimpiarCampos(){
            AP.Administrador_Pacientes_Id_Txt.setText("");
            AP.Administrador_Pacientes_Nombre_Txt.setText("");
            AP.Administrador_Pacientes_ApellidoPaterno_Txt.setText("");
            AP.Administrador_Pacientes_ApellidoMaterno_Txt.setText("");
            AP.Administrador_Pacientes_Edad_Txt.setText("");
            AP.Administrador_Pacientes_Correo_Txt.setText("");
            AP.Administrador_Pacientes_Direccion_Txt.setText("");
            AP.Administrador_Pacientes_Telefono_Txt.setText("");
            AP.Administrador_Pacientes_Celular_Txt.setText("");
            AP.Administrador_Pacientes_Genero_CBox.setSelectedIndex(0);
            AP.Administrador_Pacientes_Curp_Txt.setText("");
            AP.Administrador_Pacientes_EstadoCivil_Txt.setText("");
    }
    public void datosCitaLimpiarCampos()
    {
        ADC.Administrador_DatosCitas_Id_Txt.setText("");
        ADC.Administrador_DatosCitas_IdCita_Txt.setText("");
        ADC.Administrador_DatosCitas_Servicio_Txt.setText("");
        ADC.Administrador_DatosCitas_Descripcion_Txt.setText("");
    }
    public void utensiliosLimpiarCampos()
    {
        AUT.Administrador_Utensilios_IdRegistroUtensilios_Txt.setText("");
        AUT.Administrador_Utensilios_IdCita_Txt.setText("");
        AUT.Administrador_Utensilios_IdArticulo_Txt.setText("");
        AUT.Administrador_Utensilios_IdArticulo_Txt.setEnabled(true);
        AUT.Administrador_Utensilios_Cantidad_Txt.setText("");
        AUT.Administrador_Utensilios_Cantidad_Txt.setEnabled(true);
        AUT.Administrador_Utensilios_Existencia_Txt.setText("0");
        AUT.Administrador_Utensilios_Existencia_Txt.setEnabled(true);
        AUT.Administrador_Utensilios_Incremento_CBox.setModel(new SpinnerNumberModel(0, 0, Integer.parseInt(AUT.Administrador_Utensilios_Existencia_Txt.getText()), 1));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaDesktop.Administrador_Desktop_Articulos_Btn)
        {
            AAC.Administrador_Articulos_TablaArticulos_Table.setModel(modelo.articulosArticulosConsultar("",""));
            AAC.toFront();
        }
        if(e.getSource() == vistaDesktop.Administrador_Desktop_Citas_Btn)
        {
            AC.Administrador_Citas_TablaCitas_Table.setModel(modelo.citasCitasConsultar("",""));
            //AC.Administrador_Citas_TablaCitas_Table.setModel(modelo.mostrarCitas());
            AC.toFront();
        }
        if(e.getSource() == vistaDesktop.Administrador_Desktop_DatosCita_Btn)
        {
            ADC.Administrador_DatosCitas_TablaCitas_Table.setModel(modelo.datosCitaDatosCitaConsultar());
            ADC.toFront();
        }
        if(e.getSource() == vistaDesktop.Administrador_Desktop_Doctores_Btn)
        {
            AD.Administrador_Doctores_TablaDoctores_Table.setModel(modelo.doctoresDoctoresConsultar());
            AD.toFront();
        }
        if(e.getSource() == vistaDesktop.Administrador_Desktop_Empleados_Btn)
        {
            AE.Administrador_Empleados_TablaEmpleados_Table.setModel(modelo.empleadosEmpleadosConsultar());
            AE.toFront();
        }
        if(e.getSource() == vistaDesktop.Administrador_Desktop_Pacientes_Btn)
        {
            String ordPor = AP.Administrador_Pacientes_OrdenarPor_CBox.getSelectedItem().toString();
            String mostra = AP.Administrador_Pacientes_Mostrar_CBox.getSelectedItem().toString();
            AP.Administrador_Pacientes_TablaPacientes_Table.setModel(modelo.pacientesPacientesConsultar(mostra, ordPor));
            AP.toFront();
        }
        if(e.getSource() == vistaDesktop.Administrador_Desktop_Salir_Btn)
        {
            this.finalizarVista();
        }
        if(e.getSource() == vistaDesktop.Administrador_Desktop_Usuarios_Btn)
        {
            AUS.Administrador_Usuarios_TablaUsuarios_Table.setModel(modelo.usuariosUsuariosConsultar());
            AUS.toFront();
        }
        if(e.getSource() == vistaDesktop.Administrador_Desktop_Utensilios_Btn)
        {
            AUT.Administrador_Utensilios_TablaCitas_Table.setModel(modelo.utensiliosCitaConsultar("", AUT.Administrador_Utensilios_OrdenarPor_CBox.getSelectedItem().toString()));
            AUT.Administrador_Utensilios_TablaUtensilios_Table.setModel(modelo.utensiliosUtensiliosConsultar("0"));
            AUT.toFront();
        }
        
        if(e.getSource() == AAC.Administrador_Articulos_Mostrar_CBox || e.getSource() == AAC.Administrador_Articulos_OrdenarPor_CBox)
        {
            String txtCB = AAC.Administrador_Articulos_Mostrar_CBox.getSelectedItem().toString();
            String txtCB1 = AAC.Administrador_Articulos_OrdenarPor_CBox.getSelectedItem().toString();
            AAC.Administrador_Articulos_TablaArticulos_Table.setModel(modelo.articulosArticulosConsultar(txtCB,txtCB1));
        }
        if(e.getSource() == AAC.Administrador_Articulos_Limpiar_Btn)
        {
            this.articulosLimpiarCampos();
        }
        if(e.getSource() == AAC.Administrador_Articulos_Eliminar_Btn)
        {
                if(!modelo.articulosExisteUtensilio(AAC.Administrador_Articulos_Id_Txt.getText()))
                {
                    if(modelo.articulosEliminar(AAC.Administrador_Articulos_Id_Txt.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "Resgistro eliminado exitosamente");
                        AAC.Administrador_Articulos_TablaArticulos_Table.setModel(modelo.articulosArticulosConsultar("",""));
                        this.articulosLimpiarCampos();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Error: TIENE CAMPOS DEPENDIENTES");

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error: ARTICULO UTILIZADO EN UNA CITA");
                }
        }
        if(e.getSource() == AAC.Administrador_Articulos_Actualizar_Btn)
        {//JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
            if(vaciosONoTxt(AAC.Administrador_Articulos_Id_Txt,AAC.Administrador_Articulos_NombreArticulo_Txt,AAC.Administrador_Articulos_ExistenciaArticulo_Txt))
            {
                if(modelo.articulosActualizar(AAC.Administrador_Articulos_Id_Txt.getText(),AAC.Administrador_Articulos_NombreArticulo_Txt.getText(),AAC.Administrador_Articulos_ExistenciaArticulo_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro modificado exitosamente");
                    AAC.Administrador_Articulos_TablaArticulos_Table.setModel(modelo.articulosArticulosConsultar("",""));
                    this.articulosLimpiarCampos();
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
        }
        if(e.getSource() == AAC.Administrador_Articulos_Insertar_Btn)
        {
            if(vaciosONoTxt(AAC.Administrador_Articulos_NombreArticulo_Txt,AAC.Administrador_Articulos_ExistenciaArticulo_Txt))
            {
                if(modelo.articulosInsertar(AAC.Administrador_Articulos_NombreArticulo_Txt.getText(),AAC.Administrador_Articulos_ExistenciaArticulo_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro insertado exitosamente");
                    AAC.Administrador_Articulos_TablaArticulos_Table.setModel(modelo.articulosArticulosConsultar("",""));
                    this.articulosLimpiarCampos();
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
        }
        
        if(e.getSource() == AC.Administrador_Citas_Mostrar_CBox || e.getSource() == AC.Administrador_Citas_OrdenarPor_CBox)
        {
            String txtCB = AC.Administrador_Citas_Mostrar_CBox.getSelectedItem().toString();
            String txtCB1 = AC.Administrador_Citas_OrdenarPor_CBox.getSelectedItem().toString();
            AC.Administrador_Citas_TablaCitas_Table.setModel(modelo.citasCitasConsultar(txtCB,txtCB1));
        }
        if(e.getSource() == AC.Administrador_Citas_Limpiar_Btn)
        {
            this.citasLimpiarCampos();
        }
        if(e.getSource() == AC.Administrador_Citas_Eliminar_Btn)
        {
                if(modelo.eliminarCitas(AC.Administrador_Citas_Id_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro eliminado exitosamente");
                    AC.Administrador_Citas_TablaCitas_Table.setModel(modelo.citasCitasConsultar("",""));
                    this.citasLimpiarCampos();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "¡¡ERROR¡¡ TIENE CAMPOS DEPENDIENTES");
                }
        }
        if(e.getSource() == AC.Administrador_Citas_Insertar_Btn)
        {
            if(vaciosONoTxt(AC.Administrador_Citas_NombrePaciente_Txt,AC.Administrador_Citas_NombreDoctor_Txt,AC.Administrador_Citas_NombreRecepcionista_Txt,AC.Administrador_Citas_Descripcion_Txt,AC.Administrador_Citas_Conclusion_Txt,AC.Administrador_Citas_Estado_Txt))
            {
                //solo si existe el paciente insertado
                if(modelo.ExistePaciente(AC.Administrador_Citas_NombrePaciente_Txt.getText()))
                {
                    if(modelo.ExisteEmpleado(AC.Administrador_Citas_NombreRecepcionista_Txt.getText()))
                    {
                        if(modelo.empleadosExisteDoctor(AC.Administrador_Citas_NombreDoctor_Txt.getText()))
                        {
                            if(!modelo.CitaintervieneCita(
                                   FechaAFormatoBD(AC.Administrador_Citas_Fecha_DPicker),
                                   HoraAFormatoBD(AC.Administrador_Citas_Hora_Spinner),
                                   FechaDespuesDeTantosMinutos(30, "Fecha", AC.Administrador_Citas_Fecha_DPicker, AC.Administrador_Citas_Hora_Spinner),
                                   FechaDespuesDeTantosMinutos(30, "hora", AC.Administrador_Citas_Fecha_DPicker, AC.Administrador_Citas_Hora_Spinner)
                                 ))
                            {
                                if(modelo.citasInsertar(AC.Administrador_Citas_NombrePaciente_Txt.getText(),AC.Administrador_Citas_NombreDoctor_Txt.getText(),AC.Administrador_Citas_NombreRecepcionista_Txt.getText(),FechaAFormatoBD(AC.Administrador_Citas_Fecha_DPicker),HoraAFormatoBD(AC.Administrador_Citas_Hora_Spinner),AC.Administrador_Citas_Descripcion_Txt.getText(),AC.Administrador_Citas_Conclusion_Txt.getText(),AC.Administrador_Citas_Estado_Txt.getText()))
                                {
                                    JOptionPane.showMessageDialog(null, "Resgistro insertado exitosamente");
                                    AC.Administrador_Citas_TablaCitas_Table.setModel(modelo.citasCitasConsultar("",""));
                                    this.citasLimpiarCampos();
                                }
                            }
                            else
                                JOptionPane.showMessageDialog(null, "Error: Fecha y hora intervienen con otra cita");
                            
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Error: Id de Doctor inexistente");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error: Id de recepcionista inexistente");
                    
                }
                else
                    JOptionPane.showMessageDialog(null, "Error: Id de paciente inexistente");
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == AC.Administrador_Citas_Actualizar_Btn)
        {
            if(vaciosONoTxt(AC.Administrador_Citas_Id_Txt,AC.Administrador_Citas_NombrePaciente_Txt,AC.Administrador_Citas_NombreDoctor_Txt,AC.Administrador_Citas_NombreRecepcionista_Txt,AC.Administrador_Citas_Descripcion_Txt,AC.Administrador_Citas_Conclusion_Txt,AC.Administrador_Citas_Estado_Txt))
            {
                if(!modelo.CitaintervieneCita(
                                   FechaAFormatoBD(AC.Administrador_Citas_Fecha_DPicker),
                                   HoraAFormatoBD(AC.Administrador_Citas_Hora_Spinner),
                                   FechaDespuesDeTantosMinutos(30, "Fecha", AC.Administrador_Citas_Fecha_DPicker, AC.Administrador_Citas_Hora_Spinner),
                                   FechaDespuesDeTantosMinutos(30, "hora", AC.Administrador_Citas_Fecha_DPicker, AC.Administrador_Citas_Hora_Spinner)
                                 ))
                {
                    if(modelo.citasActualizar(AC.Administrador_Citas_Id_Txt.getText(),AC.Administrador_Citas_NombrePaciente_Txt.getText(),AC.Administrador_Citas_NombreDoctor_Txt.getText(),AC.Administrador_Citas_NombreRecepcionista_Txt.getText(),FechaAFormatoBD(AC.Administrador_Citas_Fecha_DPicker),HoraAFormatoBD(AC.Administrador_Citas_Hora_Spinner),AC.Administrador_Citas_Descripcion_Txt.getText(),AC.Administrador_Citas_Conclusion_Txt.getText(),AC.Administrador_Citas_Estado_Txt.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "Resgistro modificado exitosamente");
                        AC.Administrador_Citas_TablaCitas_Table.setModel(modelo.citasCitasConsultar("",""));
                        this.citasLimpiarCampos();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Error: Fecha y hora proporcionados intervienen con otra cita");
                
            }
            else
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                
            
        }
        if(e.getSource() == AUS.Administrador_Usuarios_Mostrar_CBox || e.getSource() == AUS.Administrador_Usuarios_OrdenarPor_CBox)
        {
            String txtCB = AUS.Administrador_Usuarios_Mostrar_CBox.getSelectedItem().toString();
            String txtCB1 = AUS.Administrador_Usuarios_OrdenarPor_CBox.getSelectedItem().toString();
            AUS.Administrador_Usuarios_TablaUsuarios_Table.setModel(modelo.usuariosUsuariosConsultar(txtCB,txtCB1));
        }
        if(e.getSource() == AUS.Administrador_Usuarios_Limpiar_Btn)
        {
            this.usuariosLimpiarCampos();
        }
        if(e.getSource() == AUS.Administrador_Usuarios_Eliminar_Btn)
        {
            if(vaciosONoTxt(AUS.Administrador_Usuarios_Id_Table))
            {
                if(modelo.usuariosEliminar(AUS.Administrador_Usuarios_Id_Table.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro eliminado exitosamente");
                    AUS.Administrador_Usuarios_TablaUsuarios_Table.setModel(modelo.usuariosUsuariosConsultar(AUS.Administrador_Usuarios_Mostrar_CBox.getSelectedItem().toString(), AUS.Administrador_Usuarios_OrdenarPor_CBox.getSelectedItem().toString()));
                    usuariosLimpiarCampos();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == AUS.Administrador_Usuarios_Insertar_Btn)
        {
            if(vaciosONoTxt(AUS.Administrador_Usuarios_Usuario_Txt,AUS.Administrador_Usuarios_Contrasena_Txt))
            {
                if(modelo.usuariosInsertar(AUS.Administrador_Usuarios_IdEmpleado_Txt.getText(),AUS.Administrador_Usuarios_Usuario_Txt.getText(),AUS.Administrador_Usuarios_Contrasena_Txt.getText(),AUS.Administrador_Usuarios_Tipo_Txt.getSelectedItem().toString()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro insertado exitosamente");
                    AUS.Administrador_Usuarios_TablaUsuarios_Table.setModel(modelo.usuariosUsuariosConsultar());
                    this.usuariosLimpiarCampos();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == AUS.Administrador_Usuarios_Actualizar_Btn)
        {
            if(vaciosONoTxt(AUS.Administrador_Usuarios_Id_Table,AUS.Administrador_Usuarios_Id_Table,AUS.Administrador_Usuarios_Usuario_Txt,AUS.Administrador_Usuarios_Contrasena_Txt))
            {
                if(modelo.usuariosActualizar(AUS.Administrador_Usuarios_Id_Table.getText(),AUS.Administrador_Usuarios_IdEmpleado_Txt.getText(),AUS.Administrador_Usuarios_Usuario_Txt.getText(),AUS.Administrador_Usuarios_Contrasena_Txt.getText(),AUS.Administrador_Usuarios_Tipo_Txt.getSelectedItem().toString()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro modificado exitosamente");
                    AUS.Administrador_Usuarios_TablaUsuarios_Table.setModel(modelo.usuariosUsuariosConsultar());
                    this.usuariosLimpiarCampos();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == AE.Administrador_Empleados_OrdenarPor_CBox || e.getSource() == AE.Administrador_Empleados_Mostrar_CBox)
        {
            String ordPor = AE.Administrador_Empleados_OrdenarPor_CBox.getSelectedItem().toString();
            String mostra = AE.Administrador_Empleados_Mostrar_CBox.getSelectedItem().toString();
            AE.Administrador_Empleados_TablaEmpleados_Table.setModel(modelo.empleadosEmpleadosConsultar(ordPor, mostra));
        }
        if(e.getSource() == AE.Administrador_Empleados_Limpiar_Btn)
        {
            this.empleadosLimpiarCampos();
        }
        if(e.getSource() == AE.Administrador_Empleados_Insertar_Btn)
        {
            if(vaciosONoTxt(AE.Administrador_Empleados_Nombre_Txt, AE.Administrador_Empleados_ApellidoPaterno_Txt, AE.Administrador_Empleados_ApellidoMaterno_Txt, AE.Administrador_Empleados_Edad_Txt, AE.Administrador_Empleados_Correo_Txt, AE.Administrador_Empleados_Direccion_Txt, AE.Administrador_Empleados_Telefono_Txt, AE.Administrador_Empleados_Celular_Txt, AE.Administrador_Empleados_Rfc_Txt, AE.Administrador_Empleados_Curp_Txt, AE.Administrador_Empleados_Tipo_Txt, AE.Administrador_Empleados_EstadoCivil_Txt))
            {
                if(modelo.empleadosInsertar(AE.Administrador_Empleados_Nombre_Txt.getText(), AE.Administrador_Empleados_ApellidoPaterno_Txt.getText(), AE.Administrador_Empleados_ApellidoMaterno_Txt.getText(), FechaAFormatoBD(AE.Administrador_Empleados_FechaNacimiento_DPicker), AE.Administrador_Empleados_Edad_Txt.getText(), AE.Administrador_Empleados_Correo_Txt.getText(), AE.Administrador_Empleados_Direccion_Txt.getText(), AE.Administrador_Empleados_Telefono_Txt.getText(), AE.Administrador_Empleados_Celular_Txt.getText(), AE.Administrador_Empleados_Genero_CBox.getSelectedItem().toString(), AE.Administrador_Empleados_Rfc_Txt.getText(), AE.Administrador_Empleados_Curp_Txt.getText(), AE.Administrador_Empleados_Tipo_Txt.getText(), AE.Administrador_Empleados_EstadoCivil_Txt.getText(), AE.Administrador_Empleados_Estado_CBox.getSelectedItem().toString()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro insertado exitosamente");
                    String ordPor = AE.Administrador_Empleados_OrdenarPor_CBox.getSelectedItem().toString();
                    String mostra = AE.Administrador_Empleados_Mostrar_CBox.getSelectedItem().toString();
                    AE.Administrador_Empleados_TablaEmpleados_Table.setModel(modelo.empleadosEmpleadosConsultar(ordPor, mostra));
                    this.empleadosLimpiarCampos();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == AE.Administrador_Empleados_Eliminar_Btn)
        {
            if(vaciosONoTxt(AE.Administrador_Empleados_Nombre_Txt, AE.Administrador_Empleados_ApellidoPaterno_Txt, AE.Administrador_Empleados_ApellidoMaterno_Txt, AE.Administrador_Empleados_Edad_Txt, AE.Administrador_Empleados_Correo_Txt, AE.Administrador_Empleados_Direccion_Txt, AE.Administrador_Empleados_Telefono_Txt, AE.Administrador_Empleados_Celular_Txt, AE.Administrador_Empleados_Rfc_Txt, AE.Administrador_Empleados_Curp_Txt, AE.Administrador_Empleados_Tipo_Txt, AE.Administrador_Empleados_EstadoCivil_Txt))
            {
                if(modelo.empleadosEliminar(AE.Administrador_Empleados_Id_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Empleado borrado exitosamente");
                    AE.Administrador_Empleados_TablaEmpleados_Table.setModel(modelo.empleadosEmpleadosConsultar());
                    this.empleadosLimpiarCampos();
                }
                else
                    JOptionPane.showMessageDialog(null, "!!ERROR!! TIENE CAMPOS DEPENDIENTES");
            }
        }

        if(e.getSource() == AE.Administrador_Empleados_Actualizar_Btn)
        {
            if(vaciosONoTxt(AE.Administrador_Empleados_Id_Txt, AE.Administrador_Empleados_Nombre_Txt, AE.Administrador_Empleados_ApellidoPaterno_Txt, AE.Administrador_Empleados_ApellidoMaterno_Txt, AE.Administrador_Empleados_Edad_Txt, AE.Administrador_Empleados_Correo_Txt, AE.Administrador_Empleados_Direccion_Txt, AE.Administrador_Empleados_Telefono_Txt, AE.Administrador_Empleados_Celular_Txt, AE.Administrador_Empleados_Rfc_Txt, AE.Administrador_Empleados_Curp_Txt, AE.Administrador_Empleados_Tipo_Txt, AE.Administrador_Empleados_EstadoCivil_Txt))
            {
                if(modelo.empleadosActualizar(AE.Administrador_Empleados_Id_Txt.getText(),AE.Administrador_Empleados_Nombre_Txt.getText(), AE.Administrador_Empleados_ApellidoPaterno_Txt.getText(), AE.Administrador_Empleados_ApellidoMaterno_Txt.getText(), FechaAFormatoBD(AE.Administrador_Empleados_FechaNacimiento_DPicker), AE.Administrador_Empleados_Edad_Txt.getText(), AE.Administrador_Empleados_Correo_Txt.getText(), AE.Administrador_Empleados_Direccion_Txt.getText(), AE.Administrador_Empleados_Telefono_Txt.getText(), AE.Administrador_Empleados_Celular_Txt.getText(), AE.Administrador_Empleados_Genero_CBox.getSelectedItem().toString(), AE.Administrador_Empleados_Rfc_Txt.getText(), AE.Administrador_Empleados_Curp_Txt.getText(), AE.Administrador_Empleados_Tipo_Txt.getText(), AE.Administrador_Empleados_EstadoCivil_Txt.getText(), AE.Administrador_Empleados_Estado_CBox.getSelectedItem().toString()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro modificado exitosamente");
                    String ordPor = AE.Administrador_Empleados_OrdenarPor_CBox.getSelectedItem().toString();
                    String mostra = AE.Administrador_Empleados_Mostrar_CBox.getSelectedItem().toString();
                    AE.Administrador_Empleados_TablaEmpleados_Table.setModel(modelo.empleadosEmpleadosConsultar(ordPor, mostra));
                    this.empleadosLimpiarCampos();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
       
        if(e.getSource() == AD.Administrador_Doctores_OrdenarPor_CBox)
        {
            AD.Administrador_Doctores_TablaDoctores_Table.setModel(modelo.doctoresDoctoresConsultar("", AD.Administrador_Doctores_OrdenarPor_CBox.getSelectedItem().toString()));
        }
        if(e.getSource() == AD.Administrador_Doctores_Limpiar_Btn)
        {
            this.doctoresLimpiarCampos();
        }
        if(e.getSource() == AD.Administrador_Doctores_Actualizar_Btn)
        {
            if(vaciosONoTxt(AD.Administrador_Doctores_Id_Txt,AD.Administrador_Doctores_Especialidad_Txt,AD.Administrador_Doctores_NumeroCedula_Txt))
            {
                if(modelo.ExisteEmpleado(AD.Administrador_Doctores_Id_Txt.getText()))
                {
                    if(modelo.doctoresActualizar(AD.Administrador_Doctores_Id_Txt.getText(),AD.Administrador_Doctores_Especialidad_Txt.getText(),AD.Administrador_Doctores_NumeroCedula_Txt.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "Resgistro modificado exitosamente");
                        String ordPor = AD.Administrador_Doctores_OrdenarPor_CBox.getSelectedItem().toString();
                        AD.Administrador_Doctores_TablaDoctores_Table.setModel(modelo.doctoresDoctoresConsultar("", ordPor));
                        this.doctoresLimpiarCampos();
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == AD.Administrador_Doctores_Eliminar_Btn)
        {
            if(vaciosONoTxt(AD.Administrador_Doctores_Especialidad_Txt, AD.Administrador_Doctores_Id_Txt, AD.Administrador_Doctores_NumeroCedula_Txt))
            {
               if(modelo.doctoresEliminar(AD.Administrador_Doctores_Id_Txt.getText()))
               {
                    JOptionPane.showMessageDialog(null, "Doctor eliminado exitosamente");
                    AD.Administrador_Doctores_TablaDoctores_Table.setModel(modelo.doctoresDoctoresConsultar());
                    this.doctoresLimpiarCampos();
               }
            }
            else
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");

        }
        if(e.getSource() == AD.Administrador_Doctores_Insertar_Btn)
        {
            String tipo = modelo.obtenerTipoEmpleado(AD.Administrador_Doctores_Id_Txt.getText());
            if(vaciosONoTxt(AD.Administrador_Doctores_Id_Txt,AD.Administrador_Doctores_Especialidad_Txt,AD.Administrador_Doctores_NumeroCedula_Txt))
            {
                if(modelo.ExisteEmpleado(AD.Administrador_Doctores_Id_Txt.getText()))
                {
                    if(tipo.equals("Doctor"))  
                    {
                        if(modelo.doctoresInsertar(AD.Administrador_Doctores_Id_Txt.getText(),AD.Administrador_Doctores_Especialidad_Txt.getText(),AD.Administrador_Doctores_NumeroCedula_Txt.getText()))
                        {
                            JOptionPane.showMessageDialog(null, "Resgistro insertado exitosamente");
                            String ordPor = AD.Administrador_Doctores_OrdenarPor_CBox.getSelectedItem().toString();
                            AD.Administrador_Doctores_TablaDoctores_Table.setModel(modelo.doctoresDoctoresConsultar("", ordPor));
                            this.doctoresLimpiarCampos();
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error: Ese empleado no es Doctor");
                    System.out.println(""+tipo);
        
                }
                else
                    JOptionPane.showMessageDialog(null, "Error: No existe ese empleado");
 
            }
        }
        if(e.getSource() == AP.Administrador_Pacientes_Mostrar_CBox || e.getSource() == AP.Administrador_Pacientes_OrdenarPor_CBox)
        {
            String ordPor = AP.Administrador_Pacientes_OrdenarPor_CBox.getSelectedItem().toString();
            String mostra = AP.Administrador_Pacientes_Mostrar_CBox.getSelectedItem().toString();
            AP.Administrador_Pacientes_TablaPacientes_Table.setModel(modelo.pacientesPacientesConsultar(mostra, ordPor));
        }
        if(e.getSource() == AP.Administrador_Pacientes_Limpiar_Btn)
        {
            this.pacientesLimpiarCampos();
        }
        if(e.getSource() == AP.Administrador_Pacientes_Insertar_Btn)
        {
            if(vaciosONoTxt(AP.Administrador_Pacientes_Nombre_Txt, AP.Administrador_Pacientes_ApellidoPaterno_Txt, AP.Administrador_Pacientes_ApellidoMaterno_Txt, AP.Administrador_Pacientes_Edad_Txt, AP.Administrador_Pacientes_Correo_Txt, AP.Administrador_Pacientes_Direccion_Txt, AP.Administrador_Pacientes_Telefono_Txt, AP.Administrador_Pacientes_Celular_Txt, AP.Administrador_Pacientes_Curp_Txt, AP.Administrador_Pacientes_EstadoCivil_Txt))
            {
                if(modelo.pacientesInsertar(AP.Administrador_Pacientes_Nombre_Txt.getText(), AP.Administrador_Pacientes_ApellidoPaterno_Txt.getText(), AP.Administrador_Pacientes_ApellidoMaterno_Txt.getText(), FechaAFormatoBD(AP.Administrador_Empleados_FechaNacimiento_DPicker), AP.Administrador_Pacientes_Edad_Txt.getText(), AP.Administrador_Pacientes_Correo_Txt.getText(), AP.Administrador_Pacientes_Direccion_Txt.getText(), AP.Administrador_Pacientes_Telefono_Txt.getText(), AP.Administrador_Pacientes_Celular_Txt.getText(), AP.Administrador_Pacientes_Genero_CBox.getSelectedItem().toString(), AP.Administrador_Pacientes_Curp_Txt.getText(), AP.Administrador_Pacientes_EstadoCivil_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro insertado exitosamente");
                    String ordPor = AP.Administrador_Pacientes_OrdenarPor_CBox.getSelectedItem().toString();
                    String mostra = AP.Administrador_Pacientes_Mostrar_CBox.getSelectedItem().toString();
                    AP.Administrador_Pacientes_TablaPacientes_Table.setModel(modelo.pacientesPacientesConsultar(mostra, ordPor));
                    this.pacientesLimpiarCampos();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //vJOptionPaneentanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == AP.Administrador_Pacientes_Eliminar_Btn)
        {
            if(vaciosONoTxt(AP.Administrador_Pacientes_Nombre_Txt, AP.Administrador_Pacientes_ApellidoPaterno_Txt, AP.Administrador_Pacientes_ApellidoMaterno_Txt, AP.Administrador_Pacientes_Edad_Txt, AP.Administrador_Pacientes_Correo_Txt, AP.Administrador_Pacientes_Direccion_Txt, AP.Administrador_Pacientes_Telefono_Txt, AP.Administrador_Pacientes_Celular_Txt, AP.Administrador_Pacientes_Curp_Txt, AP.Administrador_Pacientes_EstadoCivil_Txt))
            {
                if(modelo.eliminarPacientes(AP.Administrador_Pacientes_Id_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Paciente eliminado exitosamente");
                    String ordPor = AP.Administrador_Pacientes_OrdenarPor_CBox.getSelectedItem().toString();
                    String mostra = AP.Administrador_Pacientes_Mostrar_CBox.getSelectedItem().toString();
                    AP.Administrador_Pacientes_TablaPacientes_Table.setModel(modelo.pacientesPacientesConsultar(mostra, ordPor));
                    this.pacientesLimpiarCampos();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "!!ERROR!! TIENE CAMPOS DEPENDIENTES");

                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //vJOptionPaneentanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == AP.Administrador_Pacientes_Actualizar_Btn)
        {
            if(vaciosONoTxt(AP.Administrador_Pacientes_Id_Txt,AP.Administrador_Pacientes_Nombre_Txt, AP.Administrador_Pacientes_ApellidoPaterno_Txt, AP.Administrador_Pacientes_ApellidoMaterno_Txt, AP.Administrador_Pacientes_Edad_Txt, AP.Administrador_Pacientes_Correo_Txt, AP.Administrador_Pacientes_Direccion_Txt, AP.Administrador_Pacientes_Telefono_Txt, AP.Administrador_Pacientes_Celular_Txt, AP.Administrador_Pacientes_Curp_Txt, AP.Administrador_Pacientes_EstadoCivil_Txt))
            {
                if(modelo.pacientesActualizar(AP.Administrador_Pacientes_Id_Txt.getText(),AP.Administrador_Pacientes_Nombre_Txt.getText(), AP.Administrador_Pacientes_ApellidoPaterno_Txt.getText(), AP.Administrador_Pacientes_ApellidoMaterno_Txt.getText(), FechaAFormatoBD(AP.Administrador_Empleados_FechaNacimiento_DPicker), AP.Administrador_Pacientes_Edad_Txt.getText(), AP.Administrador_Pacientes_Correo_Txt.getText(), AP.Administrador_Pacientes_Direccion_Txt.getText(), AP.Administrador_Pacientes_Telefono_Txt.getText(), AP.Administrador_Pacientes_Celular_Txt.getText(), AP.Administrador_Pacientes_Genero_CBox.getSelectedItem().toString(), AP.Administrador_Pacientes_Curp_Txt.getText(), AP.Administrador_Pacientes_EstadoCivil_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro modificado exitosamente");
                    String ordPor = AP.Administrador_Pacientes_OrdenarPor_CBox.getSelectedItem().toString();
                    String mostra = AP.Administrador_Pacientes_Mostrar_CBox.getSelectedItem().toString();
                    AP.Administrador_Pacientes_TablaPacientes_Table.setModel(modelo.pacientesPacientesConsultar(mostra, ordPor));
                    this.pacientesLimpiarCampos();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == ADC.Administrador_DatosCitas_OrdenarPor_CBox)
        {
            ADC.Administrador_DatosCitas_TablaCitas_Table.setModel(modelo.datosCitaCitaConsultar("", ADC.Administrador_DatosCitas_OrdenarPor_CBox.getSelectedItem().toString()));
        }
        if(e.getSource() == ADC.Administrador_DatosCitas_Limpiar_Btn)
        {
            datosCitaLimpiarCampos();
        }
        if(e.getSource() == ADC.Administrador_DatosCitas_Eliminar_Btn)
        {
                if(modelo.datosCitaEliminar(ADC.Administrador_DatosCitas_Id_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro eliminado exitosamente");
                    ADC.Administrador_DatosCitas_TablaDatosCitas_Table.setModel(modelo.datosCitaDatosCitaConsultar(ADC.Administrador_DatosCitas_IdCita_Txt.getText()));
                    usuariosLimpiarCampos();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error: TIENE CAMPOS DEPENDIENTES");

                }
        }
        if(e.getSource() == ADC.Administrador_DatosCitas_Actualizar_Btn)
        {
            if(vaciosONoTxt(ADC.Administrador_DatosCitas_Id_Txt, ADC.Administrador_DatosCitas_IdCita_Txt, ADC.Administrador_DatosCitas_Servicio_Txt, ADC.Administrador_DatosCitas_Descripcion_Txt))
            {
                if(modelo.datosCitaActualizar(ADC.Administrador_DatosCitas_Id_Txt.getText(), ADC.Administrador_DatosCitas_Servicio_Txt.getText(), ADC.Administrador_DatosCitas_Descripcion_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro modificado exitosamente");
                    ADC.Administrador_DatosCitas_TablaDatosCitas_Table.setModel(modelo.datosCitaDatosCitaConsultar(ADC.Administrador_DatosCitas_IdCita_Txt.getText()));
                    this.datosCitaLimpiarCampos();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == ADC.Administrador_DatosCitas_Insertar_Btn)
        {
            if(vaciosONoTxt(ADC.Administrador_DatosCitas_IdCita_Txt, ADC.Administrador_DatosCitas_Servicio_Txt, ADC.Administrador_DatosCitas_Descripcion_Txt,ADC.Administrador_DatosCitas_Servicio_Txt,ADC.Administrador_DatosCitas_Descripcion_Txt))
            {
                if(modelo.datosCitaInsertar(ADC.Administrador_DatosCitas_IdCita_Txt.getText(), ADC.Administrador_DatosCitas_Servicio_Txt.getText(), ADC.Administrador_DatosCitas_Descripcion_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro insertado exitosamente");
                    ADC.Administrador_DatosCitas_TablaDatosCitas_Table.setModel(modelo.datosCitaDatosCitaConsultar(ADC.Administrador_DatosCitas_IdCita_Txt.getText()));
                    this.datosCitaLimpiarCampos();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == AUT.Administrador_Utensilios_OrdenarPor_CBox)
        {
            AUT.Administrador_Utensilios_TablaCitas_Table.setModel(modelo.utensiliosCitaConsultar("", AUT.Administrador_Utensilios_OrdenarPor_CBox.getSelectedItem().toString()));
        }
        if(e.getSource() == AUT.Administrador_Utensilios_Eliminar_Btn)
        {
                if(modelo.utensiliosEliminar(AUT.Administrador_Utensilios_IdRegistroUtensilios_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro eliminado exitosamente");
                    AUT.Administrador_Utensilios_TablaCitas_Table.setModel(modelo.utensiliosCitaConsultar("", AUT.Administrador_Utensilios_OrdenarPor_CBox.getSelectedItem().toString()));
                    AUT.Administrador_Utensilios_TablaUtensilios_Table.setModel(modelo.utensiliosUtensiliosConsultar("0"));
                    utensiliosLimpiarCampos();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error: TIENE CAMPOS DEPENDIENTES");

                }
        }
        if(e.getSource() == AUT.Administrador_Utensilios_Limpira_Btn)
        {
            utensiliosLimpiarCampos();
        }
        if(e.getSource() == AUT.Administrador_Utensilios_Insertar_Btn)
        {
            if(vaciosONoTxt(AUT.Administrador_Utensilios_IdCita_Txt,AUT.Administrador_Utensilios_IdArticulo_Txt,AUT.Administrador_Utensilios_Cantidad_Txt,AUT.Administrador_Utensilios_Existencia_Txt))
            {
                if(modelo.utensiliosInsertar(AUT.Administrador_Utensilios_IdCita_Txt.getText(),AUT.Administrador_Utensilios_IdArticulo_Txt.getText(),AUT.Administrador_Utensilios_Cantidad_Txt.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro insertado exitosamente");
                    AUT.Administrador_Utensilios_TablaCitas_Table.setModel(modelo.utensiliosCitaConsultar("", AUT.Administrador_Utensilios_OrdenarPor_CBox.getSelectedItem().toString()));
                    AUT.Administrador_Utensilios_TablaUtensilios_Table.setModel(modelo.utensiliosUtensiliosConsultar("0"));
                    this.utensiliosLimpiarCampos();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == AUT.Administrador_Utensilios_Actualizar_Btn)
        {
            if(vaciosONoTxt(AUT.Administrador_Utensilios_IdRegistroUtensilios_Txt,AUT.Administrador_Utensilios_IdCita_Txt,AUT.Administrador_Utensilios_IdArticulo_Txt,AUT.Administrador_Utensilios_Cantidad_Txt,AUT.Administrador_Utensilios_Existencia_Txt))
            {
                if(modelo.utensiliosActualizar(AUT.Administrador_Utensilios_IdRegistroUtensilios_Txt.getText(),AUT.Administrador_Utensilios_IdCita_Txt.getText(),AUT.Administrador_Utensilios_IdArticulo_Txt.getText(),AUT.Administrador_Utensilios_Cantidad_Txt.getText(),AUT.Administrador_Utensilios_Incremento_CBox.getValue().toString()))
                {
                    JOptionPane.showMessageDialog(null, "Resgistro actualizado exitosamente");
                    AUT.Administrador_Utensilios_TablaCitas_Table.setModel(modelo.utensiliosCitaConsultar("", AUT.Administrador_Utensilios_OrdenarPor_CBox.getSelectedItem().toString()));
                    AUT.Administrador_Utensilios_TablaUtensilios_Table.setModel(modelo.utensiliosUtensiliosConsultar("0"));
                    this.utensiliosLimpiarCampos();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: Campos vacios o con caracteres inválidos");
                //ventanita de que llene todos los campos y con caracteres validos
            }
        }
        if(e.getSource() == vistaDesktop.Administrador_Desktop_Reporte_Btn)
        {
            
        }
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == AAC.Administrador_Articulos_TablaArticulos_Table)
        {
            int fila = AAC.Administrador_Articulos_TablaArticulos_Table.rowAtPoint(e.getPoint());
            String idBusqueda = String.valueOf(AAC.Administrador_Articulos_TablaArticulos_Table.getValueAt(fila, 0));
            AAC.Administrador_Articulos_Id_Txt.setEnabled(false);
            AAC.Administrador_Articulos_Id_Txt.setText(modelo.articulosObtenerDato("Id", idBusqueda, "Id"));
            AAC.Administrador_Articulos_NombreArticulo_Txt.setText(modelo.articulosObtenerDato("Id", idBusqueda, "Articulo"));
            AAC.Administrador_Articulos_ExistenciaArticulo_Txt.setText(modelo.articulosObtenerDato("Id", idBusqueda, "Existencia"));
        }
        if(e.getSource() == AC.Administrador_Citas_TablaCitas_Table)
        {
            int fila = AC.Administrador_Citas_TablaCitas_Table.rowAtPoint(e.getPoint());
            String idBusqueda = String.valueOf(AC.Administrador_Citas_TablaCitas_Table.getValueAt(fila, 0));
            AC.Administrador_Citas_Id_Txt.setEnabled(false);
            AC.Administrador_Citas_NombreDoctor_Txt.setEnabled(false);
            AC.Administrador_Citas_NombrePaciente_Txt.setEnabled(false);
            AC.Administrador_Citas_NombreRecepcionista_Txt.setEnabled(false);
            AC.Administrador_Citas_Id_Txt.setText(modelo.citasObtenerDato("Id cita", idBusqueda, "Id cita"));
            AC.Administrador_Citas_NombrePaciente_Txt.setText(modelo.citasObtenerDato("Id cita", idBusqueda, "Id paciente"));
            AC.Administrador_Citas_NombreDoctor_Txt.setText(modelo.citasObtenerDato("Id cita", idBusqueda, "Id doctor"));
            AC.Administrador_Citas_NombreRecepcionista_Txt.setText(modelo.citasObtenerDato("Id cita", idBusqueda, "Id recepcionista"));
            AC.Administrador_Citas_Descripcion_Txt.setText(modelo.citasObtenerDato("Id cita", idBusqueda, "Descripcion"));
            AC.Administrador_Citas_Conclusion_Txt.setText(modelo.citasObtenerDato("Id cita", idBusqueda, "Conclusion"));
            AC.Administrador_Citas_Estado_Txt.setText(modelo.citasObtenerDato("Id cita", idBusqueda, "Estado"));
            
            AC.Administrador_Citas_Fecha_DPicker.setDate(StringBD_a_DateParaInput(modelo.citasObtenerDato("Id cita", idBusqueda, "Fecha")));
            AC.Administrador_Citas_Hora_Spinner.setValue(StringBD_a_HoraParaInput(modelo.citasObtenerDato("Id cita", idBusqueda, "Hora")));
            
        }
        if(e.getSource() == AUS.Administrador_Usuarios_TablaUsuarios_Table)
        {
            int fila = AUS.Administrador_Usuarios_TablaUsuarios_Table.rowAtPoint(e.getPoint());
            String idBusqueda = String.valueOf(AUS.Administrador_Usuarios_TablaUsuarios_Table.getValueAt(fila, 0));
            AUS.Administrador_Usuarios_Id_Table.setText(modelo.usuariosObtenerDato("Id", idBusqueda, "Id"));
            AUS.Administrador_Usuarios_Usuario_Txt.setText(modelo.usuariosObtenerDato("Id", idBusqueda, "Usuario"));
            AUS.Administrador_Usuarios_Contrasena_Txt.setText(modelo.usuariosObtenerDato("Id", idBusqueda, "Contrasena"));
            AUS.Administrador_Usuarios_IdEmpleado_Txt.setText(modelo.usuariosObtenerDato("Id", idBusqueda, "Id empleado"));
            
            String tipoUsu = modelo.usuariosObtenerDato("Id", idBusqueda, "Tipo");
            int indexTipoUsu = 0;
            if(tipoUsu.equals("Administrador")) indexTipoUsu = 0;
            if(tipoUsu.equals("Doctor")) indexTipoUsu = 1;
            if(tipoUsu.equals("Recepcionista")) indexTipoUsu = 2;
            if(tipoUsu.equals("Proveedor")) indexTipoUsu = 3;
            AUS.Administrador_Usuarios_Tipo_Txt.setSelectedIndex(indexTipoUsu);
        }
        if(e.getSource() == AE.Administrador_Empleados_TablaEmpleados_Table)
        {
            int fila = AE.Administrador_Empleados_TablaEmpleados_Table.rowAtPoint(e.getPoint());
            String idBusqueda = String.valueOf(AE.Administrador_Empleados_TablaEmpleados_Table.getValueAt(fila, 0));
            AE.Administrador_Empleados_Id_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "Id"));
            AE.Administrador_Empleados_Nombre_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "Nombre"));
            AE.Administrador_Empleados_ApellidoPaterno_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "Apellido paterno"));
            AE.Administrador_Empleados_ApellidoMaterno_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "Apellido materno"));
            AE.Administrador_Empleados_FechaNacimiento_DPicker.setDate(this.StringBD_a_DateParaInput(modelo.empleadosObtenerDato("Id", idBusqueda, "Fecha")));
            AE.Administrador_Empleados_Edad_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "Edad"));
            AE.Administrador_Empleados_Correo_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "Correo"));
            AE.Administrador_Empleados_Direccion_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "Direccion"));
            AE.Administrador_Empleados_Telefono_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "Telefono"));
            AE.Administrador_Empleados_Celular_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "Celular"));
            AE.Administrador_Empleados_Genero_CBox.setSelectedItem(modelo.empleadosObtenerDato("Id", idBusqueda, "Genero"));
            AE.Administrador_Empleados_Rfc_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "RFC"));
            AE.Administrador_Empleados_Curp_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "CURP"));
            AE.Administrador_Empleados_Tipo_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "Tipo"));
            AE.Administrador_Empleados_EstadoCivil_Txt.setText(modelo.empleadosObtenerDato("Id", idBusqueda, "Estado civil"));
            AE.Administrador_Empleados_Estado_CBox.setSelectedItem(modelo.empleadosObtenerDato("Id", idBusqueda, "Estado"));
            
            
        }
        if(e.getSource() == AD.Administrador_Doctores_TablaDoctores_Table)
        {
            int fila = AD.Administrador_Doctores_TablaDoctores_Table.rowAtPoint(e.getPoint());
            String idBusqueda = String.valueOf(AD.Administrador_Doctores_TablaDoctores_Table.getValueAt(fila, 0));
            AD.Administrador_Doctores_Id_Txt.setText(modelo.doctoresObtenerDato("Id", idBusqueda, "Id"));
            AD.Administrador_Doctores_Especialidad_Txt.setText(modelo.doctoresObtenerDato("Id", idBusqueda, "Especialidad"));
            AD.Administrador_Doctores_NumeroCedula_Txt.setText(modelo.doctoresObtenerDato("Id", idBusqueda, "NumCedula"));
        }
        if(e.getSource() == AP.Administrador_Pacientes_TablaPacientes_Table)
        {
            int fila = AP.Administrador_Pacientes_TablaPacientes_Table.rowAtPoint(e.getPoint());
            String idBusqueda = String.valueOf(AP.Administrador_Pacientes_TablaPacientes_Table.getValueAt(fila, 0));
            AP.Administrador_Pacientes_Id_Txt.setText(modelo.pacientesObtenerDato("Id", idBusqueda, "Id"));
            AP.Administrador_Pacientes_Nombre_Txt.setText(modelo.pacientesObtenerDato("Id", idBusqueda, "Nombre"));
            AP.Administrador_Pacientes_ApellidoPaterno_Txt.setText(modelo.pacientesObtenerDato("Id", idBusqueda, "Paterno"));
            AP.Administrador_Pacientes_ApellidoMaterno_Txt.setText(modelo.pacientesObtenerDato("Id", idBusqueda, "Materno"));
            AP.Administrador_Empleados_FechaNacimiento_DPicker.setDate(StringBD_a_DateParaInput(modelo.pacientesObtenerDato("Id", idBusqueda, "Fecha")));
            AP.Administrador_Pacientes_Edad_Txt.setText(modelo.pacientesObtenerDato("Id", idBusqueda, "Edad"));
            AP.Administrador_Pacientes_Correo_Txt.setText(modelo.pacientesObtenerDato("Id", idBusqueda, "Correo"));
            AP.Administrador_Pacientes_Direccion_Txt.setText(modelo.pacientesObtenerDato("Id", idBusqueda, "Direccion"));
            AP.Administrador_Pacientes_Telefono_Txt.setText(modelo.pacientesObtenerDato("Id", idBusqueda, "Telefono"));
            AP.Administrador_Pacientes_Celular_Txt.setText(modelo.pacientesObtenerDato("Id", idBusqueda, "Celular"));
            AP.Administrador_Pacientes_Genero_CBox.setSelectedItem(modelo.pacientesObtenerDato("Id", idBusqueda, "Genero"));
            AP.Administrador_Pacientes_Curp_Txt.setText(modelo.pacientesObtenerDato("Id", idBusqueda, "CURP"));
            AP.Administrador_Pacientes_EstadoCivil_Txt.setText(modelo.pacientesObtenerDato("Id", idBusqueda, "ECiv"));
        }
        if(e.getSource() == ADC.Administrador_DatosCitas_TablaCitas_Table)
        {
            int fila = ADC.Administrador_DatosCitas_TablaCitas_Table.rowAtPoint(e.getPoint());
            String idCita = String.valueOf(ADC.Administrador_DatosCitas_TablaCitas_Table.getValueAt(fila, 0));
            ADC.Administrador_DatosCitas_TablaDatosCitas_Table.setModel(modelo.datosCitaDatosCitaConsultar(idCita));
            
            datosCitaLimpiarCampos();
            ADC.Administrador_DatosCitas_IdCita_Txt.setText(idCita);
        }
        if(e.getSource() == ADC.Administrador_DatosCitas_TablaDatosCitas_Table)
        {
            int fila = ADC.Administrador_DatosCitas_TablaCitas_Table.rowAtPoint(e.getPoint());
            String idCita = String.valueOf(ADC.Administrador_DatosCitas_TablaDatosCitas_Table.getValueAt(fila, 0));
            ADC.Administrador_DatosCitas_Id_Txt.setText(modelo.datosCitaObtenerDato("Id", idCita, "Id"));
            ADC.Administrador_DatosCitas_IdCita_Txt.setText(modelo.datosCitaObtenerDato("Id", idCita, "Id cita"));
            ADC.Administrador_DatosCitas_Servicio_Txt.setText(modelo.datosCitaObtenerDato("Id", idCita, "Servicio"));
            ADC.Administrador_DatosCitas_Descripcion_Txt.setText(modelo.datosCitaObtenerDato("Id", idCita, "Descripcion"));
        }
        if(e.getSource() == AUT.Administrador_Utensilios_TablaCitas_Table)
        {
            int fila = AUT.Administrador_Utensilios_TablaCitas_Table.rowAtPoint(e.getPoint());
            String idCita = String.valueOf(AUT.Administrador_Utensilios_TablaCitas_Table.getValueAt(fila, 0));
            this.AUT.Administrador_Utensilios_TablaUtensilios_Table.setModel(modelo.utensiliosUtensiliosConsultar(idCita));
            AUT.Administrador_Utensilios_IdCita_Txt.setText(idCita);
        }
        if(e.getSource() == AUT.Administrador_Utensilios_TablaUtensilios_Table)
        {
            int fila = AUT.Administrador_Utensilios_TablaUtensilios_Table.rowAtPoint(e.getPoint());
            String idCita = String.valueOf(AUT.Administrador_Utensilios_TablaUtensilios_Table.getValueAt(fila, 0));
            AUT.Administrador_Utensilios_IdRegistroUtensilios_Txt.setText(modelo.utensiliosObtenerDato("Id", idCita, "Id"));
            AUT.Administrador_Utensilios_IdCita_Txt.setText(modelo.utensiliosObtenerDato("Id", idCita, "Id cita"));
            AUT.Administrador_Utensilios_IdArticulo_Txt.setText(modelo.utensiliosObtenerDato("Id", idCita, "Id articulo"));
            AUT.Administrador_Utensilios_IdArticulo_Txt.setEnabled(false);
            AUT.Administrador_Utensilios_Cantidad_Txt.setText(modelo.utensiliosObtenerDato("Id", idCita, "Cantidad"));
            AUT.Administrador_Utensilios_Cantidad_Txt.setEnabled(false);
            AUT.Administrador_Utensilios_Existencia_Txt.setText(modelo.articulosObtenerDato("Id", AUT.Administrador_Utensilios_IdArticulo_Txt.getText(), "Existencia"));
            AUT.Administrador_Utensilios_Existencia_Txt.setEnabled(false);
            AUT.Administrador_Utensilios_Incremento_CBox.setModel(new SpinnerNumberModel(0, 0, Integer.parseInt(AUT.Administrador_Utensilios_Existencia_Txt.getText()), 1));
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
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
    public String HoraAFormatoBD_NoCeros( javax.swing.JSpinner horaSpinner){
        DateTime dt = new DateTime(horaSpinner.getValue());
        int horaN = dt.getHourOfDay();
        int minutoN = dt.getMinuteOfHour();
        String hora = Integer.toString(horaN);
        String minuto = Integer.toString(minutoN);
        
        if(horaN<10)
            hora = "0" + hora;
        if(minutoN<10)
            minuto = "0" + minuto;
        
        return hora + ":" + minuto;
        
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
        
        //para que salga 0 si es menor a 10 el dia o el mes (como si es 6, que se vea 06)
        if(mesN<10)
            mesS = "0" + mesS;
        if(diaN<10)
            diaS = "0" + diaS;
        
        return anoS + "-" + mesS + "-" + diaS;
    }
    public boolean vaciosONoTxt(javax.swing.JTextField... args)
    {
        
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
    public String FechaDespuesDeTantosMinutos(int minutos, String FechaUHora,org.jdesktop.swingx.JXDatePicker fecha, javax.swing.JSpinner spin)
    {
        
        String currentDate ;
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date1= null;
        DateTime dt;

        currentDate = FechaAFormatoBD(fecha)+" "+HoraAFormatoBD_NoCeros(spin);
        try {
            date1= myFormat.parse(currentDate);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        dt = new DateTime(date1);
        dt = dt.plusMinutes(minutos);
        
        String minuto = Integer.toString(dt.getMinuteOfHour());
        String hora = Integer.toString(dt.getHourOfDay());
        String dia = Integer.toString(dt.getDayOfMonth());
        String mes = Integer.toString(dt.getMonthOfYear());
        String ano = Integer.toString(dt.getYear());
        if(Integer.parseInt(minuto)<10)
            minuto = "0" + minuto;
        if(Integer.parseInt(hora)<10)
            hora = "0" + hora;
        if(Integer.parseInt(dia)<10)
            dia = "0" + dia;
        if(Integer.parseInt(mes)<10)
            mes = "0" + mes;
    
        if(FechaUHora.equalsIgnoreCase("fecha"))
            return ano+"-"+mes+"-"+dia;
        if(FechaUHora.equalsIgnoreCase("hora"))
            return "0000-00-00 "+hora+":"+minuto;
        
        return "";
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() == AUT.Administrador_Utensilios_Existencia_Txt)
        {
            if(AUT.Administrador_Utensilios_IdArticulo_Txt.getText().equals(""))
                AUT.Administrador_Utensilios_Existencia_Txt.setText("");
            else
            {
                AUT.Administrador_Utensilios_Existencia_Txt.setText(modelo.articulosObtenerDato("Id", AUT.Administrador_Utensilios_IdArticulo_Txt.getText(), "Existencia"));
                AUT.Administrador_Utensilios_Incremento_CBox.setModel(new SpinnerNumberModel(0, 0, Integer.parseInt(AUT.Administrador_Utensilios_Existencia_Txt.getText()), 1));
            }
                
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }
}
