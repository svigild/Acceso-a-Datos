/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacioninicial;

/**
 *
 * @author Sergio
 */
public class ControlVelocidad {
    private double velocidad;
    private double taquimetro;
    private double velocidadMaxima;

    public ControlVelocidad(double velocidad, double taquimetro, double velocidadMaxima) {
        this.velocidad = velocidad;
        this.taquimetro = taquimetro;
        this.velocidadMaxima = velocidadMaxima;
    }

    
    
    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getTaquimetro() {
        return taquimetro;
    }

    public void setTaquimetro(double taquimetro) {
        this.taquimetro = taquimetro;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    
    
}
