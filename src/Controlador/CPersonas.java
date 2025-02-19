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
    
    public MPersonas buscarClienteCedula(String cedula, char CoE){
        return personaDAO.buscarPersonaPorCedula(cedula, CoE);
    } 
    
    public MPersonas buscarClienteID(String id, char CoE){
        int id1=Integer.parseInt(id);
        return personaDAO.buscarPersonaPorID(id1, CoE);
    } 
    
    public MPersonas buscarCliente2(String cedula, char CoE){
        return personaDAO.buscarPersonaPorCedula(cedula, CoE);
    }
    
    public MPersonas buscarClienteID2(int id, char CoE){
        return personaDAO.buscarPersonaPorID(id, CoE);
    }
}
