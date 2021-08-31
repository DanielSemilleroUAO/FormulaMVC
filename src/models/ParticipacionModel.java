/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author delga
 */
public class ParticipacionModel {
    
    private int idParticipacion;
    private String fecha;
    private int posicion;
    private PilotoModel piloto;
    private EscuderiaModel escuderia;
    private CarreraModel carrera;

    public ParticipacionModel() {
    }

    public ParticipacionModel(int idParticipacion, String fecha, int posicion, PilotoModel piloto, EscuderiaModel escuderia, CarreraModel carrera) {
        this.idParticipacion = idParticipacion;
        this.fecha = fecha;
        this.posicion = posicion;
        this.piloto = piloto;
        this.escuderia = escuderia;
        this.carrera = carrera;
    }
    
    public ParticipacionModel(String fecha, int posicion, PilotoModel piloto, EscuderiaModel escuderia, CarreraModel carrera) {
        this.fecha = fecha;
        this.posicion = posicion;
        this.piloto = piloto;
        this.escuderia = escuderia;
        this.carrera = carrera;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public PilotoModel getPiloto() {
        return piloto;
    }

    public void setPiloto(PilotoModel piloto) {
        this.piloto = piloto;
    }

    public EscuderiaModel getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(EscuderiaModel escuderia) {
        this.escuderia = escuderia;
    }

    public CarreraModel getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraModel carrera) {
        this.carrera = carrera;
    }

    public int getIdParticipacion() {
        return idParticipacion;
    }

    public void setIdParticipacion(int idParticipacion) {
        this.idParticipacion = idParticipacion;
    }
    

    @Override
    public String toString() {
        return "ParticipacionModel{" + "fecha=" + fecha + ", posicion=" 
                + posicion + ", piloto=" + piloto.toString() + ", escuderia="
                + escuderia.toString() + ", carrera=" + carrera.toString() + '}';
    }
    
    
    
    public Object[] toArray() {
        Object[] data = { carrera.getNombre(), piloto.getNombre(), escuderia.getNombre(), posicion, fecha, "Actualizar", "Eliminar"};
        return data;
    }
    
    public static Object[] toArrayTitles() {
        Object[] data = {"Carrera", "Piloto", "Escuderia", "Posicion", "Fecha" ,"Actualizar", "Eliminar"};
        return data;
    }
    
}
