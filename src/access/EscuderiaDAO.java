/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.EscuderiaModel;
import utils.ConnectionDB;

/**
 * Crud sobre tabla escuderia
 *
 * @author delga
 */
public class EscuderiaDAO extends ConnectionDB{

    /**
     * Encuentra la escuderia por el codigo
     *
     * @param id
     * @return
     */
    public ArrayList<EscuderiaModel> findEscuderiaByCodigo(int id) {
        ArrayList<EscuderiaModel> escuderias = new ArrayList<>();
        try {
            String sql = "SELECT * from escuderia WHERE codigo_escuderia = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                EscuderiaModel escuderia = new EscuderiaModel(result.getInt(1),
                        result.getString(2), result.getString(3),
                        result.getInt(4), result.getString(5));
                escuderias.add(escuderia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return escuderias;
    }

    /**
     * Encuentra la escuderia por su nombre
     *
     * @param name
     * @return
     */
    public ArrayList<EscuderiaModel> findEscuderiaByName(String name) {
        ArrayList<EscuderiaModel> escuderias = new ArrayList<>();
        try {
            String sql = "SELECT * from escuderia WHERE nombre LIKE ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                EscuderiaModel escuderia = new EscuderiaModel(result.getInt(1),
                        result.getString(2), result.getString(3),
                        result.getInt(4), result.getString(5));
                escuderias.add(escuderia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return escuderias;
    }

    /**
     * Encuentra una escuderia por el nombre del patrocinador
     *
     * @param name
     * @return
     */
    public ArrayList<EscuderiaModel> findEscuderiaByPatrocinador(String name) {
        ArrayList<EscuderiaModel> escuderias = new ArrayList<>();
        try {
            String sql = "SELECT * from escuderia WHERE patrocinador LIKE ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                EscuderiaModel escuderia = new EscuderiaModel(result.getInt(1),
                        result.getString(2), result.getString(3),
                        result.getInt(4), result.getString(5));
                escuderias.add(escuderia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return escuderias;
    }

    /**
     * Encuentra todas las escuderias
     *
     * @return
     */
    public ArrayList<EscuderiaModel> findAll() {
        ArrayList<EscuderiaModel> escuderias = new ArrayList<>();
        try {
            String sql = "SELECT *\n"
                    + "FROM escuderia order by escuderia.nombre asc;\n";
            ResultSet result = getConnection().createStatement().executeQuery(sql);
            while (result.next()) {
                EscuderiaModel escuderia = new EscuderiaModel(result.getInt(1),
                        result.getString(2), result.getString(3),
                        result.getInt(4), result.getString(5));
                escuderias.add(escuderia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return escuderias;
    }

    /**
     * Crea una escuderia
     *
     * @param escuderia
     */
    public void createEscuderia(EscuderiaModel escuderia) {
        try {
            String sql = "INSERT INTO escuderia(codigo_escuderia, nombre, "
                    + "patrocinador, carreras_ganadas, fecha_ingreso) VALUES (?,?,?,?,?);";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, escuderia.getCodigoEscuderia());
            statement.setString(2, escuderia.getNombre());
            statement.setString(3, escuderia.getPatrocinador());
            statement.setInt(4, escuderia.getCarrerasGanadas());
            statement.setString(5, escuderia.getFechaIngreso());
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Carrera insertado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    /**
     * Eliminar una escuderia
     *
     * @param id
     */
    public void deleteEscuderiaByCodigo(int id) {
        try {
            String sql = "DELETE FROM escuderia WHERE codigo_escuderia = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Eliminado Escuderia");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    /**
     * Actualiza una escuderia
     *
     * @param escuderia
     */
    public void updateEscuderiaById(EscuderiaModel escuderia) {
        try {
            String sql = "UPDATE escuderia SET codigo_escuderia = ?, nombre = ?, "
                    + "patrocinador = ?, carreras_ganadas = ?, fecha_ingreso = ? "
                    + "WHERE codigo_escuderia = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, escuderia.getCodigoEscuderia());
            statement.setString(2, escuderia.getNombre());
            statement.setString(3, escuderia.getPatrocinador());
            statement.setInt(4, escuderia.getCarrerasGanadas());
            statement.setString(5, escuderia.getFechaIngreso());
            statement.setInt(6, escuderia.getCodigoEscuderia());
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Carrera actualizado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }
}
