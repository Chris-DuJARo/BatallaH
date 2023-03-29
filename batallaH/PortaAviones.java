import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class PortaAviones extends Barco{
    private int capacidad;
    private ArrayList<Avion> aviones;
    
    public PortaAviones(Flota flota,int numero,int capacidad){
        super(flota,numero);
        this.capacidad = capacidad;
    }
    
    
    public boolean esDebil(){
        if(super.esDebil() || enAire()){
            return true;
        }
        return false;
    }
    
    public boolean enAire(){
        for(Avion e: aviones){
            if(e.enAire == true){
                return e.enAire;
            }
        }return false;
    }
    
    public boolean seranDestruidas(int longitud, int latitud){
        return(super.getCoordenadas(longitud, latitud));
    }
    
    public Marino pilotos(ArrayList marinos) throws BatallaNavalExcepcion{
        for (Avion e: aviones){
            if (!Arrays.asList(this.marinos).contains(e.getPiloto())){
                throw new BatallaNavalExcepcion("Un piloto de uno de los aviones no pertenece a el portaAvion con numero: " + numero);
                
            }else if(seRepiten()){
                throw new BatallaNavalExcepcion("Un piloto esta asignado a mas de un avion");
            }else{
                return e.pilotos(marinos);
            }
        }
        return null;
    }
    
    public boolean seRepiten(){
        ArrayList<String> nombres = new ArrayList<String>();
        
        for (Avion e: aviones){
            nombres.add(e.getPiloto().getName());
        }
        
        for(String e: nombres){
            if(Collections.frequency(nombres, e) > 1){
                return true;
            }else{
                return false;
            }
        }
    return false;
    }
}

