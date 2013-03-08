/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databases.conexiones;

import java.sql.Connection;

/**
 *
 * @author gtoledo
 */
public interface Conectable {
    public Connection getCon();
    public void setCon(Connection con);
}
