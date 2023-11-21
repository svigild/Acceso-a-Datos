package evaluacioninicial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ordenacion {
    
    private List<Vehiculo> listaVehiculos;
    private List<Coche> listaCoches;

    public Ordenacion(List<Vehiculo> listaVehiculos, List<Coche> listaCoches) {
        this.listaVehiculos = listaVehiculos;
        this.listaCoches = listaCoches;
    }
    
    public List<Vehiculo> ordenarVelocidad() throws Exception {
        if (listaVehiculos.isEmpty()){
            throw new Exception("La lista está vacía.");
        }
        
        Comparator <Vehiculo> comparatorVelocidad = (Vehiculo v1, Vehiculo v2) -> (int) (v1.getControlVelocidad().getVelocidad() - v2.getControlVelocidad().getVelocidad());
                
        listaVehiculos.sort(comparatorVelocidad);
        return listaVehiculos;
    }

    public List<Coche> ordenarBateria() throws Exception {
        if (listaCoches.isEmpty()){
            throw new Exception("La lista está vacía.");
        }
        
        List<Coche> electricosOHibridos = new ArrayList<>();

        for (Coche vehiculo : listaCoches) {
            if (vehiculo instanceof CocheElectrico || vehiculo instanceof CocheHibrido) {
                electricosOHibridos.add(vehiculo);
            }
        }

        Comparator<Coche> comparatorBateria = (coche1, coche2) -> {
        if (coche1 instanceof CocheElectrico && coche2 instanceof CocheElectrico) {
            double bateria1 = ((CocheElectrico) coche1).getBateria().getCargaActual();
            double bateria2 = ((CocheElectrico) coche2).getBateria().getCargaActual();
            return (int) (bateria1 - bateria2);
        } else if (coche1 instanceof CocheHibrido && coche2 instanceof CocheHibrido) {
            double bateria1 = ((CocheHibrido) coche1).getBateria().getCargaActual();
            double bateria2 = ((CocheHibrido) coche2).getBateria().getCargaActual();
            return (int) (bateria1 - bateria2);
        } else if (coche1 instanceof CocheElectrico && coche2 instanceof CocheHibrido) {
            double bateria1 = ((CocheElectrico) coche1).getBateria().getCargaActual();
            double bateria2 = ((CocheHibrido) coche2).getBateria().getCargaActual();
            return (int) (bateria1 - bateria2);
        } else if (coche1 instanceof CocheHibrido && coche2 instanceof CocheElectrico) {
            double bateria1 = ((CocheHibrido) coche1).getBateria().getCargaActual();
            double bateria2 = ((CocheElectrico) coche2).getBateria().getCargaActual();
            return (int) (bateria1 - bateria2);
        }
        return 0;
        };

        listaCoches.sort(comparatorBateria);
        return listaCoches;
                
    }



    public List<Vehiculo> ordenarTipoCombustible() throws Exception {
        if (listaVehiculos.isEmpty()){
            throw new Exception("La lista está vacía.");
        }
        
        Comparator<Vehiculo> comparatorCombustible = (v1, v2) -> {
        if (v1 instanceof CocheCombustion && v2 instanceof CocheCombustion) {
            String tipo1 = ((CocheCombustion) v1).getDeposito().getTipoCombustible();
            String tipo2 = ((CocheCombustion) v2).getDeposito().getTipoCombustible();
            return tipo1.compareTo(tipo2);
        } else if (v1 instanceof CocheHibrido && v2 instanceof CocheHibrido) {
            String tipo1 = ((CocheHibrido) v1).getDeposito().getTipoCombustible();
            String tipo2 = ((CocheHibrido) v2).getDeposito().getTipoCombustible();
            return tipo1.compareTo(tipo2);
        } else if (v1 instanceof Aeronave && v2 instanceof Aeronave) {
            String tipo1 = ((Aeronave) v1).getDeposito().getTipoCombustible();
            String tipo2 = ((Aeronave) v2).getDeposito().getTipoCombustible();
            return tipo1.compareTo(tipo2);
        } else {
            return 0;
        }
        };

        listaVehiculos.sort(comparatorCombustible);  
 
        return listaVehiculos;
    }

    

    public List<Vehiculo> ordenarPorPasajeros() throws Exception {
        
        if (listaVehiculos.isEmpty()){
            throw new Exception("La lista está vacía.");
        }
        
        Comparator <Vehiculo> comparatorPasajeros = (Vehiculo v1, Vehiculo v2) ->  v1.getCapacidadPasajeros() - v2.getCapacidadPasajeros();
                
        listaVehiculos.sort(comparatorPasajeros);
        return listaVehiculos;
    }

    public List<Vehiculo> ordenarPorAño() throws Exception {
        
        if (listaVehiculos.isEmpty()){
            throw new Exception("La lista está vacía.");
        }
        
        Comparator <Vehiculo> comparatorAño = (Vehiculo v1, Vehiculo v2) ->  v1.getAñoFabricacion() - v2.getAñoFabricacion();
                
        listaVehiculos.sort(comparatorAño);
        return listaVehiculos;
    }
}
