/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.MUsuarios;
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
public class UsuariosDAO {
    
    public String buscarUsuario(String nombreUsuario, String contrasenia){
        MUsuarios usuario = null;
        Connection con = ConexionBD.conectar();

        if (con != null){
            try {
                String sql = "SELECT * FROM vet_usuarios WHERE us_usuario = ? AND us_contrasenia = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nombreUsuario);
                stmt.setString(2, contrasenia); 
                ResultSet rs = stmt.executeQuery();
                System.out.println("Consulta ejecutada: " + stmt.toString());
                
                if (rs.next()) {
                    return rs.getString("us_tipo").trim();
                }

            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
