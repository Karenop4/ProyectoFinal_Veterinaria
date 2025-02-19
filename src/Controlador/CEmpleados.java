/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.PersonasDAO;
import Modelo.MPersonas;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class CEmpleados {
    PersonasDAO personaDAO;
    public CEmpleados(PersonasDAO pDAO){
        this.personaDAO=pDAO;
    }
    public MPersonas listarEmpleado(String cedula, char CoE){
        return personaDAO.buscarPersonaPorCedula(cedula, CoE);
    }
    public DefaultTableModel listarVeterinarios(){
        return personaDAO.listarVeterinarios();
    }
    public boolean crearEmpleado(String ced, String n, String a, String dir, String tel, String email, char AoV){
        return personaDAO.crearEmpleado(ced, n,a,dir,tel,email,AoV);
    }
    public boolean actEmpleado(String ced,String n, String a, String dir, String tel, String email, char AoV){
        return personaDAO.actEmpleado(ced,n,a,dir,tel,email,AoV);
    }
    public boolean eliminarEmpleado(String ced){
        return personaDAO.eliminarEmpleado(ced);
    }
    public boolean activarEmp(String ced){
        return personaDAO.activarEmpleado(ced);
    }
}
