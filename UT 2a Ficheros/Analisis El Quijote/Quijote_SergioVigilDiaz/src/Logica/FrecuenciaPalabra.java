/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Sergio
 */
public class FrecuenciaPalabra {
    
    private String palabra;
    private int vecesAparece;

    public FrecuenciaPalabra(String palabra, int vecesAparece) {
        this.palabra = palabra;
        this.vecesAparece = vecesAparece;
    }

    public String getPalabra() {
        return palabra;
    }

    public int getVecesAparece() {
        return vecesAparece;
    }
}
