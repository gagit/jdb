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

public class ConexionSqlServer extends ConexionBD{

    //private static final String nombreDriver="org.postgresql.Driver";

    public static Connection getConexion(String host,
        String bd,String puerto,String usuario, String clave) throws ClassNotFoundException, SQLException {
        String url ="jdbc:sqlserver://"+host+":50001"+";databaseName="+bd;
        //String url ="jdbc:sqlserver://"+host+":50001"+";databaseName="+bd+";integratedSecurity=true;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.1";
        System.out.println(url);
        return DriverManager.getConnection(url,usuario,clave);
    }


/*    public static Connection getConexion(String host,
            String bd,String puerto,String usuario, String clave) throws ClassNotFoundException, SQLException {
        Class.forName(ConexionSqlServer.nombreDriver);
        String url="jdbc:sqlserver://"+host+":"+puerto+"/"+bd;
        
        return DriverManager.getConnection(url,usuario,clave);
    }*/
}