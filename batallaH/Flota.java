 import java.util.ArrayList;

public class Flota {
    
    private Tablero tablero;
    private String nombre;
    private ArrayList<Marino> marinos;
    private ArrayList<Maquina> maquinas; 
    private ArrayList<Capsula> capsulas;
    private ArrayList<Maquina> autoDestruidas; 
    
    public Flota(Tablero tb, String nombre){
        tablero = tb;
        tb.setFlota(this);
        this.nombre = nombre; 
    }
    
    public void setMaquina(Maquina e){
        maquinas.add(e);
    }
    
    public ArrayList<Maquina> maquinasDebiles(){
        ArrayList<Maquina> debiles = new ArrayList();
        for (Maquina e: maquinas){
            if(e.esDebil()){
                debiles.add(e);
            }
            
        }        
        return debiles;
    }
    
    public void ataquen(int lon, int lat){
        for (Maquina e: maquinas){
            if(e.esDebil() != false){
                e.ataquen(lon,lat);
            }
        }
    }
    
    public void alNorte(){
        for(Maquina e: maquinas){
            try
            {
                e.alNorte();
            }
            catch (BatallaNavalExcepcion bne)
            {
                bne.getMessage();
            }
        } 
    }
    
    public void avance(int dLon, int dLat){
        for (Maquina e: maquinas){
            e.avance(dLon, dLat);
        }
    }
    
    public ArrayList<Maquina> seranDestruidas(int longitud, int latitud){
    ArrayList<Maquina> destruidas = new ArrayList();
    for (Maquina e: maquinas){
        if (e.seranDestruidas(longitud, latitud) ){
           destruidas.add(e); 
        }
    }
    return destruidas;
    }
    
    public boolean esBuenAtaque(int longitud, int latitud){
        ArrayList <Maquina> misMaquinas = seranDestruidas(longitud, latitud);

        return misMaquinas.size() == 0;
    }
    
    public void autoDestruccionMarino(String instruccion){
        for (Marino e: marinos){
            if(instruccion == e.nombre){
                e.autoDestruccion(instruccion); 
                marinos.remove(e);
            }
        }
    }
    
    public void autoDestruccion(String instruccion){
        for (Maquina e: maquinas){
            if (e.buscarMaquina(instruccion)){
                e.autoDestruccion(instruccion);
                maquinas.remove(e);
            }    
        }
    }
    
    public ArrayList<Marino> pilotos(){
        ArrayList<Marino> pilotos = new ArrayList<Marino>();
        for (Maquina e: maquinas){
            if (e instanceof Barco){
                try
                {
                    Marino piloto = ((PortaAviones)e).pilotos(marinos);
                    pilotos.add(piloto);
                }
                catch (BatallaNavalExcepcion bne)
                {
                    bne.getMessage();
                }
            }
        }
        return pilotos;
    }
    
    public int potencia(){
        try
        {
            contarMarinos();
            return maquinas.size() - maquinasDebiles().size();
        }
        catch (BatallaNavalExcepcion bne)
        {
            bne.getMessage();
        }
        return 0;
    }
    
    public boolean contarMarinos() throws BatallaNavalExcepcion{
        if (maquinas.size() > marinos.size()){
            throw new BatallaNavalExcepcion("Hay mas marinos que maquinas en la flota");
        }else{
            return true;
        }
    }
    
    
}
