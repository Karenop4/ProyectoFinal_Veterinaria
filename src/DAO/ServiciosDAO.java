/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.MServicios;
import java.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JRootPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ServiciosDAO {

    public DefaultTableModel listarServicios() {
        Connection con = ConexionBD.conectar();
        if (con != null) {
            try {
                String sql = "SELECT serv_codigo ID, serv_nombre Nombre, serv_precio Precio, serv_estado Estado FROM vet_servicios";
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                try {
                    DefaultTableModel tablem = new DefaultTableModel();
                    ResultSetMetaData metaDatos = rs.getMetaData();
                    int numColumnas = metaDatos.getColumnCount();
                    for (int i = 1; i <= numColumnas; i++) {
                        tablem.addColumn(metaDatos.getColumnName(i));
                    }

                    while (rs.next()) {
                        Object[] fila = new Object[numColumnas];
                        for (int i = 1; i <= numColumnas; i++) {
                            if (i == 4) {
                                switch (rs.getObject(i).toString().charAt(0)) {
                                    case 'A':
                                        fila[i - 1] = "Activo";
                                        break;
                                    case 'I':
                                        fila[i - 1] = "Inactivo";
                                        break;
                                    default:
                                        fila[i - 1] = rs.getObject(i);
                                        break;
                                }
                            }
                            else{
                                fila[i - 1] = rs.getObject(i);
                            }
                        }
                        tablem.addRow(fila);
                    }
                    return tablem;
                } catch (SQLException e) {
                    return null;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public MServicios listarServicio(String codigo, MServicios servicio) {
        servicio = null;
        int id = Integer.parseInt(codigo);
        Connection con = ConexionBD.conectar();
        if (con != null) {
            try {
                String sql = "SELECT * FROM vet_servicios where serv_codigo=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                try {
                    if (rs.next()) {

                        int serv_id = rs.getInt("serv_codigo");
                        String serv_nombre = rs.getString("serv_nombre");
                        int serv_precio = rs.getInt("serv_precio");
                        char serv_estado = rs.getString("serv_estado").charAt(0);
                        char serv_iva = rs.getString("serv_iva").charAt(0);

                        servicio = new MServicios(serv_id, serv_nombre, serv_precio, serv_estado, serv_iva);
                        return servicio;
                    }
                } catch (SQLException e) {
                    return null;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public void eliminarServicio(String codigo, MServicios servicio, JRootPane r) {
        servicio = null;
        int id = Integer.parseInt(codigo);
        Connection con = ConexionBD.conectar();
        if (con != null) {
            servicio = listarServicio(codigo, servicio);
            if (servicio.getSer_estado() == 'A') {
                try {
                    String sql = "DELETE from vet_servicios where serv_codigo=?";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setInt(1, id);
                    ResultSet rs = stmt.executeQuery();
                } catch (SQLIntegrityConstraintViolationException ex) {
                    JOptionPane.showMessageDialog(r, "Servicio asociado a una factura, se procede a desactivarlo.", "Servicio asociado a factura", INFORMATION_MESSAGE);
                    try {
                        String sql = "Update vet_servicios set serv_estado='I' where serv_codigo=?";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setInt(1, id);
                        ResultSet rs = stmt.executeQuery();
                    } catch (SQLException ex2) {
                        ex2.printStackTrace();
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(r, "Este servicio ya ha sido desactivado.", "Servicio desactivado", INFORMATION_MESSAGE);
            }
        }
    }

    public void crearServicio(String nombre, int precio, char iva) {
        Connection con = ConexionBD.conectar();
        if (con != null) {
            try {
                String sql = "Insert into vet_servicios values (v_serv_seq.nextval, ?, ?, 'A', ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nombre);
                stmt.setInt(2, precio);
                stmt.setObject(3, iva);
                ResultSet rs = stmt.executeQuery();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
