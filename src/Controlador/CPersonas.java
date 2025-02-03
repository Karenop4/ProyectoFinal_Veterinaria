/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.ConeccionBD;
import DAO.PersonasDAO;
import Modelo.MPersonas;
import java.sql.*;

/**
 *
 * @author karen
 */
public class CPersonas {
    PersonasDAO personaDAO;
    
    public CPersonas(){
        personaDAO = new PersonasDAO();
    }
    
    public MPersonas buscarCliente(String cedula, char CoE){
        return personaDAO.buscarClientePorCedula(cedula, CoE);
    }
}
