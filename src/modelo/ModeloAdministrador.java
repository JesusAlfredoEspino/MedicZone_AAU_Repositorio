/*
 Modelo para el usuario de administrador de Medic Zone
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
 * @author office depot
 */
public class ModeloAdministrador {
    
    private Conexion conexion = new Conexion();
    
    public DefaultTableModel usuariosUsuariosConsultar(){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            
            try{
                ResultSet rs = s.executeQuery("select usuarios.id_Usu as 'Id Usuario', "
                                                + "empleados.CURP_Emp as 'CURP',"
                                                + "usuarios.Usuario as 'Usuario', "
                                                + "usuarios.Passw as 'Contraseña',"
                                                + "usuarios.Tipo as 'Tipo usuario' "
                                                + "from usuarios, empleados "
                                                + "where usuarios.id_Emp = empleados.id_Emp;");
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
    public DefaultTableModel usuariosUsuariosConsultar(String mostrarCondicion, String OrdenarPor)
    {
        
        String sqlExtra = "";
        if(mostrarCondicion.equals("Administrador"))
            sqlExtra = " and usuarios.Tipo = 'Administrador' ";
        if(mostrarCondicion.equals("Doctor"))
            sqlExtra = " and usuarios.Tipo = 'Doctor' ";
        if(mostrarCondicion.equals("Recepcionista"))
            sqlExtra = " and usuarios.Tipo = 'Recepcionista' ";
        if(mostrarCondicion.equals("Proveedor"))
            sqlExtra = " and usuarios.Tipo = 'Proveedor' ";
        
        String OrdPor = " order by usuarios.id_Usu asc";
        if(OrdenarPor.equals("Id"))
            OrdPor = " order by usuarios.id_Usu asc";
        if(OrdenarPor.equals("CURP"))
            OrdPor = " order by empleados.CURP_Emp asc ";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            
            try{
                ResultSet rs = s.executeQuery("select usuarios.id_Usu as 'Id Usuario', "
                                                + "empleados.CURP_Emp as 'CURP',"
                                                + "usuarios.Usuario as 'Usuario', "
                                                + "usuarios.Passw as 'Contraseña',"
                                                + "usuarios.Tipo as 'Tipo usuario' "
                                                + "from usuarios, empleados "
                                                + "where usuarios.id_Emp = empleados.id_Emp " + sqlExtra + OrdPor + " ; ");
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
    public boolean usuariosEliminar(String idUsu)
    {
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from usuarios where id_Usu = " + idUsu + ";"
            );
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        }
    }
    public String usuariosObtenerDato(String datoBusqueda, String valorBusqueda, String datoDeseado){
        
        String dat = "";
        String valor = "";
        String que = "*";
        if(datoBusqueda.equals("Id"))
            dat = "and id_Usu = ";
        if(datoBusqueda.equals("Usuario"))
            dat = "and Usuario = ";
        if(datoBusqueda.equals("Contrasena"))
            dat = "and Passw = ";
        if(datoBusqueda.equals("Tipo"))
            dat = "and Tipo = ";
        valor = valorBusqueda;
        if(datoDeseado.equals("Id"))
            que = "id_Usu";
        if(datoDeseado.equals("Usuario"))
            que = "Usuario";
        if(datoDeseado.equals("Contrasena"))
            que = "Passw";
        if(datoDeseado.equals("Tipo"))
            que = "Tipo";
        if(datoDeseado.equals("Id empleado"))
            que = "id_Emp";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery(
                "select "+ que + " "
                + "from usuarios "
                + "where id_Usu = id_Usu " + dat + valor + " ;"
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
    public boolean usuariosInsertar( String idEmp, String usuario, String contrasena, String tipo){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "insert into usuarios values(null, '"
                    +idEmp+"','"+usuario+"','" +contrasena+"','" +tipo+"'"
                    +");");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public boolean usuariosActualizar( String idUsu, String idEmp, String usuario, String contrasena, String tipo){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "update usuarios set id_Emp = "+idEmp+", Usuario = '"+usuario+"', Passw = '"+contrasena+"', Tipo = '"+tipo+"' where id_Usu = "+idUsu+";");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public boolean empleadosExisteCita(String idEmp)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery("select id_Rec from citas where id_Rec = '"+idEmp+"';");
                
                if(rs.next())
                {
                    return true;
                }
                else
                {
                    return false;
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
            return false;
        }
        return false;
    }
    public boolean CitaintervieneCita(String fechaIni, String horaIni, String fechaFin, String horaFin)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                
                ResultSet rs = s.executeQuery("select id_Cita from citas where "
                        + "(Fecha_Cita BETWEEN '"+fechaIni+"' AND '"+fechaFin+"') AND "
                        + "(Hora_Cita BETWEEN '"+horaIni+"' AND '"+horaFin+"') ");
                
                if(rs.next())
                {
                    return true;
                }
                else
                {
                    return false;
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
            return false;
        }
        return false;
    }
    public boolean empleadosExisteDoctor(String idEmp)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery("select id_Emp from doctores where id_Emp = '"+idEmp+"';");
                
                if(rs.next())
                {
                    return true;
                }
                else
                {
                    return false;
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
            return false;
        }
        return false;
    }
    public boolean ExisteRecepcionista(String idEmp)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery("select id_Emp from doctores where Tipo_Emp = 'Recepcionista' id_Emp = '"+idEmp+"';");
                
                if(rs.next())
                {
                    return true;
                }
                else
                {
                    return false;
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
            return false;
        }
        return false;
    }
    public boolean ExisteUtensilio(String idEmp)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery("select id_Art from articuloscita where id_Art = '"+idEmp+"';");
                
                if(rs.next())
                {
                    return true;
                }
                else
                {
                    return false;
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
            return false;
        }
        return false;
    }
    public DefaultTableModel empleadosEmpleadosConsultar(){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;

            try{
                ResultSet rs = s.executeQuery("select id_Emp as 'Id empleado', "
                                                + "CURP_Emp as 'CURP', "
                                                + "Tipo_Emp as 'Tipo' "
                                                + "from empleados; ");
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
    public DefaultTableModel empleadosEmpleadosConsultar( String OrdenarPor, String mostrarCondicion){
        
        String sqlExtra = "";
        if(mostrarCondicion.equals("Administrador"))
            sqlExtra = " and Tipo_Emp = 'Administrador' ";
        if(mostrarCondicion.equals("Doctor"))
            sqlExtra = " and Tipo_Emp = 'Doctor' ";
        if(mostrarCondicion.equals("Recepcionista"))
            sqlExtra = " and Tipo_Emp = 'Recepcionista' ";
        if(mostrarCondicion.equals("Otros"))
            sqlExtra = " and Tipo_Emp != 'Recepcionista' and Tipo_Emp != 'Doctor' and Tipo_Emp != 'Administrador' ";
        
        String OrdPor = " order by id_Emp asc";
        if(OrdenarPor.equals("Id"))
            OrdPor = " order by id_Emp asc ";
        if(OrdenarPor.equals("CURP"))
            OrdPor = " order by CURP_Emp asc ";
        if(OrdenarPor.equals("Tipo de empleado"))
            OrdPor = " order by Tipo_Emp asc ";
        
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;

            try{
                ResultSet rs = s.executeQuery("select id_Emp as 'Id empleado', "
                                                + "CURP_Emp as 'CURP', "
                                                + "Tipo_Emp as 'Tipo' "
                                                + "from empleados "
                                                + "where id_Emp = id_Emp "+sqlExtra+OrdPor+" ;");
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
    public String empleadosObtenerDato(String datoBusqueda, String valorBusqueda, String datoDeseado){
        
        String dat = "";
        String valor = "";
        String que = "*";
        if(datoBusqueda.equals("Id"))
            dat = "and id_Emp = ";
        
        valor = valorBusqueda;
        
        if(datoDeseado.equals("Id"))
            que = "id_Emp";
        if(datoDeseado.equals("Nombre"))
            que = "Nom_Emp";
        if(datoDeseado.equals("Apellido paterno"))
            que = "PApell_Emp";
        if(datoDeseado.equals("Apellido materno"))
            que = "MApell_Emp";
        if(datoDeseado.equals("Fecha"))
            que = "FNac_Emp";
        if(datoDeseado.equals("Edad"))
            que = "Edad_Emp";
        if(datoDeseado.equals("Correo"))
            que = "Correo_Emp";
        if(datoDeseado.equals("Direccion"))
            que = "Direccion_Emp";
        if(datoDeseado.equals("Telefono"))
            que = "Telefono_Emp";
        if(datoDeseado.equals("Celular"))
            que = "Celular_Emp";
        if(datoDeseado.equals("Genero"))
            que = "Gene_Emp";
        if(datoDeseado.equals("RFC"))
            que = "RFC_Emp";
        if(datoDeseado.equals("CURP"))
            que = "CURP_Emp";
        if(datoDeseado.equals("Tipo"))
            que = "Tipo_Emp";
        if(datoDeseado.equals("Estado civil"))
            que = "ECiv_Emp";
        if(datoDeseado.equals("Estado"))
            que = "Estado_Emp";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery(
                "select "+ que +"  from empleados  where id_Emp = id_Emp "+ dat + valor + ";"
                );
                
                if(rs.next())
                {
                    if(rs.getObject(1).toString() != null)
                        return rs.getObject(1).toString();
                    else
                        return "";
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
    public String doctoresObtenerDato(String datoBusqueda, String valorBusqueda, String datoDeseado)
    {
        
        String dat = "";
        String valor = "";
        String que = "*";
        if(datoBusqueda.equals("Id"))
            dat = "and id_Emp = ";
        
        valor = valorBusqueda;
        if(datoDeseado.equals("Id"))
            que = "id_Emp";
        if(datoDeseado.equals("Especialidad"))
            que = "Espe_Doc";
        if(datoDeseado.equals("NumCedula"))
            que = "NumCed_Doc";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery(
                "select "+ que + " "
                + "from doctores "
                + "where id_Emp = id_Emp " + dat + valor + " ;"
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
    public boolean empleadosInsertar( String Nom, String PApell, String MApell, String FNac, String Edad, String Correo, String Direccion, String Telefono, String Celular, String Gene, String RFC, String CURP, String Tipo, String ECiv, String Estado){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "insert into empleados values(null, '"
                    +Nom+"','" +PApell+"','" +MApell+"','" +FNac+"','" +Edad+"','" +Correo+"','" +Direccion+ "','" + Telefono + "','" + Celular + "','" + Gene + "','" + RFC + "','" + CURP + "','" + Tipo + "','" + ECiv + "'," + Estado
                    +");");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public boolean empleadosActualizar( String id, String Nom, String PApell, String MApell, String FNac, String Edad, String Correo, String Direccion, String Telefono, String Celular, String Gene, String RFC, String CURP, String Tipo, String ECiv, String Estado){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "update empleados set Nom_Emp = '" +Nom+"', PApell_Emp = '" +PApell+"', MApell_Emp = '" +MApell+"', FNac_Emp = '" +FNac+"', Edad_Emp = '" +Edad+"', Correo_Emp = '" +Correo+"', Direccion_Emp = '" +Direccion+ "', Telefono_Emp = '" + Telefono + "', Celular_Emp = '" + Celular + "', Gene_Emp = '" + Gene + "', RFC_Emp = '" + RFC + "', CURP_Emp = '" + CURP + "', Tipo_Emp = '" + Tipo + "', ECiv_Emp = '" + ECiv + "', Estado_Emp = " + Estado + " where id_Emp = "+id
                    +";");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public DefaultTableModel doctoresDoctoresConsultar(){
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery("select doctores.id_Emp as 'Id Empleado', "
                                                + "empleados.CURP_Emp as 'CURP', "
                                                + "doctores.Espe_Doc as 'Especialidad', "
                                                + "doctores.NumCed_Doc as 'Num. Cédula' "
                                                + "from doctores, empleados "
                                                + "where empleados.id_Emp = doctores.id_Emp; ");
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
    public DefaultTableModel doctoresDoctoresConsultar(String mostrarCondicion, String OrdenarPor){
        
        String sqlExtra = "";
        
        String OrdPor = " order by empleados.id_Emp asc";
        if(OrdenarPor.equals("Id"))
            OrdPor = "  order by empleados.id_Emp asc ";
        if(OrdenarPor.equals("CURP"))
            OrdPor = " order by empleados.CURP_Emp asc ";
        if(OrdenarPor.equals("Especialidad"))
            OrdPor = " order by doctores.Espe_Doc asc ";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery("select doctores.id_Emp as 'Id Empleado', "
                                                + "empleados.CURP_Emp as 'CURP', "
                                                + "doctores.Espe_Doc as 'Especialidad', "
                                                + "doctores.NumCed_Doc as 'Num. Cédula' "
                                                + "from doctores, empleados "
                                                + "where empleados.id_Emp = doctores.id_Emp "
                                                + sqlExtra+OrdPor+" ; ");
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
    public boolean doctoresActualizar( String IdDoc, String Especialidad, String NumC){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "update doctores set  Espe_Doc = '"
                    +Especialidad+"', NumCed_Doc = '" +NumC+"'"
                    +" where id_Emp = " + IdDoc + ";");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public boolean doctoresInsertar(String id,String Especialidad, String NumC){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "INSERT INTO doctores (id_Emp , Espe_Doc, NumCed_Doc) VALUES ("+id+", '"+Especialidad+"', '"+NumC+"');");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public boolean ExisteEmpleado(String idEmp)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery("select id_Emp from empleados where id_Emp = '"+idEmp+"';");
                
                if(rs.next())
                {
                    return true;
                }
                else
                {
                    return false;
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
            return false;
        }
        return false;
    }
    public boolean ExistePaciente(String idEmp)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery("select id_Pac from pacientes where id_Pac = '"+idEmp+"';");
                
                if(rs.next())
                {
                    return true;
                }
                else
                {
                    return false;
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
            return false;
        }
        return false;
    }
    
    public DefaultTableModel pacientesPacientesConsultar( String mostrarCondicion, String OrdenarPor){
        
        String sqlExtra = "";
        if(mostrarCondicion.equals("Mujeres"))
            sqlExtra = " and Gene_Pac = 'Femenino' ";
        if(mostrarCondicion.equals("Hombres"))
            sqlExtra = " and Gene_Pac = 'Masculino' ";
        
        String OrdPor = " order by id_Pac asc";
        if(OrdenarPor.equals("Id"))
            OrdPor = " order by id_Pac asc ";
        if(OrdenarPor.equals("CURP"))
            OrdPor = " order by CURP_Pac asc ";
        
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery(
                       "select id_Pac as 'Id pacientes', CONCAT(PApell_Pac,' ',MApell_Pac) as 'Apellidos', Nom_Pac as 'Nombre', "
                            + "CURP_Pac as 'CURP', "+ "Gene_Pac as 'Género' "
                            + "from pacientes where id_Pac = id_Pac " + sqlExtra + OrdPor);
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
    public boolean pacientesInsertar( String Nom, String PApell, String MApell, String FNac, String Edad, String Correo, String Direccion, String Telefono, String Celular, String Gene, String CURP, String ECiv){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "insert into pacientes values(null, '"
                    +Nom+"','" +PApell+"','" +MApell+"','" +FNac+"','" +Edad+"','" +Correo+"','" +Direccion+ "','" + Telefono + "','" + Celular + "','" + Gene + "','" + CURP + "','" + ECiv
                    +"');");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public boolean pacientesActualizar( String id, String Nom, String PApell, String MApell, String FNac, String Edad, String Correo, String Direccion, String Telefono, String Celular, String Gene, String CURP, String ECiv){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "update pacientes set "
                    +" Nom_Pac = '"+Nom+"', PApell_Pac = '" +PApell
                    +"', MApell_Pac = '" +MApell+"', FNac_Pac = '" 
                    +FNac+"', Edad_Pac = '" +Edad+"', Correo_Pac = '" 
                    +Correo+"', Direccion_Pac = '" 
                    +Direccion+ "', Telefono_Pac = '" 
                    + Telefono + "', Celular_Pac = '"
                    + Celular + "', Gene_Pac = '" 
                    + Gene + "', CURP_Pac = '" 
                    + CURP + "', ECiv_Pac = '"+ ECiv
                    +"' where id_Pac = "+id+";");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public DefaultTableModel citasCitasConsultar(String mostrarCondicion, String OrdenarPor){
        
        String sqlExtra = "";
        if(mostrarCondicion.equals("Activas"))
            sqlExtra = " and citas.Estado_Cita = 1 ";
        if(mostrarCondicion.equals("Inactivas"))
            sqlExtra = " and citas.Estado_Cita = 0 ";
        
        String OrdPor = " order by citas.id_Cita asc";
        if(OrdenarPor.equals("Id"))
            OrdPor = " order by citas.id_Cita asc ";
        if(OrdenarPor.equals("CURP Doctor"))
            OrdPor = " order by ds.CURP_Emp asc ";
        if(OrdenarPor.equals("CURP Paciente"))
            OrdPor = " order by pacientes.CURP_Pac asc ";
        if(OrdenarPor.equals("CURP Recepcionista"))
            OrdPor = " order by rs.CURP_Emp asc ";
        if(OrdenarPor.equals("Fecha"))
            OrdPor = " order by citas.Fecha_Cita asc";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery(
                "select citas.id_Cita as 'Id cita', ds.CURP_Emp as 'CURP doctor', pacientes.CURP_Pac as 'CURP paciente', rs.CURP_Emp as 'CURP recepcionista', citas.Fecha_Cita as 'Fecha cita' from citas, pacientes, empleados as ds, empleados as rs where citas.id_Doc = ds.id_Emp and citas.id_Rec = rs.id_Emp and ds.id_Emp != rs.id_Emp and citas.id_Pac = pacientes.id_Pac " + sqlExtra + OrdPor + " ;"
                ); 
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
    public String citasObtenerDato(String datoBusqueda, String valorBusqueda, String datoDeseado){
        
        String dat = "";
        String valor = "";
        String que = "*";
        if(datoBusqueda.equals("Id cita"))
            dat = "and citas.id_Cita = ";
        if(datoBusqueda.equals("CURP doctor"))
            dat = "and ds.CURP_Emp = ";
        if(datoBusqueda.equals("CURP recepcionista"))
            dat = "and rs.CURP_Emp = ";
        if(datoBusqueda.equals("CURP paciente"))
            dat = "and pacientes.CURP_Pac = ";
        valor = valorBusqueda;
        
        if(datoDeseado.equals("Id cita"))
            que = "citas.id_Cita";
        if(datoDeseado.equals("Id paciente"))
            que = "pacientes.id_Pac";
        if(datoDeseado.equals("Id recepcionista"))
            que = "rs.id_Emp";
        if(datoDeseado.equals("Id doctor"))
            que = "ds.id_Emp";
        if(datoDeseado.equals("Descripcion"))
            que = "citas.Descripcion_Cita";
        if(datoDeseado.equals("Conclusion"))
            que = "citas.Conclusion_Cita";
        if(datoDeseado.equals("Estado"))
            que = "citas.Estado_Cita";
        if(datoDeseado.equals("Fecha"))
            que = "citas.Fecha_Cita";
        if(datoDeseado.equals("Hora"))
            que = "citas.Hora_Cita";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery(
                "select "+ que +"  from citas, pacientes, empleados as ds, empleados as rs where citas.id_Doc = ds.id_Emp and citas.id_Rec = rs.id_Emp and ds.id_Emp != rs.id_Emp and citas.id_Pac = pacientes.id_Pac " + dat + valor + ";"
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
    public boolean citasExisteUtensilios(String idCita)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery("select id_Cita from utensilios where id_Cita = '"+idCita+"';");
                
                if(rs.next())
                {
                    return true;
                }
                else
                {
                    return false;
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
            return false;
        }
        return false;
    }
    public boolean citasExisteDatosCita(String idCita)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery("select id_Cita from datoscita where id_Cita = '"+idCita+"';");
                
                if(rs.next())
                {
                    return true;
                }
                else
                {
                    return false;
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
            return false;
        }
        return false;
    }
    public boolean citasInsertar( String IdPaciente, String IdDoctor, String IdRecepcionista, String Fecha, String Hora, String Descripcion, String Conclusion, String Estado){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "insert into citas values(null, '"
                    +IdPaciente+"','" +IdDoctor+"','" +IdRecepcionista+"','" +Fecha+"','" +Hora+"','" +Descripcion+"','" +Conclusion+"','" +Estado+ "'"
                    +");");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public boolean citasActualizar( String IdCita, String IdPaciente, String IdDoctor, String IdRecepcionista, String Fecha, String Hora, String Descripcion, String Conclusion, String Estado){
        try{
//id_Cita, id_Pac, id_Doc, id_Rec, Fecha_Cita, Hora_Cita, Descripcion_Cita, Conclusion_Cita, Estado_Cita
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "update citas set  id_Pac = '"
                    +IdPaciente+"', id_Doc = '" +IdDoctor+"', id_Rec = '" +IdRecepcionista+"', Fecha_Cita = '" +Fecha+"', Hora_Cita = '" +Hora+"', Descripcion_Cita = '" +Descripcion+"', Conclusion_Cita = '" +Conclusion+"', Estado_Cita = '" +Estado+ "'"
                    +" where id_Cita = " + IdCita + ";");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public DefaultTableModel datosCitaDatosCitaConsultar(){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery(
                "select citas.id_Cita as 'Id cita', ds.CURP_Emp as 'CURP doctor', pacientes.CURP_Pac as 'CURP paciente', rs.CURP_Emp as 'CURP recepcionista', citas.Fecha_Cita as 'Fecha cita' from citas, pacientes, empleados as ds, empleados as rs where citas.id_Doc = ds.id_Emp and citas.id_Rec = rs.id_Emp and ds.id_Emp != rs.id_Emp and citas.id_Pac = pacientes.id_Pac;"
                );
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
    public DefaultTableModel datosCitaCitaConsultar(String mostrarCondicion, String OrdenarPor)
    {
        
        String ordpor = "";
        if(OrdenarPor.equals("Id"))
            ordpor = " order  by citas.id_Cita ";
        if(OrdenarPor.equals("CURP doctor"))
            ordpor = " order by ds.CURP_Emp ";
        
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery(
                "select citas.id_Cita as 'Id cita', ds.CURP_Emp as 'CURP doctor', pacientes.CURP_Pac as 'CURP paciente', rs.CURP_Emp as 'CURP recepcionista', citas.Fecha_Cita as 'Fecha cita' from citas, pacientes, empleados as ds, empleados as rs where citas.id_Doc = ds.id_Emp and citas.id_Rec = rs.id_Emp and ds.id_Emp != rs.id_Emp and citas.id_Pac = pacientes.id_Pac "+ordpor+" ;"
                );
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
    public DefaultTableModel datosCitaDatosCitaConsultar(String idCita){
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery(
                "select id_Datos as 'Id dato', id_Cita as 'Id cita', Servicio_Datos as 'Servicio' from datoscita where id_Cita = "+idCita+";"
                );
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
    public String datosCitaObtenerDato(String datoBusqueda, String valorBusqueda, String datoDeseado){
        
        String dat = "";
        String valor = "";
        String que = "*";
        if(datoBusqueda.equals("Id"))
            dat = "and id_Datos = ";
        
        valor = valorBusqueda;
        
        if(datoDeseado.equals("Id"))
            que = "id_Datos";
        if(datoDeseado.equals("Id cita"))
            que = "id_Cita";
        if(datoDeseado.equals("Servicio"))
            que = "Servicio_Datos";
        if(datoDeseado.equals("Descripcion"))
            que = "Descripcion_Datos";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery(
                "select "+ que + " "
                + "from datoscita "
                + "where id_Datos = id_Datos " + dat + valor + " ;"
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
    public boolean datosCitaEliminar(String idDC)
    {
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from datoscita where id_Datos= " + idDC + ";"
            );
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        }
    }
    public boolean datosCitaActualizar(String id, String servicio, String descripcion)
    {
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "update datoscita set Servicio_Datos = '"
            + servicio + "', Descripcion_Datos = '" + descripcion
            + "' where id_Datos = " + id + ";"
            );
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        }
    }
    public boolean datosCitaInsertar(String idcita, String servicio, String descripcion)
    {
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "insert into datoscita values(null, "+idcita+", '"
            + servicio + "','" + descripcion + "') ;"
            );
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        }
    }
    public DefaultTableModel utensiliosUtensiliosConsultar(){   
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery(
                "select u.id_Ut as 'Id utensilios', a.Nombre_Art as 'Artículo', "
                + "u.id_Cita as 'Id cita', e.CURP_Emp as 'Curp doctor', "
                + "c.Fecha_Cita as 'Fecha de la cita' "
                + "from citas as c, utensilios as u, empleados as e, articuloscita as a where "
                + "u.id_Cita = c.id_Cita and "
                + "u.id_Art = a.id_Art and "
                + "c.id_Doc = e.id_Emp;"
                );
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
    
    public DefaultTableModel utensiliosUtensiliosConsultar( String mostrarCondicion, String OrdenarPor)
    {
        
        String OrdPor = " order by u.id_Ut asc ";
        if(OrdenarPor.equals("Id"))
            OrdPor = " order by u.id_Ut asc ";
        if(OrdenarPor.equals("Id cita"))
            OrdPor = " order by u.id_Cita asc ";
        if(OrdenarPor.equals("Artículo"))
            OrdPor = "order by a.Nombre_Art asc";
        if(OrdenarPor.equals("CURP doctor"))
            OrdPor = "order by e.CURP_Emp asc";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery(
                "select u.id_Ut as 'Id utensilios', a.Nombre_Art as 'Artículo', "
                + "u.id_Cita as 'Id cita', e.CURP_Emp as 'Curp doctor', "
                + "c.Fecha_Cita as 'Fecha de la cita' "
                + "from citas as c, utensilios as u, empleados as e, articuloscita as a where "
                + "u.id_Cita = c.id_Cita and "
                + "u.id_Art = a.id_Art and "
                + "c.id_Doc = e.id_Emp "+OrdPor+" ;"
                );
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
    public DefaultTableModel utensiliosCitaConsultar(String mostrarCondicion, String OrdenarPor)
    {
        
        String ordpor = "";
        if(OrdenarPor.equals("Id"))
            ordpor = " order  by citas.id_Cita ";
        if(OrdenarPor.equals("CURP doctor"))
            ordpor = " order by ds.CURP_Emp ";
        
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery(
                "select citas.id_Cita as 'Id cita', ds.CURP_Emp as 'CURP doctor', pacientes.CURP_Pac as 'CURP paciente', rs.CURP_Emp as 'CURP recepcionista', citas.Fecha_Cita as 'Fecha cita' from citas, pacientes, empleados as ds, empleados as rs where citas.id_Doc = ds.id_Emp and citas.id_Rec = rs.id_Emp and ds.id_Emp != rs.id_Emp and citas.id_Pac = pacientes.id_Pac "+ordpor+" ;"
                );
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
    public DefaultTableModel utensiliosUtensiliosConsultar(String idCita)
    {
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery(
                "select u.id_Ut as 'Id utensilio', a.Nombre_Art as 'Artículo' from utensilios as u, articuloscita as a where u.id_Cita = "+idCita+" and u.id_Art = a.id_Art ;"
                );
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
    public String utensiliosObtenerDato(String datoBusqueda, String valorBusqueda, String datoDeseado)
    {
        
        String dat = "";
        String valor = "";
        String que = "*";
        if(datoBusqueda.equals("Id"))
            dat = "and id_Ut = ";
        
        valor = valorBusqueda;
        
        if(datoDeseado.equals("Id"))
            que = "id_Ut";
        if(datoDeseado.equals("Id cita"))
            que = "id_Cita";
        if(datoDeseado.equals("Id articulo"))
            que = "id_Art";
        if(datoDeseado.equals("Cantidad"))
            que = "Cantidad_Ut";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery(
                "select "+ que + " "
                + "from utensilios "
                + "where id_Art = id_Art " + dat + valor + " ;"
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
    public boolean utensiliosEliminar(String idDC)
    {
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from utensilios where id_Ut = " + idDC + ";"
            );
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        }
    }
    public boolean utensiliosInsertar(String idCita, String idArt, String Cantidad)
    {
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "insert into utensilios(id_Ut, id_Cita, id_Art, Cantidad_Ut) values (null,"+idCita+","+idArt+","+Cantidad+");");
            
            Statement s1 = con.createStatement();
            int r1 = s1.executeUpdate(
                    "update articuloscita set Existencia_Art = Existencia_Art - "+Cantidad+" where id_Art = "+idArt+" ;"
            );
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public boolean utensiliosActualizar(String idUt, String idCita, String idArt, String Cantidad, String incremento)
    {
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "update utensilios set "
                    + "id_Cita = "+idCita+", id_Art="+idArt+", Cantidad_Ut="+Cantidad+"+"+incremento+" where id_Ut = " + idUt + ";");
            Statement s1 = con.createStatement();
            int r1 = s1.executeUpdate(
                    "update articuloscita set Existencia_Art = Existencia_Art - "+incremento+" where id_Art = "+idArt+" ;"
            );
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public boolean utensiliosModificarExistencia(String idUt, String decremento)
    {
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "update articuloscita set "
                    + "Existencia_Art = Existencia_Art -"+decremento+" where id_Ut = " + idUt + ";");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public DefaultTableModel articulosArticulosConsultar(String mostrarCondicion, String OrdenarPor)
    {
        String sqlExtra = "";
        if(mostrarCondicion.equals("Existencia<10"))
            sqlExtra = "and Existencia_Art<10";
        
        if(mostrarCondicion.equals("Existencia<50"))
            sqlExtra = "and Existencia_Art<50";
        if(mostrarCondicion.equals("Existencia<100"))
            sqlExtra = "and Existencia_Art<100";
        
        String OrdPor = "order by id_Art asc";
        if(OrdenarPor.equals("Id"))
            OrdPor = "order by id_Art asc";
        if(OrdenarPor.equals("Artículo"))
            OrdPor = "order by Nombre_Art asc";
        if(OrdenarPor.equals("Existencia"))
            OrdPor = "order by Existencia_Art asc";
        
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery(
                "select id_Art as 'Id artículo', "
                + "Nombre_Art as 'Artículo', "
                + "Existencia_Art as 'Existencia' from articuloscita "
                + "where id_Art = id_Art " + sqlExtra + " " + OrdPor + " ;"
                );
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
    public String articulosObtenerDato(String datoBusqueda, String valorBusqueda, String datoDeseado)
    {
        
        String dat = "";
        String valor = "";
        String que = "*";
        if(datoBusqueda.equals("Id"))
            dat = "and id_Art = ";
        
        valor = valorBusqueda;
        
        if(datoDeseado.equals("Id"))
            que = "id_Art";
        if(datoDeseado.equals("Articulo"))
            que = "Nombre_Art";
        if(datoDeseado.equals("Existencia"))
            que = "Existencia_Art";
        
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery(
                "select "+ que + " "
                + "from articuloscita "
                + " where id_Art = id_Art " + dat + valor + " ;"
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
    public boolean articulosEliminar(String artId){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from articuloscita where id_Art = " + artId + ";"
            );
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        }
    }
    public boolean articulosActualizar(String artId, String Articulo, String Existencia){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "update articuloscita set Nombre_Art = '"
            + Articulo + "', Existencia_Art = '" + Existencia
            + "' where id_Art = " + artId + ";"
            );
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        }
    }
    public boolean articulosInsertar(String articulo, String existencia)
    {
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                    "insert into articuloscita(id_Art,Nombre_Art,Existencia_Art) values(null, '"
                    + articulo + "', '" + existencia + "');");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public boolean articulosExisteUtensilio(String idArt)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            try{
                ResultSet rs = s.executeQuery("select id_Art from utensilios where id_Art = '"+idArt+"';");
                
                if(rs.next())
                {
                    return true;
                }
                else
                {
                    return false;
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
            return false;
        }
        return false;
    }
    public boolean empleadosEliminar(String emId){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from empleados where id_Emp = " + emId + ";");
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        }
       
    }
    public boolean doctoresEliminar(String docId){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from doctores where id_Emp = " + docId + ";"
            );
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        }
    }
    public String obtenerTipoEmpleado(String empId)
    {
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement(); 
            ResultSet rs = s.executeQuery("SELECT Tipo_Emp FROM empleados WHERE id_Emp= "+ empId +";");
            String a;
            rs.next();
            a = rs.getString(1);
            conexion.cerrarConexion(con);
            return a;
        }
        catch(SQLException e)
        {
          return null;    
        }
    }
    public boolean eliminarPacientes(String paId)
    {
        try
        {
           Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from pacientes where id_Pac = " + paId + ";"
            );
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        } 
    }
    public boolean eliminarCitas(String ciId)
    {
        try
        {
           Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from citas where id_Cita = " + ciId + ";"
            );
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        } 
    }
    
    public DefaultTableModel reporteCitas(String fechaini, String fechafin)
    {

        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try{
                ResultSet rs = s.executeQuery(
                "SELECT citas.id_Cita AS 'Id Cita', "
                        + " CONCAT(pacientes.Nom_Pac,' ',pacientes.PApell_Pac,' ',pacientes.MApell_Pac) AS 'Paciente',"
                        + " CONCAT(doctoresEMP.Nom_Emp,' ',doctoresEMP.PApell_Emp,' ',doctoresEMP.MApell_Emp) AS 'Doctor',"
                        + " CONCAT(recepcionistasEMP.Nom_Emp,' ',recepcionistasEMP.PApell_Emp,' ',recepcionistasEMP.MApell_Emp) AS 'Recepcionista',"
                        + " citas.Fecha_Cita AS 'Fecha', "
                        + " citas.Hora_Cita AS 'Hora',"
                        + " citas.Descripcion_Cita AS 'Descripción'"
                        + " FROM citas, pacientes, empleados AS doctoresEMP, empleados AS recepcionistasEMP WHERE"
                        + " citas.id_Pac = pacientes.id_Pac AND"
                        + " citas.id_Doc = doctoresEMP.id_Emp AND"
                        + " citas.id_Rec = recepcionistasEMP.id_Emp AND"
                        + " citas.Estado_Cita = 1 AND"
                        + " citas.Fecha_Cita BETWEEN '2018-08-00' AND '2018-08-31'"
                        + ";"
                );
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
}

