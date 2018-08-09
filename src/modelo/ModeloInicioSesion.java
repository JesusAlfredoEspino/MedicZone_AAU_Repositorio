/*
Modelo para el el inicio de sesion de Medic Zone
    Dentro de esta clase se encuentran metodos de consultas para obtener datos
    utiles para comprobar el inicio de sesion
    
*/
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author office depot
 */
public class ModeloInicioSesion {
    
    private Conexion conexion = new Conexion();
    
    /**
     * Obtiene la contraseña de un usuario con su nombre de usuario
     * @param Usu
     * @return
     */
    public String obtenerContra(String Usu)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery("select Passw from usuarios where Usuario = '"+Usu+"';");
                
                if(rs.next())
                {
                    return rs.getObject(1).toString();
                }
                else
                {
                    System.out.println("Ese Usuario no existe...");
                    return "";
                }
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }finally{
                conexion.cerrarConexion(con);
            }
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return "";
        }
        return "";
    }
    public String obtenerIdEmpleadoUsuario(String Usu)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            
            try{
                ResultSet rs = s.executeQuery("select id_Emp from usuarios where Usuario = '"+Usu+"';");
                
                if(rs.next())
                {
                    return rs.getObject(1).toString();
                }
                else
                {
                    System.out.println("Ese Usuario no existe...");
                    return "";
                }
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }finally{
                conexion.cerrarConexion(con);
            }
            
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return "";
        }
        return "";
    }
    // obtiene tipo de usuario con su nombre de usuario
    public String obtenerTipoUsuario(String Usu)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            
            try{
                ResultSet rs = s.executeQuery("select Tipo from usuarios where Usuario = '"+Usu+"';");
                
                if(rs.next())
                {
                    return rs.getObject(1).toString();
                }
                else
                {
                    System.out.println("Ese Usuario no existe...");
                    return "";
                }
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }finally{
                conexion.cerrarConexion(con);
            }
            
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return "";
        }
        return "";
    }
    // obtiene el nombre del empleado con el nombre de usuario
    public String obtenerNombreEmpleado(String Usu)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            Statement s1 = con.createStatement();
            Statement s2 = con.createStatement();
            Statement s3 = con.createStatement();
            
            try{
                
                ResultSet rs = s.executeQuery("select id_Emp from usuarios where Usuario = '"+Usu+"';");
                
                String IDEmp;
                
                if(rs.next())
                {
                    IDEmp = rs.getObject(1).toString();
                }
                else
                {
                    return "";
                }
                
                ResultSet rs1 = s1.executeQuery("select Nom_Emp from empleados where id_Emp = '"+IDEmp+"';");
                ResultSet rs2 = s2.executeQuery("select PApell_Emp from empleados where id_Emp = '"+IDEmp+"';");
                ResultSet rs3 = s3.executeQuery("select MApell_Emp from empleados where id_Emp = '"+IDEmp+"';");
                
                String NombreCompleto;
                
                if(rs1.next())
                {
                    NombreCompleto = rs1.getObject(1).toString();
                }
                else
                {
                    System.out.println("Ese empleado no existe...");
                    return "";
                }
                if(rs2.next())
                {
                    NombreCompleto += " " + rs2.getObject(1).toString();
                }
                else
                {
                    System.out.println("Ese Usuario no existe...");
                    return "";
                }
                if(rs3.next())
                {
                    NombreCompleto += " " + rs3.getObject(1).toString();
                }
                else
                {
                    System.out.println("Ese Usuario no existe...");
                    return "";
                }
                return NombreCompleto;
            }
            catch(Exception ex){
                
            }finally{
                conexion.cerrarConexion(con);
            }
            
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return "";
        }
        
        return "";
    }
    
}
