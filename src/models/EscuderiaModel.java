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
public class EscuderiaModel {
    
    private int codigoEscuderia;
    private String nombre;
    private String patrocinador;
    private int carrerasGanadas;
    private String fechaIngreso;

    public EscuderiaModel() {
    }

    public EscuderiaModel(int codigoEscuderia, String nombre, String patrocinador, int carrerasGanadas, String fechaIngreso) {
        this.codigoEscuderia = codigoEscuderia;
        this.nombre = nombre;
        this.patrocinador = patrocinador;
        this.carrerasGanadas = carrerasGanadas;
        this.fechaIngreso = fechaIngreso;
    }

    public EscuderiaModel(String nombre) {
        this.nombre = nombre;
    }
    

    public int getCodigoEscuderia() {
        return codigoEscuderia;
    }

    public void setCodigoEscuderia(int codigoEscuderia) {
        this.codigoEscuderia = codigoEscuderia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public int getCarrerasGanadas() {
        return carrerasGanadas;
    }

    public void setCarrerasGanadas(int carrerasGanadas) {
        this.carrerasGanadas = carrerasGanadas;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "EscuderiaModel{" + "codigoEscuderia=" + codigoEscuderia + ", nombre=" + nombre + ", patrocinador=" + patrocinador + ", carrerasGanadas=" + carrerasGanadas + ", fechaIngreso=" + fechaIngreso + '}';
    }
    
    public Object[] toArray() {
        Object[] data = {codigoEscuderia, nombre, patrocinador, carrerasGanadas, fechaIngreso, "Actualizar", "Eliminar"};
        return data;
    }
    
    public static Object[] toArrayTitles() {
        Object[] data = {"Codigo Escuderia", "Nombre", "Patrocinador", "Carreras Ganadas", "Fecha ingreso", "Actualizar", "Eliminar"};
        return data;
    }
    
}
