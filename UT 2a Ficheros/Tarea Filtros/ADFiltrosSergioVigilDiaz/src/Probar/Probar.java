package Probar;


import Logica.Filtros;
import java.io.File;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sergio
 */
public class Probar {
    
    public static void main(String[]args){
        
        File directorio = new File("C:\\Users\\Sergio\\Desktop");
        Filtros filtro = new Filtros(directorio);
        
        System.out.println("Ficheros filtrados por imagenes:");
        List<String> ficherosImagen = filtro.filtrarPorImagen();
        for (String s : ficherosImagen){
            System.out.println("- " + s);
        }
        
        System.out.println("Ficheros filtrados por videos:");
        List<String> ficherosVideo = filtro.filtrarPorVideo();
        for (String s : ficherosVideo){
            System.out.println("- " + s);
        }
        
        System.out.println("Ficheros filtrados por directorios:");
        List<String> directorios = filtro.filtrarPorDirectorio();
        for (String s : directorios){
            System.out.println("- " + s);
        }
        
        System.out.println("Ficheros filtrados por un tamaño minimo de bytes:");
        long tamañoMinimo = 2035;
        List<String> ficheros = filtro.filtrarPorTamaño(tamañoMinimo);
        for (String s : ficheros){
            System.out.println("- " + s);
        }
        
        System.out.println("Ficheros modificados en las ultimas 24 horas:");
        List<String> ficheros24Horas = filtro.filtrarPorModificado24Horas();
        for (String s : ficheros24Horas){
            System.out.println("- " + s);
        }
    }
}
