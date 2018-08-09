/*
 Modelo para el usuario de recepcionista de Medic Zone
    Dentro de esta clase se encuentran metodos de consultas para cargar
    las tablas u obtener valores individuales.
    Igualmente se ejecutan actualizaciones de datos (inserciones, actualizaciones,
    eliminaciones)
 */
package modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jose_
 */ 
public class ModeloRecepcionista {
    private Conexion conexion = new Conexion();
    
    public DefaultTableModel CitasConsultar(){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            
            try{
                ResultSet rs = s.executeQuery("select citas.id_Cita as 'ID', "
                                             + "citas.Fecha_Cita as 'Fecha', "
                                             + "citas.Hora_Cita as 'Hora', "
                                             + "pacientes.Nom_Pac as 'Paciente' "
                                             + "from citas, pacientes "
                                             + "where citas.id_Pac = pacientes.id_Pac and Fecha_Cita = CURDATE();");
                modelo = new DefaultTableModel();
                
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();
                
                for(int i=1;i <=cantidadColumnas;i++){
                    modelo.addColumn(rsMd.getColumnLabel(i));
                }
                while(rs.next()){
                    Object[] fila = new Object[cantidadColumnas];
                    for(int i = 0; i<cantidadColumnas; i++){
                        fila[i]=rs.getObject(i+1);
                        
                        
                    }
                    modelo.addRow(fila);
                }
                System.out.println("asdf");
                return modelo;
            }finally{
                conexion.cerrarConexion(con);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
            }                                  
    }
    public DefaultTableModel NuevaCitaConsultar(){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            
            try{
                ResultSet rs = s.executeQuery("select Nom_Pac as 'Nombre',"
                                                + "PApell_Pac as 'A. Paterno',"
                                                + "MApell_Pac as 'A. Materno',"
                                                + "CURP_Pac as 'CURP' "
                                                + "from pacientes;");
               modelo = new DefaultTableModel();
                
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();
                
                for(int i=1;i <=cantidadColumnas;i++){
                    modelo.addColumn(rsMd.getColumnLabel(i));
                }
                while(rs.next()){
                    Object[] fila = new Object[cantidadColumnas];
                    for(int i = 0; i<cantidadColumnas; i++){
                        fila[i]=rs.getObject(i+1);
                        
                        
                    }
                    modelo.addRow(fila);
                }
                return modelo;
            }finally{
                conexion.cerrarConexion(con);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
            }                          
    }
    public boolean InsertarPacientes(String Nombre, String Paterno, String Materno, String Fecha, String Edad, String Correo, String Direccion, String Telefono, String Celular, String Genero, String CURP, String ECivil){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate("insert into pacientes(Nom_Pac, PApell_Pac, MApell_Pac, FNac_Pac, Edad_Pac, Correo_Pac, Direccion_Pac, Telefono_Pac, Celular_Pac, Gene_Pac, CURP_Pac, ECiv_Pac) values('" 
                    + Nombre + "', '" + Paterno + "', '" + Materno + "', '" + Fecha +  "', '" + Edad + "', '" + Correo + "', '" + Direccion + "', '" + Telefono + "', '" + Celular + "', '" + Genero + "', '" + CURP + "', '" + ECivil + "');");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public DefaultTableModel CitasConsultar(String mostrarCodicion){
        String sqlExtra = "";
        if(mostrarCodicion.equals("De hoy"))
            sqlExtra = "and Fecha_Cita = CURDATE();";
        if(mostrarCodicion.equals("Activas"))
            sqlExtra = "and Estado_Cita = 1;";
        if(mostrarCodicion.equals("Finalizadas"))
            sqlExtra = "and Estado_Cita = 0;";
         try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            
            try{
                ResultSet rs = s.executeQuery("select c.id_Cita as 'Id cita', c.Fecha_Cita as 'Fecha', p.Nom_Pac as 'Nombre paciente', p.PApell_Pac as 'Apellido paciente', p.CURP_Pac as 'CURP paciente	' from citas as c, pacientes as p where p.id_Pac = c.id_Pac "+sqlExtra+" ;");
                modelo = new DefaultTableModel();
                
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();
                
                for(int i=1;i <=cantidadColumnas;i++){
                    modelo.addColumn(rsMd.getColumnLabel(i));
                }
                while(rs.next()){
                    Object[] fila = new Object[cantidadColumnas];
                    for(int i = 0; i<cantidadColumnas; i++){
                        fila[i]=rs.getObject(i+1);
                        
                    }
                    modelo.addRow(fila);
                }
                return modelo;
            }finally{
                conexion.cerrarConexion(con);
            }
            
        }
        catch(SQLException e){
            return null;
        }
    }
    public boolean InsertarCita(String Fecha, String Hora, String idpac, String idRec, String descripcion)
    {
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate("insert into citas(id_Pac, id_Rec, Descripcion_Cita, Fecha_Cita, Hora_Cita, id_Doc, Conclusion_Cita, Estado_Cita) values( "+idpac+","+idRec+", '"+descripcion+"','" + Fecha + "','" + Hora + "',0,'',1);");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean cambiarcita(int idcita){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate("UPDATE `citas` SET `Estado_Cita` = '0' WHERE `citas`.`id_Cita` = "+idcita+" ;");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public DefaultTableModel RecepcionistaPacientesConsultar(){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery(
                       "select Nom_Pac as 'Nombre pacientes', "+ "CURP_Pac as 'CURP', "+ "Gene_Pac as 'Genero' "+ "from pacientes");
                modelo = new DefaultTableModel();
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();
                for(int i=1;i <=cantidadColumnas;i++){
                    modelo.addColumn(rsMd.getColumnLabel(i));
                }
                while(rs.next()){
                    Object[] fila = new Object[cantidadColumnas];
                    for(int i = 0; i<cantidadColumnas; i++){
                        fila[i]=rs.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
                return modelo;
            }finally{
                conexion.cerrarConexion(con);
            }
        }
        catch(SQLException e){
            return null;
        }
    }
    public boolean PacientesActualizar(String ReId, String ReNom, String ReApePat, String ReApeMat, String ReFecha, String ReCorreo, String ReDire, String ReTel, String ReCel,String ReGen, String ReCurp, String ReEsCiv){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "update pacientes set id_Pac = '" + ReId + "', Nom_Pac = '" + ReNom + "', PApell_Pac = '" + ReApePat + "', MApell_Pac = '" + ReApeMat + "', FNac_Pac = '" +  ReFecha + "', Correo_Pac = '" + ReCorreo + "', Direccion_Pac = '" + ReDire + "', Telefono_Pac = '" + ReTel + "', Celular_Pac = '" + ReCel + "', Gene_Pac = '" + ReGen + "', CURP_Pac = '" + ReCurp + "', ECiv_Pac = '" + ReEsCiv + "' where Id_Pac = '" + ReId + "';");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        }
    } 
    public String PacientesObtenerDato(String datoBusqueda, String valorBusqueda, String datoDeseado){
        
        String dat = "";
        String valor = "";
        String que = "*";
        if(datoBusqueda.equals("CURP"))
            dat = "and CURP_Pac = ";
        valor = valorBusqueda;
        
        
        if(datoDeseado.equals("Id"))
            que = "id_Pac";
        if(datoDeseado.equals("Nombre"))
            que = "Nom_Pac";
        if(datoDeseado.equals("Apellido paterno"))
            que = "PApell_Pac";
        if(datoDeseado.equals("Apellido materno"))
            que = "MaPell_Pac";
        if(datoDeseado.equals("Fecha"))
            que = "FNac_Pac";
        if(datoDeseado.equals("Edad"))
            que = "Edad_Pac";
        if(datoDeseado.equals("Correo"))
            que = "Correo_Pac";
        if(datoDeseado.equals("Direccion"))
            que = "Direccion_Pac";
        if(datoDeseado.equals("Telefono"))
            que = "Telefono_Pac";
        if(datoDeseado.equals("Celular"))
            que = "Celular_Pac";
        if(datoDeseado.equals("Genero"))
            que = "Gene_Pac";
        if(datoDeseado.equals("CURP"))
            que = "CURP_Pac";
        if(datoDeseado.equals("Estado civil"))
            que = "ECiv_Pac";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery(
                "select "+ que + " from pacientes " + "where CURP_Pac = CURP_Pac " + dat +"'"+ valor + "' ;");
                if(rs.next())
                {
                    return rs.getObject(1).toString();
                }
                else{
                    System.out.println("select "+ que + " from pacientes " + "where CURP_Pac = CURP_Pac " + dat +"'"+ valor + "' ;");
                    System.out.println("Dato inexistente...");
                    return "";
                }
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }finally{
                conexion.cerrarConexion(con);
            }
        }
        catch(SQLException e){
            return null;
        }
            
        return "";
    }
    
}

