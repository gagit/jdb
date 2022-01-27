/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databases.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 *
 * @author gabriel
 */
public class ConexionBD {
    
    
    public static Connection crearConexion(String motor,String driver,
                                        String host, String puerto, String bd,
                                            String usuario, String clave) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Connection c=null;
        if(motor.equalsIgnoreCase("oracle")){
            c = ConexionOracle.
                    getConexionOracle(host,usuario,clave,puerto,bd);
        }
        if(motor.equalsIgnoreCase("mysql")){
            c = databases.conexiones.ConexionMysql.
                    getConexion(host,bd,usuario,clave);
        }
        if(motor.equalsIgnoreCase("dbf")){
            String url = "jdbc:dbf:/"+host;
            //System.out.println(url);
            Class.forName("com.hxtt.sql.dbf.DBFDriver").newInstance();
            Locale.setDefault(new Locale("Es"));
            c= DriverManager.getConnection(url, "", "");
       }
       if(motor.equalsIgnoreCase("postgres")){
            c = databases.conexiones.ConexionPostgress.
                    getConexion(host,bd,puerto,usuario,clave);
       }
       if(motor.equalsIgnoreCase("sqlserver")){
            c = databases.conexiones.ConexionSqlServer.
                    getConexion(host,bd,puerto,usuario,clave);
       }
       return c;
    }
    
    
    
}
