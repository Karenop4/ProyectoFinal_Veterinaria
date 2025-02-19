/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DetalleFacturaDAO;
import Modelo.MDetalleFact;

/**
 *
 * @author karen
 */
public class CDetalleFactura {
    private DetalleFacturaDAO detalleFacturaDAO;

    public CDetalleFactura(DetalleFacturaDAO detalleFacturaDAO) {
        this.detalleFacturaDAO = detalleFacturaDAO;
    }
    
    public void crearDetalle(MDetalleFact detalle, int facId){
        detalleFacturaDAO.insertarDetalleFactura(detalle, facId);
    }
    
}
