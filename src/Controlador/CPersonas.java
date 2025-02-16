/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.ConexionBD;
import DAO.PersonasDAO;
import Modelo.MPersonas;
import java.sql.*;

/**
 *
 * @author karen
 */
public class CPersonas {
    private PersonasDAO personaDAO;
    
    public CPersonas(PersonasDAO personaDAO){
        this.personaDAO = personaDAO;
    }
    
    public MPersonas buscarCliente(String cedula, char CoE){
        return personaDAO.buscarClientePorCedula(cedula, CoE);
    }
}
