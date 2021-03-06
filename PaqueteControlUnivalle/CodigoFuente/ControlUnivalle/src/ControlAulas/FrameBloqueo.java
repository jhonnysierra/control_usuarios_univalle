package ControlAulas;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GermanV
 */
public class FrameBloqueo extends javax.swing.JFrame {

    PreparedStatement pst, pst1;
    conectar cc = new conectar();
    Connection cn = cc.conexion();
    ResultSet rs, rs1;
    String usuario, contraseña, sql, sql1, sql2, codigo, passw, tipo, estado, fecha, horaI, horaF = "00:00:00", conse = "", aula = "", equipo,codPC;
    Date fecha1, hora1;
    Calendar fecha2;

    AdminInfo adminf = new AdminInfo();

    public FrameBloqueo() {

        setAlwaysOnTop(true);
        this.setFocusableWindowState(true);

        this.setUndecorated(true);//quita bordes a jframe

        initComponents();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//evita cerra jframe con ALT+C
        this.setExtendedState(MAXIMIZED_BOTH);//maximizado
        this.setAlwaysOnTop(true);//siempre al frente       
        //nueva instancia de jBlocked pasando como parametros e este JFrame
        new Bloqueo(this).Seguro();
        panelAyuda.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AyudaUsu = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        panelAyuda = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAyuda = new javax.swing.JTextArea();

        AyudaUsu.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        AyudaUsu.setTitle("AYUDA");
        AyudaUsu.setAlwaysOnTop(true);

        jLabel4.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel4.setText("AYUDA PARA USUARIOS");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Para que el sistema habilite el uso de éste equipo usted debe ingresar un usuario y una contraseña. \nEl usuario es el código completodel estudiante y la contraseña es la primer letra del primer nombre en mayúscula,seguido del código sin los dos primeros digitos, seguido de la primer letra del primer \napellido en mayúscula. \n\nEjemplo:\nSi su nombre es Pepito Alberto Perez y su código es 201251098 su usuario será 201251098 y su contraseña P1251098P\n\nRECUERDE que si es la primera vez que ingresa debe cambiar la contraseña. Si tiene problemas para ingresar por favor diríjase al administrador para solucionar su problema.\n\nSi ya cambió su contraseña y la olvidó, debe dirijirse al administrador y presentar su carnet estudiantil para que su contraseña sea restablecida. Una vez restablecida su contraseña ingrese como se explica al principio del documento.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout AyudaUsuLayout = new javax.swing.GroupLayout(AyudaUsu.getContentPane());
        AyudaUsu.getContentPane().setLayout(AyudaUsuLayout);
        AyudaUsuLayout.setHorizontalGroup(
            AyudaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AyudaUsuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AyudaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(AyudaUsuLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AyudaUsuLayout.setVerticalGroup(
            AyudaUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AyudaUsuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        AyudaUsu.getAccessibleContext().setAccessibleName("jFrame1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(197, 37, 37));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setAutoscrolls(true);

        jLabel1.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel1.setText("Usuario :");

        jLabel2.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña :");

        btnEntrar.setBackground(new java.awt.Color(255, 204, 204));
        btnEntrar.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        txtPass.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N

        txtUser.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel3.setText("Universidad del Valle Sede Caicedonia");

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControlAulas/help_rojo_22.png"))); // NOI18N
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel6.setText("Sistema de Control de Uso de Equipos");

        panelAyuda.setBackground(new java.awt.Color(204, 204, 204));

        txtAyuda.setEditable(false);
        txtAyuda.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        txtAyuda.setLineWrap(true);
        txtAyuda.setText("Para que el sistema habilite el uso de éste equipo usted  \ndebe ingresar un usuarioy una contraseña. \n\nEl usuario es el código completo del estudiante y la \ncontraseña es la primer letra del primer nombre en \nmayúscula, seguido del código sin los dos primeros dígitos, \nseguido de la primer letra del primer apellido en mayúscula. \n\nEjemplo:\nSi su nombre es Pepito Alberto Perez y su código es \n201251098 su usuario será  201251098 y su contraseña \nP1251098P\n\nRECUERDE que si es la primera vez que ingresa debe cambiarla contraseña. Si tiene problemas para ingresar por favor \ndiríjase al administrador para solucionar su problema.\n\nSi ya cambió su contraseña y la olvidó, debe dirijirse al \nadministrador y presentar su carnet estudiantil para que su \ncontraseña sea restablecida. Una vez restablecida su \ncontraseña ingrese como se explica al principio del \ndocumento.");
        txtAyuda.setWrapStyleWord(true);
        txtAyuda.setAutoscrolls(false);
        txtAyuda.setCaretPosition(1);
        jScrollPane2.setViewportView(txtAyuda);

        javax.swing.GroupLayout panelAyudaLayout = new javax.swing.GroupLayout(panelAyuda);
        panelAyuda.setLayout(panelAyudaLayout);
        panelAyudaLayout.setHorizontalGroup(
            panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAyudaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelAyudaLayout.setVerticalGroup(
            panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAyudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(txtUser))
                            .addComponent(btnEntrar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel1.add(jPanel2, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        usuario = txtUser.getText();
        contraseña = txtPass.getText();

        sql = "select codigo, contraseña, tipo, estado from estudiante where codigo='" + usuario + "'";
        try {
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();

            codigo = rs.getString(1);
            passw = rs.getString(2);
            tipo = rs.getString(3);
            estado = rs.getString(4);

            if (usuario.equals(codigo) && contraseña.equals(passw) && estado.equals("1")) {

                if (tipo.equals("0")) {
                    fechaHora();
                    conseguirMAC();
                    codFicha();

                    aula = adminf.consultarCodigo("equipo", "aula", equipo, "mac");
                    codPC = adminf.consultarCodigo("equipo", "codigo", equipo, "mac");
                          
                    /////////////////////////////////////////////////////////////
                    sql1 = "insert into bitacora values(?,?,?,?,?,?,?)";
                    System.out.println(sql1);
                    pst = cn.prepareStatement(sql1);
                    pst.setString(1, conse);
                    pst.setString(2, fecha);
                    pst.setString(3, horaI);
                    pst.setString(4, horaF);
                    pst.setString(5, usuario);
                    //// Consultar a la BD el aula y la direccion mac del equipo en servicio//////
                    pst.setString(6, aula);
                    pst.setString(7, codPC);
                    pst.executeUpdate();
                /////////////////////////////////////////////////////////////

                    //Crear otro frame para el control de la aplicacion por parte de usuario o administrador
                    JOptionPane.showMessageDialog(this, "Acceso Autorizado");
                    Control1 controlp = new Control1(conse, usuario);
                    controlp.setVisible(true);
                    this.dispose();
                } else if (tipo.equals("1")) {
                    JOptionPane.showMessageDialog(this, "Acceso como administrador autorizado");
                    Administrador admin = new Administrador();
                    admin.setVisible(true);
                    this.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(this, "Acceso Denegado \n" + "Datos Incorrectos");
                txtUser.setText("");
                txtPass.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrameBloqueo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Acceso Denegado \n");
            txtUser.setText("");
            txtPass.setText("");
        } catch (IOException ex) {
            Logger.getLogger(FrameBloqueo.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        char carac = evt.getKeyChar();
        if (!(((int) carac > 47 && (int) carac < 58 || (int) carac == 8))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUserKeyTyped
    int bandera = 0;
    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed

        if (bandera == 0) {
            panelAyuda.setVisible(true);
            bandera = 1;
        } else if (bandera == 1) {
            panelAyuda.setVisible(false);
            bandera = 0;
        }


    }//GEN-LAST:event_btnHelpActionPerformed
    public void codFicha() {
        int cod;
        sql2 = "select max(codigo)+1 from bitacora";
        try {
            pst1 = cn.prepareStatement(sql2);
            rs1 = pst1.executeQuery();
            rs1.next();
            cod = rs1.getInt(1);

            if (cod == 0) {
                conse = "1";
            } else {
                conse = String.valueOf(cod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrameBloqueo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fechaHora() {
        fecha1 = new Date();
        hora1 = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formato1 = new SimpleDateFormat("HH:mm:ss");
        fecha = formato.format(fecha1);
        horaI = formato1.format(hora1);
    }

    public void conseguirMAC() {
        NetworkInterface a;
        try {
            a = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            byte[] mac = a.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            equipo = sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line +evc
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameBloqueo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame AyudaUsu;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnHelp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel panelAyuda;
    private javax.swing.JTextArea txtAyuda;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
