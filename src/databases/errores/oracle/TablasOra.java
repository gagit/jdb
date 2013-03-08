/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databases.errores.oracle;

import databases.conexiones.Conectable;
import databases.conexiones.FactoriaConexionesDB;
import java.sql.*;

/**
 *
 * @author gabriel
 */
public abstract class TablasOra implements Conectable{
    
    private Connection con;

    /**
     * @return the con
     */
    @Override
    public Connection getCon() {
        
        try {
            return FactoriaConexionesDB.getConexion("oracle_mp");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           return null;
        }
    }

    /**
     * @param aCon the con to set
     */
    @Override
    public void setCon(Connection aCon) {
        con = aCon;
    }
    
    
    private String tipoBD;
    private String nombreTabla;
    private String campos;
    private String id;
    
    
    private String getQueryInsertPS(){
        String sqlInsert;
        sqlInsert="INSERT INTO "+this.getNombreTabla()
                +" ("+this.getCampos()+") VALUES (";
        String [] campos_tabla = this.getCampos().split(",");
        String signos="";
        for(int i=0;i<campos_tabla.length;i++){
            signos+="?,";
        }
        sqlInsert+=signos.substring(0, signos.length()-1)+")";
        return sqlInsert;
    }
    
    protected PreparedStatement getPSInsert(){
        try {

            return this.getCon().prepareStatement(this.getQueryInsertPS());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()+" - "+this.getQueryInsertPS());
            return null;
        }
    }
    public ResultSet getTodosDatosTabla() throws SQLException{
        
        Statement s= this.getCon().createStatement();
        String sqlSelect="SELECT "+this.getCampos()+" FROM "+this.getNombreTabla()+";";
        return s.executeQuery(sqlSelect);
        
    }
    
    

    /**
     * @return the nombreTabla
     */
    public String getNombreTabla() {
        return nombreTabla;
    }

    /**
     * @param nombreTabla the nombreTabla to set
     */
    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    /**
     * @return the campos
     */
    public String getCampos() {
        return campos;
    }

    /**
     * @param campos the campos to set
     */
    public void setCampos(String campos) {
        this.campos = campos;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the tipoBD
     */
    public String getTipoBD() {
        return tipoBD;
    }

    /**
     * @param tipoBD the tipoBD to set
     */
    public void setTipoBD(String tipoBD) {
        this.tipoBD = tipoBD;
    }
    
    public void getCamposDefault(){
        
    }
}
