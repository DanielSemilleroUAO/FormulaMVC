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
import static utils.ConnectionDB.getConnection;

/**
 *
 * @author delga
 */
public class EscuderiaDAO {

    public EscuderiaModel findEscuderiaByCodigo(int id) {
        EscuderiaModel escuderia = null;
        try {
            String sql = "SELECT * from escuderia WHERE codigo_escuderia = ?;";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                escuderia = new EscuderiaModel();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return escuderia;
    }

    public EscuderiaModel findEscuderiaByName(String name) {
        return null;
    }

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
                //CarreraModel carrera = new CarreraModel(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4), result.getBoolean(5));
               escuderias.add(escuderia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return escuderias;
    }

    public void createEscuderia(EscuderiaModel escuderia) {
    }

    public void deleteEscuderiaByCodigo(int id) {
    }

    public void updateEscuderiaById(int id, EscuderiaModel escuderia) {
    }
    
    public static void main(String[] args) {
        EscuderiaDAO escuderiaDAO = new EscuderiaDAO();
        ArrayList<EscuderiaModel> escuderias = escuderiaDAO.findAll();
        for (EscuderiaModel escuderia : escuderias) {
            System.out.println(escuderia.toString());
        }
        
    }

}
