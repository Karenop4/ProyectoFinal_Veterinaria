/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.MDetalleFact;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author karen
 */
public class DetalleFacturaDAO {
    public boolean insertarDetalleFactura(MDetalleFact detalle, int facId) {
        Connection con = ConexionBD.conectar();
        if (con != null) {
            try {
                String sql = "INSERT INTO vet_detalles_fac (FACD_ID, FACD_CANTIDAD, FACD_SUBTOTAL, FACD_VALORIVA, FAC_TOTAL, FACD_PRECIOS, VET_SERVICIOS_SERV_CODIGO, VET_FACTURAS_FAC_ID) VALUES (v_detf_seq.nextval,?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, detalle.getFacd_cantidad());
                stmt.setDouble(2, detalle.getFacd_subtotal());
                stmt.setDouble(3, detalle.getFacd_valorIVA());
                stmt.setDouble(4, detalle.getFacd_total());
                stmt.setDouble(5, detalle.getFacd_precios());
                stmt.setInt(6, detalle.getServicio().getServ_codigo());
                stmt.setInt(7, facId);

                int filasAfectadas = stmt.executeUpdate();

                return filasAfectadas > 0; // Retorna true si la inserción fue exitosa
            } catch (SQLException ex) {
                Logger.getLogger(FacturasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false; // Retorna false si hubo un error
    }

}
