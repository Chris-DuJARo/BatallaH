 public abstract class Maquina {
    private Ubicacion ubicacion;
    protected Flota flota;
    
    public Maquina(Flota flota){
        flota.setMaquina(this);
    }
    
    public void alNorte() throws BatallaNavalExcepcion{
        ubicacion.alNorte();
    }
    
    public void avance(int dLon, int dLan){
        ubicacion.avance(dLon, dLan);
    }
    
    public abstract boolean esDebil();
    
    public abstract boolean seranDestruidas(int longitud, int latitud);
    
    public abstract void autoDestruccion(String instruccion);
    
    public abstract boolean buscarMaquina(String instruccion);

    public boolean getCoordenadas(int longitud, int latitud){
        return ubicacion.getLatitud() == latitud && ubicacion.getLongitud() == longitud;      
    }
    
    public void ataquen(int lon, int lat){
        ubicacion.setLongitud(lon);
        ubicacion.setLatitud(lat);
    }
    
}
