/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CitasDAO;
import Modelo.MCitas;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karen
 */
public class CCitas {
    CitasDAO cDAO=new CitasDAO();
     public CCitas(CitasDAO citasDAO) {
        this.cDAO = citasDAO;
    }
    public DefaultTableModel consultarCitas(String id, String fecha){
        return cDAO.consultarCitas(id, fecha);
    }
    public String consultarCitasHora(int id, String fecha, String hora, String minutos){
        return cDAO.consultarCitasHora(id, fecha, hora, minutos);
    } 
    public boolean crearCitas(int idvet, int idmasc, String fecha, String hora, String minutos){
        return cDAO.crearCita(idvet, idmasc, fecha, hora, minutos);
    }
    public boolean eliminarCitas(int id){
        return cDAO.eliminarCita(id);
    }
}
