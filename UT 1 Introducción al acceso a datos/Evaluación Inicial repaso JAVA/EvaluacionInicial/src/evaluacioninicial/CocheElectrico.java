/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacioninicial;

/**
 *
 * @author Sergio
 */
public class CocheElectrico extends Coche {
    
    private Bateria bateria;

    public CocheElectrico(Bateria bateria, int numPuertas, double kilometraje, String modelo, String fabricante, String color, int añoFabricacion, String matricula, int totalVehiculos, ControlVelocidad controlVelocidad, Ubicacion ubicacion, boolean arrancadoSiNo, int capacidadPasajeros) {
        super(numPuertas, kilometraje, modelo, fabricante, color, añoFabricacion, matricula, totalVehiculos, controlVelocidad, ubicacion, arrancadoSiNo, capacidadPasajeros);
        this.bateria = bateria;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }
}
