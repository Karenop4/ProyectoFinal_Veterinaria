/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author karen
 */
public class MPersonas {
    private int per_id;
    private String per_cedula;
    private String per_nombre;
    private String per_apellido;
    private String per_direccion;
    private String per_telefono;
    private String per_correo;
    private char per_CoE; //C si es cliente o E si es empleado
    private char per_empleado; //A si es un empleado que brinda atencion al cliente o V si es veterinario
    private char per_estado; //A si está activo o I si esta inactivo

    public MPersonas(int per_id, String per_cedula, String per_nombre, String per_apellido, String per_direccion, String per_telefono, String per_correo, char per_CoE, char per_empleado, char per_estado) {
        this.per_id = per_id;
        this.per_cedula = per_cedula;
        this.per_nombre = per_nombre;
        this.per_apellido = per_apellido;
        this.per_direccion = per_direccion;
        this.per_telefono = per_telefono;
        this.per_correo = per_correo;
        this.per_CoE = per_CoE;
        this.per_empleado = per_empleado;
        this.per_estado = per_estado;
    }

    public MPersonas(int per_id, String per_cedula, String per_nombre, String per_apellido, String per_direccion, String per_telefono, String per_correo, char per_estado) {
        this.per_id = per_id;
        this.per_cedula = per_cedula;
        this.per_nombre = per_nombre;
        this.per_apellido = per_apellido;
        this.per_direccion = per_direccion;
        this.per_telefono = per_telefono;
        this.per_correo = per_correo;
        
        this.per_estado = per_estado;
    }
    public MPersonas(int per_id, String per_nombre, String per_apellido){
        this.per_id=per_id;
        this.per_nombre=per_nombre;
        this.per_apellido=per_apellido;
    }
    
    public MPersonas() {
    }


    
    public MPersonas(int per_id, String per_cedula, String per_nombre, String per_apellido, String per_direccion, String per_telefono, String per_correo, char per_coe, char per_estado) {
        this.per_id = per_id;
        this.per_cedula = per_cedula;
        this.per_nombre = per_nombre;
        this.per_apellido = per_apellido;
        this.per_direccion = per_direccion;
        this.per_telefono = per_telefono;
        this.per_correo = per_correo;
        this.per_estado = per_estado;
    }
    
    public int getPer_id() {
        return per_id;
    }

    public String getPer_cedula() {
        return per_cedula;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public String getPer_apellido() {
        return per_apellido;
    }

    public String getPer_direccion() {
        return per_direccion;
    }

    public String getPer_telefono() {
        return per_telefono;
    }

    public String getPer_correo() {
        return per_correo;
    }

    public char getPer_CoE() {
        return per_CoE;
    }

    public char getPer_empleado() {
        return per_empleado;
    }

    public char getPer_estado() {
        return per_estado;
    }  
    
    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }
}