/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.MascotasDAO;
import Modelo.MMascotas;
import Modelo.MPersonas;
import java.util.List;

/**
 *
 * @author karen
 */
public class CMascotas {
    private MascotasDAO mascotasDAO;

    public CMascotas(MascotasDAO mascotasDAO) {
        this.mascotasDAO = mascotasDAO;
    }
    
    public List<MMascotas> listarMascotasCliente(MPersonas cliente){
        return mascotasDAO.buscarMascotasCliente(cliente);
    }
    
    public boolean agregarMascota(MPersonas mCliente, MMascotas mMascotas){
        return mascotasDAO.agregarMascota(mCliente, mMascotas);
    }
    
    public boolean eliminarMascota(MMascotas mMascotas){
        return mascotasDAO.eliminarMascota(mMascotas);
    }
    
    public boolean actualizarMascota(MMascotas mMascota){
        return mascotasDAO.actualizarMascota();
    }
}
