/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author karen
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConeccionBD {
    Connection connection = null;
    
    public void conectar(){
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        // Usuario y contraseña de la base de datos
        String username = "ADMIN_VET";
        String password = "1234";

        try {
            // Cargar el driver de Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establecer la conexión
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos Oracle!");
            } else {
                System.out.println("Fallo en la conexión a la base de datos Oracle.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de Oracle JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
