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
public class PilotoModel {
    
    private int codigoPiloto;
    private String nombre;
    private Double millasRecorridas;
    private int combustibleUsado;
    private EscuderiaModel escuderia;

    public PilotoModel() {
    }

    public PilotoModel(int codigoPiloto, String nombre, Double millasRecorridas, int combustibleUsado) {
        this.codigoPiloto = codigoPiloto;
        this.nombre = nombre;
        this.millasRecorridas = millasRecorridas;
        this.combustibleUsado = combustibleUsado;
    }

    public PilotoModel(int codigoPiloto, String nombre, Double millasRecorridas, int combustibleUsado, EscuderiaModel escuderia) {
        this.codigoPiloto = codigoPiloto;
        this.nombre = nombre;
        this.millasRecorridas = millasRecorridas;
        this.combustibleUsado = combustibleUsado;
        this.escuderia = escuderia;
    }

    public PilotoModel(String nombre) {
        this.nombre = nombre;
    }
    
   
    public int getCodigoPiloto() {
        return codigoPiloto;
    }

    public void setCodigoPiloto(int codigoPiloto) {
        this.codigoPiloto = codigoPiloto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMillasRecorridas() {
        return millasRecorridas;
    }

    public void setMillasRecorridas(Double millasRecorridas) {
        this.millasRecorridas = millasRecorridas;
    }

    public int getCombustibleUsado() {
        return combustibleUsado;
    }

    public void setCombustibleUsado(int combustibleUsado) {
        this.combustibleUsado = combustibleUsado;
    }

    public EscuderiaModel getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(EscuderiaModel escuderia) {
        this.escuderia = escuderia;
    }

    @Override
    public String toString() {
        return "PilotoModel{" + "codigoPiloto=" + codigoPiloto + ", nombre=" + nombre + ", millasRecorridas=" + millasRecorridas + ", combustibleUsado=" + combustibleUsado + ", escuderia=" + escuderia + '}';
    }
    
    public Object[] toArray() {
        Object[] data = {codigoPiloto, nombre, combustibleUsado, escuderia.getNombre(), "Actualizar", "Eliminar"};
        return data;
    }
    
    public static Object[] toArrayTitles() {
        Object[] data = {"Codigo Piloto", "Nombre", "Combustible Usado", "Escuderia","Actualizar", "Eliminar"};
        return data;
    }
    
}
