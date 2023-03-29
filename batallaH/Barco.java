
import java.util.ArrayList;

public class Barco extends Maquina{
    protected int numero;
    private ArrayList<Capsula> naves;
    protected ArrayList<Marino> marinos;
    
    public Barco(Flota flota, int numero){
        super(flota);
        this.numero = numero; 
    }
    
    public boolean esDebil(){
        return (marinos.size()<5);
    }
    
    public boolean buscarMaquina(String instruccion){
        
        if (Integer.parseInt(instruccion) == numero){
            flota = null;
            return true;
        }else return false;
        
    }
    
    public boolean seranDestruidas(int longitud, int latitud){
        return getCoordenadas(longitud, latitud);
    }
    
    public void autoDestruccion(String instruccion){
        for(Capsula e: naves){
            e.autoDestruccion(instruccion);
        }
        
        System.out.println("Me destrui porque mi numero de instruccion es: " + instruccion);
    }
    
}
