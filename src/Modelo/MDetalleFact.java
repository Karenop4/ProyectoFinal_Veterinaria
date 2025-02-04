/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author karen
 */
public class MDetalleFact {
    private int facd_id;
    private int facd_cantidad;
    private double facd_subtotal;
    private double facd_valorIVA;
    private double facd_total;
    private double facd_precios;
    private MServicios servicio;
    private MFacturas factura;

    public MDetalleFact(int facd_id, int facd_cantidad, double facd_subtotal, double facd_valorIVA, double facd_total, double facd_precios, MServicios servicio, MFacturas factura) {
        this.facd_id = facd_id;
        this.facd_cantidad = facd_cantidad;
        this.facd_subtotal = facd_subtotal;
        this.facd_valorIVA = facd_valorIVA;
        this.facd_total = facd_total;
        this.facd_precios = facd_precios;
        this.servicio = servicio;
        this.factura = factura;
    }

    public int getFacd_id() {
        return facd_id;
    }

    public int getFacd_cantidad() {
        return facd_cantidad;
    }

    public double getFacd_subtotal() {
        return facd_subtotal;
    }

    public double getFacd_valorIVA() {
        return facd_valorIVA;
    }

    public double getFacd_total() {
        return facd_total;
    }

    public double getFacd_precios() {
        return facd_precios;
    }

    public MServicios getServicio() {
        return servicio;
    }

    public MFacturas getFactura() {
        return factura;
    }
    
    
}
