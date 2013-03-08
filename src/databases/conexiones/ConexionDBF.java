/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databases.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;

/**
 *
 * @author gabriel
 */
public class ConexionDBF extends ConexionBD {
    
    public Connection getConexionDBF(String url){
       Connection conDBF;
        try {
            Class.forName("com.hxtt.sql.dbf.DBFDriver").newInstance();
            Locale.setDefault(new Locale("Es"));
            conDBF= DriverManager.getConnection(url, "", "");
        } catch (Exception e) {                
            System.out.println(e.getMessage());
            conDBF = null;
        }
        return conDBF;
    }
    
}
