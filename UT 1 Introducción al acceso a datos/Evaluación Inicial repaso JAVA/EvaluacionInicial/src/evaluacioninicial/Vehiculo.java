/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacioninicial;

/**
 *
 * @author Sergio
 */
public class Vehiculo implements Acelerable {
    
    private String modelo;
    private String fabricante;
    private String color;
    private int añoFabricacion;
    private String matricula;
    private int totalVehiculos;
    private ControlVelocidad controlVelocidad;
    private Ubicacion ubicacion;
    private boolean arrancadoSiNo;
    private int capacidadPasajeros;

    public Vehiculo(String modelo, String fabricante, String color, int añoFabricacion, String matricula, int totalVehiculos, ControlVelocidad controlVelocidad, Ubicacion ubicacion, boolean arrancadoSiNo, int capacidadPasajeros) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.color = color;
        this.añoFabricacion = añoFabricacion;
        this.matricula = matricula;
        this.totalVehiculos = totalVehiculos;
        this.controlVelocidad = controlVelocidad;
        this.ubicacion = ubicacion;
        this.arrancadoSiNo = arrancadoSiNo;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public ControlVelocidad getControlVelocidad() {
        return controlVelocidad;
    }

    public void setControlVelocidad(ControlVelocidad controlVelocidad) {
        this.controlVelocidad = controlVelocidad;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isArrancadoSiNo() {
        return arrancadoSiNo;
    }

    public void setArrancadoSiNo(boolean arrancadoSiNo) {
        this.arrancadoSiNo = arrancadoSiNo;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

   
    
    @Override
    public void acelerar(double velocidad) {
        this.controlVelocidad.setVelocidad(this.controlVelocidad.getVelocidad() + velocidad);
    }

    @Override
    public void frenar(double velocidad) {
        this.controlVelocidad.setVelocidad(this.controlVelocidad.getVelocidad() - velocidad);
    }
}
