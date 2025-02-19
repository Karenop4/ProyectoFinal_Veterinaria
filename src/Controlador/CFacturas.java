/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.FacturasDAO;
import Modelo.MFacturas;
import java.util.Date;
import java.util.List;

/**
 *
 * @author karen
 */
public class CFacturas {
    private FacturasDAO facturasDAO;

    public CFacturas(FacturasDAO facturasDAO) {
        this.facturasDAO = facturasDAO;
    }
    
    public int crearFactura(MFacturas factura){
        return facturasDAO.crearFactura(factura);
    }
    
    public List<MFacturas> listarFacturas (Date inicio, Date fin, int codigo){
        return facturasDAO.listarFacturas(inicio, fin, codigo);
    }
}
