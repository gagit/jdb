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
        switch (motor.toLowerCase()){
            case "postgres":
                c = databases.conexiones.ConexionPostgress.
                        getConexion(host,bd,puerto,usuario,clave);
                break;
            case "oracle":
                c = ConexionOracle.
                        getConexionOracle(host,usuario,clave,puerto,bd);
                break;
            case "mysql":
                c = databases.conexiones.ConexionMysql.
                        getConexion(host,bd,usuario,clave);
                break;
            case "dbf":
                String url = "jdbc:dbf:/"+host;
                //System.out.println(url);
                Class.forName("com.hxtt.sql.dbf.DBFDriver").newInstance();
                Locale.setDefault(new Locale("Es"));
                c= DriverManager.getConnection(url, "", "");
                break;
        }
       return c;
    }
    
    
    
}
