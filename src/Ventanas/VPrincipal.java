/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import java.awt.Color;
import java.awt.Panel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Ventanas.*;
import Clases.*;
import Controlador.CUsuarios;
import DAO.ConexionBD;
import DAO.UsuariosDAO;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author USER
 */
public class VPrincipal extends javax.swing.JFrame {
    private VEmpleado vEmpleado;
    Busquedas b=new Busquedas();
    private UsuariosDAO usuariosDAO;
    private CUsuarios cUsuarios;
    
    public StringBuilder passwordBuilder = new StringBuilder();
     /* Creates new form VPrincipal
     */
    public VPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        ImageIcon cliIcon = new ImageIcon("src\\imagenes\\user.png");
        Image image = cliIcon.getImage(); // Obtener la imagen
        Image newImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Redimensionar
        cliIcon = new ImageIcon(newImage);
        lblUsuIcono.setIcon(cliIcon);
        
        ImageIcon contIcon = new ImageIcon("src\\imagenes\\padlock.png");
        Image image2 = contIcon.getImage(); // Obtener la imagen
        Image newImage2 = image2.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Redimensionar
        contIcon = new ImageIcon(newImage2);
        lblContIcono.setIcon(contIcon);
        
        ImageIcon mostrarContrasenia = new ImageIcon("src\\imagenes\\hide.png");
        Image scaledImage = mostrarContrasenia.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        mostrarContrasenia = new ImageIcon(scaledImage);
        button.setIcon(mostrarContrasenia);
        
        ImageIcon icono = new ImageIcon("src\\imagenes\\login.png");
        setIconImage(icono.getImage());
        
        usuariosDAO = new UsuariosDAO();
        cUsuarios = new CUsuarios(usuariosDAO);
        
        // Listener para ocultar caracteres al escribir
        TxtContraseña.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && passwordBuilder.length() > 0) {
                    // Eliminar el último carácter si se presiona Backspace
                    passwordBuilder.deleteCharAt(passwordBuilder.length() - 1);
                } else if (Character.isLetterOrDigit(e.getKeyChar()) || Character.isWhitespace(e.getKeyChar())) {
                    // Agregar el carácter ingresado al "passwordBuilder"
                    passwordBuilder.append(e.getKeyChar());
                } else {
                    e.consume(); // Ignorar caracteres no válidos
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Reemplazar el texto del campo con asteriscos después de procesar el carácter
                TxtContraseña.setText("*".repeat(passwordBuilder.length()));
            }
        });

        
        button.addActionListener(e -> JOptionPane.showMessageDialog(PanelUsuario, 
            "Contraseña: " + passwordBuilder.toString()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelUsuario = new javax.swing.JPanel();
        TxtUsuario = new javax.swing.JTextField();
        TxtContraseña = new javax.swing.JTextField();
        BtnIngresar = new javax.swing.JToggleButton();
        lblUsuIcono = new javax.swing.JLabel();
        lblContIcono = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Gestor Veterinaria");
        setPreferredSize(new java.awt.Dimension(600, 500));
        setResizable(false);

        PanelUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelUsuario.setPreferredSize(new java.awt.Dimension(231, 220));

        TxtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        TxtUsuario.setText("Usuario");
        TxtUsuario.setName("TxtUsuario"); // NOI18N
        TxtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtUsuarioMouseClicked(evt);
            }
        });

        TxtContraseña.setForeground(new java.awt.Color(153, 153, 153));
        TxtContraseña.setText("Contraseña");
        TxtContraseña.setName("TxtContraseña"); // NOI18N
        TxtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtContraseñaMouseClicked(evt);
            }
        });

        BtnIngresar.setText("Ingresar");
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });

        button.setToolTipText("Ver contraseña");

        javax.swing.GroupLayout PanelUsuarioLayout = new javax.swing.GroupLayout(PanelUsuario);
        PanelUsuario.setLayout(PanelUsuarioLayout);
        PanelUsuarioLayout.setHorizontalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblContIcono, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(lblUsuIcono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelUsuarioLayout.createSequentialGroup()
                        .addComponent(TxtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(BtnIngresar)
                .addGap(17, 17, 17))
        );
        PanelUsuarioLayout.setVerticalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblContIcono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnIngresar)
                .addGap(28, 28, 28))
        );

        TxtUsuario.getAccessibleContext().setAccessibleName("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Inicio de sesión");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPasswordField1.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(229, 229, 229))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(250, 250, 250))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarTXT(JTextField Txt){
        Txt.setForeground(Color.BLACK);
        Txt.setText("");
    }
    private void llenarTXT(JTextField Txt){
        Txt.setForeground(Color.GRAY);
        if(Txt.getName().equals("TxtUsuario")){
            Txt.setText("Usuario");
        }
        else{
            Txt.setText("Contraseña");
        }
    }
    //Metodo para obtener que tipo de empleado es (General o administrativo) de la base de datos
    private String tipoEmpl(String usr){
        return "Administrativo";
    }
    private void TxtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtUsuarioMouseClicked
       this.limpiarTXT(TxtUsuario);
    }//GEN-LAST:event_TxtUsuarioMouseClicked
 
    
    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed
        String tipoUsuario = cUsuarios.buscarUsuario(TxtUsuario.getText(), passwordBuilder.toString());
        
        if(tipoUsuario == null){
            JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrecto");
        }else{
            this.setVisible(false);
            vEmpleado=new VEmpleado(this);
            vEmpleado.setLocationRelativeTo(null);
            vEmpleado.setVisible(true);
            vEmpleado.setTipo(tipoUsuario);
        }
        this.llenarTXT(TxtUsuario);
        this.llenarTXT(TxtContraseña);
    }//GEN-LAST:event_BtnIngresarActionPerformed

    private void TxtContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtContraseñaMouseClicked
        this.limpiarTXT(TxtContraseña);
    }//GEN-LAST:event_TxtContraseñaMouseClicked

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtnIngresar;
    private javax.swing.JPanel PanelUsuario;
    private javax.swing.JTextField TxtContraseña;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JButton button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lblContIcono;
    private javax.swing.JLabel lblUsuIcono;
    // End of variables declaration//GEN-END:variables
}
