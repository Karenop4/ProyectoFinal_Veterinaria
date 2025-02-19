/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.ServiciosDAO;
import Modelo.MServicios;
import java.util.List;
import javax.swing.JRootPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karen
 */
public class CServicios {
    ServiciosDAO sDAO=new ServiciosDAO();
    public CServicios(ServiciosDAO serviciosDAO) {
        this.sDAO = serviciosDAO;
    }
    public DefaultTableModel listarServicios(){
        return sDAO.listarServicios();
    }
    public MServicios listarServicio(String codigo, MServicios servicio){
        return sDAO.listarServicio(codigo, servicio);
    }
    public void eliminarServicio(String codigo, MServicios servicio, JRootPane r){
        sDAO.eliminarServicio(codigo, servicio, r);
    }
    public void crearServicio( String nombre, int precio, char iva){
        sDAO.crearServicio(nombre, precio, iva);
    }
    
    public List<MServicios> listarServicios2(){
        return sDAO.listarServicios2();
    }
}
