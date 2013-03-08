/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databases.tablas;

import databases.conexiones.Conectable;

/**
 *
 * @author gabriel
 */
public abstract class Tablas {
    
    private String tipoBD;
    private String nombreTabla;
    private String campos;
    private String id;
        
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
