/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evaluacioninicial;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class EvaluacionInicial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //                                                      Creo 3 objetos de cada clase
        //Aeronave 1
        Deposito d1 = new Deposito(150, 500, "Gas");
        ControlVelocidad cv1 = new ControlVelocidad(120, 3000, 400);
        Ubicacion u1 = new Ubicacion(100, 200);
        Aeronave aeronave1 = new Aeronave(2, 10000, true, d1, "Airbus", "A320","blanco", 1999, "9893PLF", 4, cv1, u1, true, 400);
        
        //Aeronave 2
        Deposito d2 = new Deposito(250, 600, "Gas");
        ControlVelocidad cv2 = new ControlVelocidad(0, 1000, 500);
        Ubicacion u2 = new Ubicacion(50, 0);
        Aeronave aeronave2 = new Aeronave(3, 10000, true, d1, "Airbus", "A710","rojo", 1978, "8493PRA", 10, cv2, u2, true, 300);
        
        //Aeronave 3
        Deposito d3 = new Deposito(450, 500, "Gas");
        ControlVelocidad cv3 = new ControlVelocidad(320, 4000, 600);
        Ubicacion u3 = new Ubicacion(-100, 200);
        Aeronave aeronave3 = new Aeronave(2, 10000, true, d1, "Oeing", "747","azul", 2010, "9382MFL", 2, cv3, u3, true, 700);
        
        //CocheEléctrico 1
        Bateria b1 = new Bateria(2500, 1000, false);
        ControlVelocidad cv4 = new ControlVelocidad(120, 1000, 500);
        Ubicacion u4 = new Ubicacion(590, 0);
        CocheElectrico ce1 = new CocheElectrico(b1, 5, 150000, "Model S", "Tesla", "blanco", 2014, "8454MFJ", 4, cv4, u4, true, 5);
        
        //CocheEléctrico 2
        Bateria b2 = new Bateria(4500, 900, false);
        ControlVelocidad cv5 = new ControlVelocidad(220, 2000, 350);
        Ubicacion u5 = new Ubicacion(102, 0);
        CocheElectrico ce2 = new CocheElectrico(b2, 5, 100000, "i4", "BMW", "negro", 2019, "1854RKM", 15, cv5, u5, true, 5);
        
        //CocheEléctrico 3
        Bateria b3 = new Bateria(5500, 5500, true);
        ControlVelocidad cv6 = new ControlVelocidad(102, 1000, 210);
        Ubicacion u6 = new Ubicacion(-504, 0);
        CocheElectrico ce3 = new CocheElectrico(b3, 3, 30000, "EV6", "KIA", "blanco", 2020, "4395KMD", 15, cv6, u6, true, 4);
        
        //CocheHibrido 1
        ControlVelocidad cv7 = new ControlVelocidad(102, 1000, 245);
        Ubicacion u7 = new Ubicacion(-301, 0);
        Deposito d4 = new Deposito(15, 50, "Diesel");
        CocheHibrido ch1 = new CocheHibrido(b1, d4, 5, 10000, "Corolla", "Toyota", "blanco", 2014, "4343POL", 20, cv7, u7, true, 5);
        
        //CocheHibrido 2
        ControlVelocidad cv8 = new ControlVelocidad(202, 3000, 359);
        Ubicacion u8 = new Ubicacion(145, 0);
        Deposito d5 = new Deposito(25, 70, "Diesel");
        CocheHibrido ch2 = new CocheHibrido(b2, d5, 5, 15000, "X-Trail", "Nissan", "negro", 2017, "9343ILD", 32, cv8, u8, true, 5);
        
        //CocheHibrido 3
        ControlVelocidad cv9 = new ControlVelocidad(92, 231000, 250);
        Ubicacion u9 = new Ubicacion(1750, 0);
        Deposito d6 = new Deposito(80, 80, "Diesel");
        CocheHibrido ch3 = new CocheHibrido(b3, d6, 5, 760000, "Niro", "KIA", "rojo", 2020, "9685ERE", 5, cv9, u9, true, 5);
        
        //CocheCombustion 1
        ControlVelocidad cv10 = new ControlVelocidad(0, 0, 250);
        Ubicacion u10 = new Ubicacion(1150, 0);
        Deposito d7 = new Deposito(23, 80, "Gasolina");
        CocheCombustion cc1 = new CocheCombustion(d7, 5, 125000, "Serie 2", "BMW", "blanco", 2018, "1292FLS", 1, cv10, u10, false, 5);
        
        //CocheCombustion 2
        ControlVelocidad cv11 = new ControlVelocidad(150, 2400, 350);
        Ubicacion u11 = new Ubicacion(-2150, 0);
        Deposito d8 = new Deposito(70, 88, "Gasolina");
        CocheCombustion cc2 = new CocheCombustion(d8, 5, 125000, "Clase C", "Mercedes-Benz", "blanco", 2020, "3922ODM", 8, cv11, u11, true, 5);
        
        //CocheCombustion 3
        ControlVelocidad cv12 = new ControlVelocidad(150, 3100, 190);
        Ubicacion u12 = new Ubicacion(-105, 0);
        Deposito d9 = new Deposito(10, 70, "Gasolina");
        CocheCombustion cc3 = new CocheCombustion(d9, 3, 125000, "Giulia", "Alfa Romeo", "rojo", 2015, "6576FCN", 3, cv12, u12, true, 2);
        
        //Los añado a una lista
        List<Vehiculo> allVehiculos = new ArrayList<>();
        allVehiculos.add(aeronave1);
        allVehiculos.add(aeronave2);
        allVehiculos.add(aeronave3);
        allVehiculos.add(ce1);
        allVehiculos.add(ce2);
        allVehiculos.add(ce3);
        allVehiculos.add(ch1);
        allVehiculos.add(ch2);
        allVehiculos.add(ch3);
        allVehiculos.add(cc1);
        allVehiculos.add(cc2);
        allVehiculos.add(cc3);
        
        
        //                                  Creo una lista con todos los coches incluidos sus subtipos.
        List<Coche> allCoches = new ArrayList<>();
        allCoches.add(ce1);
        allCoches.add(ce2);
        allCoches.add(ce3);
        allCoches.add(ch1);
        allCoches.add(ch2);
        allCoches.add(ch3);
        allCoches.add(cc1);
        allCoches.add(cc2);
        allCoches.add(cc3);
        
        //                                                      Pruebo los métodos de ordenación
        
        //Creo un objeto de ordenación
        Ordenacion o = new Ordenacion(allVehiculos, allCoches);
        
        //Pruebo el método de ordenar los vehículos por su velocidad
        System.out.println("\n");
        System.out.println("----- Vehiculos sin ordenar por velocidad: -----");
        for (int i=0; i<allVehiculos.size(); i++){
            System.out.println("Vehiculo: " + allVehiculos.get(i).getClass().getSimpleName() + " - Modelo: " + allVehiculos.get(i).getFabricante() + " " + allVehiculos.get(i).getModelo() + " - Velocidad: " + allVehiculos.get(i).getControlVelocidad().getVelocidad() + " km/h");
        }
       List<Vehiculo> vehiculosOrdenadosVelocidad;
        try {
            vehiculosOrdenadosVelocidad = o.ordenarVelocidad();
            System.out.println("----- Vehiculos ordenados por velocidad (de menor a mayor): -----");
            for (int i=0; i<vehiculosOrdenadosVelocidad.size(); i++){
                System.out.println("Vehiculo: " + vehiculosOrdenadosVelocidad.get(i).getClass().getSimpleName() + " - Modelo: " + vehiculosOrdenadosVelocidad.get(i).getFabricante() + " " + vehiculosOrdenadosVelocidad.get(i).getModelo() + " - Velocidad: " + vehiculosOrdenadosVelocidad.get(i).getControlVelocidad().getVelocidad() + " km/h");
            }
        } catch (Exception ex) {
            Logger.getLogger(EvaluacionInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Pruebo que el método de ordenar los coches eléctricos e híbridos por la carga de la batería
        System.out.println("\n");
        System.out.println("----- Coches sin ordenar por carga de la bateria: -----");
        for (Coche coche : allCoches) {
            if (coche instanceof CocheElectrico) {
                CocheElectrico cocheElectrico = (CocheElectrico) coche;
                System.out.println("Vehiculo: CocheElectrico - Modelo: " + cocheElectrico.getFabricante() + " " + cocheElectrico.getModelo() +
                        " - Carga de bateria: " + cocheElectrico.getBateria().getCargaActual() + " kWh");
            } else if (coche instanceof CocheHibrido) {
                CocheHibrido cocheHibrido = (CocheHibrido) coche;
                System.out.println("Vehiculo: CocheHibrido - Modelo: " + cocheHibrido.getFabricante() + " " + cocheHibrido.getModelo() +
                        " - Carga de bateria: " + cocheHibrido.getBateria().getCargaActual() + " kWh");
            }
        }
        System.out.println("----- Vehiculos ordenados por carga de bateria (de menor a mayor): -----");
        Ordenacion o2 = new Ordenacion(allVehiculos, allCoches);
        List<Coche> cochesOrdenadosBateria;
        
        try {
            cochesOrdenadosBateria = o2.ordenarBateria();
            
            for (Coche c : cochesOrdenadosBateria){
                if (c instanceof CocheElectrico) {
                CocheElectrico cocheElectrico = (CocheElectrico) c;
                System.out.println("Vehiculo: CocheElectrico - Modelo: " + cocheElectrico.getFabricante() + " " + cocheElectrico.getModelo() +
                        " - Carga de bateria: " + cocheElectrico.getBateria().getCargaActual() + " kWh");
            } else if (c instanceof CocheHibrido) {
                CocheHibrido cocheHibrido = (CocheHibrido) c;
                System.out.println("Vehiculo: CocheHibrido - Modelo: " + cocheHibrido.getFabricante() + " " + cocheHibrido.getModelo() +
                        " - Carga de bateria: " + cocheHibrido.getBateria().getCargaActual() + " kWh");
            }
            }
        } catch (Exception ex) {
            Logger.getLogger(EvaluacionInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Pruebo que el método de ordenar los vehículos por tipo de combustible en el orden "Gasolina","Diesel" y "Gas"
        System.out.println("\n");
        System.out.println("----- Vehiculos sin ordenar por tipo de combustible: -----");
        for (Vehiculo v : allVehiculos) {
            if (v instanceof CocheHibrido) {
                CocheHibrido cocheHibrido = (CocheHibrido) v;
                System.out.println("Vehiculo: CocheHibrido - Modelo: " + cocheHibrido.getFabricante() + " " + cocheHibrido.getModelo() +
                        " - Tipo de combustible: " + cocheHibrido.getDeposito().getTipoCombustible());
            } else if (v instanceof CocheCombustion) {
                CocheCombustion cocheCombustion = (CocheCombustion) v;
                System.out.println("Vehiculo: CocheCombustion - Modelo: " + cocheCombustion.getFabricante() + " " + cocheCombustion.getModelo() +
                        " - Tipo de combustible: " + cocheCombustion.getDeposito().getTipoCombustible());
            } else if (v instanceof Aeronave) {
                Aeronave aeronave = (Aeronave) v;
                System.out.println("Vehiculo: Aeronave - Modelo: " + aeronave.getFabricante() + " " + aeronave.getModelo() +
                        " - Tipo de combustible: " + aeronave.getDeposito().getTipoCombustible());
            }
        }
        System.out.println("----- Vehiculos ordenados por tipo de combustible: -----");
        Ordenacion o3 = new Ordenacion(allVehiculos, allCoches);
        List<Vehiculo> vehiculosOrdenadosCombustible;
        try {
            vehiculosOrdenadosCombustible = o3.ordenarTipoCombustible();
            for (Vehiculo v : vehiculosOrdenadosCombustible){
                if (v instanceof CocheHibrido cocheHibrido) {
                System.out.println("Vehiculo: CocheHibrido - Modelo: " + cocheHibrido.getFabricante() + " " + cocheHibrido.getModelo() +
                        " - Tipo de combustible: " + cocheHibrido.getDeposito().getTipoCombustible());
            } else if (v instanceof CocheCombustion cocheCombustion) {
                System.out.println("Vehiculo: CocheCombustion - Modelo: " + cocheCombustion.getFabricante() + " " + cocheCombustion.getModelo() +
                        " - Tipo de combustible: " + cocheCombustion.getDeposito().getTipoCombustible());
            } else if (v instanceof Aeronave aeronave) {
                System.out.println("Vehiculo: Aeronave - Modelo: " + aeronave.getFabricante() + " " + aeronave.getModelo() +
                        " - Tipo de combustible: " + aeronave.getDeposito().getTipoCombustible());
            }
            }
        } catch (Exception ex) {
            Logger.getLogger(EvaluacionInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Pruebo el método para ordenar los vehículos según la cantidad de pasajeros que caben
        System.out.println("\n");
        System.out.println("----- Vehiculos sin ordenar segun la cantidad de pasajeros que caben: -----");
        for (int i=0; i<allVehiculos.size(); i++){
            System.out.println("Vehiculo: " + allVehiculos.get(i).getClass().getSimpleName() + " - Modelo: " + allVehiculos.get(i).getFabricante() + " " + allVehiculos.get(i).getModelo() + " - Numero de pasajeros: " + allVehiculos.get(i).getCapacidadPasajeros());
        }
        System.out.println("----- Vehiculos ordenados segun la cantidad de pasajeros que caben: -----");
        Ordenacion o4 = new Ordenacion(allVehiculos, allCoches);
    
            
            List<Vehiculo> vehiculosOrdenadosPasajeros;

        try {
            vehiculosOrdenadosPasajeros = o4.ordenarPorPasajeros();
            
            for (Vehiculo v : vehiculosOrdenadosPasajeros){
                System.out.println("Vehiculo: " + v.getClass().getSimpleName() + " - Modelo: " + v.getFabricante() + " " + v.getModelo() + " - Pasajeros: " + v.getCapacidadPasajeros());
            }
        } catch (Exception ex) {
            Logger.getLogger(EvaluacionInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
   
        System.out.println("\n");
        //Pruebo el método para ordenar los vehículos según el año en el que fueron fabricados
        System.out.println("----- Vehiculos sin ordenar segun el año de fabricacion: -----");
        for (int i=0; i<allVehiculos.size(); i++){
            System.out.println("Vehiculo: " + allVehiculos.get(i).getClass().getSimpleName() + " - Modelo: " + allVehiculos.get(i).getFabricante() + " " + allVehiculos.get(i).getModelo() + " - Year: " + allVehiculos.get(i).getAñoFabricacion());
        }
        System.out.println("----- Vehiculos ordenados segun el año de fabricacion: -----");
        Ordenacion o5 = new Ordenacion(allVehiculos, allCoches);
        List<Vehiculo> vehiculosOrdenadosAño;
        try {
            vehiculosOrdenadosAño = o5.ordenarPorAño();
            
            for (int i=0; i<vehiculosOrdenadosAño.size(); i++){
            System.out.println("Vehiculo: " + allVehiculos.get(i).getClass().getSimpleName() + " - Modelo: " + allVehiculos.get(i).getFabricante() + " " + allVehiculos.get(i).getModelo() + " - Year: " + allVehiculos.get(i).getAñoFabricacion());
        }
        } catch (Exception ex) {
            Logger.getLogger(EvaluacionInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("---------------------------------------------------");
       

    }   
    
    
}
