/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class OperacionesFicheros {
    
    public static void main(String[]args) throws CarpetaVacia, NoEsUnDirectorioNoSePuedeListar, DirectorioYaExiste{
        
        
        //Pruebo el método de listarFicheros
        List<File> ficherosEscritorio;
        try {
            ficherosEscritorio = listarFicheros("C:\\Windows", true, false, false);
            
            for (int i=0; i<ficherosEscritorio.size(); i++){
            System.out.println(ficherosEscritorio.get(i).getName());
        }
        } catch (CarpetaVacia | NoEsUnDirectorioNoSePuedeListar ex) {
            Logger.getLogger(OperacionesFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Pruebo el método de crearDirectorios creando 3 directorios (Directorio1, Directorio2 y Directorio3) en el escritorio
        ArrayList<String> listaDeDirectorios = new ArrayList<>(Arrays.asList("Directorio1", "Directorio2", "Directorio3"));
        String nombreDeUsuario = System.getProperty("user.name");
        String rutaCrearDirectorios = "C:\\Users\\" + nombreDeUsuario + "\\Desktop";
        int directoriosCreados = crearDirectorios(rutaCrearDirectorios, listaDeDirectorios);
        System.out.println("Se han creado " + directoriosCreados + " directorios.");
        
        //Pruebo el método de cambiarExtensionFicheros con una carpeta de prueba y sus ficheros
        String extensionOriginal = ".txt";
        String extensionFinal = ".exe";
        int extensionesCambiadas = cambiarExtensionFicheros("C:\\Users\\"+ nombreDeUsuario + "\\Desktop\\CarpetaPrueba", extensionOriginal, extensionFinal);
        System.out.println("Se han cambiado " + extensionesCambiadas + " extensiones. La extension original era: " + extensionOriginal + " y ahora es: " + extensionFinal);
    }   
    
    /**
     * Lista los ficheros y/o directorios en una ruta dada.
     * 
     * @param ruta La ruta en la que se listarán los ficheros y directorios.
     * @param ordenarPorNombre si es true, retornará la lista ordenada por nombre. 
     * @param ordenarPorLongitud si es true, retornará la lista ordenada por tamaño.
     * @param soloDirectorios si es true, retornará solo los nombres de los directorios.
     * @return una List de elementos File
     * @throws Logica.OperacionesFicheros.CarpetaVacia Si la carpeta especificada está vacía.
     * @throws Logica.OperacionesFicheros.NoEsUnDirectorioNoSePuedeListar Si la ruta no es un directorio válido.
     */
    public static List<File> listarFicheros(String ruta, boolean ordenarPorNombre, boolean ordenarPorLongitud, boolean soloDirectorios) throws CarpetaVacia, NoEsUnDirectorioNoSePuedeListar{
        
        //Creo el archivo en la ruta asignada como parámetro
        File directorio = new File(ruta);
        
        //Excepción si el directorio no existe.
        if (!directorio.exists()){
            throw new CarpetaVacia("La ruta especificada no existe");
        }
        //Excepción si no es un directorio.
        if (!directorio.isDirectory()) {
            throw new NoEsUnDirectorioNoSePuedeListar("La ruta especificada no es un directorio.");
        }
        
        //Creo una lista con los archivos de ese directorio
        File[] archivos = directorio.listFiles();
        
        //Si no hay archivos, lanzo la excepción
        if (archivos == null) {
            throw new CarpetaVacia("La carpeta está vacía.");
        }
        
        List<File> listaDeArchivos;
        listaDeArchivos = new ArrayList<>();
        
        for (File archivo : archivos) {
            //Si soloDirectorios es 'true' y el archivo NO es un directorio, salto a la siguiente interación ya que solo quiero directorios
            if (soloDirectorios && !archivo.isDirectory()) {
                continue;
            }
            listaDeArchivos.add(archivo);
        }
        
        //Si ordenarPorNombre es 'true', ordeno la lista por nombre
        if (ordenarPorNombre) {
            Collections.sort(listaDeArchivos, (File archivo1, File archivo2) -> archivo1.getName().compareTo(archivo2.getName()));
        }
        //Si ordenarPorLongitud es 'true', ordeno la lista por longitud
        if (ordenarPorLongitud) {
           Collections.sort(listaDeArchivos, (File archivo1, File archivo2) -> Long.compare(archivo1.length(), archivo2.length()));
        }

        //Devuelvo la lista de archivos
        return listaDeArchivos;
        
    }
    
    /**
     * Error que es lanzado cuando una carpeta está vacía.
     */
    public static class CarpetaVacia extends Exception {
        public CarpetaVacia(String mensaje) {
            super(mensaje);
        }
    }
    
    /**
     * Error que es lanzado cuando no es un directorio.
     */
    public static class NoEsUnDirectorioNoSePuedeListar extends Exception {
        public NoEsUnDirectorioNoSePuedeListar(String mensaje) {
            super(mensaje);
        }
    }
    
    /**
     * Crea directorios en la ruta dada.
     * 
     * @param rutaOrigen Es la ruta donde se creará el/los directorio/s.
     * @param listaDirectorios Una lista de nombres de directorios a crear.
     * @return El número total de directorios creados.
     * @throws Logica.OperacionesFicheros.CarpetaVacia Si la carpeta de origen no existe.
     * @throws Logica.OperacionesFicheros.NoEsUnDirectorioNoSePuedeListar Si no es un directorio.
     * @throws Logica.OperacionesFicheros.DirectorioYaExiste Si uno de los directorios especificados ya existe.
     */
    public static int crearDirectorios(String rutaOrigen, ArrayList<String> listaDirectorios) throws CarpetaVacia, NoEsUnDirectorioNoSePuedeListar, DirectorioYaExiste {
        
        //Creo el archivo en la ruta asignada como parámetro
        File directorio = new File(rutaOrigen);
        
        //Excepción si el directorio no existe.
        if (!directorio.exists()){
            throw new CarpetaVacia("La ruta especificada no existe");
        }
        //Excepción si no es un directorio
        if (!directorio.isDirectory()) {
            throw new NoEsUnDirectorioNoSePuedeListar("La ruta de origen no es un directorio.");
        }
        
        //Inicializo el contador de directorios creados a 0
        int directoriosCreados = 0;
        
        for (String nombreDirectorio : listaDirectorios) {
            //Creo el nuevo directorio con el nombre asignado
            File nuevoDirectorio = new File(rutaOrigen, nombreDirectorio);
            if (nuevoDirectorio.exists() && nuevoDirectorio.isDirectory()) {
                //Excepción si el directorio ya existe
                throw new DirectorioYaExiste("El directorio " + nombreDirectorio + " ya existe.");
            }
            //Si el directorio ya se creó...
            if (nuevoDirectorio.mkdir()){
                directoriosCreados++;
            }
        }
        
        return directoriosCreados;
    }
    
    /**
     * Error que es lanzado cuando un directorio ya existe.
     */
    public static class DirectorioYaExiste extends Exception {
        public DirectorioYaExiste(String mensaje) {
            super(mensaje);
        }
    }
    
    /**
     * Cambia la extensión de los ficheros de una ruta dada
     * 
     * @param ruta La ruta donde están los ficheros a los que se les cambiará la extensión.
     * @param extensionAntigua Si uno de los directorios especificados ya existe.
     * @param extensionNueva. La nueva extensión que se utilizará.
     * @return El número de ficheros modificados.
     * @throws Logica.OperacionesFicheros.CarpetaVacia Si la carpeta especificada está vacía.
     */
    public static int cambiarExtensionFicheros(String ruta, String extensionAntigua, String extensionNueva) throws CarpetaVacia {
        //Creo el archivo en la ruta asignada como parámetro
        File directorio = new File(ruta);
        
        //Excepción si el directorio no existe.
        if (!directorio.exists()){
            throw new CarpetaVacia("La ruta especificada no existe");
        }
        
        //Creo una lista con todos los ficheros de ese directorio
        File[] todosLosFicheros = directorio.listFiles();
        
        //Inicio el contador de ficheros modificados a 0
        int ficherosModificados = 0;
        
        for (File archivo : todosLosFicheros){
            //Si el archivo es un archivo y si su extensión es la que se pasó como parámetro al llamar al método...
              if (archivo.isFile() && archivo.getName().endsWith(extensionAntigua)) {
                  //Obtengo el nuevo nombre del archivo reemplazando la extensión antigua por la nueva
                String nuevoNombre = archivo.getName().replace(extensionAntigua, extensionNueva);
                //Creo un nuevo archivo con el nuevo nombre
                File nuevoArchivo = new File(directorio, nuevoNombre);
                //Si el nombre es cambiado, sumo 1 al contador de ficheros modificados
                if (archivo.renameTo(nuevoArchivo)) {
                    ficherosModificados++;
                }
            }
        }
        
        return ficherosModificados;
    }
    
    /**
     * Cambia la extensión de los ficheros dado un File.
     * 
     * @param ruta La ruta donde están los ficheros a los que se les cambiará la extensión.
     * @param extensionAntigua Si uno de los directorios especificados ya existe.
     * @param extensionNueva. La nueva extensión que se utilizará.
     * @return El número de ficheros modificados.
     * @throws Logica.OperacionesFicheros.CarpetaVacia Si la carpeta especificada está vacía.
     */
    public static int cambiarExtensionFicheros(File ruta, String extensionAntigua, String extensionNueva) throws CarpetaVacia {
        
        //Excepción si el directorio no existe.
        if (!ruta.exists()){
            throw new CarpetaVacia("La ruta especificada no existe");
        }
        
        //Creo una lista con todos los ficheros de ese directorio
        File[] todosLosFicheros = ruta.listFiles();
        
        //Inicio el contador de ficheros modificados a 0
        int ficherosModificados = 0;
        
        for (File archivo : todosLosFicheros){
            //Si el archivo es un archivo y si su extensión es la que se pasó como parámetro al llamar al método...
              if (archivo.isFile() && archivo.getName().endsWith(extensionAntigua)) {
                  //Obtengo el nuevo nombre del archivo reemplazando la extensión antigua por la nueva
                String nuevoNombre = archivo.getName().replace(extensionAntigua, extensionNueva);
                //Creo un nuevo archivo con el nuevo nombre
                File nuevoArchivo = new File(ruta, nuevoNombre);
                //Si el nombre es cambiado, sumo 1 al contador de ficheros modificados
                if (archivo.renameTo(nuevoArchivo)) {
                    ficherosModificados++;
                }
            }
        }
        
        return ficherosModificados;
    }
}
