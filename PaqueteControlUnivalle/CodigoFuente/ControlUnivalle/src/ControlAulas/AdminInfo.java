/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAulas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author JHONNY
 */
public class AdminInfo {

    String sql, sql2, sql3, sql4, descripcion, descripcion2;
    PreparedStatement pst, pst2, pst3, pst4;
    ResultSet rs, rs2, rs3, rs4;
    conectar cc = new conectar();
    Connection cn = cc.conexion();

    public void cargarCombo(String tabla, String campo, JComboBox combo) {
        sql = "select " + campo + " from " + tabla + " order by " + campo;
        try {
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                descripcion = rs.getString(campo);
                combo.addItem(descripcion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarComboCiudad(String tabla, String campo, String depar, JComboBox combo) {
        sql2 = "select municipio." + campo + " from dpto," + tabla + " where municipio.dpto=dpto.codigo and dpto.nombre='" + depar + "' order by " + campo;
        try {
            pst2 = cn.prepareStatement(sql2);
            rs2 = pst2.executeQuery();
            while (rs2.next()) {
                descripcion2 = rs2.getString(campo);
                combo.addItem(descripcion2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String consultaremple(String tabla, String campo) {
        String resul = null;
        sql3 = "select concat(nombre1,' ',nombre2,' ',apellido1,' ',apellido2)nombre from " + tabla + " where cedula='" + campo + "'";
        try {
            pst3 = cn.prepareStatement(sql3);
            rs3 = pst3.executeQuery();
            rs3.first();
            resul = rs3.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resul;
    }

    public String consultarCodigo(String tabla, String campoAtraer, String ValorAbuscar, String campoAcomparar) {
        ValorAbuscar = "'" + ValorAbuscar + "'";
        String resultado = "";
        try {
            sql4 = "select " + campoAtraer + " from " + tabla + " where " + campoAcomparar + "=" + ValorAbuscar;
            pst4 = cn.prepareStatement(sql4);
            rs4 = pst4.executeQuery();
            rs4.first();
            resultado = rs4.getString(campoAtraer);            
        } catch (SQLException ex) {
            //Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

}
