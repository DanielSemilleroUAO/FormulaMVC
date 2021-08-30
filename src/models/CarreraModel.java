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
public class CarreraModel {

    private int idCarrera;
    private String nombre;
    private int capacidad;
    private double nivelDificultad;
    private boolean isTecho;

    public CarreraModel() {
    }

    public CarreraModel(int idCarrera, String nombre, int capacidad, double nivelDificultad, boolean isTecho) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.nivelDificultad = nivelDificultad;
        this.isTecho = isTecho;
    }

    public CarreraModel(String nombre, int capacidad, double nivelDificultad, boolean isTecho) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.nivelDificultad = nivelDificultad;
        this.isTecho = isTecho;
    }

    public CarreraModel(String nombre) {
        this.nombre = nombre;
    }
    
    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(double nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public boolean isIsTecho() {
        return isTecho;
    }

    public void setIsTecho(boolean isTecho) {
        this.isTecho = isTecho;
    }

    @Override
    public String toString() {
        return "CarreraModel{" + "idCarrera=" + idCarrera + ", nombre=" + nombre + ", capacidad=" + capacidad + ", nivelDificultad=" + nivelDificultad + ", isTecho=" + isTecho + '}';
    }
    

    public Object[] toArray() {
        Object[] data = {nombre, capacidad, nivelDificultad, isTecho, "Actualizar", "Eliminar"};
        return data;
    }

    public static Object[] toArrayTitles() {
        Object[] data = {"Nombre", "Capacidad", "Nivel Dificultad", "Techo", "Actualizar", "Eliminar"};
        return data;
    }

}
