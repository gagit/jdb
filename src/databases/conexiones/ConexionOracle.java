/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databases.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabriel
 */
public class ConexionOracle extends ConexionBD {
    
    public static Connection getConexionOracle(String host, 
            String usuario, String clave, String puerto, String bd) throws SQLException {
        Connection conOracle;
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            conOracle = DriverManager.getConnection(
                "jdbc:oracle:thin:@"+host+":"+puerto+":"+
                    bd,usuario,clave);
        } catch (Exception e) {                
            System.out.println(e.getMessage());
            conOracle = null;
        }
        return conOracle;
    }
}
