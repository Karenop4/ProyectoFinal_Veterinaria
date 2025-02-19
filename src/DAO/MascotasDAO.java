/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.ConexionBD;
import Modelo.MMascotas;
import Modelo.MPersonas;
import Modelo.MRazas;
import Modelo.MTiposMascotas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author karen
 */
public class MascotasDAO {
    
    public List<MMascotas> buscarMascotasCliente(MPersonas cliente){
        MMascotas mMascota = null;
        Connection con = ConexionBD.conectar();
        List<MMascotas> listaMascotas = new ArrayList<>();
        if (con != null) {
            try {
                String sql = "SELECT m.masc_id, m.masc_nombre, r.raza_nombre, t.tipom_nombre "
                        + "FROM vet_mascotas m "
                        + "JOIN vet_razas r ON m.vet_razas_raza_id = r.raza_id "
                        + "JOIN vet_tiposmascotas t ON r.vet_tiposmascotas_tipom_id = t.tipom_id "
                        + "WHERE m.vet_personas_per_id = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, cliente.getPer_id());
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    MTiposMascotas tipo = new MTiposMascotas(rs.getString("tipom_nombre"));
                    MRazas raza = new MRazas(rs.getString("raza_nombre"), tipo);
                    mMascota = new MMascotas(rs.getInt("masc_id"), rs.getString("masc_nombre"), cliente, raza);
                    listaMascotas.add(mMascota);
                }
                
                return listaMascotas;
                
            } catch (SQLException ex) {
                Logger.getLogger(MascotasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    return null;
    }
    
    public boolean agregarMascota(MPersonas mCliente, MMascotas mMascotas){
        Connection con = ConexionBD.conectar();
        
        if(con!=null){
            try {
                String sql = "INSERT INTO vet_mascotas VALUES (v_masc_seq.nextval, ?, ?, (SELECT raza_id FROM vet_razas WHERE raza_nombre LIKE '?'))";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, mMascotas.getMasc_nombre());
                stmt.setInt(2, mCliente.getPer_id());
                stmt.setInt(3, mMascotas.getMascota().getRaza_id());
                stmt.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(MascotasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean eliminarMascota(MMascotas mMascotas){
        Connection con = ConexionBD.conectar();
        if(con!=null){
            try {
                String sql = "DELETE FROM vet_mascotas WHERE mascota_id = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, mMascotas.getMasc_id());
                int rowsDeleted = stmt.executeUpdate();
                
                if (rowsDeleted > 0) {
                    System.out.println("Registro eliminado correctamente.");
                } else {
                    System.out.println("No se encontró el registro.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MascotasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean actualizarMascota(){
        
        return false;
    }
}
