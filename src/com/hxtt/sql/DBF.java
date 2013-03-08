/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxtt.sql;

import java.sql.Connection;

/**
 *
 * @author gtoledo
 */
public class DBF {
    
    private static Connection c;
    
    public static void iniciar(Connection c) {
        DBF.c = c;
    }
    
    public static void romper() {
        ((com.hxtt.sql.be) c).bc().d = false;
    }
    
}
