/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacioninicial;

/**
 *
 * @author Sergio
 */
public class CocheHibrido extends Coche {

    private Bateria bateria;
    private Deposito deposito;

    public CocheHibrido(Bateria bateria, Deposito deposito, int numPuertas, double kilometraje, String modelo, String fabricante, String color, int añoFabricacion, String matricula, int totalVehiculos, ControlVelocidad controlVelocidad, Ubicacion ubicacion, boolean arrancadoSiNo, int capacidadPasajeros) {
        super(numPuertas, kilometraje, modelo, fabricante, color, añoFabricacion, matricula, totalVehiculos, controlVelocidad, ubicacion, arrancadoSiNo, capacidadPasajeros);
        this.bateria = bateria;
        this.deposito = deposito;
    }
    
    

    public Bateria getBateria() {
        return bateria;
    }

    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }
    
    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }
    
}
