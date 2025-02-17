/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.MTiposMascotas;
import java.util.List;
import DAO.ConexionBD;
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
    public List<MTiposMascotas> listarTiposMascotas(){
        Connection con = ConexionBD.conectar();
        MTiposMascotas tipo = null;
        List<MTiposMascotas> listaTipos = new ArrayList<>();
        
        if(con != null){
            try {
                String sql = "SELECT * FROM vet_tiposmascotas";
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
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
}
