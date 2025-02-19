/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controlador.CMascotas;
import Controlador.CPersonas;
import Modelo.MCitas;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class CitasDAO {

    MCitas cita;
    PersonasDAO pDAO = new PersonasDAO();
    CPersonas cper = new CPersonas(pDAO);
    MascotasDAO mDAO = new MascotasDAO();
    CMascotas cmas = new CMascotas(mDAO);
    Connection con;

    public DefaultTableModel consultarCitas(String cod, String fecha) {
        String fechan = fecha + " 00:00:00";
        String fechan2 = fecha + " 23:59:59";
        cita = null;
        int id = Integer.parseInt(cod);
        if (con == null) {
            con = ConexionBD.conectar();
        }
        if (con != null) {
            try {
                String nMasc = "select m.masc_nombre from vet_mascotas m right outer join vet_citas c on c.vet_mascotas_masc_id=m.masc_id where m.vet_personas_per_id=(select per_id from vet_personas where per_cedula=?) group by m.masc_nombre";
                String sql = "SELECT cita_id ID, cita_fecha FECHA_Y_HORA  , cita_estado Estado, (" + nMasc + ") MASCOTA, vet_personas_per_id VETERINARIO FROM vet_citas where vet_mascotas_masc_id=(select masc_id from vet_mascotas where vet_personas_per_id=(select per_id from vet_personas where per_cedula=?)) and cita_fecha BETWEEN (TO_TIMESTAMP(?, 'YYYY/MM/DD HH24:MI:SS')) and (TO_TIMESTAMP(?, 'YYYY/MM/DD HH24:MI:SS'))";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, cod);
                stmt.setString(2, cod);
                stmt.setString(3, fechan);
                stmt.setString(4, fechan2);
                ResultSet rs = stmt.executeQuery();
                try {
                    DefaultTableModel tablem = new DefaultTableModel();
                    ResultSetMetaData metaDatos = rs.getMetaData();
                    int numColumnas = metaDatos.getColumnCount();
                    for (int i = 1; i <= numColumnas; i++) {
                        tablem.addColumn(metaDatos.getColumnName(i));
                    }

                    while (rs.next()) {
                        Object[] fila = new Object[numColumnas];
                        for (int i = 1; i <= numColumnas; i++) {
                            switch (i) {
                                case 3:
                                    switch (rs.getObject(i).toString().charAt(0)) {
                                        case 'A':
                                            fila[i - 1] = "Activa";
                                            break;
                                        case 'C':
                                            fila[i - 1] = "Cancelada";
                                            break;
                                        default:
                                            fila[i - 1] = rs.getObject(i);
                                            break;
                                    }   break;
                                case 5:
                                    int codvet = rs.getInt(i);
                                    String sqlvet = "select per_nombre||' '||per_apellido from vet_personas where per_id= ?";
                                    PreparedStatement stmt2 = con.prepareStatement(sqlvet);
                                    stmt2.setInt(1, codvet);
                                    ResultSet rs2 = stmt2.executeQuery();
                                    if (rs2.next()) {
                                        fila[i - 1] = rs2.getObject(1);
                                    }   break;
                                case 1:
                                    fila[i-1]=rs.getInt(i);
                                default:
                                    fila[i - 1] = rs.getObject(i);
                                    break;
                            }

                        }
                        tablem.addRow(fila);
                    }
                    return tablem;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public String consultarCitasHora(int id, String fecha, String hora, String minutos) {
        int hora1 = (Integer.parseInt(hora)) - 1;
        int min1 = (Integer.parseInt(minutos)) + 1;

        String fechan = fecha + " " + String.valueOf(hora1) + ":" + String.valueOf(min1) + ":00";
        int hora2 = (Integer.parseInt(hora)) + 1;
        String fechan2 = fecha + " " + String.valueOf(hora2) + ":" + minutos + ":00";
        cita = null;
        if (con == null) {
            con = ConexionBD.conectar();
        }
        if (con != null) {
            try {
                String sql = "select * from vet_citas where vet_personas_per_id=? and cita_fecha BETWEEN (TO_TIMESTAMP(?,'YYYY/MM/DD HH24:MI:SS')) and (TO_TIMESTAMP(?,'YYYY/MM/DD HH24:MI:SS'))";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.setString(2, fechan);
                stmt.setString(3, fechan2);
                ResultSet rs = stmt.executeQuery();
                try {
                    DefaultTableModel tablem = new DefaultTableModel();
                    ResultSetMetaData metaDatos = rs.getMetaData();
                    int numColumnas = metaDatos.getColumnCount();
                    for (int i = 1; i <= numColumnas; i++) {
                        tablem.addColumn(metaDatos.getColumnName(i));
                    }

                    if (rs.next()) {
                        if (rs.getString("CITA_ESTADO").charAt(0) == 'A') {
                            return rs.getString("CITA_FECHA");
                        } else {
                            return null;
                        }
                    }
                    return null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public boolean crearCita(int idvet, int idmasc, String fecha, String hora, String minutos) {
        try {
            int hora1 = (Integer.parseInt(hora));
            int min1 = (Integer.parseInt(minutos));

            String fechan = fecha + " " + String.valueOf(hora1) + ":" + String.valueOf(min1) + ":00";
            String sql = "insert into vet_citas values(v_cit_seq.nextval,(TO_TIMESTAMP(?,'YYYY/MM/DD HH24:MI:SS')),'A',?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fechan);
            stmt.setInt(2, idmasc);
            stmt.setInt(3, idvet);
            ResultSet rs = stmt.executeQuery();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean eliminarCita(int id) {
        try {
            String sql = "Update vet_citas set cita_estado='C' where cita_id=? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
