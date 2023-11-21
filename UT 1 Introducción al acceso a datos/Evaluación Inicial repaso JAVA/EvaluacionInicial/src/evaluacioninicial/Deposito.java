/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacioninicial;

/**
 *
 * @author Sergio
 */
public class Deposito implements Repostable {
    
    private double litrosDeposito;
    private double capacidadDeposito;
    private String tipoCombustible;

    public Deposito(double litrosDeposito, double capacidadDeposito, String tipoCombustible) {
        this.litrosDeposito = litrosDeposito;
        this.capacidadDeposito = capacidadDeposito;
        this.tipoCombustible = tipoCombustible;
    }

    public double getLitrosDeposito() {
        return litrosDeposito;
    }

    public void setLitrosDeposito(double litrosDeposito) {
        this.litrosDeposito = litrosDeposito;
    }

    public double getCapacidadDeposito() {
        return capacidadDeposito;
    }

    public void setCapacidadDeposito(double capacidadDeposito) {
        this.capacidadDeposito = capacidadDeposito;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public void repostar(double cantidadLitros, char tipoCombustible) {
        double gasolinaActual = this.getLitrosDeposito();
        double gasolinaMaxima = this.getCapacidadDeposito();
        
        //Si al echarle el nuevo combustible no se supera la capacidad del depósito y el combustible es del mismo tipo:
        if (((gasolinaActual + cantidadLitros) <= gasolinaMaxima)&&(this.getTipoCombustible().equals(tipoCombustible))){
            this.setLitrosDeposito(this.getLitrosDeposito() + cantidadLitros);
        } else {
            System.out.println("Se ha producido un error: Exceso de combustible o tipo de combustible incorrecto.");
        }      
    }

    @Override
    public void gastar(double cantidadLitros, char tipoCombustible) {
        double gasolinaActual = this.getLitrosDeposito();
        double gasolinaMaxima = this.getCapacidadDeposito();
        
        //Si al restarle el nuevo combustible la capacidad no es menor que 0 y el combustible es del mismo tipo:
        if (((gasolinaActual - cantidadLitros) >= 0)&&(this.getTipoCombustible().equals(tipoCombustible))){
            this.setLitrosDeposito(this.getLitrosDeposito() - cantidadLitros);
        } else {
            System.out.println("Se ha producido un error: Se ha intentado gastar más combustible del permitido o tipo de combustible incorrecto.");
        }   
    }
    
    
}
