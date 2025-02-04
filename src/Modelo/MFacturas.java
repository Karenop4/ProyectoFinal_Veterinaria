/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author karen
 */
public class MFacturas {
    private int fac_id;
    private Date fac_fecha;
    private double fac_subtotal;
    private double fac_totalIVA;
    private double fac_total;
    private MUsuarios usuario;
    private MPersonas cliente;

    public MFacturas(int fac_id, Date fac_fecha, double fac_subtotal, double fac_totalIVA, double fac_total, MUsuarios usuario, MPersonas cliente) {
        this.fac_id = fac_id;
        this.fac_fecha = fac_fecha;
        this.fac_subtotal = fac_subtotal;
        this.fac_totalIVA = fac_totalIVA;
        this.fac_total = fac_total;
        this.usuario = usuario;
        this.cliente = cliente;
    }

    public int getFac_id() {
        return fac_id;
    }

    public Date getFac_fecha() {
        return fac_fecha;
    }

    public double getFac_subtotal() {
        return fac_subtotal;
    }

    public double getFac_totalIVA() {
        return fac_totalIVA;
    }

    public double getFac_total() {
        return fac_total;
    }

    public MUsuarios getUsuario() {
        return usuario;
    }

    public MPersonas getCliente() {
        return cliente;
    }
    
    
}
