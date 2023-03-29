import java.util.ArrayList;

public class Capsula extends Maquina
{
    private boolean esNodriza;
    private int profundidad;
    private Maquina nodriza;
    private ArrayList<Capsula> naves;
    
    public Capsula(Flota flota, Barco nodriza){
        super(flota);
        this.nodriza = nodriza;
    }
    
    public Capsula(Flota flota,Capsula nodriz){
        super(flota);
        this.nodriza = nodriz;
        nodriz.soyNodriza(this);
    }
    
    private void soyNodriza(Capsula nodriza){
        naves.add(nodriza);
        esNodriza = true;
    }
    
    public int getProfundidad(){
        return profundidad;    
    }
    
    public void setProfundidad(int profundidad){
        this.profundidad = profundidad;
    }
    
    public boolean buscarMaquina(String instruccion){
        return nodriza.buscarMaquina(instruccion);
    }
    
    public boolean seranDestruidas(int longitud, int latitud){
        return getCoordenadas(longitud, latitud);
    }
    
    public boolean esDebil(){
        return getProfundidad() <8000;
    }
    
    public void autoDestruccion(String instruccion){
        if(esNodriza){
            
            for(Capsula e: naves){
                e.autoDestruccion(instruccion);
            }
            
        }
        System.out.println("Me destrui porque mi nodriza con numero de instruccion: " + instruccion + "\nseautodestruyo");
    }
    
    
    
}
