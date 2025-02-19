/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.MFacturas;
import Modelo.MPersonas;
import Modelo.MUsuarios;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author karen
 */
public class FacturasDAO {
    public List<MFacturas> listarFacturas(Date inicio, Date fin, int codigo) {
        Connection con = ConexionBD.conectar();
        List<MFacturas> listaFacturas = new ArrayList<>();

        if (con != null) {
            try {
                String sql = "SELECT * FROM vet_facturas WHERE (fac_fecha BETWEEN ? AND ?) OR (fac_id = ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setDate(1, new java.sql.Date(inicio.getTime()));
                stmt.setDate(2, new java.sql.Date(fin.getTime()));
                stmt.setInt(3, codigo);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int fac_id = rs.getInt("fac_id");
                    Date fac_fecha = rs.getDate("fac_fecha");
                    double fac_subtotal = rs.getDouble("fac_subtotal");
                    double fac_totalIVA = rs.getDouble("fac_totaliva");
                    double fac_total = rs.getDouble("fac_total");
                    int vet_personas_per_id = rs.getInt("vet_personas_per_id");
                    int vet_usuarios_us_id = rs.getInt("vet_usuarios_us_id");

                    MPersonas cliente = new MPersonas();
                    cliente.setPer_id(vet_personas_per_id);

                    MUsuarios usuario = new MUsuarios();
                    usuario.setUs_id(vet_usuarios_us_id);

                    MFacturas factura = new MFacturas(fac_id, fac_fecha, fac_subtotal, fac_totalIVA, fac_total, usuario, cliente);
                    listaFacturas.add(factura);
                }


            } catch (SQLException ex) {
                Logger.getLogger(FacturasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaFacturas;
    }

    public int crearFactura(MFacturas factura) {
        int idFactura = 0; // Variable para almacenar el ID generado
        Connection con = ConexionBD.conectar();

        if (con != null) {
            try {
                // Primero, obtener el ID desde la secuencia
                String sqlID = "SELECT v_fac_seq.NEXTVAL FROM dual";
                PreparedStatement stmtID = con.prepareStatement(sqlID);
                ResultSet rsID = stmtID.executeQuery();

                if (rsID.next()) {
                    idFactura = rsID.getInt(1);
                }
                rsID.close();
                stmtID.close();

                // Insertar la factura con el ID obtenido
                String sql = "INSERT INTO vet_facturas (fac_id, fac_fecha, fac_subtotal, fac_totaliva, fac_total, vet_personas_per_id, vet_usuarios_us_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);

                stmt.setInt(1, idFactura); // Usar el ID obtenido
                stmt.setDate(2, new java.sql.Date(factura.getFac_fecha().getTime()));
                stmt.setDouble(3, factura.getFac_subtotal());
                stmt.setDouble(4, factura.getFac_totalIVA());
                stmt.setDouble(5, factura.getFac_total());
                stmt.setInt(6, factura.getCliente().getPer_id());
                stmt.setInt(7, factura.getUsuario().getUs_id());

                stmt.executeUpdate();


            } catch (SQLException ex) {
                Logger.getLogger(FacturasDAO.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
        }
        return idFactura; // Retornar el ID generado
    }



    
    public boolean eliminarFactura(int fac_id) {
        Connection con = ConexionBD.conectar();
        if (con != null) {
            try {
                String sql = "DELETE FROM vet_facturas WHERE fac_id = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, fac_id);

                int filasAfectadas = stmt.executeUpdate();

                return filasAfectadas > 0;

            } catch (SQLException ex) {
                Logger.getLogger(FacturasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    
}
