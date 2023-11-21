/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacioninicial;

/**
 *
 * @author Sergio
 */
public class Bateria implements Recargable {
    
    private double capacidad;
    private double cargaActual;
    private boolean estaLlenaSiNo;

    public Bateria(double capacidad, double cargaActual, boolean estaLlenaSiNo) {
        this.capacidad = capacidad;
        this.cargaActual = cargaActual;
        this.estaLlenaSiNo = estaLlenaSiNo;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getCargaActual() {
        return cargaActual;
    }

    public void setCargaActual(double cargaActual) {
        this.cargaActual = cargaActual;
    }

    public boolean isEstaLlenaSiNo() {
        return estaLlenaSiNo;
    }

    public void setEstaLlenaSiNo(boolean estaLlenaSiNo) {
        this.estaLlenaSiNo = estaLlenaSiNo;
    }


    @Override
    public void recargar(double cantidad) {
        if ((this.getCargaActual() + cantidad)<= this.getCapacidad()){
            this.setCargaActual(this.getCargaActual() + cantidad);
        } else {
            System.out.println("Se ha producido un error: Exceso de carga");
        }
    }

    @Override
    public void descargar(double cantidad) {
        if ((this.getCargaActual() - cantidad)>= 0){
            this.setCargaActual(this.getCargaActual() - cantidad);
        } else {
            System.out.println("Se ha producido un error: Exceso de carga");
        }
    }
}
