
package hojaVida;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hyperic.sigar.FileSystem;

import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.cmd.CpuInfo;
import org.hyperic.sigar.cmd.Free;
import org.hyperic.sigar.cmd.Shell;
import org.hyperic.sigar.cmd.SigarCommandBase;
import org.hyperic.sigar.cmd.Uptime;

/**
 * Display System Information
 */
public class SysInfo extends SigarCommandBase {

    CpuInfo cpuinfo;
      InetAddress ip;
            

    public SysInfo(Shell shell) throws UnknownHostException {
        super(shell);
        ip = InetAddress.getLocalHost();
    }

    public SysInfo() throws UnknownHostException {
        super();
        ip = InetAddress.getLocalHost();
    }

    public String getUsageShort() {
        return "Display system information";
    }

    public List particiones() throws SigarException {
        List<FileSystem> particiones = Arrays.asList(this.sigar.getFileSystemList());
        return particiones;
    }

    public List interfacesRed() throws SigarException {
        List<String> interfacesRed = Arrays.asList(this.sigar.getNetInterfaceList());
        return interfacesRed;
    }

    public long totalMemoriaRam() throws SigarException {
        long totalMemoriaRam = this.sigar.getMem().getTotal();
        return totalMemoriaRam;
    }

    public long LibreMemoriaRam() throws SigarException {
        long libreMemoriaRam = this.sigar.getMem().getFree();
        return libreMemoriaRam;
    }

    public long ocupadaMemoriaRam() throws SigarException {
        long ocupadaMemoriaRam = this.sigar.getMem().getUsed();
        return ocupadaMemoriaRam;
    }

    public String nombrePc() throws SigarException {
        String nombrePc = System.getProperty("user.name");
        return nombrePc;
    }

    public String nombreSo() throws SigarException {
        String nombreSo = System.getProperty("os.name");
        return nombreSo;
    }

    public String archSO() throws SigarException {
        String archSO = System.getProperty("os.arch");
        return archSO;
    }

    public String versionSO() throws SigarException {
        String versionSO = System.getProperty("os.version");
        return versionSO;
    }

    public String procesador() throws SigarException {

        org.hyperic.sigar.CpuInfo[] infos = this.sigar.getCpuInfoList();
        org.hyperic.sigar.CpuInfo info = infos[0];
        String vendor = (info.getVendor());
        return vendor;
    }

    public String procesadorModel() throws SigarException {
        org.hyperic.sigar.CpuInfo[] infos
                = this.sigar.getCpuInfoList();
        org.hyperic.sigar.CpuInfo info = infos[0];
        String vendorModel = (info.getModel());
        return vendorModel;
    }
    
    public void instancia() throws SigarException, SigarException, SigarException{
        try {
            //    new SysInfo().processCommand(args);
            new RegistrarEquipoHV().setVisible(true);
        } catch (SigarException ex) {
            Logger.getLogger(SysInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(SysInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(SysInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public int procesadorMghz() throws SigarException {
        org.hyperic.sigar.CpuInfo[] infos
                = this.sigar.getCpuInfoList();
        org.hyperic.sigar.CpuInfo info = infos[0];
        int vendorModel = (info.getMhz());
        return vendorModel;
    }
    
    public StringBuilder mac() throws SocketException{
    
     NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            StringBuilder sb = new StringBuilder();
            byte[] mac = network.getHardwareAddress();
            System.out.print("Current MAC address : ");
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(sb.toString());
            System.setProperty("mac", sb.toString());
        return sb;
            
    }
    
    public String serialboard(){
        Process p = null;
        String serial = null;
    try { 
            p = Runtime.getRuntime().exec("wmic bios get serialnumber");
          
        } catch (IOException ex) {
            Logger.getLogger(SysInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    serial=String.valueOf(p);
    return serial;
    }
    

    public void output(String[] args) throws SigarException {
        new Uptime(this.shell).output(args);
        println("");
        cpuinfo = new CpuInfo(this.shell);
        cpuinfo.displayTimes = false;
        cpuinfo.output(args);
        println("");
        new Free(this.shell).output(args);
        println("");
        println("Particiones de disco duro"
                + Arrays.asList(this.sigar.getFileSystemList()));
        println("");
        println("Interfaces de Red..."
                + Arrays.asList(this.sigar.getNetInterfaceList()));
        println("");
        Long memoria = this.sigar.getMem().getRam();
        println("Memoria Ram"
                + Arrays.asList(this.sigar.getMem()));
        println("");
        println("Nombre del equipo: "
                + System.getProperty("user.name"));
        println("");
        println("Nombre del SO: "
                + System.getProperty("os.name"));
        println("");
        String var = System.getProperty("os.arch");
        String tipoArquitectura = System.setProperty("1", var);
        println("Tipo de arquitectura: "
                + System.getProperty("os.arch"));
        println("");
        println("Versión del sistema operativo: "
                + System.getProperty("os.version"));
        println("");
        
        


    }

  
}
