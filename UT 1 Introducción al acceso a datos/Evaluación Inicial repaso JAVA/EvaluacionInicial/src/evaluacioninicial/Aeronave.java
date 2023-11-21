/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacioninicial;

/**
 *
 * @author Sergio
 */
public class Aeronave extends Vehiculo implements Volable {
    
    private int numMotores;
    private double alturaMaxima;
    private boolean estaVolandoSiNo;
    private Deposito deposito;

    public Aeronave(int numMotores, double alturaMaxima, boolean estaVolandoSiNo, Deposito deposito, String modelo, String fabricante, String color, int añoFabricacion, String matricula, int totalVehiculos, ControlVelocidad controlVelocidad, Ubicacion ubicacion, boolean arrancadoSiNo, int capacidadPasajeros) {
        super(modelo, fabricante, color, añoFabricacion, matricula, totalVehiculos, controlVelocidad, ubicacion, arrancadoSiNo, capacidadPasajeros);
        this.numMotores = numMotores;
        this.alturaMaxima = alturaMaxima;
        this.estaVolandoSiNo = estaVolandoSiNo;
        this.deposito = deposito;
    }
    

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }
    
    public int getNumMotores() {
        return numMotores;
    }

    public void setNumMotores(int numMotores) {
        this.numMotores = numMotores;
    }

    public double getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(double alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }

    public boolean isEstaVolandoSiNo() {
        return estaVolandoSiNo;
    }

    public void setEstaVolandoSiNo(boolean estaVolandoSiNo) {
        this.estaVolandoSiNo = estaVolandoSiNo;
    }
    
    @Override
    public void despegar(){
        this.setEstaVolandoSiNo(true);
    }
    
    @Override
    public void ganarAltura(int altura){
        this.getUbicacion().setPosicionY(this.getUbicacion().getPosicionY() + altura);
    }
    
    @Override
    public void perderAltura(int altura){
        this.getUbicacion().setPosicionY(this.getUbicacion().getPosicionY() - altura);
    }
}
