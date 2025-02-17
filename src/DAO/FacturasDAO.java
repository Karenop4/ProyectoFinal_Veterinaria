/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.MFacturas;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author karen
 */
public class FacturasDAO {
    public List<MFacturas> listarFacturas(){
        Connection con = ConexionBD.conectar();
        if(con != null){
            
        }
        return null;
    }
}
