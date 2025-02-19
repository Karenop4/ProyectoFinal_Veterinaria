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

public class ConexionBD {

    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "ADMIN_VET";
    private static final String PASSWORD = "1234";
    private static Connection connection = null;

    public static Connection conectar() {
        if (connection == null) {

            try {
                // Cargar el driver de Oracle
                Class.forName("oracle.jdbc.driver.OracleDriver");

                // Establecer la conexión
                connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                System.out.println("No se encontró el driver de Oracle JDBC.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos.");
                e.printStackTrace();
            }
        }
        return connection; // Retorna la conexión activa
    }
}
