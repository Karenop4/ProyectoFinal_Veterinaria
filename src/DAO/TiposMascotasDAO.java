/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Modelo.MTiposMascotas;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karen
 */
public class TiposMascotasDAO {

    Connection con;

    public List<MTiposMascotas> listarTiposMascotas() {
        Connection con = ConexionBD.conectar();
        MTiposMascotas tipo = null;
        List<MTiposMascotas> listaTipos = new ArrayList<>();

        if (con != null) {
            try {
                String sql = "SELECT * FROM vet_tiposmascotas";
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    tipo = new MTiposMascotas(rs.getInt("tipoM_id"), rs.getString("tipoM_nombre"));
                    listaTipos.add(tipo);
                }
                return listaTipos;
            } catch (SQLException ex) {
                Logger.getLogger(TiposMascotasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void crearTipo(String nombre) {
        if (con == null) {
            con = ConexionBD.conectar();
        }
        try {
            String sql = "insert into vet_tiposmascotas values (v_tmas_seq.nextval, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException ex) {
           
        }
    }
    public void eliminarTipo(String nombre) {
        if (con == null) {
            con = ConexionBD.conectar();
        }
        try {
            String sql = "DELETE from vet_tiposmascotas where tipom_nombre=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public int verCodigo(String nombre){
        if (con == null) {
            con = ConexionBD.conectar();
        }
        try {
            String sql = "select tipom_id from vet_tiposmascotas where tipom_nombre=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return -1;
    }
}
