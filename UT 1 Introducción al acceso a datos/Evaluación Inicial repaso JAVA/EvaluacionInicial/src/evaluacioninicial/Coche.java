/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacioninicial;

/**
 *
 * @author Sergio
 */
public class Coche extends Vehiculo {
    
    private int numPuertas;
    private double kilometraje;

    public Coche(int numPuertas, double kilometraje, String modelo, String fabricante, String color, int añoFabricacion, String matricula, int totalVehiculos, ControlVelocidad controlVelocidad, Ubicacion ubicacion, boolean arrancadoSiNo, int capacidadPasajeros) {
        super(modelo, fabricante, color, añoFabricacion, matricula, totalVehiculos, controlVelocidad, ubicacion, arrancadoSiNo, capacidadPasajeros);
        this.numPuertas = numPuertas;
        this.kilometraje = kilometraje;
    }
    

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }
    
    
    
}
