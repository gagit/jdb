/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databases.errores.oracle;

import java.util.UUID;

/**
 *
 * @author gtoledo
 */
public class ErroresCarga {
    
    private String ID_ERROR;
    private String UFI;
    private String TABLA;
    private String MENSAJE_ERROR;
    private String NOMBRE_ID;
    private String VALOR_ID;
    private String TIPO_DATO_ID;
    private String CORREGIDO;
    private String CREADO_EN;

    
    
    public ErroresCarga(){
        this.ID_ERROR=UUID.randomUUID().toString();
    }
    
    public void setID_ERROR(){
        this.ID_ERROR=UUID.randomUUID().toString();
    }
    
    /**
     * @return the ID_ERROR
     */
    public String getID_ERROR() {
        return ID_ERROR;
    }

    /**
     * @param ID_ERROR the ID_ERROR to set
     */
    public void setID_ERROR(String ID_ERROR) {
        this.ID_ERROR = ID_ERROR;
    }

    /**
     * @return the UFI
     */
    public String getUFI() {
        return UFI;
    }

    /**
     * @param UFI the UFI to set
     */
    public void setUFI(String UFI) {
        this.UFI = UFI;
    }

    /**
     * @return the TABLA
     */
    public String getTABLA() {
        return TABLA;
    }

    /**
     * @param TABLA the TABLA to set
     */
    public void setTABLA(String TABLA) {
        this.TABLA = TABLA;
    }

    /**
     * @return the MENSAJE_ERROR
     */
    public String getMENSAJE_ERROR() {
        return MENSAJE_ERROR;
    }

    /**
     * @param MENSAJE_ERROR the MENSAJE_ERROR to set
     */
    public void setMENSAJE_ERROR(String MENSAJE_ERROR) {
        this.MENSAJE_ERROR = MENSAJE_ERROR;
    }

    /**
     * @return the NOMBRE_ID
     */
    public String getNOMBRE_ID() {
        return NOMBRE_ID;
    }

    /**
     * @param NOMBRE_ID the NOMBRE_ID to set
     */
    public void setNOMBRE_ID(String NOMBRE_ID) {
        this.NOMBRE_ID = NOMBRE_ID;
    }

    /**
     * @return the VALOR_I
     */
    public String getVALOR_ID() {
        return VALOR_ID;
    }

    /**
     * @param VALOR_I the VALOR_I to set
     */
    public void setVALOR_ID(String VALOR_I) {
        this.VALOR_ID = VALOR_I;
    }

    /**
     * @return the TIPO_DATO_ID
     */
    public String getTIPO_DATO_ID() {
        return TIPO_DATO_ID;
    }

    /**
     * @param TIPO_DATO_ID the TIPO_DATO_ID to set
     */
    public void setTIPO_DATO_ID(String TIPO_DATO_ID) {
        this.TIPO_DATO_ID = TIPO_DATO_ID;
    }

    /**
     * @return the CORREGIDO
     */
    public String getCORREGIDO() {
        return CORREGIDO;
    }

    /**
     * @param CORREGIDO the CORREGIDO to set
     */
    public void setCORREGIDO(String CORREGIDO) {
        this.CORREGIDO = CORREGIDO;
    }

    /**
     * @return the CREADO_EN
     */
    public String getCREADO_EN() {
        return CREADO_EN;
    }

    /**
     * @param CREADO_EN the CREADO_EN to set
     */
    public void setCREADO_EN(String CREADO_EN) {
        this.CREADO_EN = CREADO_EN;
    }
    
}
