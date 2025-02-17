/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author karen
 */
public class MMascotas {
    private int masc_id;
    private String masc_nombre;
    private MPersonas cliente;
    private MRazas mascota;

    public MMascotas(int masc_id, String masc_nombre, MPersonas cliente, MRazas mascota) {
        this.masc_id = masc_id;
        this.masc_nombre = masc_nombre;
        this.cliente = cliente;
        this.mascota = mascota;
    }

    public int getMasc_id() {
        return masc_id;
    }

    public String getMasc_nombre() {
        return masc_nombre;
    }

    public MPersonas getCliente() {
        return cliente;
    }

    public MRazas getMascota() {
        return mascota;
    }
    
    
}
