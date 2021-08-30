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

/**
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
    
    
    
    
    public void saveDataEscuderia(){
        
    }
    
    public void saveDataParticipacion(){
    
    }
    
    public void saveDataPiloto(){
        
    }
    
    public void saveDataCarrera(CarreraModel carrera){
        if(carrera.getIdCarrera() == -1){
            carreraDAO.createCarrera(carrera);
        }else {
            carreraDAO.updateCarreraById(carrera.getIdCarrera(), carrera);
        }
    }
    
    
}
