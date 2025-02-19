/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;
import Controlador.*;
import DAO.*;
import Modelo.MUsuarios;
import Ventanas.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class VEmpleado extends javax.swing.JFrame {
    //Instancia ventanas
    VPrincipal vPrincipal;
    VCliente VCliente;
    VServicioListado VservicioListado;
    VFacturacion VFacturacion;
    VListarFacturas VListarFacturas;
    VListarEmpleados VListarEmpleados;
    VRazasMascotas VRazasMascotas;
    VCitas VCitas;
    VMascotas VMascotas;
    
    //Instancia DAOS
    private CitasDAO citasDAO;
    private FacturasDAO facturasDAO;
    private MascotasDAO mascotasDAO;
    private PersonasDAO personasDAO;
    private RazasDAO razasDAO;
    private ServiciosDAO serviciosDAO;
    private TiposMascotasDAO tiposMascotasDAO;
    private DetalleFacturaDAO detalleFacturaDAO;
    private UsuariosDAO usuariosDAO;
    
    //Instancia controladores
    private CCitas cCitas;
    private CFacturas cFacturas;
    private CMascotas cMascotas;
    private CPersonas cPersonas;
    private CRazas cRazas;
    private CServicios cServicios;
    private CTiposMascotas cTiposMascotas;
    private CUsuarios cUsuarios;
    private CDetalleFactura cDetalleFactura;
    
    private MUsuarios mUsuario;
    /**
     * Creates new form VEmpleado
     */
    public VEmpleado(VPrincipal vP, MUsuarios usuario) {
        initComponents();
        vPrincipal=vP;
        this.mUsuario = usuario;
        ImageIcon icono = new ImageIcon("src\\imagenes\\veterinarian_logo.png");
        setIconImage(icono.getImage());
        
        ImageIcon cliIcon = new ImageIcon("src\\imagenes\\client.png");
        Image image = cliIcon.getImage(); // Obtener la imagen
        Image newImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Redimensionar
        cliIcon = new ImageIcon(newImage);
        LblClienteIcono.setIcon(cliIcon);
        
        ImageIcon factIcon = new ImageIcon("src\\imagenes\\bill.png");
        Image image2 = factIcon.getImage(); // Obtener la imagen
        Image newImage2 = image2.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Redimensionar
        factIcon = new ImageIcon(newImage2);
        LblFacIcono.setIcon(factIcon);
        
        ImageIcon mascIcon = new ImageIcon("src\\imagenes\\pets.png");
        Image image3 = mascIcon.getImage(); // Obtener la imagen
        Image newImage3 = image3.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Redimensionar
        mascIcon = new ImageIcon(newImage3);
        LblMascIcono.setIcon(mascIcon);
        
        ImageIcon servIcon = new ImageIcon("src\\imagenes\\shower.png");
        Image image4 = servIcon.getImage(); // Obtener la imagen
        Image newImage4 = image4.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Redimensionar
        servIcon = new ImageIcon(newImage4);
        LblServIcono.setIcon(servIcon);
        
        ImageIcon citaIcon = new ImageIcon("src\\imagenes\\reserve.png");
        Image image5 = citaIcon.getImage(); // Obtener la imagen
        Image newImage5 = image5.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Redimensionar
        citaIcon = new ImageIcon(newImage5);
        LblCitaIcono2.setIcon(citaIcon);
        
        ImageIcon vetIcon = new ImageIcon("src\\imagenes\\veterinarian_logo.png");
        Image image6 = vetIcon.getImage(); // Obtener la imagen
        Image newImage6 = image6.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionar
        vetIcon = new ImageIcon(newImage6);
        LblVetIcono.setIcon(vetIcon);
        LblVetIcono1.setIcon(vetIcon);
        
        ImageIcon empIcon = new ImageIcon("src\\imagenes\\veterinarian.png");
        Image image7 = empIcon.getImage(); // Obtener la imagen
        Image newImage7 = image7.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Redimensionar
        empIcon = new ImageIcon(newImage7);
        lblEmpIcono.setIcon(empIcon);
        
        ImageIcon razaIcon = new ImageIcon("src\\imagenes\\animals.png");
        Image image8 = razaIcon.getImage(); // Obtener la imagen
        Image newImage8 = image8.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Redimensionar
        razaIcon = new ImageIcon(newImage8);
        LblRazaIcono.setIcon(razaIcon);
        
        //Creacion DAOS
        citasDAO = new CitasDAO();
        facturasDAO = new FacturasDAO();
        mascotasDAO = new MascotasDAO();
        personasDAO = new PersonasDAO();
        razasDAO = new RazasDAO();
        serviciosDAO = new ServiciosDAO();
        tiposMascotasDAO = new TiposMascotasDAO();
        usuariosDAO = new UsuariosDAO();
        detalleFacturaDAO = new DetalleFacturaDAO();
        
        //Creacion controladores
        cCitas = new CCitas(citasDAO);
        cFacturas = new CFacturas(facturasDAO);
        cMascotas = new CMascotas(mascotasDAO);
        cPersonas = new CPersonas(personasDAO);
        cRazas = new CRazas(razasDAO);
        cServicios = new CServicios(serviciosDAO);
        cTiposMascotas = new CTiposMascotas(tiposMascotasDAO);
        cUsuarios = new CUsuarios(usuariosDAO);
        cDetalleFactura = new CDetalleFactura(detalleFacturaDAO);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JTabbedPane();
        panelEmpleado = new javax.swing.JPanel();
        LblTipo = new javax.swing.JLabel();
        PanelClientes = new javax.swing.JPanel();
        LblClienteIcono = new javax.swing.JLabel();
        BtnClientes = new javax.swing.JToggleButton();
        PanelFac = new javax.swing.JPanel();
        LblFacIcono = new javax.swing.JLabel();
        BtnFacturacion = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        PanelMascotas = new javax.swing.JPanel();
        btnMascotas = new javax.swing.JButton();
        LblMascIcono = new javax.swing.JLabel();
        LblVetIcono = new javax.swing.JLabel();
        panelAdmin = new javax.swing.JPanel();
        PanelServ = new javax.swing.JPanel();
        LblServIcono = new javax.swing.JLabel();
        BtnServicios = new javax.swing.JToggleButton();
        PanelCitas = new javax.swing.JPanel();
        LblCitaIcono2 = new javax.swing.JLabel();
        BtnCitas = new javax.swing.JToggleButton();
        PanelEmpleado = new javax.swing.JPanel();
        btnEmpleado = new javax.swing.JButton();
        lblEmpIcono = new javax.swing.JLabel();
        LblVetIcono1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LblRazaIcono = new javax.swing.JLabel();
        BtnCerrarSesion = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Atencion al cliente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelPrincipal.setName("Empleado"); // NOI18N

        LblTipo.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        PanelClientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelClientes.setPreferredSize(new java.awt.Dimension(260, 130));

        LblClienteIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblClienteIcono.setLabelFor(BtnClientes);

        BtnClientes.setText("Clientes");
        BtnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnClientesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelClientesLayout = new javax.swing.GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelClientesLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(LblClienteIcono))
                    .addGroup(PanelClientesLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(BtnClientes)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        PanelClientesLayout.setVerticalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(LblClienteIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnClientes)
                .addGap(17, 17, 17))
        );

        PanelFac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelFac.setPreferredSize(new java.awt.Dimension(260, 130));

        LblFacIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblFacIcono.setLabelFor(BtnFacturacion);

        BtnFacturacion.setText("Facturación");
        BtnFacturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnFacturacionMouseClicked(evt);
            }
        });

        jButton1.setText("Buscar Fact.");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelFacLayout = new javax.swing.GroupLayout(PanelFac);
        PanelFac.setLayout(PanelFacLayout);
        PanelFacLayout.setHorizontalGroup(
            PanelFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFacLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(LblFacIcono)
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(PanelFacLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(BtnFacturacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );
        PanelFacLayout.setVerticalGroup(
            PanelFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFacLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(LblFacIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFacturacion)
                    .addComponent(jButton1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        PanelMascotas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnMascotas.setText("Mascotas");
        btnMascotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMascotasMouseClicked(evt);
            }
        });

        LblMascIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblMascIcono.setLabelFor(BtnFacturacion);

        javax.swing.GroupLayout PanelMascotasLayout = new javax.swing.GroupLayout(PanelMascotas);
        PanelMascotas.setLayout(PanelMascotasLayout);
        PanelMascotasLayout.setHorizontalGroup(
            PanelMascotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMascotasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblMascIcono)
                .addGap(106, 106, 106))
            .addGroup(PanelMascotasLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnMascotas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelMascotasLayout.setVerticalGroup(
            PanelMascotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMascotasLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(LblMascIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMascotas)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout panelEmpleadoLayout = new javax.swing.GroupLayout(panelEmpleado);
        panelEmpleado.setLayout(panelEmpleadoLayout);
        panelEmpleadoLayout.setHorizontalGroup(
            panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmpleadoLayout.createSequentialGroup()
                        .addComponent(LblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelEmpleadoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanelMascotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelFac, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(LblVetIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        panelEmpleadoLayout.setVerticalGroup(
            panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEmpleadoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelEmpleadoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LblVetIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panelPrincipal.addTab("Empleado", panelEmpleado);

        PanelServ.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelServ.setPreferredSize(new java.awt.Dimension(260, 130));

        LblServIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServIcono.setLabelFor(BtnClientes);

        BtnServicios.setText("Servicios");
        BtnServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnServiciosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelServLayout = new javax.swing.GroupLayout(PanelServ);
        PanelServ.setLayout(PanelServLayout);
        PanelServLayout.setHorizontalGroup(
            PanelServLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelServLayout.createSequentialGroup()
                .addGroup(PanelServLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelServLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(LblServIcono))
                    .addGroup(PanelServLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(BtnServicios)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelServLayout.setVerticalGroup(
            PanelServLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelServLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(LblServIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnServicios)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        PanelCitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelCitas.setPreferredSize(new java.awt.Dimension(260, 130));

        LblCitaIcono2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblCitaIcono2.setLabelFor(BtnClientes);

        BtnCitas.setText("Citas");
        BtnCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCitasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelCitasLayout = new javax.swing.GroupLayout(PanelCitas);
        PanelCitas.setLayout(PanelCitasLayout);
        PanelCitasLayout.setHorizontalGroup(
            PanelCitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCitasLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(PanelCitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnCitas)
                    .addComponent(LblCitaIcono2))
                .addGap(96, 96, 96))
        );
        PanelCitasLayout.setVerticalGroup(
            PanelCitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCitasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(LblCitaIcono2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCitas)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        PanelEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnEmpleado.setText("Empleados");
        btnEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmpleadoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelEmpleadoLayout = new javax.swing.GroupLayout(PanelEmpleado);
        PanelEmpleado.setLayout(PanelEmpleadoLayout);
        PanelEmpleadoLayout.setHorizontalGroup(
            PanelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmpleadoLayout.createSequentialGroup()
                .addGroup(PanelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEmpleadoLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnEmpleado))
                    .addGroup(PanelEmpleadoLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(lblEmpIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        PanelEmpleadoLayout.setVerticalGroup(
            PanelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEmpleadoLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblEmpIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEmpleado)
                .addGap(22, 22, 22))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setText("Razas");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel1.setText("Mascotas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(LblRazaIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(LblRazaIcono, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelServ, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelCitas, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(LblVetIcono1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblVetIcono1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelPrincipal.addTab("Administrador", panelAdmin);

        BtnCerrarSesion.setText("Cerrar Sesión");
        BtnCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnCerrarSesion)
                .addGap(335, 335, 335))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCerrarSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPrincipal.getAccessibleContext().setAccessibleName("Empleado");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarSesionActionPerformed
        vPrincipal.passwordBuilder.setLength(0);
        this.setVisible(false);
        vPrincipal.setVisible(true);
        panelPrincipal.setVisible(true);
        panelPrincipal.setSelectedComponent(panelEmpleado);
        
    }//GEN-LAST:event_BtnCerrarSesionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       int op=JOptionPane.showConfirmDialog(rootPane, "Cerrar el programa?", "Confirmar", JOptionPane.YES_NO_OPTION,2);
       if(op==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Gracias :)");
            this.setVisible(false);
            System.exit(0);  
       }
    }//GEN-LAST:event_formWindowClosing

    private void BtnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClientesMouseClicked
        VCliente=new VCliente(this, cPersonas);
        this.setEnabled(false);
        VCliente.setLocationRelativeTo(null);
        VCliente.setVisible(true);
    }//GEN-LAST:event_BtnClientesMouseClicked

    private void BtnServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnServiciosMouseClicked
        VservicioListado = new VServicioListado(this);
        this.setEnabled(false);
        VservicioListado.setLocationRelativeTo(null);
        VservicioListado.setVisible(true);
    }//GEN-LAST:event_BtnServiciosMouseClicked

    private void BtnFacturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnFacturacionMouseClicked
        VFacturacion = new VFacturacion(this,cFacturas, cDetalleFactura, mUsuario, cPersonas, cServicios);
        this.setEnabled(false);
        VFacturacion.setLocationRelativeTo(null);
        VFacturacion.setVisible(true);
    }//GEN-LAST:event_BtnFacturacionMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        VListarFacturas = new VListarFacturas(this,cFacturas, cPersonas, cUsuarios);
        this.setEnabled(false);
        VListarFacturas.setLocationRelativeTo(null);
        VListarFacturas.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadoMouseClicked
        VListarEmpleados = new VListarEmpleados(this);
        this.setEnabled(false);
        VListarEmpleados.setLocationRelativeTo(null);
        VListarEmpleados.setVisible(true);
    }//GEN-LAST:event_btnEmpleadoMouseClicked

    private void BtnCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCitasMouseClicked
        VCitas = new VCitas(this);
        this.setEnabled(false);
        VCitas.setLocationRelativeTo(null);
        VCitas.setVisible(true);
    }//GEN-LAST:event_BtnCitasMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        VRazasMascotas = new VRazasMascotas(this, cTiposMascotas, cRazas);
        this.setEnabled(false);
        VRazasMascotas.setLocationRelativeTo(null);
        VRazasMascotas.setVisible(true);
    }//GEN-LAST:event_jButton4MouseClicked

    private void btnMascotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMascotasMouseClicked
        VMascotas = new VMascotas(this, cTiposMascotas, cRazas, cPersonas, cMascotas);
        this.setEnabled(false);
        VMascotas.setLocationRelativeTo(null);
        VMascotas.setVisible(true);
    }//GEN-LAST:event_btnMascotasMouseClicked

    /**
     * @param args the command line arguments
     */
    //Para establecer el mensaje y esconder o mostrar las opciones disponibles
    public void setTipo(String tipo){
        if(tipo.charAt(0)=='G'){
            panelPrincipal.setEnabled(false);
            LblTipo.setText("Usted está registrado como usuario General");
        }
        else{
            panelPrincipal.setVisible(true);
            LblTipo.setText("Usted está registrado como usuario Administrativo");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtnCerrarSesion;
    private javax.swing.JToggleButton BtnCitas;
    private javax.swing.JToggleButton BtnClientes;
    private javax.swing.JToggleButton BtnFacturacion;
    private javax.swing.JToggleButton BtnServicios;
    private javax.swing.JLabel LblCitaIcono2;
    private javax.swing.JLabel LblClienteIcono;
    private javax.swing.JLabel LblFacIcono;
    private javax.swing.JLabel LblMascIcono;
    private javax.swing.JLabel LblRazaIcono;
    private javax.swing.JLabel LblServIcono;
    private javax.swing.JLabel LblTipo;
    private javax.swing.JLabel LblVetIcono;
    private javax.swing.JLabel LblVetIcono1;
    private javax.swing.JPanel PanelCitas;
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JPanel PanelEmpleado;
    private javax.swing.JPanel PanelFac;
    private javax.swing.JPanel PanelMascotas;
    private javax.swing.JPanel PanelServ;
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JButton btnMascotas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEmpIcono;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel panelEmpleado;
    private javax.swing.JTabbedPane panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
