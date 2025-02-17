/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author karen
 */
public class MRazas {
    private int raza_id;
    private String raza_nombre;
    private MTiposMascotas tipo_mascota;

    public MRazas(int raza_id, String raza_nombre, MTiposMascotas tipo_mascota) {
        this.raza_id = raza_id;
        this.raza_nombre = raza_nombre;
        this.tipo_mascota = tipo_mascota;
    }
    
    public MRazas(String raza_nombre, MTiposMascotas tipo_mascota) {
        this.raza_nombre = raza_nombre;
        this.tipo_mascota = tipo_mascota;
    }

    public int getRaza_id() {
        return raza_id;
    }

    public String getRaza_nombre() {
        return raza_nombre;
    }

    public MTiposMascotas getTipo_mascota() {
        return tipo_mascota;
    }
    
    
}
