/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.ConexionBD;
import Modelo.MMascotas;
import Modelo.MPersonas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author karen
 */
public class MascotasDAO {
    
    public MMascotas buscarClientePorCedula(MPersonas cliente){
        MMascotas mMascota = null;
        Connection con = ConexionBD.conectar();
        if (con != null) {
            try {
                String sql = "SELECT * FROM vet_mascotas m JOIN vet_personas p ON m.vet_personas_vet_id = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, cliente.getPer_id());
                ResultSet rs = stmt.executeQuery();
                
            } catch (SQLException ex) {
                Logger.getLogger(MascotasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    return null;
    }
}
