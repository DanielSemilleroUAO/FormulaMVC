/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.EscuderiaModel;
import models.PilotoModel;
import static utils.ConnectionDB.getConnection;

/**
 *
 * @author delga
 */
public class PilotoDAO {

    public PilotoModel findPilotoByCodigo(int id) {
        return null;
    }

    public PilotoModel findPilotoByName(String name) {
        return null;
    }

    public ArrayList<PilotoModel> findAll() {
        ArrayList<PilotoModel> pilotos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM piloto INNER JOIN escuderia ON piloto.codigo_escuderia_fk = escuderia.codigo_escuderia order by piloto.codigo_piloto asc;\n";
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

    public void createPiloto(PilotoModel piloto) {
    }

    public void deletePilotoByCodigo(int id) {
    }

    public void updatePilotoById(int id, PilotoModel piloto) {
    }
    
    public static void main(String[] args) {
        PilotoDAO pilotoDAO = new PilotoDAO();
        ArrayList<PilotoModel> pilotos = pilotoDAO.findAll();
        for (PilotoModel piloto : pilotos) {
            System.out.println(pilotos.toString());
        }
        
    }

}
