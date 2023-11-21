/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Logica.EstacionMeteorologica;
import Logica.RegistroMeteorologico;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class Main {
    public static void main(String[]args){
        //Creo instancias de estaciones meteorológicas y registros
        EstacionMeteorologica estacion1 = new EstacionMeteorologica("Ciudad 1", "Ubicacion 1");
        EstacionMeteorologica estacion2 = new EstacionMeteorologica("Ciudad 2", "Ubicacion 2");

        //Genero los datos meteorológicos aleatorios
        estacion1.generarDatosMeteorologicosAleatorios(10);
        estacion2.generarDatosMeteorologicosAleatorios(10);

        //Muestro las estadísticas de la primera estación
        System.out.println("Estadisticas de la primera estacion:");
        estacion1.mostrarEstadisticas();

        //Obtengo la estación con la temperatura máxima
        estacion1.obtenerEstacionTemperaturaMaxima()
                .ifPresent(temperaturaMaximaEstacion -> {
                    System.out.println("Estacion con temperatura maxima:");
                    System.out.println("ID: " + temperaturaMaximaEstacion.getId());
                    System.out.println("Localidad: " + temperaturaMaximaEstacion.getLocalidad());
                });

        //Calculo la temperatura media para una localidad, mes y año específicos
        double temperaturaMedia = estacion1.calcularTemperaturaMediaPorMesYAnio(List.of(estacion1, estacion2), "Ciudad A", 11, 2023);
        System.out.println("Temperatura media para Ciudad A en noviembre de 2023: " + temperaturaMedia + " C");

        //Buscar registros en un intervalo de tiempo especifico
        LocalDateTime inicio = LocalDateTime.of(2023, 11, 1, 0, 0);
        LocalDateTime fin = LocalDateTime.of(2023, 11, 30, 23, 59);
        List<RegistroMeteorologico> registrosEnRango = estacion1.buscarRegistrosDesdeArchivo(inicio, fin);
        System.out.println("Registros meteorologicos en el rango de tiempo especificado:");
        for (RegistroMeteorologico registro : registrosEnRango) {
            System.out.println("Fecha: " + registro.getFecha() + ", Temperatura: " + registro.getTemperatura());
        }
    }
}
