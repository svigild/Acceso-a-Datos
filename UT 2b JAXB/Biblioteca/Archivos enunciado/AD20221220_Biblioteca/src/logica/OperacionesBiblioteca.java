/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import JAXB.biblioteca.Biblioteca;
import JAXB.biblioteca.LibroType;
import JAXB.biblioteca.ObjectFactory;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author joselariasclassroom
 */
public class OperacionesBiblioteca {

    public OperacionesBiblioteca() {
    }

    /**
     * Cuenta libros
     *
     * @param biblioteca
     * @return
     */
    public int contarLibros(Biblioteca biblioteca) throws Exception {
        Biblioteca.Libros nodoLibros = biblioteca.getLibros();
        List<LibroType> listaLibros = nodoLibros.getLibro();
        return listaLibros.size();

        //  return biblioteca.getLibros().getLibro().size();
    }

    /**
     * añadir Libro
     * @param biblioteca
     * @param libroNuevo
     * @return 
     */
    public boolean añadirLibro(Biblioteca biblioteca, LibroType libroNuevo) {
        Biblioteca.Libros nodoLibros = biblioteca.getLibros();
        List<LibroType> listaLibros = nodoLibros.getLibro();
        return listaLibros.add(libroNuevo);
    }

    
    /**
     * añadir Libro
     * @param biblioteca
     * @param autor
     * @param fechaPublicacion
     * @return
     * @throws Exception 
     */
   
    public boolean añadirLibro(Biblioteca biblioteca, String autor, XMLGregorianCalendar fechaPublicacion) throws Exception{

        ObjectFactory objectFactory = new ObjectFactory();
        LibroType nuevoLibro = objectFactory.createLibroType();

        nuevoLibro.setAutor(autor);
        nuevoLibro.setFechaPublicacion(fechaPublicacion);

        Biblioteca.Libros nodoLibros = biblioteca.getLibros();
        List<LibroType> listaLibros = nodoLibros.getLibro();
        return listaLibros.add(nuevoLibro);
    }

}
