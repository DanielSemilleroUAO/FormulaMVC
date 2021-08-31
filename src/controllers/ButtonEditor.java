/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import access.CarreraDAO;
import access.EscuderiaDAO;
import access.PilotoDAO;
import access.ParticipacionDAO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import views.CarreraView;
import views.EscuderiaView;
import views.MainView;
import views.ParticipacionView;
import views.PilotoView;

/**
 *
 * @author delga
 */
class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;
    int id;

    public ButtonEditor(JCheckBox checkBox, int opc) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (label.equals("Actualizar")) {
                    switch (opc) {
                        case 0:
                            EscuderiaView escuderiaView = new EscuderiaView(MainViewController.escuderiaModels.get(id));
                            escuderiaView.setVisible(true);
                            break;
                        case 1:
                            PilotoView pilotoView = new PilotoView(MainViewController.pilotoModels.get(id));
                            pilotoView.setVisible(true);
                            break;
                        case 2:
                            ParticipacionView participacionView = new ParticipacionView(MainViewController.participacionModels.get(id));
                            participacionView.setVisible(true);
                            break;
                        case 3:
                            CarreraView carreraView = new CarreraView(MainViewController.carreraModels.get(id));
                            carreraView.setVisible(true);
                            break;
                    }
                } else {
                    switch (opc) {
                        case 0:
                            EscuderiaDAO escuderiaDAO = new EscuderiaDAO();
                            escuderiaDAO.deleteEscuderiaByCodigo(MainViewController.escuderiaModels.get(id).getCodigoEscuderia());
                            break;
                        case 1:
                            PilotoDAO pilotoDAO = new PilotoDAO();
                            pilotoDAO.deletePilotoByCodigo(MainViewController.pilotoModels.get(id).getCodigoPiloto());
                            break;
                        case 2:
                            ParticipacionDAO participacionDAO = new ParticipacionDAO();
                            participacionDAO.deleteParticipacionById(MainViewController.participacionModels.get(id).getIdParticipacion());
                            break;
                        case 3:
                            CarreraDAO carreraDAO = new CarreraDAO();
                            carreraDAO.deleteCarreraById(MainViewController.carreraModels.get(id).getIdCarrera());
                            break;
                    }
                    MainView.updateTable();
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        id = row;
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            JOptionPane.showMessageDialog(button, label + ": Ouch!" + String.valueOf(id));
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}
