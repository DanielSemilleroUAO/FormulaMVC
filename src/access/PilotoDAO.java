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
import models.PilotoModel;
import utils.ConnectionDB;

/**
 * Crud sobre tabla piloto
 *
 * @author delga
 */
public class PilotoDAO extends ConnectionDB {

    /**
     * Encontrar piloto por codigo
     *
     * @param id
     * @return ArrayList<PilotoModel>
     */
    public ArrayList<PilotoModel> findPilotoByCodigo(int id) {
        ArrayList<PilotoModel> pilotos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM piloto "
                    + "INNER JOIN escuderia ON piloto.codigo_escuderia_fk = escuderia.codigo_escuderia "
                    + "WHERE piloto.codigo_piloto = ? "
                    + "order by piloto.codigo_piloto asc;\n";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                PilotoModel piloto = new PilotoModel(result.getInt(1),
                        result.getString(2), result.getDouble(3), result.getInt(4),
                        new EscuderiaModel(result.getInt(6), result.getString(7),
                                result.getString(8), result.getInt(9), result.getString(10)));
                pilotos.add(piloto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return pilotos;
    }

    /**
     * Encuentra piloto por nombre
     *
     * @param name
     * @return ArrayList<PilotoModel>
     */
    public ArrayList<PilotoModel> findPilotoByName(String name) {
        ArrayList<PilotoModel> pilotos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM piloto "
                    + "INNER JOIN escuderia ON piloto.codigo_escuderia_fk = escuderia.codigo_escuderia "
                    + "where piloto.nombre like ? "
                    + "order by piloto.codigo_piloto asc;\n";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                PilotoModel piloto = new PilotoModel(result.getInt(1),
                        result.getString(2), result.getDouble(3), result.getInt(4),
                        new EscuderiaModel(result.getInt(6), result.getString(7),
                                result.getString(8), result.getInt(9), result.getString(10)));
                pilotos.add(piloto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return pilotos;
    }

    /**
     * Encuentra todos los pilotos
     *
     * @return ArrayList<PilotoModel>
     */
    public ArrayList<PilotoModel> findAll() {
        ArrayList<PilotoModel> pilotos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM piloto "
                    + "INNER JOIN escuderia ON piloto.codigo_escuderia_fk = escuderia.codigo_escuderia "
                    + "order by piloto.codigo_piloto asc;\n";
            ResultSet result = getConnection().createStatement().executeQuery(sql);
            while (result.next()) {
                PilotoModel piloto = new PilotoModel(result.getInt(1),
                        result.getString(2), result.getDouble(3), result.getInt(4),
                        new EscuderiaModel(result.getInt(6), result.getString(7),
                                result.getString(8), result.getInt(9), result.getString(10)));
                pilotos.add(piloto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return pilotos;
    }

    /**
     * Crea un piloto
     *
     * @param piloto
     */
    public void createPiloto(PilotoModel piloto) {
        try {
            String sql = "INSERT INTO piloto(codigo_piloto, nombre, "
                    + "millas_recorridas, combustible_usado, codigo_escuderia_fk) "
                    + "VALUES (?,?,?,?,?);";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, piloto.getCodigoPiloto());
            statement.setString(2, piloto.getNombre());
            statement.setDouble(3, piloto.getMillasRecorridas());
            statement.setInt(4, piloto.getCombustibleUsado());
            statement.setInt(5, piloto.getEscuderia().getCodigoEscuderia());
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Piloto insertado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    /**
     * Elimina un piloto
     *
     * @param id
     */
    public void deletePilotoByCodigo(int id) {
        try {
            String sql = "DELETE FROM piloto WHERE codigo_piloto = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Eliminado Piloto");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    /**
     * Actualiza un piloto
     *
     * @param piloto
     */
    public void updatePilotoById(PilotoModel piloto) {
        try {
            String sql = "UPDATE piloto SET codigo_piloto= ?, nombre = ?, "
                    + "millas_recorridas = ?, combustible_usado = ?, "
                    + "codigo_escuderia_fk = ? WHERE codigo_piloto = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, piloto.getCodigoPiloto());
            statement.setString(2, piloto.getNombre());
            statement.setDouble(3, piloto.getMillasRecorridas());
            statement.setInt(4, piloto.getCombustibleUsado());
            statement.setInt(5, piloto.getEscuderia().getCodigoEscuderia());
            statement.setInt(6, piloto.getCodigoPiloto());
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Piloto actualizado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

}
