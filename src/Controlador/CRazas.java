/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.RazasDAO;
import Modelo.MRazas;
import Modelo.MTiposMascotas;
import java.util.List;

/**
 *
 * @author karen
 */
public class CRazas {
    private RazasDAO razasDAO;

    public CRazas(RazasDAO razasDAO) {
        this.razasDAO = razasDAO;
    }
    
    public List<MRazas> listarRazasPorTipo (List<MTiposMascotas> listaTiposMacotas, String tipoMascota){
        return razasDAO.devolverRazas(listaTiposMacotas, tipoMascota);
    }
    public void crearRaza(int id,String nombre){
        razasDAO.crearRaza(id,nombre);
    }
    public void eliminarRaza(String nombre){
        razasDAO.eliminarRaza(nombre);
    }
}
