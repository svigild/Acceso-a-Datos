/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Probar;

import Logica.FrecuenciaPalabra;
import Logica.OperacionesFicheros;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class Main {
    
    public static void main(String args[]){
        
        String rutaFichero = "./ElQuijote.txt";
        String rutaDirectorio = "./";
        try {
            //2. Contar el número de líneas. 
            int numeroLineas = OperacionesFicheros.contarNumeroLineas(rutaFichero);
            System.out.println("---------- Numero de lineas del texto: ----------");
            System.out.println(numeroLineas);

            
            //3. Contar cuantas veces aparece una palabra. 
            /* . 
            int numeroVecesAparecePalabra = OperacionesFicheros.contarVecesAparecePalabra(rutaFichero, "caballo");
            System.out.println("---------- Numero de veces que aparece la palabra caballo: ----------");
            System.out.println(numeroVecesAparecePalabra);
            */
            
            //4. Contar el número total de letras. 
            /*
            int numeroLetras = OperacionesFicheros.contarNumeroLetras(rutaFichero);
            System.out.println("---------- Numero de letras: ----------");
            System.out.println(numeroLetras);
            */
              
            //5. Crear un Hashmap<K,V> K= palabra V= número de veces que aparece. 
            /*
            System.out.println("---------- Palabras clasificadas segun el numero de veces que aparecen ----------");
            for (HashMap.Entry<String, Integer> entrada : OperacionesFicheros.numeroVecesAparecePalabraHashMap(rutaFichero).entrySet()) {
                String clave = entrada.getKey();
                Integer valor = entrada.getValue();
                System.out.println("Palabra: " + clave + ", Veces que aparece: " + valor);
            }
            */
             
            //6. Clasificar las palabras por longitud. Hashmap<K,V> K= Integer V= lista de palabras. 
            /*
            System.out.println("---------- Palabras clasificadas por longitud ----------");
            for (HashMap.Entry<Integer, List<String>> entrada : OperacionesFicheros.clasificarPalabrasPorLongitud(rutaFichero).entrySet()) {
                Integer clave = entrada.getKey();
                List<String> valor = entrada.getValue();
                System.out.println("Longitud: " + clave + ", Palabras: " + valor);
            }
            */
            
            /*7.Clasificar las palabra por la letra que empiezan. 
            System.out.println("---------- Palabras clasificadas por la letra por la que empiezan ----------");
            for (HashMap.Entry<Character, List<String>> entrada : OperacionesFicheros.clasificarPalabrasPorPrimeraLetra(rutaFichero).entrySet()) {
                Character clave = entrada.getKey();
                List<String> valor = entrada.getValue();
                System.out.println("Caracter: " + clave + ", Palabras: " + valor);
            }
            */
            
            /*9. Ampliar el apartado 5, de forma que procese todos los ficheros txt  de un determinado directorio y almacene los resultados en un HashMap<fichero, HashMap<palabra,apariciones>> mapaFrecuenciaPalabrasFicheros = new HashMap<String, HashMap<String,Integer>>(); 
            System.out.println("---------- Numero de veces que aparecen las palabras de los ficheros de un directorio ----------");
            HashMap<String, Integer> hashmap = OperacionesFicheros.cargarCarpetaFicherosEnHashMap(rutaDirectorio);
            for (String palabra : hashmap.keySet()) {
                System.out.println(palabra + ": " + hashmap.get(palabra));
            }
            */
            
            /*10. Analizar el texto y mostrar las 100 palabras que mas veces aparecen en el mismo.
            System.out.println("---------- 100 Palabras que más veces aparecen en el fichero ----------");
            List<FrecuenciaPalabra> top100Palabras = OperacionesFicheros.obtenerTop100PalabrasFrecuentes(rutaFichero);
            // Imprimo las 100 palabras más frecuentes
            for (int i = 0; i < top100Palabras.size(); i++) {
                FrecuenciaPalabra fp = top100Palabras.get(i);
                System.out.println((i + 1) + ". " + fp.getPalabra() + " - " + fp.getVecesAparece() + " veces");
            }
            */
            
        } catch (IOException ex) {
            System.err.println("Ha habido un error a la hora de acceder al fichero.");
        }
    }
}
