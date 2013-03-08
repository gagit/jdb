/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databases.errores.oracle;

import java.sql.*;

/**
 *
 * @author gabriel
 */
public class ErroresCargaOra extends TablasOra {
    
    private PreparedStatement psInsertErroresCargaOra;
    private PreparedStatement psUpdateErroresCargaOra;
    private PreparedStatement psUpdateCorregido;
    
    public ErroresCargaOra(){
        super.setNombreTabla("ERRORES_CARGA");
        super.setCampos("ID_ERROR,UFI,TABLA,MENSAJE_ERROR,"
                + "NOMBRE_ID,VALOR_ID,TIPO_DATO_ID,CORREGIDO,CREADO_EN");
        
    }
    
    public ErroresCargaOra(Connection c){
    }
    public ResultSet getErrores() throws SQLException{
       return super.getTodosDatosTabla();
    }
    public ResultSet getErroresNoCorregidos() throws SQLException{
        Statement s= super.getCon().createStatement();
        String sqlSelect=
                "SELECT "+this.getCampos()+
                " FROM "+this.getNombreTabla()+
                " WHERE CORREGIDO='N' ";
        return s.executeQuery(sqlSelect);
      
    }
    public PreparedStatement getPsErroresCargaOra() {
        return psInsertErroresCargaOra;
    }
    public void setPsInsertErroresCargaOra() {
        this.psInsertErroresCargaOra = super.getPSInsert();
    }
    public void grabarError(ErroresCarga e) {
        if(psInsertErroresCargaOra==null){
            this.setPsInsertErroresCargaOra();
        }
        try {
            this.getPsErroresCargaOra().setString(1, e.getID_ERROR());
            this.getPsErroresCargaOra().setString(2, e.getUFI());
            this.getPsErroresCargaOra().setString(3, e.getTABLA());
            this.getPsErroresCargaOra().setString(4, e.getMENSAJE_ERROR());
            this.getPsErroresCargaOra().setString(5, e.getNOMBRE_ID());
            this.getPsErroresCargaOra().setString(6, e.getVALOR_ID());
            this.getPsErroresCargaOra().setString(7, e.getTIPO_DATO_ID());
            this.getPsErroresCargaOra().setString(8, "N");
            this.getPsErroresCargaOra().setTimestamp(9, new Timestamp(new java.util.Date().getTime()));
            this.getPsErroresCargaOra().executeUpdate();
            this.getCon().commit();
            
        } catch (SQLException ex) {
            System.out.println("Fallo el registro del log de error!!!! ");
            ex.printStackTrace();
            try {
                this.getCon().rollback();  
            } catch (SQLException err) {
                System.out.println("Fallo el Rollback del log del error!!!! ");
                err.getStackTrace();
            }
        }
        
    }
    public void grabarError(String id) throws SQLException {
        this.getPsErroresCargaOra().setString(1, id);
    }
    public void actualizarCorregido(String id) throws SQLException {
        if(psUpdateCorregido != null){
            this.psUpdateCorregido.setString(1, id);
            this.psUpdateCorregido.execute();
            super.getCon().commit();
        }else{
            setPSUpdateCorregido();
            actualizarCorregido(id);
        }
    }
    
    private void setPSUpdateCorregido() throws SQLException{
        String sql="UPDATE "+super.getNombreTabla()+" SET corregido='S' WHERE ID_ERROR = ? ";
        psUpdateCorregido = this.getCon().prepareStatement(sql);
    }


    
}
