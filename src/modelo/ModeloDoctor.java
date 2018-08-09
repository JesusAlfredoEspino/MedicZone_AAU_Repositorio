/*
 Modelo para el usuario de Doctor de Medic Zone
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
 * @author marco
 */
public class ModeloDoctor {
    
    private Conexion conexion = new Conexion();
    
     public DefaultTableModel DoctorInicioConsultar(){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            
            try{
                ResultSet rs = s.executeQuery("select c.id_Cita as 'Id cita', c.Fecha_Cita as 'Fecha', p.Nom_Pac as 'Nombre paciente', p.PApell_Pac as 'Apellido paciente', p.CURP_Pac as 'CURP paciente	' from citas as c, pacientes as p where p.id_Pac = c.id_Pac and Fecha_Cita = CURDATE();\n" +
"");
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
     
     public DefaultTableModel DoctorInicioConsultar(String mostrarCondicion)
     {
        String sqlExtra = "";
        if(mostrarCondicion.equals("De hoy"))
            sqlExtra = " and c.Fecha_Cita = CURDATE() ";
        if(mostrarCondicion.equals("Activas"))
            sqlExtra = " and c.Estado_Cita = 1 ";
        if(mostrarCondicion.equals("Finalizadas"))
            sqlExtra = " and c.Estado_Cita = 0 ";
        
        
        
         try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            
            try{
                ResultSet rs = s.executeQuery("select c.id_Cita as 'Id cita', c.Hora_Cita as 'Hora', c.Fecha_Cita as 'Fecha', p.Nom_Pac as 'Nombre paciente', p.PApell_Pac as 'Apellido paciente', p.CURP_Pac as 'CURP paciente	' from citas as c, pacientes as p where p.id_Pac = c.id_Pac "+sqlExtra+" ;");
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
     public DefaultTableModel DoctorDatosConsultar(String mostrarCondicion)
     {
        String sqlExtra = "";
        if(mostrarCondicion.equals("De hoy"))
            sqlExtra = " and c.Fecha_Cita = CURDATE() ";
        if(mostrarCondicion.equals("Activas"))
            sqlExtra = " and c.Estado_Cita = 1 ";
        if(mostrarCondicion.equals("Finalizadas"))
            sqlExtra = " and c.Estado_Cita = 0 ";
        
        
        
         try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            
            try{
                ResultSet rs = s.executeQuery("select c.id_Cita as 'Id cita', c.Fecha_Cita as 'Fecha', p.Nom_Pac as 'Nombre paciente', p.PApell_Pac as 'Apellido paciente', p.CURP_Pac as 'CURP paciente' from citas as c, pacientes as p where p.id_Pac = c.id_Pac "+sqlExtra+" order by p.CURP_Pac asc ;");
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
     public String[] obtenerCantidadArticulos(int que)
     {
        
         try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            Statement s1 = con.createStatement();
            try{
                ResultSet rs = s.executeQuery("select count(*) from articuloscita ;");
                
                 int cantidad = 0;
                if(rs.next())
                {
                    cantidad = Integer.parseInt(rs.getObject(1).toString());
                }
                else
                {
                    System.out.println("Ese articulo no existe...");
                    return new String[0];
                }
                
                ResultSet rs1 = s1.executeQuery("select * from articuloscita ;");
                
                String []arr = new String[cantidad];
                int i=0;
                while(rs1.next())
                {
                    arr[i] = rs1.getObject(que).toString();
                    i++;
                }
                return arr;
                
            }finally{
                conexion.cerrarConexion(con);
            }
        }
        catch(SQLException e){
            return new String[0];
        }
    }
     public DefaultTableModel DoctorDatosConsultar(int idCita)
     {
      
         try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            
            try{
                ResultSet rs = s.executeQuery("select Servicio_Datos as 'Servicio', Descripcion_Datos as 'Descripcion' from datoscita where id_Cita  = "+idCita+" order by id_Cita asc ;");
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
    
     public boolean datoscitaInsertar( String idCita, String servicio, String descripcion){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "insert into datoscita values(null, '"
                    +idCita+"','"+servicio+"','" +descripcion+"'"
                    +");");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
     public boolean utensiliosInsertar( String idCita, String IdArt, String cantidad){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "insert into utensilios values(null, '"
                    +idCita+"','"+IdArt+"','" +cantidad+"'"
                    +");");
            Statement s1 = con.createStatement();
            int registro1 = s1.executeUpdate("update articuloscita set Existencia_Art = Existencia -"+cantidad+" where id_Art="+IdArt);
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
     public boolean citaActualizar( String idDoc, String conclusion, String idcita){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "update citas set id_Doc = "+idDoc+" Conclusion ='"+conclusion+"' where id_Cita = "+idcita
                    +" ;");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
     
     public DefaultTableModel DoctorHistorialConsultar(){
         try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            
            try{
                ResultSet rs = s.executeQuery("SELECT Nom_Pac, PApell_Pac, MApell_Pac, CURP_Pac FROM pacientes;");
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
     
     public DefaultTableModel DoctorHistorialConsultar(String mostrarCondicion, String OrdenarPor)
     {
         try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            String sqlExtra = "";
            String sqlplus = "";
            if(mostrarCondicion.equals("Mujeres"))
                sqlExtra = "WHERE Gene_Pac = 'Femenino';";
            if(mostrarCondicion.equals("Hombres"))
                sqlExtra = "WHERE Gene_Pac = 'Masculino';";
            
            if(OrdenarPor.equals("CURP"))
                sqlplus = "ORDER BY CURP_Pac ASC;";
            if(OrdenarPor.equals("Edad"))
                sqlplus = "ORDER BY Edad_Pac ASC;";
            if(OrdenarPor.equals("Registro"))
                sqlplus = "ORDER BY id_Pac ASC;";
            
            try{
                ResultSet rs = s.executeQuery("SELECT id_Pac as 'Id', Nom_Pac as 'Nombre', PApell_Pac as 'Apellido paterno', MApell_Pac as 'Apellido materno', CURP_Pac as 'CURP' FROM pacientes " +sqlExtra+" "+sqlplus+" ;");
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
     public DefaultTableModel DoctorHistorialConsultar( String idPaciente)
     {
         try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            
            try{
                ResultSet rs = s.executeQuery("SELECT id_Cita as 'Id cita', id_Doc as 'Id doctor', Fecha_Cita as 'Fecha' FROM citas where id_Pac = "+idPaciente+" ORDER BY id_Pac ASC;");
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
     public String citasObtenerDato(String datoBusqueda, String valorBusqueda, String datoDeseado){
        
        String dat = "";
        String valor = "";
        String que = "*";
        if(datoBusqueda.equals("Id"))
            dat = "and id_Cita = ";

        valor = valorBusqueda;
        
        if(datoDeseado.equals("Conclusion"))
            que = "Conclusion_Cita";
        if(datoDeseado.equals("Id doctor"))
            que = "id_Doc";
        if(datoDeseado.equals("Fecha"))
            que = "Fecha_Cita";
        if(datoDeseado.equals("Id paciente"))
            que = "id_Pac";
        
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                
                ResultSet rs = s.executeQuery(
                "select "+ que +"  from citas where id_Cita = id_Cita " + dat + valor + ";"
                );
                
                if(rs.next())
                {
                    return rs.getObject(1).toString();
                }
                else
                {
                    System.out.println("Ese articulo no existe...");
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
     public DefaultTableModel DoctorEditarPaciente(String mostrarCondicion, String OrdenarPor)
     {
         try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            String sqlExtra = "";
            String sqlplus = "";
            if(mostrarCondicion.equals("Mujeres"))
                sqlExtra = " WHERE Gene_Pac = 'Femenino' ";
            if(mostrarCondicion.equals("Hombres"))
                sqlExtra = " WHERE Gene_Pac = 'Masculino' ";
            
            if(OrdenarPor.equals("Apellido"))
                sqlplus = " ORDER BY PApell_Pac ASC ";
            if(OrdenarPor.equals("Edad"))
                sqlplus = " ORDER BY Edad_Pac ASC ";
            if(OrdenarPor.equals("Registro"))
                sqlplus = " ORDER BY id_Pac ASC ";
            
            try{
                ResultSet rs = s.executeQuery("SELECT Nom_Pac, PApell_Pac, MApell_Pac, CURP_Pac FROM pacientes " +sqlExtra+" "+sqlplus+" ;");
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
     public String pacientesObtenerDato(String datoBusqueda, String valorBusqueda, String datoDeseado)
    {
        
        String dat = "";
        String valor = "";
        String que = "*";
        if(datoBusqueda.equals("Id"))
            dat = "and id_Pac = ";
        if(datoBusqueda.equals("CURP"))
            dat = "and CURP_Pac = ";
        
        valor = valorBusqueda;
        
        if(datoDeseado.equals("Id"))
            que = "id_Pac";
        if(datoDeseado.equals("Nombre"))
            que = "Nom_Pac";
        if(datoDeseado.equals("Paterno"))
            que = "PApell_Pac";
        if(datoDeseado.equals("Materno"))
            que = "MApell_Pac";
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
        if(datoDeseado.equals("ECiv"))
            que = "ECiv_Pac";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery(
                "select "+ que + " "
                + "from pacientes "
                + "where id_Pac = id_Pac " + dat + valor + " ;"
                );
                
                if(rs.next())
                {
                    return rs.getObject(1).toString();
                }
                else
                {
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
     public boolean pacientesActualizar(String Id, String Nombre, String PApell, String MApell, String FechaN, String Edad, String Correo, String Direccion, String Telefono, String Celular, String Genero, String Curp,String EstadoC)
     {
         try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    //id_Pac, Nom_Pac, PApell_Pac, MApell_Pac, FNac_Pac, Edad_Pac, Correo_Pac, Direccion_Pac, Telefono_Pac, Celular_Pac, Gene_Pac, CURP_Pac, ECiv_Pac
                    "update pacientes set Nom_Pac = '"+Nombre+"', PApell_Pac = '"+PApell+"', MApell_Pac = '"+MApell+"', FNac_Pac = '"+FechaN+"', Edad_Pac = '"+Edad+"', Correo_Pac = '"+Correo+"', Direccion_Pac = '"+Direccion+"', Telefono_Pac = '"+Telefono+"', Celular_Pac = '"+Celular+"', Gene_Pac = '"+Genero+"', CURP_Pac = '"+Curp+"', ECiv_Pac = '"+EstadoC+"' where id_Pac = "+Id+";");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
     }
     
}
