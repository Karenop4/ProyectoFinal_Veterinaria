/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Controlador.CDetalleFactura;
import Controlador.CFacturas;
import Controlador.CPersonas;
import Controlador.CServicios;
import DAO.UsuariosDAO;
import Modelo.MDetalleFact;
import Modelo.MFacturas;
import Modelo.MPersonas;
import Modelo.MServicios;
import Modelo.MUsuarios;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karen
 */
public class VFacturacion extends javax.swing.JFrame {
    private VEmpleado v;
    private MPersonas cliente;
    private CFacturas cFacturas;
    private CDetalleFactura cDetalleFactura;
    private MUsuarios mUsuario;
    private CPersonas cPersonas;
    private CServicios cServicios;
    private List<MServicios> servicios;
    
    /**
     * Creates new form NewJFrame
     */
    public VFacturacion(VEmpleado v, CFacturas cFacturas, CDetalleFactura cDetalleFactura, MUsuarios mUsuario, CPersonas cPersonas, CServicios cServicios) {
        initComponents();
        this.v = v;
        this.cDetalleFactura = cDetalleFactura;
        this.cFacturas = cFacturas;
        this.mUsuario = mUsuario;
        this.cPersonas = cPersonas;
        this.cServicios = cServicios;
        ImageIcon icono = new ImageIcon("src\\imagenes\\bill.png");
        setIconImage(icono.getImage());
        
        buscarEmpleado();
        txtCedulaEmpleado.setText(mUsuario.getEmpleado().getPer_cedula());
        txtNombreEmpleado.setText(mUsuario.getEmpleado().getPer_nombre() + " " + mUsuario.getEmpleado().getPer_apellido());
        txtCodigoEmpleado.setText(String.valueOf(mUsuario.getEmpleado().getPer_id()));
        
        servicios = new ArrayList<>();
        
        llenarListaServicios();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNumeroFactura = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCedulaCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtEmailCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtServicio = new javax.swing.JTextField();
        btnBuscarServicio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServiciosAgregados = new javax.swing.JTable();
        btnEliminarServicio = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaServiciosBuscados = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCodigoEmpleado = new javax.swing.JTextField();
        txtCedulaEmpleado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Facturación");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setAutoscrolls(true);
        jPanel1.setName("Facturación de Servicios"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Factura N°:");

        lblNumeroFactura.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumeroFactura.setText("000000");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel3.setText("C.I:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Dirección:");

        jLabel6.setText("Telefono:");

        jLabel7.setText("Email:");

        txtNombreCliente.setEditable(false);

        txtDireccionCliente.setEditable(false);

        txtTelefonoCliente.setEditable(false);

        txtEmailCliente.setEditable(false);

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCliente))
                    .addComponent(txtNombreCliente)
                    .addComponent(txtDireccionCliente)
                    .addComponent(txtTelefonoCliente)
                    .addComponent(txtEmailCliente))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel8.setText("Código / Nombre:");

        btnBuscarServicio.setText("Buscar");
        btnBuscarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarServicioActionPerformed(evt);
            }
        });

        tablaServiciosAgregados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cantidad", "Servicio", "IVA", "Precio Unitario", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaServiciosAgregados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaServiciosAgregadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaServiciosAgregados);

        btnEliminarServicio.setText("Eliminar");
        btnEliminarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarServicioActionPerformed(evt);
            }
        });

        listaServiciosBuscados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaServiciosBuscadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaServiciosBuscados);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarServicio)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(txtServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarServicio)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarServicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarServicio))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Totales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel9.setText("Subtotal sin IVA:");

        jLabel10.setText("Total IVA:");

        jLabel11.setText("Total:");

        txtSubtotal.setEditable(false);

        txtIva.setEditable(false);

        txtTotal.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSubtotal)
                    .addComponent(txtIva)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel12.setText("Codigo:");

        jLabel13.setText("C.I:");

        txtCodigoEmpleado.setEditable(false);

        txtCedulaEmpleado.setEditable(false);

        jLabel14.setText("Nombre:");

        txtNombreEmpleado.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedulaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCedulaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap())
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNumeroFactura))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(67, 67, 67)
                .addComponent(btnEnviar)
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNumeroFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnEnviar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        salir();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        salir();
    }//GEN-LAST:event_formWindowClosing

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        cliente = cPersonas.buscarCliente2(txtCedulaCliente.getText(), 'C');
        txtNombreCliente.setText(cliente.getPer_nombre() + " " + cliente.getPer_apellido());
        txtDireccionCliente.setText(cliente.getPer_direccion());
        txtEmailCliente.setText(cliente.getPer_correo());
        txtTelefonoCliente.setText(cliente.getPer_telefono());
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnBuscarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarServicioActionPerformed
        
    }//GEN-LAST:event_btnBuscarServicioActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if(cliente!=null && tablaServiciosAgregados.getRowCount() > 0){
            MFacturas factura = new MFacturas(0, new Date(), Double.parseDouble(txtSubtotal.getText()), Double.parseDouble(txtIva.getText()), Double.parseDouble(txtTotal.getText()), mUsuario, cliente);
            int id = cFacturas.crearFactura(factura);
            factura.setFac_id(id);
            
            DefaultTableModel model = (DefaultTableModel) tablaServiciosAgregados.getModel();

            for (int i = 0; i < model.getRowCount(); i++) {
                Object codigoObj = model.getValueAt(i, 0);  
                Object cantidadObj = model.getValueAt(i, 1);
                Object ivaObj = model.getValueAt(i, 3);
                Object precioObj = model.getValueAt(i, 4);
                Object totalObj = model.getValueAt(i, 5);

                int codigo = (codigoObj instanceof Integer) ? (Integer) codigoObj : Integer.parseInt(codigoObj.toString().trim());
                int cantidad = (cantidadObj instanceof Integer) ? (Integer) cantidadObj : Integer.parseInt(cantidadObj.toString().trim());
                double iva = (ivaObj instanceof Double) ? (Double) ivaObj : Double.parseDouble(ivaObj.toString().trim());
                double precio = (precioObj instanceof Double) ? (Double) precioObj : Double.parseDouble(precioObj.toString().trim());
                double total = (totalObj instanceof Double) ? (Double) totalObj : Double.parseDouble(totalObj.toString().trim());

                String nombre = model.getValueAt(i, 2).toString();
                MServicios servicio = null;
                for(MServicios s : servicios){
                    if(s.getServ_nombre().equals(nombre)){
                        servicio = s;
                        break;
                    }
                }
                
                MDetalleFact detalle = new MDetalleFact(id, cantidad, total, iva, total, precio, servicio, factura);
                
                cDetalleFactura.crearDetalle(detalle, id);
            }
        JOptionPane.showMessageDialog(this, "Factura creada");
        limpiar();    
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese los campos del cliente y los servicios");
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void listaServiciosBuscadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaServiciosBuscadosMouseClicked
         MServicios servicioSeleccionado = null;
         DefaultTableModel model = (DefaultTableModel) tablaServiciosAgregados.getModel();
         if (model.getColumnCount() == 0) {
            model.addColumn("Código");
            model.addColumn("Cantidad");
            model.addColumn("Nombre");
            model.addColumn("IVA");
            model.addColumn("Precio");
            model.addColumn("Total");
        }
         
            for(MServicios s : servicios){
                if(s.equals(listaServiciosBuscados.getSelectedValue())){
                    servicioSeleccionado = s;
                    
                    double IVA = 0;
                    double total = s.getServ_precio();
                    if(s.getServ_iva() == 'S'){
                        IVA = s.getServ_precio() * 0.12;
                        total = total + IVA;
                    }
                    model.addRow(new Object[]{s.getServ_codigo(), 1, s.getServ_nombre(), new BigDecimal(IVA).setScale(2, RoundingMode.HALF_UP).doubleValue(), s.getServ_precio(), new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue()});
                    calcularSumaTotal();
                    break;
                }
            }
    }//GEN-LAST:event_listaServiciosBuscadosMouseClicked

    private void tablaServiciosAgregadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServiciosAgregadosMouseClicked
        tablaServiciosAgregados.getModel().addTableModelListener(e -> {
            int column = e.getColumn(); // Columna que fue editada

            // Verificamos si la columna modificada es la de "Cantidad" (Índice 1)
            if (column == 1) { 
                int row = e.getFirstRow(); // Fila donde ocurrió el cambio
                DefaultTableModel model = (DefaultTableModel) tablaServiciosAgregados.getModel();

                try {
                    int cantidad = Integer.parseInt(model.getValueAt(row, 1).toString()); // Nueva cantidad
                    double precio = Double.parseDouble(model.getValueAt(row, 4).toString()); // Precio
                    double iva = Double.parseDouble(model.getValueAt(row, 3).toString()); // IVA

                    // Recalcular total
                    double total = (precio + iva) * cantidad;

                    // Actualizar el total en la tabla (columna 5)
                    model.setValueAt(new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue(), row, 5);
                    calcularSumaTotal();
                } catch (NumberFormatException ex) {
                    System.out.println("Error: Ingrese un número válido en la cantidad.");
                }
            }
        });

    }//GEN-LAST:event_tablaServiciosAgregadosMouseClicked

    private void btnEliminarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarServicioActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaServiciosAgregados.getModel();
        int filaSeleccionada = tablaServiciosAgregados.getSelectedRow(); // Obtener fila seleccionada

        if (filaSeleccionada != -1) { // Verificar si hay una fila seleccionada
            model.removeRow(filaSeleccionada); // Eliminar la fila
            calcularSumaTotal();
        }
    }//GEN-LAST:event_btnEliminarServicioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        salir();
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    public void salir(){
        this.setVisible(false);
        v.setEnabled(true);
        v.setVisible(true);
    }
    
    public void buscarEmpleado(){
        mUsuario.setEmpleado(cPersonas.buscarClienteID2(mUsuario.getUs_id(), 'E'));
    }
    
    private void calcularSumaTotal() {
        double sumaTotal = 0.0;
        double sumaUnitario = 0.0;
        double sumaIva= 0.0;
        DefaultTableModel model = (DefaultTableModel) tablaServiciosAgregados.getModel();

        // Recorrer todas las filas de la tabla
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                int cantidad = Integer.parseInt(model.getValueAt(i, 1).toString());
                double IVA = Double.parseDouble(model.getValueAt(i, 3).toString());
                double unitario = Double.parseDouble(model.getValueAt(i, 4).toString());
                double total = Double.parseDouble(model.getValueAt(i, 5).toString()); // Columna "Total" (índice 5)
                IVA = cantidad * IVA;
                unitario = unitario * cantidad;
                sumaTotal += total;
                sumaUnitario += unitario;
                sumaIva += IVA;
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Error al sumar fila " + i + ": " + e.getMessage());
            }
        }

        txtTotal.setText(String.valueOf(sumaTotal));
        txtSubtotal.setText(String.valueOf(sumaUnitario));
        txtIva.setText(String.valueOf(sumaIva));
    }


    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarServicio;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarServicio;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNumeroFactura;
    private javax.swing.JList<String> listaServiciosBuscados;
    private javax.swing.JTable tablaServiciosAgregados;
    private javax.swing.JTextField txtCedulaCliente;
    private javax.swing.JTextField txtCedulaEmpleado;
    private javax.swing.JTextField txtCodigoEmpleado;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void llenarListaServicios() {
        servicios = cServicios.listarServicios2();
        DefaultListModel model = new DefaultListModel();
        
        for (MServicios servicio : servicios) {
            model.addElement(servicio);
        }
        
        listaServiciosBuscados.setModel(model);
    }

    private void limpiar() {
        txtCedulaCliente.setText("");
        txtDireccionCliente.setText("");
        txtEmailCliente.setText("");
        txtIva.setText("");
        txtNombreCliente.setText("");
        txtSubtotal.setText("");
        txtTelefonoCliente.setText("");
        txtTotal.setText("");
   }
}
