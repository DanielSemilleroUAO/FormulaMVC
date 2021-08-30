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

    public ArrayList<ParticipacionModel> findParticipacionByCodigoPiloto(int codigoPiloto) {
        ArrayList<ParticipacionModel> participaciones = new ArrayList<>();
        try {
            String sql = "SELECT carrera.nombre, carrera.corre_techo, "
                    + "carrera.nivel_dificultad, piloto.nombre, "
                    + "participacion.posicion FROM participacion "
                    + "INNER JOIN carrera ON participacion.id_carrera_fk = carrera.id_carrera "
                    + "INNER JOIN piloto ON participacion.codigo_piloto_fk = piloto.codigo_piloto "
                    + "WHERE piloto.codigo_piloto = ? ORDER BY carrera.nombre ASC;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, codigoPiloto);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                ParticipacionModel participacion = new ParticipacionModel();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return participaciones;
    }

    public ArrayList<ParticipacionModel> findParticipacionByIdCarrera(int idCarrera) {
        return null;
    }

    public ArrayList<ParticipacionModel> findAll() {
        ArrayList<ParticipacionModel> participaciones = new ArrayList<>();
        try {
            String sql = "select carrera.nombre, piloto.nombre, escuderia.nombre, participacion.posicion, participacion.fecha from participacion "
                    + "inner join piloto on participacion.codigo_piloto_fk = piloto.codigo_piloto "
                    + "inner join carrera on participacion.id_carrera_fk = carrera.id_carrera "
                    + "inner join escuderia on piloto.codigo_escuderia_fk = escuderia.codigo_escuderia ORDER BY carrera.nombre asc;";
            ResultSet result = getConnection().createStatement().executeQuery(sql);
            while (result.next()) {
                ParticipacionModel participacion = 
                        new ParticipacionModel(result.getString(5), result.getInt(4),
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
    }

    public void deleteParticipacionById(int id) {
    }

    public void updateParticipacionById(int id, ParticipacionModel participacion) {
    }

}
