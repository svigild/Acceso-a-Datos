package Logica;


import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sergio
 */
public class Filtros {
    
    File fichero;
    
    public Filtros(File fichero) {
        this.fichero = fichero;
    }
    
    /**
     * Filtra los ficheros de imagenes
     * @return una lista con los nombres de los archivos filtrados
     */
    public List<String> filtrarPorImagen(){
        //Creo el filtro de las imagenes según su extensión
        FilenameFilter filtroImagen = (File dir, String name) -> (name.endsWith(".gif") || name.endsWith(".jpg") || name.endsWith(".tittf") || name.endsWith(".png"));
        //Creo la lista de ficheros filtrados
        File[] listaFicherosImagen = fichero.listFiles(filtroImagen);
        //Creo la lista de los nombres de los ficheros
        List<String> listaNombresImagenes = new ArrayList<>();
        //Añado el nombre de cada fichero a la List 
        for (File archivo : listaFicherosImagen) {
            listaNombresImagenes.add(archivo.getName());
        }
        //Devuelvo la List de nombres de ficheros
        return listaNombresImagenes;
    }
    
    /**
     * Filtra los ficheros de videos
     * @return una lista con los nombres de los archivos filtrados
     */
    public List<String> filtrarPorVideo(){
        //Creo el filtro de los videos según su extensión
        FilenameFilter filtroVideo = (File dir, String name) -> (name.endsWith(".avi") || name.endsWith(".mp4") || name.endsWith(".mkv") || name.endsWith(".wmv"));
        //Creo la lista de ficheros filtrados
        File[] listaFicherosVideo = fichero.listFiles(filtroVideo);
        //Creo la lista de los nombres de los ficheros
        List<String> listaNombresVideo = new ArrayList<>();
        //Añado el nombre de cada fichero a la List 
        for (File archivo : listaFicherosVideo) {
            listaNombresVideo.add(archivo.getName());
        }
        //Devuelvo la List de nombres de ficheros
        return listaNombresVideo;
    }
    
    /**
     * Filtra los ficheros por directorios
     * @return una lista con los nombres de los directorios filtrados
     */
    public List<String> filtrarPorDirectorio(){
        // Creo el filtro de los directorios
        FilenameFilter filtroDirectorio = (dir, name) -> dir.isDirectory() && !name.contains(".");
        // Creo la lista de directorios filtrados
        File[] listaDirectorios = fichero.listFiles(filtroDirectorio);

        List<String> listaNombresDirectorio = new ArrayList<>();

        if (listaDirectorios != null) {
            for (File directorio : listaDirectorios) {
                listaNombresDirectorio.add(directorio.getName());
            }
        }
        return listaNombresDirectorio;
    }
    
    /**
     * Filtra los ficheros por un tamaño minimo
     * @param tamañoMinimo
     * @return una lista con los nombres de los archivos filtrados
     */
    public List<String> filtrarPorTamaño(double tamañoMinimo){
        //Creo el filtro de los ficheros teniendo en cuenta el tamaño minimo
        FilenameFilter filtroTamaño = (dir, name) -> new File(dir, name).length() >= tamañoMinimo;
        //Creo la lista de ficheros filtrados
        File[] listaFicheroTamaño = fichero.listFiles(filtroTamaño);
        //Creo la lista de los nombres de los ficheros
        List<String> listaNombresTamaño = new ArrayList<>();
        //Añado el nombre de cada fichero a la List 
        for (File archivo : listaFicheroTamaño) {
            listaNombresTamaño.add(archivo.getName());
        }
        //Devuelvo la List de nombres de ficheros
        return listaNombresTamaño;
    }
    
    /**
     * Filtra los ficheros modificados en las últimas 24 horas
     * @return 
     */
    public List<String> filtrarPorModificado24Horas(){
        //Creo el filtro de los directorios
        FilenameFilter filtroModificado24Horas = (dir, name) -> {
            File archivo = new File(dir, name); // Creo un objeto File 
            long lastModified = archivo.lastModified();
            long currentTime = System.currentTimeMillis();
            return ((currentTime - lastModified) < 86400000); // Si la diferencia de tiempo es menor a 24 horas (en milisegundos)
        };
        //Creo la lista de ficheros filtrados
        File[] listaFicheros = fichero.listFiles(filtroModificado24Horas);
        //Creo la lista de los nombres de los ficheros
        List<String> listaNombresFicheros = new ArrayList<>();
        //Añado el nombre de cada fichero a la List 
        for (File archivo : listaFicheros) {
            listaNombresFicheros.add(archivo.getName());
        }
        //Devuelvo la List de nombres de directorios
        return listaNombresFicheros;
    }
}
