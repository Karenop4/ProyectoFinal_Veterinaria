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
public class MCitas {
    private int cita_id;
    private Date cita_fecha;
    private char cita_estado;
    private MMascotas mascota;
    private MPersonas cliente;

    public MCitas(int cita_id, Date cita_fecha, char cita_estado, MMascotas mascota, MPersonas cliente) {
        this.cita_id = cita_id;
        this.cita_fecha = cita_fecha;
        this.cita_estado = cita_estado;
        this.mascota = mascota;
        this.cliente = cliente;
    }

    public int getCita_id() {
        return cita_id;
    }

    public Date getCita_fecha() {
        return cita_fecha;
    }

    public char getCita_estado() {
        return cita_estado;
    }

    public MMascotas getMascota() {
        return mascota;
    }

    public MPersonas getCliente() {
        return cliente;
    }
    
    
}
