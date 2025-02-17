/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author karen
 */
public class MTiposMascotas {
    private int tipoM_id;
    private String tipoM_nombre;

    public MTiposMascotas(int tipoM_id, String tipoM_nombre) {
        this.tipoM_id = tipoM_id;
        this.tipoM_nombre = tipoM_nombre;
    }
    
    public MTiposMascotas(String tipoM_nombre) {
        this.tipoM_nombre = tipoM_nombre;
    }

    public int getTipoM_id() {
        return tipoM_id;
    }

    public String getTipoM_nombre() {
        return tipoM_nombre;
    }
    
    
}
