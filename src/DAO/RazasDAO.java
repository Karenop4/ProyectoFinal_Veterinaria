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
                stmt.setString(1, tipo.getTipoM_id());
                ResultSet rs = stmt.executeQuery();
                
                
                
                while(rs.next()){
                    raza = new MRazas(rs.getString("raza_id"), rs.getString("raza_nombre"), tipo);
                    listaRazas.add(raza);
                }
                return listaRazas;
            } catch (SQLException ex) {
                Logger.getLogger(TiposMascotasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
