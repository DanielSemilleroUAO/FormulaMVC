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
import models.CarreraModel;
import models.EscuderiaModel;
import models.ParticipacionModel;
import models.PilotoModel;

/**
 * Controlador de las vistas secundarias para guardar información
 * 
 * @author delga
 */
public class SaveDataController {

    private CarreraDAO carreraDAO;
    private EscuderiaDAO escuderiaDAO;
    private ParticipacionDAO participacionDAO;
    private PilotoDAO pilotoDAO;

    public SaveDataController() {
        carreraDAO = new CarreraDAO();
        escuderiaDAO = new EscuderiaDAO();
        participacionDAO = new ParticipacionDAO();
        pilotoDAO = new PilotoDAO();
    }
    
    /**
     * Guardar o actualizar informacion escuderia
     *  
     * @param escuderia
     * @param id 
     */
    public void saveDataEscuderia(EscuderiaModel escuderia, int id) {
        if(id == -1){
            escuderiaDAO.createEscuderia(escuderia);
        }else{
            escuderiaDAO.updateEscuderiaById(escuderia);
        }
    }
    
    /**
     * Guardar o actualizar informacion Participacion
     * 
     * @param participacion 
     */
    public void saveDataParticipacion(ParticipacionModel participacion) {
        if(participacion.getIdParticipacion() == -1){
            participacionDAO.createParticipacion(participacion);
        }else{
            participacionDAO.updateParticipacionById(participacion);
        }
    }
    
    /**
     * Guardar o actualizar informacion piloto
     * 
     * @param piloto
     * @param id 
     */
    public void saveDataPiloto(PilotoModel piloto, int id) {
        if (id == -1) {
            pilotoDAO.createPiloto(piloto);
        } else {
            pilotoDAO.updatePilotoById(piloto);
        }

    }

    /**
     * Guardar o actualizar informacion de la carrera
     * @param carrera 
     */
    public void saveDataCarrera(CarreraModel carrera) {
        if (carrera.getIdCarrera() == -1) {
            carreraDAO.createCarrera(carrera);
        } else {
            carreraDAO.updateCarreraById(carrera);
        }
    }

}
