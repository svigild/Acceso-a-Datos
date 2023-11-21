/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author Sergio
 */
public class RegistroMeteorologico {
   
    private LocalDateTime fecha;
    private double temperatura;
    private double humedad;
    private double presionAtmosferica;
    private double velocidadViento;

    public RegistroMeteorologico(LocalDateTime fecha, double temperatura, double humedad, double presionAtmosferica, double velocidadViento) {
        this.fecha = fecha;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.presionAtmosferica = presionAtmosferica;
        this.velocidadViento = velocidadViento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getHumedad() {
        return humedad;
    }

    public void setHumedad(double humedad) {
        this.humedad = humedad;
    }

    public double getPresionAtmosferica() {
        return presionAtmosferica;
    }

    public void setPresionAtmosferica(double presionAtmosferica) {
        this.presionAtmosferica = presionAtmosferica;
    }

    public double getVelocidadViento() {
        return velocidadViento;
    }

    public void setVelocidadViento(double velocidadViento) {
        this.velocidadViento = velocidadViento;
    }
    
    
}
