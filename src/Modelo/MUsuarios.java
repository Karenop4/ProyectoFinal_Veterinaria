/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author karen
 */
public class MUsuarios {
    private int us_id;
    private String us_usuario;
    private String us_contrasenia;
    private String us_tipo;
    private MPersonas empleado;

    public MUsuarios(int us_id, String us_usuario, String us_contrasenia, String us_tipo, MPersonas empleado) {
        this.us_id = us_id;
        this.us_usuario = us_usuario;
        this.us_contrasenia = us_contrasenia;
        this.us_tipo = us_tipo;
        this.empleado = empleado;
    }

    public MUsuarios() {
    }

    public int getUs_id() {
        return us_id;
    }

    public String getUs_usuario() {
        return us_usuario;
    }

    public String getUs_contrasenia() {
        return us_contrasenia;
    }

    public String getUs_tipo() {
        return us_tipo;
    }

    public MPersonas getEmpleado() {
        return empleado;
    }
    
    public void setUs_id(int us_id) {
        this.us_id = us_id;
    }

    public void setUs_tipo(String us_tipo) {
        this.us_tipo = us_tipo;
    }

    public void setEmpleado(MPersonas empleado) {
        this.empleado = empleado;
    }
    
}
