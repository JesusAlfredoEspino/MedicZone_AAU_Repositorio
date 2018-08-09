/*
 Controlador con el cual se manejan todos los enventos, datos y validaciones 
    para el inicio de sesion del sistema
 */
package controlador;

import modelo.ModeloInicioSesion;
import vista.Desktop_InicioSesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.*;
import javax.swing.ImageIcon;
import org.joda.time.*;

/**
 *
 * @author office depot
 */
public class ControladorInicioSesion implements ActionListener, MouseListener {
    
    private ModeloInicioSesion modelo;
    private Desktop_InicioSesion vista;
    public boolean Ingreso;
    public String TipoUsuario;
    public String idEmpleado;
    public String NombreUsuario;
    public long threadId;

    public ControladorInicioSesion(ModeloInicioSesion modelo, Desktop_InicioSesion vista, long TID) {
        this.Ingreso = false;
        this.TipoUsuario = "";
        this.modelo = modelo;
        this.vista = vista;
        this.threadId = TID;
        this.idEmpleado = "0";
        this.vista.Usuario_InicioSesion_Entrar_Btn.addActionListener(this);
        this.vista.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoInicio.png")).getImage());
    }
    public ControladorInicioSesion(ControladorInicioSesion c) {
        this.Ingreso = c.Ingreso;
        this.TipoUsuario = c.TipoUsuario;
        this.modelo = c.modelo;
        this.vista = c.vista;
        this.NombreUsuario = c.NombreUsuario;
        this.idEmpleado = c.idEmpleado;
        
        this.vista.Usuario_InicioSesion_Entrar_Btn.addActionListener(this);
    }
    
    public void iniciarVista(){
        vista.setTitle("Medic-Zone - Inicio Sesión");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
    }
    
    public boolean getIngreso()
    {
        return this.Ingreso;
    }

    public String getTipoUsuario() {
        return this.TipoUsuario;
    }
    
    public void finalizarVista()
    {
        this.vista.setVisible(false);
        this.vista.dispose();
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(vista.Usuario_InicioSesion_Entrar_Btn == evento.getSource())
        {
            String UsuarioTXT = vista.Usuario_InicioSesion_Usuario_Txt.getText();
            String ContraTXT = vista.Usuario_InicioSesion_Contra_Txt.getText();
            if(!vaciosONoTxt(vista.Usuario_InicioSesion_Usuario_Txt,vista.Usuario_InicioSesion_Contra_Txt))
            {
                System.out.println("Estan vacios >:b");
                JOptionPane.showMessageDialog(null, "ERROR: Campos vacios o con caracteres inválidos");
            }
            else
            {
                String contraIntento = modelo.obtenerContra(UsuarioTXT);
                if(contraIntento.equals(""))
                {
                    System.out.println("Contra incorrecta");
                    JOptionPane.showMessageDialog(null, "ERROR: Contraseña incorrecta");
                }
                else
                {
                    if(!contraIntento.equals(ContraTXT))
                    {
                        System.out.println("Contraseña incorrecta");
                        JOptionPane.showMessageDialog(null, "ERROR: Contraseña incorrecta");
                    }
                    else
                    {
                        System.out.println("Contraseña correcta");

                        
                        this.idEmpleado = modelo.obtenerIdEmpleadoUsuario(UsuarioTXT);
                        this.TipoUsuario = modelo.obtenerTipoUsuario(UsuarioTXT);
                        this.NombreUsuario = modelo.obtenerNombreEmpleado(UsuarioTXT);
                        this.Ingreso = true;
                        this.finalizarVista();                        
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
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
    
}
