/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.TiposMascotasDAO;
import Modelo.MTiposMascotas;
import java.util.List;

/**
 *
 * @author karen
 */
public class CTiposMascotas {

    private TiposMascotasDAO tiposMascotasDAO;

    public CTiposMascotas(TiposMascotasDAO tiposMascotasDAO) {
        this.tiposMascotasDAO = tiposMascotasDAO;
    }

    public List<MTiposMascotas> listarTiposMascotas() {
        return tiposMascotasDAO.listarTiposMascotas();
    }
    
    public int verCodigoTipo(String nombre){
        return tiposMascotasDAO.verCodigo(nombre);
    }

    public void crearTipoMascota(String nombre) {
        tiposMascotasDAO.crearTipo(nombre);
    }

    public void eliminarTipoMascota(String nombre) {
        tiposMascotasDAO.eliminarTipo(nombre);
    }
}
