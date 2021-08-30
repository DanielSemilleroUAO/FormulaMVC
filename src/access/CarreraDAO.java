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
import java.util.List;
import javax.swing.JOptionPane;
import models.CarreraModel;
import utils.ConnectionDB;

/**
 *
 * @author delga
 */
public class CarreraDAO extends ConnectionDB {
    
    public CarreraModel findCarreraByID(int id) {
        CarreraModel carrera = null;
        try {
            String sql = "SELECT * from carrera WHERE id_carrera = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                carrera = new CarreraModel(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4), result.getBoolean(5));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return carrera;
    }
    
    public CarreraModel findCarreraByName(String name) {
        CarreraModel carrera = null;
        try {
            String sql = "SELECT * from carrera WHERE nombre LIKE ? LIMIT 1;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, "%"+name+"%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                carrera = new CarreraModel(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4), result.getBoolean(5));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return carrera;
    }
    
    public ArrayList<CarreraModel> findAll() {
        ArrayList<CarreraModel> carreras = new ArrayList();
        try {
            String sql = "SELECT *\n"
                    + "FROM carrera order by carrera.nombre asc;\n";
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
    
    public void updateCarreraById(int id, CarreraModel carrera) {
        try {
            String sql = "UPDATE carrera SET nombre = ?, capacidad = ?, nivel_dificultad = ?, corre_techo = ? WHERE id_carrera = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, 0);
            statement.setString(0, sql);
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Carrera insertado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        CarreraDAO carreraDAO = new CarreraDAO();
        CarreraModel carrera = carreraDAO.findCarreraByName("Z");
        if(carrera != null){
            System.out.println(carrera.toString());
        } else {
            System.err.println("No existe");
        }
    }
    
}
