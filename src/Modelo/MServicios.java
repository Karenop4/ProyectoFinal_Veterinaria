/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author karen
 */
public class MServicios {
    private int serv_codigo;
    private String serv_nombre;
    private double serv_precio;
    private char ser_estado;
    private char serv_iva;

    public MServicios(int serv_codigo, String serv_nombre, double serv_precio, char ser_estado, char serv_iva) {
        this.serv_codigo = serv_codigo;
        this.serv_nombre = serv_nombre;
        this.serv_precio = serv_precio;
        this.ser_estado = ser_estado;
        this.serv_iva = serv_iva;
    }

    public int getServ_codigo() {
        return serv_codigo;
    }

    public String getServ_nombre() {
        return serv_nombre;
    }

    public double getServ_precio() {
        return serv_precio;
    }

    public char getSer_estado() {
        return ser_estado;
    }

    public char getServ_iva() {
        return serv_iva;
    }
    
    @Override
    public String toString() {
        return serv_nombre;
    }
}
