/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
public class RazasDAO {
    Connection con;
    public List<MRazas> devolverRazas(List<MTiposMascotas> listaTiposMacotas, String tipoMascota){
        Connection con = ConexionBD.conectar();
        MRazas raza = null;
        List<MRazas> listaRazas = new ArrayList<>();
        
        if(con != null){
            try {
                MTiposMascotas tipo = null;
                for(MTiposMascotas e : listaTiposMacotas){
                    if(e.getTipoM_nombre().equals(tipoMascota)){
                        tipo = e;
                        break;
                    }
                }
                
                String sql = "SELECT * FROM vet_razas WHERE vet_tiposmascotas_tipom_id = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, tipo.getTipoM_id());
                ResultSet rs = stmt.executeQuery();
                
                
                
                while(rs.next()){
                    raza = new MRazas(rs.getInt("raza_id"), rs.getString("raza_nombre"), tipo);
                    listaRazas.add(raza);
                }
                return listaRazas;
            } catch (SQLException ex) {
                Logger.getLogger(TiposMascotasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public void crearRaza(int id, String nombre){
     if (con == null) {
            con = ConexionBD.conectar();
        }
        try {
            String sql = "insert into vet_razas values (v_ra_seq.nextval, ?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setInt(2, id);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException ex) {
        }
    }
    public void eliminarRaza( String nombre){
     if (con == null) {
            con = ConexionBD.conectar();
        }
        try {
            String sql = "DELETE from vet_razas where raza_nombre=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
