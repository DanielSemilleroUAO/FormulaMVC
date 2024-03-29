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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.CarreraModel;
import models.EscuderiaModel;
import models.ParticipacionModel;
import models.PilotoModel;

/**
 * Controlador de la vista principal
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

    /**
     * Cargar información a la tabla de acuerdo a tabla seleccionada
     *
     * @param tabla
     * @param tablaSelected
     */
    public void loadDataTabSelected(JTable tabla, int tablaSelected) {

        Object[] headers;
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {

                switch (tablaSelected) {
                    case 0:
                        if (column == 5 || column == 6) {
                            return true;
                        } else {
                            return false;
                        }
                    case 1:
                        if (column == 5 || column == 4) {
                            return true;
                        } else {
                            return false;
                        }
                    case 2:
                        if (column == 5 || column == 6) {
                            return true;
                        } else {
                            return false;
                        }
                    case 3:
                        if (column == 5 || column == 4) {
                            return true;
                        } else {
                            return false;
                        }
                    default:
                        if (column == 5 || column == 6) {
                            return true;
                        } else {
                            return false;
                        }
                }
            }
        };

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
        tabla.getColumn("Actualizar").setCellEditor(new ButtonEditor(new JCheckBox(), tablaSelected));

        tabla.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        tabla.getColumn("Eliminar").setCellEditor(new ButtonEditor(new JCheckBox(), tablaSelected));
    }

    /**
     * Ejecuta los filtros y coloca información en la tabla
     *
     * @param tabla
     * @param tablaSelected
     * @param filterSelected
     * @param dataSearch
     */
    public void executeFilter(JTable tabla, int tablaSelected, int filterSelected, String dataSearch) {

        Object[] headers;
        DefaultTableModel tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {

                switch (tablaSelected) {
                    case 0:
                        if (column == 5 || column == 6) {
                            return true;
                        } else {
                            return false;
                        }
                    case 1:
                        if (column == 5 || column == 4) {
                            return true;
                        } else {
                            return false;
                        }
                    case 2:
                        if (column == 5 || column == 6) {
                            return true;
                        } else {
                            return false;
                        }
                    case 3:
                        if (column == 5 || column == 4) {
                            return true;
                        } else {
                            return false;
                        }
                    default:
                        if (column == 5 || column == 6) {
                            return true;
                        } else {
                            return false;
                        }
                }
            }
        };

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
                if (filterSelected == 0) {
                    if (dataSearch.equals("")) {
                        escuderiaModels = escuderiaDAO.findAll();
                    } else {
                        try {
                            escuderiaModels = escuderiaDAO.findEscuderiaByCodigo(Integer.parseInt(dataSearch));
                        } catch (Exception e) {
                            escuderiaModels = escuderiaDAO.findAll();
                            JOptionPane.showMessageDialog(null, "Ingresa valores validos");
                        }

                    }
                } else if (filterSelected == 1) {
                    escuderiaModels = escuderiaDAO.findEscuderiaByName(dataSearch);
                } else {
                    escuderiaModels = escuderiaDAO.findEscuderiaByPatrocinador(dataSearch);
                }
                for (int i = 0; i < escuderiaModels.size(); i++) {
                    tableModel.addRow(escuderiaModels.get(i).toArray());
                }
                break;
            case 1:
                if (filterSelected == 0) {
                    if (dataSearch.equals("")) {
                        pilotoModels = pilotoDAO.findAll();
                    } else {
                        try {
                            pilotoModels = pilotoDAO.findPilotoByCodigo(Integer.parseInt(dataSearch));

                        } catch (Exception e) {
                            pilotoModels = pilotoDAO.findAll();
                            JOptionPane.showMessageDialog(null, "Ingresa valores validos");
                        }
                    }
                } else {
                    pilotoModels = pilotoDAO.findPilotoByName(dataSearch);
                }
                for (int i = 0; i < pilotoModels.size(); i++) {
                    tableModel.addRow(pilotoModels.get(i).toArray());
                }
                break;
            case 2:
                if (filterSelected == 0) {
                    participacionModels = participacionDAO.findParticipacionByNamePiloto(dataSearch);
                } else {
                    participacionModels = participacionDAO.findParticipacionByNameCarrera(dataSearch);
                }
                for (int i = 0; i < participacionModels.size(); i++) {
                    tableModel.addRow(participacionModels.get(i).toArray());
                }
                break;

            case 3:
                carreraModels = carreraDAO.findCarreraByName(dataSearch);
                for (int i = 0; i < carreraModels.size(); i++) {
                    tableModel.addRow(carreraModels.get(i).toArray());
                }
                break;
            default:
                break;
        }

        tabla.getColumn(
                "Actualizar").setCellRenderer(new ButtonRenderer());
        tabla.getColumn(
                "Actualizar").setCellEditor(new ButtonEditor(new JCheckBox(), tablaSelected));

        tabla.getColumn(
                "Eliminar").setCellRenderer(new ButtonRenderer());
        tabla.getColumn(
                "Eliminar").setCellEditor(new ButtonEditor(new JCheckBox(), tablaSelected));

    }

    /**
     * Carga los datos al ComboBox para mostrar todas las escuderías disponibles
     *
     * @param comboBox
     * @return
     */
    public ArrayList<EscuderiaModel> loadComboBoxEscuderia(JComboBox comboBox) {
        ArrayList<EscuderiaModel> escuderias = escuderiaDAO.findAll();
        String[] data = new String[escuderias.size()];
        for (int i = 0; i < escuderias.size(); i++) {
            data[i] = escuderias.get(i).getNombre();
        }
        comboBox.setModel(new DefaultComboBoxModel<>(data));
        return escuderias;
    }

    /**
     * Carga los datos al ComboBox para mostrar todos los pilotos disponibles
     *
     * @param comboBox
     * @return
     */
    public ArrayList<PilotoModel> loadComboBoxPilotos(JComboBox comboBox) {
        ArrayList<PilotoModel> pilotos = pilotoDAO.findAll();
        String[] data = new String[pilotos.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = pilotos.get(i).getNombre();
        }
        comboBox.setModel(new DefaultComboBoxModel<>(data));
        return pilotos;
    }

    /**
     * Carga los datos al ComboBox para mostrar todos las carreras disponibles
     *
     * @param comboBox
     * @return
     */
    public ArrayList<CarreraModel> loadComboBoxCarreras(JComboBox comboBox) {
        ArrayList<CarreraModel> carreras = carreraDAO.findAll();
        String[] data = new String[carreras.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = carreras.get(i).getNombre();
        }
        comboBox.setModel(new DefaultComboBoxModel<>(data));
        return carreras;
    }

}
