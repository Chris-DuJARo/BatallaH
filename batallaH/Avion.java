import java.util.ArrayList;
import java.util.Arrays;

public class Avion extends Maquina{
    private String placa;
    protected boolean enAire;
    private Marino piloto;
    private Marino copiloto;
    
    public Avion(Flota flota,String placa, Marino piloto){
        super(flota);
        this.placa = placa;
        this.piloto = piloto;
    }
    
    public Marino getPiloto(){
        return piloto;
    }
    
    public boolean esDebil(){
        return(piloto == null);
    }
    
    public boolean seranDestruidas(int longitud, int latitud){
        if (getCoordenadas(longitud, latitud) ){
            return enAire != true;
        }else{
            return false;
        }
    }
    
    public boolean buscarMaquina(String instruccion){
        return(instruccion.equals(placa));
    }
    
    public void autoDestruccion(String instruccion){
        System.out.print("Me autoDestrui porque tengo la placa: "+ instruccion); 
    }
    
    
    public Marino pilotos(ArrayList marinos) throws BatallaNavalExcepcion{
        if (!Arrays.asList(marinos).contains(piloto)){
            throw new BatallaNavalExcepcion("Piloto No pertenece a esta flota");
        }
        
        else{
           return piloto; 
        }
    }
}