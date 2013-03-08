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

public class ConexionMysql extends ConexionBD{

    private static final String nombreDriver="com.mysql.jdbc.Driver";

   public static Connection getConexion(String host,
            String bd,String usuario, String clave) throws ClassNotFoundException, SQLException {
        
        Class.forName(ConexionMysql.nombreDriver);
        String url ="jdbc:mysql://"+host+":3306/"+bd;
        //System.out.println(url);
        return DriverManager.getConnection(url,usuario,clave);
    }
     /*public static Connection getConexion(String host,
            String bd,String puerto,String usuario, String clave) throws ClassNotFoundException, SQLException {
        Class.forName(ConexionMysql.nombreDriver);
        String url="jdbc:mysql://"+host+":"+puerto+"/"+bd;
        
        return DriverManager.getConnection(url,usuario,clave);
    }*/
}