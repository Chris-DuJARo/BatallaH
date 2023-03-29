 

public class Ubicacion {
    private int longitud;
    private int latitud;
    
    public void alNorte() throws BatallaNavalExcepcion{
        if (longitud <= 175 && longitud > 0){
            longitud += 5;
        }else{
            throw new BatallaNavalExcepcion("Bad operand at use of the method alNorte()\n one or more Maquina cannot move to north");
        }
    }
    
    public void avance(int dLon, int dLat){
        if (longitud + dLon <= 180 && longitud + dLon >= 0 && latitud + dLat <= 90 && latitud + dLat >= -90){
            longitud += dLon;
            latitud += dLat;
        }
    }
    
    public int getLongitud(){
        return longitud;
    }
    
    public int getLatitud(){
        return latitud;
    }
    
    public void setLatitud(int lat){
        latitud = lat;
    }
    
    public void setLongitud(int lon){
        longitud = lon;
    }
    
}
