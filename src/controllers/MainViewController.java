/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import access.CarreraDAO;
import access.EscuderiaDAO;
import access.ParticipacionDAO;
import access.PilotoDAO;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.CarreraModel;
import models.EscuderiaModel;
import models.ParticipacionModel;
import models.PilotoModel;

/**
 *
 * @author delga
 */
public class MainViewController {

    private CarreraDAO carreraDAO;
    private EscuderiaDAO escuderiaDAO;
    private ParticipacionDAO participacionDAO;
    private PilotoDAO pilotoDAO;
    
    public static ArrayList<EscuderiaModel> escuderiaModels;
    public static ArrayList<PilotoModel> pilotoModels;
    public static ArrayList<ParticipacionModel> participacionModels;
    public static ArrayList<CarreraModel> carreraModels;

    public MainViewController() {
        carreraDAO = new CarreraDAO();
        escuderiaDAO = new EscuderiaDAO();
        participacionDAO = new ParticipacionDAO();
        pilotoDAO = new PilotoDAO();
    }

    public void loadDataTabSelected(JTable tabla, int tablaSelected) {

        Object[] headers;
        DefaultTableModel tableModel = new DefaultTableModel();

        tabla.removeAll();
        //Se colocan los titulos

        switch (tablaSelected) {
            case 0:
                headers = EscuderiaModel.toArrayTitles();
                break;
            case 1:
                headers = PilotoModel.toArrayTitles();
                break;
            case 2:
                headers = ParticipacionModel.toArrayTitles();
                break;
            case 3:
                headers = CarreraModel.toArrayTitles();
                break;
            default:
                headers = EscuderiaModel.toArrayTitles();
                break;
        }
        tableModel.setColumnIdentifiers(headers);
        //Se cargan los datos
        tabla.setModel(tableModel);

        switch (tablaSelected) {
            case 0:
                escuderiaModels = escuderiaDAO.findAll();
                for (int i = 0; i < escuderiaModels.size(); i++) {
                    tableModel.addRow(escuderiaModels.get(i).toArray());
                }
                break;
            case 1:
                pilotoModels = pilotoDAO.findAll();
                for (int i = 0; i < pilotoModels.size(); i++) {
                    tableModel.addRow(pilotoModels.get(i).toArray());
                }
                break;
            case 2:
                participacionModels = participacionDAO.findAll();
                for (int i = 0; i < participacionModels.size(); i++) {
                    tableModel.addRow(participacionModels.get(i).toArray());
                }
                break;
            case 3:
                carreraModels = carreraDAO.findAll();
                for (int i = 0; i < carreraModels.size(); i++) {
                    tableModel.addRow(carreraModels.get(i).toArray());
                }
                break;
            default:
                break;
        }

        tabla.getColumn("Actualizar").setCellRenderer(new ButtonRenderer());
        tabla.getColumn("Actualizar").setCellEditor(new ButtonEditor(new JCheckBox(),tablaSelected));

        tabla.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        tabla.getColumn("Eliminar").setCellEditor(new ButtonEditor(new JCheckBox(),tablaSelected));
    }

    public Object[][] executeFilter(int tabSelected, int filterSelected) {

        return null;
    }

    public Object[][] filtersEscuderia() {
        return null;
    }

    public Object[][] filtersPiloto() {
        return null;
    }

    public Object[][] filtersParticipacion() {
        return null;
    }

    public Object[][] filtersCarrera() {
        return null;
    }

}