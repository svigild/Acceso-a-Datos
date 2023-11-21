package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sergio
 */
public class OperacionesFicheros {
    
    /**
     * Contar el número de líneas 
     * @param fichero
     * @return total de líneas del fichero
     * @throws IOException 
     */
    public static int contarNumeroLineas( String fichero ) throws IOException{
        Path ruta = Path.of(fichero);
        //Cuenta el número de líneas
        int numeroLineas = (int) Files.readString(ruta) //Obtengo una cadena con todo el contenido del fichero
                .lines()    //Stream de cadenas
                .count();   //Cuenta el total de cadenas en el stream
        //Devuelvo el número de líneas
        return numeroLineas;
    }
    
    /**
     * Contar cuantas veces aparece una palabra
     * @param fichero
     * @param palabraBuscada
     * @return número de veces que aparece la palabra
     * @throws IOException 
     */
    public static int contarVecesAparecePalabra ( String fichero, String palabraBuscada ) throws IOException{
        Path ruta = Path.of(fichero);
        String libroCompleto = Files.readString(ruta);
        //Cuenta el número de veces que aparece la palabra introducida
        int numeroVecesAparece = (int) Stream.of(libroCompleto.split(" "))  //Crea un stream de cadenas
                .filter(palabra -> palabra.equalsIgnoreCase(palabraBuscada))    //Filtra el stream por palabras
                .count();   //Cuento el número de elementos en el stream
        
        //Devuelvo el número de veces que aparece dicha palabra
        return numeroVecesAparece;
    }
    
    /**
     * Contar el número total de letras
     * @param fichero
     * @return numero de letras totales del fichero
     * @throws IOException 
     */
    public static int contarNumeroLetras ( String fichero ) throws IOException{
        Path ruta = Path.of(fichero);
        String libroCompleto = Files.readString(ruta);
        int contadorLetras = 0;
        //Itero para cada caracter del libro completo
        for (int i = 0; i < libroCompleto.length(); i++) {
            char caracter = libroCompleto.charAt(i);
            //Si el caracter es una letra, se suma 1 al contador de letras
            if (Character.isLetter(caracter)) {
                contadorLetras++;
            }
        }
        return contadorLetras;
    }
    
    /**
     * Crear un Hashmap<K,V> K= palabra V= número de veces que aparece. 
     * @param fichero
     * @return un HashMap <String, Integer> con todas las palabras y las veces que aparecen en el fichero
     * @throws IOException 
     */
    public static HashMap<String, Integer> numeroVecesAparecePalabraHashMap(String fichero) throws IOException {
        HashMap<String, Integer> palabraFrecuencia = new HashMap<>();
        Path ruta = Path.of(fichero);
        String libroCompleto = Files.readString(ruta);
    
        // Divido el libro completo en palabras
        String[] palabras = libroCompleto.split("\\s+");
    
        for (String palabra : palabras) {
            // Elimino todo lo que no sean letras y lo paso a minúscula
            palabra = palabra.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
            if (!palabra.isEmpty()) {
                // Verifica si la palabra ya está en el HashMap, y si lo está, aumenta la frecuencia
                if (palabraFrecuencia.containsKey(palabra)) {
                    palabraFrecuencia.put(palabra, palabraFrecuencia.get(palabra) + 1);
                } else {
                    // Si la palabra no está en el HashMap, la agrega con frecuencia 1
                    palabraFrecuencia.put(palabra, 1);
                }
            }
        }
        return palabraFrecuencia;
    }
    
    /**
     * Clasificar las palabras por longitud. Hashmap<K,V> K= Integer V= lista de palabras. 
     * @param fichero
     * @return un Hashmap<K,V> con las palabras ordenadas en función de su longitud
     * @throws IOException 
     */
    public static HashMap <Integer, List<String>> clasificarPalabrasPorLongitud ( String fichero ) throws IOException{
        HashMap<Integer, List<String>> longitudPalabras = new HashMap<>();
        Path ruta = Path.of(fichero);
        String libroCompleto = Files.readString(ruta);
        
        String[] palabras = libroCompleto.split("\\s+");

        for (String palabra : palabras) {
            //Elimino todo lo que no sean letras y lo paso a minúscula
            palabra = palabra.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!palabra.isEmpty()) {
                int longitud = palabra.length();
                //Si el hashmap no contiene la clave de esa longitud, añade la arraylist
                if (!longitudPalabras.containsKey(longitud)) {
                    longitudPalabras.put(longitud, new ArrayList<>());
                }
                //Miro si la palabra ya está incluida antes de añadirla
                if (!longitudPalabras.get(longitud).contains(palabra)) {
                    longitudPalabras.get(longitud).add(palabra);
                }
            }
        }
        return longitudPalabras;
    }
    
    /**
     * Clasificar las palabra por la letra que empiezan. 
     * @param fichero
     * @return un Hashmap<K,V> con las palabras ordenadas en función de la letra por la que empiezan
     * @throws IOException 
     */
    public static HashMap<Character, List<String>> clasificarPalabrasPorPrimeraLetra(String fichero) throws IOException {
        HashMap<Character, List<String>> palabrasPorPrimeraLetra = new HashMap<>();
        Path ruta = Path.of(fichero);
        String libroCompleto = Files.readString(ruta);

        String[] palabras = libroCompleto.split("\\s+");

        for (String palabra : palabras) {
            palabra = palabra.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!palabra.isEmpty()) {
                char primeraLetra = palabra.charAt(0);
                if (!palabrasPorPrimeraLetra.containsKey(primeraLetra)) {
                    palabrasPorPrimeraLetra.put(primeraLetra, new ArrayList<>());
                }
                if (!palabrasPorPrimeraLetra.get(primeraLetra).contains(palabra)) {
                    palabrasPorPrimeraLetra.get(primeraLetra).add(palabra);
                }
            }
        }

    return palabrasPorPrimeraLetra;
}
    
   /**
     * Crear un HashMap<K,V> K= palabra V= número de veces que aparece en todos los ficheros .txt de un directorio.
     *
     * @param directorio Ruta del directorio que contiene los archivos .txt.
     * @return Un HashMap que contiene las palabras y la cantidad de veces que aparecen en todos los archivos .txt.
     * @throws IOException
     */
    public static HashMap<String, Integer> cargarCarpetaFicherosEnHashMap(String directorio) throws IOException {
        File dir = new File(directorio);
        File[] archivos = dir.listFiles();

        HashMap<String, Integer> mapaFicheros = new HashMap<>();

        for (File archivo : archivos) {
            if (archivo.isFile() && archivo.getName().endsWith(".txt")) {
                HashMap<String, Integer> mapaArchivo = numeroVecesAparecePalabraHashMap(archivo.getAbsolutePath());

                // Agregar el conteo de palabras del archivo actual al mapa global
                for (String palabra : mapaArchivo.keySet()) {
                    mapaFicheros.put(palabra, mapaFicheros.getOrDefault(palabra, 0) + mapaArchivo.get(palabra));
                }
            }
        }

        return mapaFicheros;
    } 
    
    /**
     * Muestra las 100 palabras que más veces aparecen en un texto ordenadas de mayor a menor
     * @param fichero
     * @return una lista con objetos de tipo FrecuenciaPalabra donde aparece la palabra y las veces que está en el texto
     * @throws IOException 
     */
    public static List<FrecuenciaPalabra> obtenerTop100PalabrasFrecuentes(String fichero) throws IOException {
        HashMap<String, Integer> palabraFrecuencia = numeroVecesAparecePalabraHashMap(fichero);
        //Creo una lista de objetos de FrecuenciaPalabra
        List<FrecuenciaPalabra> listaPalabrasFrecuentes = new ArrayList<>();
        //Creo un objeto de FrecuenciaPalabra para cada entrada del HashMap y lo añado a la lista
        for (HashMap.Entry<String, Integer> entry : palabraFrecuencia.entrySet()) {
            FrecuenciaPalabra fp = new FrecuenciaPalabra(entry.getKey(), entry.getValue());
            listaPalabrasFrecuentes.add(fp);
        }
        //Ordeno la lista en funcion de las veces que aparece la palabra
        listaPalabrasFrecuentes.sort((fp1, fp2) -> Integer.compare(fp2.getVecesAparece(), fp1.getVecesAparece()));
        //Establezco el minimo de la lista a 100 elementos
        listaPalabrasFrecuentes = listaPalabrasFrecuentes.subList(0, Math.min(100, listaPalabrasFrecuentes.size()));

        return listaPalabrasFrecuentes;
    }
}
