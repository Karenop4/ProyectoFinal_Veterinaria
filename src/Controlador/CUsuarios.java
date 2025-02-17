/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.UsuariosDAO;

/**
 *
 * @author karen
 */
public class CUsuarios {
    private UsuariosDAO usuariosDAO;

    public CUsuarios(UsuariosDAO usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }
    
    public String buscarUsuario(String nombreUsuario, String contrasenia){
        return usuariosDAO.buscarUsuario(nombreUsuario, contrasenia);
    }
}
