/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package databases.conexiones;

/**
 *
 * @author gaby
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPostgress extends ConexionBD{

    private static final String nombreDriver="org.postgresql.Driver";

    public static Connection getConexion(String host,
        String bd,String usuario, String clave) throws ClassNotFoundException, SQLException {
        String url ="jdbc:postgresql://"+host+":5432/"+bd;
        return DriverManager.getConnection(url,usuario,clave);
    }
    public static Connection getConexion(String host,
            String bd,String puerto,String usuario, String clave) throws ClassNotFoundException, SQLException {
        String url="jdbc:postgresql://"+host+":"+puerto+"/"+bd;
        
        return DriverManager.getConnection(url,usuario,clave);
    }
}