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
    Connection con = ConexionBD.conectar();
    public String buscarUsuario(String nombreUsuario, String contrasenia) {
        MUsuarios usuario = null;
        if (con == null) {
            con = ConexionBD.conectar();
        }
        if (con != null) {
            try {
                String sql = "SELECT * FROM vet_usuarios WHERE us_usuario = ? AND us_contrasenia = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nombreUsuario);
                stmt.setString(2, contrasenia);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return rs.getString("us_tipo").trim();
                }

            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public char validarUsuario(String usr, String passwd) {
        con = ConexionBD.conectar();
        if (con != null) {
            try {
                String sql = "SELECT us_tipo FROM vet_usuarios WHERE us_usuario = ? AND us_contrasenia = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, usr);
                stmt.setString(2, passwd);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String l = rs.getString(1);
                    return l.charAt(0);

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 'x';
    }
    public int validarUsuarioActivo(String usr, String passwd) {
        con = ConexionBD.conectar();
        if (con != null) {
            try {
                String sql = "SELECT vet_personas_per_id FROM vet_usuarios WHERE us_usuario = ? AND us_contrasenia = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, usr);
                stmt.setString(2, passwd);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    return id;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 'x';
    }
    public boolean crearUsuario(String usr, String contr, char tipo, int idusr) {
        if (con == null) {
            con = ConexionBD.conectar();
        }
        if (con != null) {
            try {
                String sql = "insert into vet_usuarios values (v_us_seq.nextval, ?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, usr);
                stmt.setString(2, contr);
                stmt.setObject(3, tipo);
                stmt.setInt(4,idusr);
                ResultSet rs = stmt.executeQuery();
                return true;
            } catch (SQLException ex) {
                return false;
            }
        }
        return false;
    }
}
