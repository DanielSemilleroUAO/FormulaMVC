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
import models.CarreraModel;
import utils.ConnectionDB;

/**
 * Crud sobre tabla carrera
 *
 * @author delga
 */
public class CarreraDAO extends ConnectionDB {

    /**
     * Encuentra la carreras con el id
     *
     * @param id
     * @return ArrayList<CarreraModel>
     */
    public ArrayList<CarreraModel> findCarreraByID(int id) {
        ArrayList<CarreraModel> carreras = new ArrayList<>();
        try {
            String sql = "SELECT * from carrera WHERE id_carrera = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                CarreraModel carrera = new CarreraModel(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4), result.getBoolean(5));
                carreras.add(carrera);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return carreras;
    }

    /**
     * Encuentra las carreras de acuerdo al nombre
     *
     * @param name
     * @return ArrayList<CarreraModel>
     */
    public ArrayList<CarreraModel> findCarreraByName(String name) {
        ArrayList<CarreraModel> carreras = new ArrayList<>();
        try {
            String sql = "SELECT * from carrera WHERE nombre LIKE ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                CarreraModel carrera = new CarreraModel(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4), result.getBoolean(5));
                carreras.add(carrera);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return carreras;
    }

    /**
     * Encuentra todas las carreras
     *
     * @return ArrayList<CarreraModel>
     */
    public ArrayList<CarreraModel> findAll() {
        ArrayList<CarreraModel> carreras = new ArrayList();
        try {
            String sql = "SELECT * FROM carrera order by carrera.nombre asc;";
            ResultSet result = getConnection().createStatement().executeQuery(sql);
            while (result.next()) {
                CarreraModel carrera = new CarreraModel(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4), result.getBoolean(5));
                carreras.add(carrera);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return carreras;
    }

    /**
     * Crear una carrera
     *
     * @param carrera CarreraModel
     */
    public void createCarrera(CarreraModel carrera) {
        try {
            String sql = "INSERT INTO carrera(nombre, capacidad, nivel_dificultad, corre_techo) VALUES (?,?,?,?);";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, carrera.getNombre());
            statement.setInt(2, carrera.getCapacidad());
            statement.setDouble(3, carrera.getNivelDificultad());
            statement.setBoolean(4, carrera.isIsTecho());
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
     * Eliminar una carrera
     *
     * @param id
     */
    public void deleteCarreraById(int id) {
        try {
            String sql = "DELETE FROM carrera WHERE id_carrera = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Eliminado Carrera");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    /**
     * Actualizar una carrera
     *
     * @param carrera
     */
    public void updateCarreraById(CarreraModel carrera) {
        try {
            String sql = "UPDATE carrera SET nombre = ?, capacidad = ?, nivel_dificultad = ?, corre_techo = ? WHERE id_carrera = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, carrera.getNombre());
            statement.setInt(2, carrera.getCapacidad());
            statement.setDouble(3, carrera.getNivelDificultad());
            statement.setBoolean(4, carrera.isIsTecho());
            statement.setInt(5, carrera.getIdCarrera());
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
