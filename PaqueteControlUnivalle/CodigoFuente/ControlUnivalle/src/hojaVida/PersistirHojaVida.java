/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojaVida;

import ControlAulas.conectar;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hyperic.sigar.SigarException;

/**
 *
 * @author capriatto
 */
public class PersistirHojaVida {

    PreparedStatement pst, pst1;
    conectar cc = new conectar();
    Connection cn = cc.conexion();
    String sql1, equipo;

    public void insertar(String codigo,String aula) throws UnknownHostException, SigarException, SocketException {
        try {
            sql1 = "insert into equipo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = cn.prepareStatement(sql1);
            pst.setString(4, new SysInfo().procesador());
            pst.setString(5, new SysInfo().procesadorModel());
            pst.setString(6, String.valueOf(new SysInfo().procesadorMghz()));
            pst.setString(7, new HardDisk().getHardDiskFileSystem());
            pst.setString(8, String.valueOf(new HardDisk().getHardDiskSpace() + " GB"));
            pst.setString(9, new SysInfo().particiones().toString());
            pst.setString(10, String.valueOf(new SysInfo().totalMemoriaRam() + " KB"));
            pst.setString(11, new SysInfo().nombrePc());
            pst.setString(12, new SysInfo().nombreSo());
            pst.setString(13, new SysInfo().archSO());
            pst.setString(14, new SysInfo().versionSO());
            pst.setString(2, new SysInfo().mac().toString());
            pst.setString(3, aula);
            pst.setString(1, codigo);
            pst.setString(15, getMotherboardSN());          
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hoja de vida registrada");

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, este equipo ya fue registrado.");

        } catch (CommunicationsException e){
            JOptionPane.showMessageDialog(null, "Se ha perdido la conexión con la base de datos. ¡Lo sentimos!\nPor Favor intente más tarde.");
            
        }catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            Logger.getLogger(PersistirHojaVida.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "No se pudo registrar este equipo. Se ha perdido la conexión con la base de datos.\nIntente más tarde por favor");
        }

    }

    public static String getMotherboardSN() {
        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs
                    = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n"
                    + "   (\"Select * from Win32_bios\") \n"
                    + "For Each objItem in colItems \n"
                    + "    Wscript.Echo objItem.SerialNumber \n"
                    + "    exit for  ' do the first cpu only! \n"
                    + "Next \n";

            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.trim();
    }
}
