/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.MPersonas;
import DAO.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author karen
 */
public class PersonasDAO {
    Connection con = ConexionBD.conectar();
    public MPersonas buscarPersonaPorCedula(String cedula, char CoE) {
        MPersonas persona = null;
        if (con == null) {
            con = ConexionBD.conectar();
        }
        if (con != null) {
            try {
                String sql = "SELECT * FROM vet_personas WHERE per_cedula = ? AND per_coe = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, cedula);
                stmt.setString(2, String.valueOf(CoE));
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int per_id = rs.getInt("per_id");
                    String per_cedula = rs.getString("per_cedula");
                    String per_nombre = rs.getString("per_nombre");
                    String per_apellido = rs.getString("per_apellido");
                    String per_direccion = rs.getString("per_direccion");
                    String per_telefono = rs.getString("per_telefono");
                    String per_correo = rs.getString("per_correo");
                    char per_estado = rs.getString("per_estado").charAt(0);
                    if (CoE == 'C') {
                        persona = new MPersonas(per_id, per_cedula, per_nombre, per_apellido, per_direccion, per_telefono, per_correo, per_estado);
                        return persona;
                    } else if (CoE == 'E') {
                        char per_empleadoAoV = rs.getString("per_empleadoaov").charAt(0);
                        persona = new MPersonas(per_id, per_cedula, per_nombre, per_apellido, per_direccion, per_telefono, per_correo, CoE, per_empleadoAoV, per_estado);
                        return persona;
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public DefaultTableModel listarVeterinarios() {
        Connection con = ConexionBD.conectar();
        if (con != null) {
            try {
                String sql = "SELECT per_estado Estado, per_id ID, per_nombre||' '||per_apellido Nombre FROM vet_personas where per_empleadoaov='V'";
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                try {
                    DefaultTableModel tablem = new DefaultTableModel();
                    ResultSetMetaData metaDatos = rs.getMetaData();
                    int numColumnas = metaDatos.getColumnCount();
                    tablem.addColumn(metaDatos.getColumnName(2));
                    tablem.addColumn(metaDatos.getColumnName(3));

                    while (rs.next()) {
                        Object[] fila = new Object[numColumnas];
                        for (int i = 1; i < numColumnas; i++) {
                            if (i == 1) {
                                switch (rs.getObject(i).toString().charAt(0)) {
                                    case 'A':
                                        fila[i - 1] = rs.getObject(i + 1);
                                        break;
                                    case 'I':
                                        i = numColumnas + 1;
                                        break;
                                    default:

                                        break;
                                }
                            } else {
                                fila[i - 1] = rs.getObject(i + 1);
                            }
                        }
                        tablem.addRow(fila);
                    }
                    return tablem;
                } catch (SQLException e) {
                    return null;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    public MPersonas buscarPersonaPorID(int id, char CoE) {
        MPersonas persona = null;
        if (con == null) {
            con = ConexionBD.conectar();
        }
        if (con != null) {
            try {
                String sql = "SELECT * FROM vet_personas WHERE per_id = ? AND per_coe = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.setString(2, String.valueOf(CoE));
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int per_id = rs.getInt("per_id");
                    String per_cedula = rs.getString("per_cedula");
                    String per_nombre = rs.getString("per_nombre");
                    String per_apellido = rs.getString("per_apellido");
                    String per_direccion = rs.getString("per_direccion");
                    String per_telefono = rs.getString("per_telefono");
                    String per_correo = rs.getString("per_correo");
                    char per_estado = rs.getString("per_estado").charAt(0);
                    if (CoE == 'C') {
                        persona = new MPersonas(per_id, per_cedula, per_nombre, per_apellido, per_direccion, per_telefono, per_correo, per_estado);
                        return persona;
                    } else if (CoE == 'E') {
                        char per_empleadoAoV = rs.getString("per_empleadoaov").charAt(0);
                        persona = new MPersonas(per_id, per_cedula, per_nombre, per_apellido, per_direccion, per_telefono, per_correo, CoE, per_empleadoAoV, per_estado);
                        return persona;
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public boolean crearEmpleado(String ced, String n, String a, String dir, String tel, String email, char AoV) {
        if (con == null) {
            con = ConexionBD.conectar();
        }
        try {
            String sql = "insert into vet_personas values (v_per_seq.nextval,?,?,?,?,?,?,'E',?,'A')";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ced);
            stmt.setString(2, n);
            stmt.setString(3, a);
            stmt.setString(4, dir);
            stmt.setString(5, tel);
            stmt.setString(6, email);
            stmt.setObject(7, AoV);

            ResultSet rs = stmt.executeQuery();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public boolean actEmpleado(String ced, String n, String a, String dir, String tel, String email, char AoV) {
        if (con == null) {
            con = ConexionBD.conectar();
        }
        try {
            String sql = "Update vet_personas set per_nombre=?, per_apellido=?, per_direccion=?, per_telefono=?, per_correo=?, per_empleadoaov=? where per_cedula=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, n);
            stmt.setString(2, a);
            stmt.setString(3, dir);
            stmt.setString(4, tel);
            stmt.setString(5, email);
            stmt.setObject(6, AoV);
            stmt.setString(7, ced);

            ResultSet rs = stmt.executeQuery();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public boolean eliminarEmpleado(String ced) {
        if (con == null) {
            con = ConexionBD.conectar();
        }
        try {
            String sql = "Update vet_personas set per_estado='I' where per_cedula=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ced);
            ResultSet rs = stmt.executeQuery();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public boolean activarEmpleado(String ced) {
        if (con == null) {
            con = ConexionBD.conectar();
        }
        try {
            String sql = "Update vet_personas set per_estado='A' where per_cedula=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ced);
            ResultSet rs = stmt.executeQuery();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    
    public boolean crearCliente(MPersonas cliente){
        Connection con = ConexionBD.conectar();
        if (con != null) {
            try {
                String sql = "INSERT INTO vet_personas VALUES (v_per_seq.nextval,?, ?, ?, ?, ?, ?, 'C', null, 'A');";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, cliente.getPer_cedula());
                stmt.setString(2, cliente.getPer_nombre());
                stmt.setString(3, cliente.getPer_apellido());
                stmt.setString(4, cliente.getPer_direccion());
                stmt.setString(5, cliente.getPer_telefono());
                stmt.setString(6, cliente.getPer_correo());

                int filasAfectadas = stmt.executeUpdate(); // Usar executeUpdate()
            
               
                return filasAfectadas > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    
    public boolean modificarCliente(MPersonas cliente) {
        Connection con = ConexionBD.conectar();
        if (con != null) {
            String sql = "UPDATE vet_personas SET per_nombre = ?, per_apellido = ?, per_direccion = ?, per_telefono = ?, per_correo = ? WHERE per_id = ?";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, cliente.getPer_nombre());
                stmt.setString(2, cliente.getPer_apellido());
                stmt.setString(3, cliente.getPer_direccion());
                stmt.setString(4, cliente.getPer_telefono());
                stmt.setString(5, cliente.getPer_correo());
                stmt.setInt(6, cliente.getPer_id());

                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0; 
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    
    public boolean eliminarCliente(String cedula) {
        Connection con = ConexionBD.conectar();
        if (con != null) {
            String sql = "DELETE FROM vet_personas WHERE per_cedula = ?";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, cedula); // Asigna la cédula del cliente a eliminar

                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0; // Retorna true si se eliminó al menos un registro
            } catch (SQLException e) {
                e.printStackTrace();
            } 
        }
        return false;
    }
    
    

    
}
