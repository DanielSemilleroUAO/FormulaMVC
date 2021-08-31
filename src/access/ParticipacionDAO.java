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
import models.EscuderiaModel;
import models.ParticipacionModel;
import models.PilotoModel;
import static utils.ConnectionDB.getConnection;

/**
 *
 * @author delga
 */
public class ParticipacionDAO {

    public ArrayList<ParticipacionModel> findParticipacionByNamePiloto(String nombre) {
        ArrayList<ParticipacionModel> participaciones = new ArrayList<>();
        try {
            String sql = "select carrera.nombre, piloto.nombre, escuderia.nombre, participacion.posicion, participacion.fecha, participacion.id_participacion from participacion "
                    + "inner join piloto on participacion.codigo_piloto_fk = piloto.codigo_piloto "
                    + "inner join carrera on participacion.id_carrera_fk = carrera.id_carrera "
                    + "inner join escuderia on piloto.codigo_escuderia_fk = escuderia.codigo_escuderia "
                    + "where piloto.nombre LIKE ? "
                    + "ORDER BY carrera.nombre asc;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, "%" + nombre + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                ParticipacionModel participacion
                        = new ParticipacionModel(result.getInt(6), result.getString(5), result.getInt(4),
                                new PilotoModel(result.getString(2)),
                                new EscuderiaModel(result.getString(3)),
                                new CarreraModel(result.getString(1)));
                participaciones.add(participacion);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return participaciones;
    }

    public ArrayList<ParticipacionModel> findParticipacionByNameCarrera(String nombre) {
        ArrayList<ParticipacionModel> participaciones = new ArrayList<>();
        try {
            String sql = "select carrera.nombre, piloto.nombre, escuderia.nombre, participacion.posicion, participacion.fecha, participacion.id_participacion from participacion "
                    + "inner join piloto on participacion.codigo_piloto_fk = piloto.codigo_piloto "
                    + "inner join carrera on participacion.id_carrera_fk = carrera.id_carrera "
                    + "inner join escuderia on piloto.codigo_escuderia_fk = escuderia.codigo_escuderia "
                    + "where carrera.nombre like ? "
                    + "ORDER BY carrera.nombre asc;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, "%" + nombre + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                ParticipacionModel participacion
                        = new ParticipacionModel(result.getInt(6), result.getString(5), result.getInt(4),
                                new PilotoModel(result.getString(2)),
                                new EscuderiaModel(result.getString(3)),
                                new CarreraModel(result.getString(1)));
                participaciones.add(participacion);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return participaciones;
    }

    public ArrayList<ParticipacionModel> findAll() {
        ArrayList<ParticipacionModel> participaciones = new ArrayList<>();
        try {
            String sql = "select carrera.nombre, piloto.nombre, escuderia.nombre, participacion.posicion, participacion.fecha, participacion.id_participacion from participacion "
                    + "inner join piloto on participacion.codigo_piloto_fk = piloto.codigo_piloto "
                    + "inner join carrera on participacion.id_carrera_fk = carrera.id_carrera "
                    + "inner join escuderia on piloto.codigo_escuderia_fk = escuderia.codigo_escuderia ORDER BY carrera.nombre asc;";
            ResultSet result = getConnection().createStatement().executeQuery(sql);
            while (result.next()) {
                ParticipacionModel participacion
                        = new ParticipacionModel(result.getInt(6), result.getString(5), result.getInt(4),
                                new PilotoModel(result.getString(2)),
                                new EscuderiaModel(result.getString(3)),
                                new CarreraModel(result.getString(1)));
                participaciones.add(participacion);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return participaciones;
    }

    public void createParticipacion(ParticipacionModel participacion) {
        try {
            String sql = "INSERT INTO participacion(fecha, posicion, codigo_piloto_fk, id_carrera_fk) VALUES (?,?,?,?);";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, participacion.getFecha());
            statement.setInt(2, participacion.getPosicion());
            statement.setInt(3, participacion.getPiloto().getCodigoPiloto());
            statement.setInt(4, participacion.getCarrera().getIdCarrera());
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Participacion insertado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteParticipacionById(int id) {
        try {
            String sql = "DELETE FROM participacion WHERE id_participacion = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Eliminado Participacion");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateParticipacionById(ParticipacionModel participacion) {
        try {
            System.out.println(participacion.getIdParticipacion());
            String sql = "UPDATE participacion SET fecha = ?, posicion = ?, codigo_piloto_fk = ?, id_carrera_fk = ? WHERE id_participacion = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, participacion.getFecha());
            statement.setInt(2, participacion.getPosicion());
            statement.setInt(3, participacion.getPiloto().getCodigoPiloto());
            statement.setInt(4, participacion.getCarrera().getIdCarrera());
            statement.setInt(5, participacion.getIdParticipacion());
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Participacion actualizado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        EscuderiaDAO escuderiaDAO = new EscuderiaDAO();
        ArrayList<EscuderiaModel> escuderias = escuderiaDAO.findAll();
        for (EscuderiaModel escuderia : escuderias) {
            System.out.println(escuderia.toString());
        }

    }

}
