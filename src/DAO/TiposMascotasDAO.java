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

/**
 *
 * @author karen
 */
public class TiposMascotasDAO {
    public List<MTiposMascotas> listarTiposMascotas(){
        Connection con = ConexionBD.conectar();
        
        return null;
    }
}
