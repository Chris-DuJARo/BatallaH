 

public class Marino {
    protected String nombre;
    private int rango;
    
    public String getName(){
        return nombre;
    }
    
    public void autoDestruccion(String instruccion){
        System.out.println("Me destrui porque mi nombre de instruccion es: " + instruccion);
    }
    
}
