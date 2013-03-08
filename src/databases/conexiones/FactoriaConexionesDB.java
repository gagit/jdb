/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databases.conexiones;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author gtoledo
 */
public class FactoriaConexionesDB {

    private static HashMap<String,Connection> conexiones=new HashMap<String,Connection>(64);
    
    public static Connection getConexion(String nombreConexion) throws SQLException{

            if(conexiones.get(nombreConexion) == null || 
                    conexiones.get(nombreConexion).isClosed()){
                if(establecerConexion(nombreConexion))
                    return getConexion(nombreConexion);
                else
                    return null;
            }else{
                return conexiones.get(nombreConexion);
            }
    }
    public static void cerrarConexiones(){
        Iterator it = conexiones.entrySet().iterator();
        while (it.hasNext()) {
        Map.Entry e = (Map.Entry)it.next();
        Connection c=(Connection)e.getValue();
            try {
                if(!c.isClosed())
                    c.close();
            } catch (SQLException ex) {
                System.out.println(
                        "Error en la Factoria, en el cierre de conexiones. "+
                        ex.getMessage());
            }
        }
    }
    
    private static boolean establecerConexion(String nombreConec) throws SQLException {
        boolean ok=false;
        HashMap<String,String[]> params_con=new HashMap<String,String[]>(64);
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("bds.properties"));
            Enumeration<String> propiedades= (Enumeration<String>) prop.propertyNames();
            int j=0;
            while( propiedades.hasMoreElements() ) {
                String p=propiedades.nextElement();
                if((p.indexOf("nombre_conexion_")!=-1)){
                    p.substring(16);
                    String[] para_conex=new String[7];
                    para_conex[0]=prop.getProperty("motor_"+p.substring(16));
                    para_conex[1]=prop.getProperty("driver_conexion_"+p.substring(16));
                    para_conex[2]=prop.getProperty("host_conexion_"+p.substring(16));
                    para_conex[3]=prop.getProperty("puerto_conexion_"+p.substring(16));
                    para_conex[4]=prop.getProperty("nombre_bd_conexion_"+p.substring(16));
                    para_conex[5]=prop.getProperty("usuario_conexion_"+p.substring(16));
                    para_conex[6]=prop.getProperty("clave_conexion_"+p.substring(16));
                    params_con.put(prop.getProperty(p), para_conex);
                }
            }
            
        } catch (IOException e) {
            System.out.print("Hubo algun problema con el archivo de propiedades");
            e.printStackTrace();
        }
        try {
            String[] par=params_con.get(nombreConec);
            Connection con = ConexionBD.crearConexion(
                    par[0],par[1],par[2],par[3],par[4],par[5],par[6]);
            if( con != null){
                con.setAutoCommit(false);
                conexiones.put(nombreConec, con);
                ok=true;
            } 
        }//--if nomnbre conexion encontrada
        catch (ClassNotFoundException ex) {
            Logger.getLogger(FactoriaConexionesDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FactoriaConexionesDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FactoriaConexionesDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
    public static boolean establecerConexion(String nombreConec,String[] parametros) throws SQLException {
        
        boolean ok=false;
        /*
        String[] para_conex=new String[7];
        para_conex[0]=prop.getProperty("motor_"+p.substring(16));
        para_conex[1]=prop.getProperty("driver_conexion_"+p.substring(16));
        para_conex[2]=prop.getProperty("host_conexion_"+p.substring(16));
        para_conex[3]=prop.getProperty("puerto_conexion_"+p.substring(16));
        para_conex[4]=prop.getProperty("nombre_bd_conexion_"+p.substring(16));
        para_conex[5]=prop.getProperty("usuario_conexion_"+p.substring(16));
        para_conex[6]=prop.getProperty("clave_conexion_"+p.substring(16));
        params_con.put(prop.getProperty(p), para_conex);
        */
        try {
            String[] par=parametros;
            Connection con = ConexionBD.crearConexion(
                    par[0],par[1],par[2],par[3],par[4],par[5],par[6]);
            if( con != null){
                con.setAutoCommit(false);
                conexiones.put(nombreConec, con);
                ok=true;
            } 
        }//--if nomnbre conexion encontrada
        catch (ClassNotFoundException ex) {
            Logger.getLogger(FactoriaConexionesDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FactoriaConexionesDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FactoriaConexionesDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    

}
