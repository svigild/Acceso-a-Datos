/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author Sergio
 */
public class EstacionMeteorologica {
    
    private final int id;
    private String localidad;
    private String ubicacion;
    List<RegistroMeteorologico> registros;

    public EstacionMeteorologica(String localidad, String ubicacion) {
        this.id = this.generarId();
        this.localidad = localidad;
        this.ubicacion = ubicacion;
        this.registros = new ArrayList<>();
    }

    public EstacionMeteorologica(int id, String localidad, String ubicacion, List<RegistroMeteorologico> registros) {
        this.id = id;
        this.localidad = localidad;
        this.ubicacion = ubicacion;
        this.registros = registros;
    }
    
    public int getId(){
        return id;
    }
    
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<RegistroMeteorologico> getRegistrosMeteorologicos() {
        return registros;
    }

    public void setRegistrosMeteorologicos(List<RegistroMeteorologico> registros) {
        this.registros = registros;
    }

    public List<RegistroMeteorologico> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroMeteorologico> registros) {
        this.registros = registros;
    }
    
    
    
    /**
     * Genera un ID aleatorio.
     * @return el id en concreto.
     */
    public int generarId(){
        HashSet <Integer> idSet = new HashSet();
        Random random = new Random();
        int id = random.nextInt();
        while (!idSet.add(id)){ //Mientras el id se encuentre en el HashSet se busca un nuevo id que no lo esté
            id = random.nextInt();
        }
        return id;
    }
    
    /**
     * Genera datos meteorológicos aleatorios para cada estación y lo guarda en un archivo CSV
     * @param numeroRegistros 
     */
    public void generarDatosMeteorologicosAleatorios(int numeroRegistros) {
        Random rand = new Random();

        String nombreArchivo = "Registro.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            boolean archivoExiste = new File(nombreArchivo).exists();
            // Si el archivo no existe, escribir los encabezados
            if (!archivoExiste) {
                writer.write("ID Estación,Timestamp,Temperatura (°C),Humedad (%),Presión Atmosférica (hPa),Velocidad del Viento (m/s)");
                writer.newLine();
            }

            // Escribir datos
            for (int i = 0; i < numeroRegistros; i++) {
                LocalDateTime timestamp = generateRandomTimestamp();
                double temperatura = rand.nextDouble() * 30; // Temperatura entre 0 y 30°C
                double humedad = rand.nextDouble() * 100; // Humedad entre 0% y 100%
                double presion = rand.nextDouble() * 1000; // Presión entre 0 hPa y 1000 hPa
                double viento = rand.nextDouble() * 100; // Velocidad a la que sopla el viento entre 0 m/s y 100 m/s

                RegistroMeteorologico nuevoRegistro = new RegistroMeteorologico(timestamp, temperatura, humedad, presion, viento);
                this.registros.add(nuevoRegistro);

                // Escribir línea en el archivo CSV
                String linea = String.format("%d,%s,%.2f,%.2f,%.2f,%.2f", this.id, timestamp, temperatura, humedad, presion, viento);
                writer.write(linea);
                writer.newLine();  // Añadir esta línea para pasar a la siguiente fila
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public LocalDateTime generateRandomTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        Random RAND = new Random();
        long daysInThePast = RAND.nextLong(365); // días aleatorios del último año
        long minutesInThePast = RAND.nextLong(24 * 60); // minutos aleatorios del día
    
        return now.minusDays(daysInThePast).minusMinutes(minutesInThePast);
    }
    
    /**
     * Dada la ID de una estación meteorológica y un rango de tiempo, busca en el fichero CSV y devuelve todos los registros meteorológicos
     * de dicha estación dentro del rango de tiempo especificado.
     *
     * @param idEstacion ID de la estación meteorológica a buscar.
     * @param inicio Fecha de inicio del rango.
     * @param fin Fecha de fin del rango.
     * @return una lista de registros meteorológicos.
     */
    public List<RegistroMeteorologico> buscarRegistrosDesdeArchivo(LocalDateTime inicio, LocalDateTime fin) {
        List<RegistroMeteorologico> resultados = new ArrayList<>();

        String nombreArchivo = "Registro.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] campos = line.split(",");

                if (campos.length == 6) { // Se corrigió el número de campos
                    try {
                        LocalDateTime fecha = LocalDateTime.parse(campos[1]); // Se corrigió el índice del timestamp
                        double temperatura = Double.parseDouble(campos[2]);
                        double humedad = Double.parseDouble(campos[3]);
                        double presion = Double.parseDouble(campos[4]);
                        double viento = Double.parseDouble(campos[5]);

                        RegistroMeteorologico registro = new RegistroMeteorologico(fecha, temperatura, humedad, presion, viento);

                        // Filtrar por rango de tiempo
                        if (registro.getFecha().isAfter(inicio) && registro.getFecha().isBefore(fin)) {
                            resultados.add(registro);
                        }
                    } catch (Exception e) {
                        // Manejar cualquier error de formato o conversión
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultados;
    }

    /**
     * Obtiene una estacion mediante su ID
     * @param estacionesMeteorologicas
     * @param idEstacion
     * @return una EstacionMeteorologica que tenga dicho ID
     */
    public EstacionMeteorologica obtenerEstacionPorId(List<EstacionMeteorologica> estacionesMeteorologicas, int idEstacion) {
        for (EstacionMeteorologica estacion : estacionesMeteorologicas) {
            if (estacion.getId() == idEstacion) {
                return estacion;
            }
        }
        //Si no se encuentra la estacion, devuelve null
        return null; 
    }
    
    /**
     * Calcula y muestra estadísticas generales de los datos meteorológicos. 
     * Incluye temperatura promedio, máxima y mínima.
     */
    public void mostrarEstadisticas() {
        if (registros.isEmpty()) {
            System.out.println("No hay datos meteorologicos disponibles para calcular estadisticas.");
            return;
        }

        //Inicializo las variables para las estadísticas de temperatura
        double sumaTemperatura = 0;
        double temperaturaMaxima = Double.MIN_VALUE;
        double temperaturaMinima = Double.MAX_VALUE;

        //Calculo las estadísticas de temperatura
        for (RegistroMeteorologico registro : registros) {
            double temperatura = registro.getTemperatura();
            sumaTemperatura += temperatura;

            if (temperatura > temperaturaMaxima) {
                temperaturaMaxima = temperatura;
            }

            if (temperatura < temperaturaMinima) {
                temperaturaMinima = temperatura;
            }
        }

        //Calculo la temperatura media
        double temperaturaPromedio = sumaTemperatura / registros.size();

        //Muestro las estadisticas en consola
        System.out.println("Estadisticas de temperatura:");
        System.out.println("Temperatura promedio: " + temperaturaPromedio + " C");
        System.out.println("Temperatura maxima: " + temperaturaMaxima + " C");
        System.out.println("Temperatura minima: " + temperaturaMinima + " C");
    }

    /**
     * Devuelve la estación que ha alcanzado la temperatura máxima
     *
     * @return la estación con temperatura máxima
     */
    public Optional<EstacionMeteorologica> obtenerEstacionTemperaturaMaxima() {
        return registros.stream()
                .max(Comparator.comparingDouble(registro -> registro.getTemperatura()))
                .map(registro -> this);
    }
    
    /**
     * Calcula la temperatura media, pasando como parámetros el mes y el año
     * @param estacionesMeteorologicas
     * @param localidad
     * @param mes
     * @param año
     * @return la temperatura media
     */
    public double calcularTemperaturaMediaPorMesYAnio(List<EstacionMeteorologica> estacionesMeteorologicas, String localidad, int mes, int año) {
        List<EstacionMeteorologica> estacionesEnLocalidad = estacionesMeteorologicas.stream()
                .filter(estacion -> estacion.getLocalidad().equals(localidad))
                .collect(Collectors.toList());

        if (estacionesEnLocalidad.isEmpty()) {
            System.out.println("No hay estaciones meteorologicas en esa localidad");
            return 0.0; 
        }

        List<RegistroMeteorologico> registrosFiltrados = estacionesEnLocalidad.stream()
                .flatMap(estacion -> estacion.getRegistrosMeteorologicos().stream())
                .filter(registro -> //Filtro el stream
                        registro.getFecha().getMonthValue() == mes &&
                        registro.getFecha().getYear() == año)
                .collect(Collectors.toList());

        if (registrosFiltrados.isEmpty()) {
            System.out.println("No hay datos meteorologicos disponibles para la localidad, mes y año especificados.");
            return 0.0; // 
        }

        double temperaturaMedia = registrosFiltrados.stream()
                .mapToDouble(RegistroMeteorologico::getTemperatura)
                .average()
                .orElse(0.0);

        return temperaturaMedia;
    }
}
