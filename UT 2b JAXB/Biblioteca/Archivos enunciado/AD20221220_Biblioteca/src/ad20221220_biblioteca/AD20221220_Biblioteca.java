/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad20221220_biblioteca;

import JAXB.biblioteca.Biblioteca;
import JAXB.biblioteca.LibroType;
import JAXB.biblioteca.ObjectFactory;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import logica.OperacionesBiblioteca;

/**
 *
 * @author joselariasclassroom
 */
public class AD20221220_Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        OperacionesBiblioteca operacionesBiblioteca = new logica.OperacionesBiblioteca();
        
        
        ObjectFactory objectFactory = new ObjectFactory();
        Biblioteca biblioteca = objectFactory.createBiblioteca();
        
        LibroType libroNuevo = objectFactory.createLibroType();
        
        libroNuevo.setAutor("Autor1");
        
        
        // opcion 1
        DatatypeFactory XMLFactory = DatatypeFactory.newDefaultInstance();        
        XMLGregorianCalendar ahoraXMLGregorianCalendar = XMLFactory.newXMLGregorianCalendar(2022, 12, 20, 16, 19, 50, 0, 0);   
        
        
        // opcion 2
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        XMLGregorianCalendar ahoraXMLGregorianCalendar2 = XMLFactory.newXMLGregorianCalendar(gregorianCalendar);
        
        
        
        libroNuevo.setFechaPublicacion(ahoraXMLGregorianCalendar);
        
        
        
        
        
        operacionesBiblioteca.añadirLibro(biblioteca, libroNuevo);
        
    }

    private static void XMLGregorianCalendar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
