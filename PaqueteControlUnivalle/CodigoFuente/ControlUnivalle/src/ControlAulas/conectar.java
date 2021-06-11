package ControlAulas;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Sony
 */

public class conectar {

    Connection conn = null;

    public Connection conexion() {
        try {
          //"jdbc:mysql://192.168.0.1/sistema_integral","sistemas","sistemas"
            //"jdbc:mysql://localhost/controlaula","root",""             
            //Cargamos el Driver MySQL
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.0.1/sistema_integral","sistemas","sistemas");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);

        }
        return conn;
    }
//////////////////////////////////////////////////////////*************/////////////////////////////////

    public Connection conexion2() {
        try {

            //Cargamos el Driver MySQL
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/controlasinred", "root", "");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);

        }
        return conn;
    }

}
