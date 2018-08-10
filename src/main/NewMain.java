/*
 * Mazatlan, Sinaloa. Martes 17 de abril del 2018
 * Medic Zone
 * Sistema de gestion de informacion para consultorio Medico
 * 
 * INF 5-1
 *
 * Desarrolladores:
 * Jesus Espino
 * Erick Medina
 * Jose Vizcarra
 * Marcos Castro

    Archivo del main, en el cual se utilizan hilos para controlar las diversas
    partes del sistema
 */
//EL CHUY ES UN DIOS!!!!!! xdxdxds
package main;
//jaja xdxds
import controlador.ControladorInicioSesion;
import modelo.ModeloInicioSesion;
import vista.Desktop_InicioSesion;

import controlador.ControladorAdministrador;
import controlador.ControladorDoctor;
import controlador.ControladorRecepcionista;
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

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import org.joda.time.*;
import javax.swing.*;
import modelo.ModeloDoctor;
import modelo.ModeloRecepcionista;
import vista.Desktop_Doctor;
import vista.Desktop_Recepcionista;
import vista.IF_DoctorCita;
import vista.IF_DoctorDatosPacientes;
import vista.IF_DoctorEditarPacientes;
import vista.IF_DoctorHistorialMedico;
import vista.IF_DoctorAgenda;
import vista.IF_RecepcionistaAgregarPaciente;
import vista.IF_RecepcionistaEditarPaciente;
import vista.IF_RecepcionistaCitas;
import vista.IF_RecepcionistaNuevaCita;
import vista.IF_RecepcionistaPacientes;

/**
 *
 * @author office depot
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {          
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println(ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }
        
        //hilo para inicio de sesion
        class HiloIS extends Thread{
            public ControladorInicioSesion contrIS;

            public HiloIS(String name) {
                super(name);
            }
            
            @Override
            public void run(){
                    ModeloInicioSesion modIS = new ModeloInicioSesion();
                    Desktop_InicioSesion visIS = new Desktop_InicioSesion();
                    contrIS = new ControladorInicioSesion(modIS, visIS,this.getId());
                    contrIS.iniciarVista();      
                    
                    //espera a que el ingreso sea true (que ingreso bien) antes de morir el Thread/Hilo
                    while(!contrIS.getIngreso()){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    
            }
            public ControladorInicioSesion getContrIS() {
                return contrIS;
            }
        }
        //hilo para espera
        class HiloES extends Thread{

            public HiloES(String name) {
                super(name);
            }
            
            @Override
            public void run(){
                    
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
            }
        }
        //hilo para todo lo demas/ que se abra la vista del usuario
        class HiloUSU extends Thread{
            public ControladorInicioSesion contrIS;
            
            public HiloUSU(String name,ControladorInicioSesion c) {
                super(name);
                this.contrIS = new ControladorInicioSesion(c);
            }
            
            @Override
            public void run(){
                
                switch (contrIS.TipoUsuario) {
                    case "Administrador":
                        ModeloAdministrador modAD = new ModeloAdministrador();
                        Desktop_Administrador vistaDesktopAD = new Desktop_Administrador();
                        IF_AdministradorArticulosCita AAC = new IF_AdministradorArticulosCita();
                        IF_AdministradorCitas AC = new IF_AdministradorCitas();
                        IF_AdministradorDatosCita ADC = new IF_AdministradorDatosCita();
                        IF_AdministradorDoctores AD = new IF_AdministradorDoctores();
                        IF_AdministradorEmpleados AE = new IF_AdministradorEmpleados();
                        IF_AdministradorPacientes AP = new IF_AdministradorPacientes();
                        IF_AdministradorUsuarios AUS = new IF_AdministradorUsuarios();
                        IF_AdministradorUtensilios AUT = new IF_AdministradorUtensilios();
                        ControladorAdministrador contrAD = new ControladorAdministrador(modAD, vistaDesktopAD, AAC, AC, ADC, AD, AE, AP, AUS, AUT,contrIS.NombreUsuario);
                        contrAD.iniciarVista();
                        
                        while(contrAD.banderaSalida == 0)
                        {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                        
                        break;
                    case "Doctor":
                        ModeloDoctor modDoc = new ModeloDoctor();
                        Desktop_Doctor DeskD = new Desktop_Doctor();
                        IF_DoctorCita DC = new IF_DoctorCita();
                        IF_DoctorDatosPacientes DDP = new IF_DoctorDatosPacientes();
                        IF_DoctorEditarPacientes DEP = new IF_DoctorEditarPacientes();
                        IF_DoctorHistorialMedico DHM = new IF_DoctorHistorialMedico();
                        IF_DoctorAgenda DI = new IF_DoctorAgenda();
                        ControladorDoctor contrDoc = new ControladorDoctor(modDoc, DeskD, DC, DDP, DEP, DHM, DI, contrIS.NombreUsuario,contrIS.idEmpleado);
                        contrDoc.iniciarVista();
                        
                        while(contrDoc.banderaSalida == 0)
                        {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                        
                        break;
                    case "Recepcionista":
                        ModeloRecepcionista modRec = new ModeloRecepcionista();
                        Desktop_Recepcionista vistaDesktop = new Desktop_Recepcionista();
                        IF_RecepcionistaAgregarPaciente AP2 = new IF_RecepcionistaAgregarPaciente();
                        IF_RecepcionistaEditarPaciente EP = new IF_RecepcionistaEditarPaciente();
                        IF_RecepcionistaCitas I = new IF_RecepcionistaCitas();
                        IF_RecepcionistaNuevaCita NC = new IF_RecepcionistaNuevaCita();
                        IF_RecepcionistaPacientes P = new IF_RecepcionistaPacientes();
                        
                        ControladorRecepcionista contrRec = new ControladorRecepcionista(modRec, vistaDesktop, AP2, EP, I, NC, P, contrIS.NombreUsuario,contrIS.idEmpleado);
                        contrRec.IniciarVista();
                        
                        while(contrRec.banderaSalida == 0)
                        {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                        
                        break;
                    case "Proveedor":
                        
                        break;
                    default:
                        break;
                }
                
            }
            
        }
        
        HiloIS hiloInicioSesion = new HiloIS("hiloDeIS");
        HiloES hiloEspera;
        HiloUSU hiloUsuario;
        
        while(true)
        {
            hiloInicioSesion = new HiloIS("hiloDeIS");
            hiloInicioSesion.start();
            try {
                hiloInicioSesion.join();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            hiloEspera = new HiloES("hiloDeES");
            hiloEspera.start();
            try {
                hiloEspera.join();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            //esperamos que termine el thread de inicio sesion para ir con el siguiente
            //porque sino no se tiene el nombre de usuario ni el id del usuario
            hiloUsuario = new HiloUSU("hiloDeLoDemas",hiloInicioSesion.getContrIS());
            hiloUsuario.start();
            try {
                hiloUsuario.join();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        
        
    }
    
}
