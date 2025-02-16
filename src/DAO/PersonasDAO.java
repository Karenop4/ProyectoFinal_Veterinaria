/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.MPersonas;
import DAO.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author karen
 */
public class PersonasDAO {
    
    public MPersonas buscarClientePorCedula(String cedula, char CoE){
        MPersonas cliente = null;
        Connection con = ConexionBD.conectar();
        if (con != null) {
            try {
                String sql = "SELECT * FROM vet_personas WHERE per_cedula = ? AND per_coe = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, cedula);
                stmt.setString(2, String.valueOf(CoE)); 
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    
                    int per_id = rs.getInt("per_id");
                    String per_cedula = rs.getString("per_cedula");
                    String per_nombre = rs.getString("per_nombre");
                    String per_apellido = rs.getString("per_apellido");
                    String per_direccion = rs.getString("per_direccion");
                    String per_telefono = rs.getString("per_telefono");
                    String per_correo = rs.getString("per_correo");
                    char per_estado = rs.getString("per_estado").charAt(0);
                    
                    cliente = new MPersonas(per_id, per_cedula, per_nombre, per_apellido, per_direccion, per_telefono, per_correo, per_estado);
                    
                }

                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cliente;
    }
    
}
