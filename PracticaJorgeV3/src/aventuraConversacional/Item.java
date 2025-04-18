package aventuraConversacional;

public class Item {
    private String nombre;
    private String descripcion;
    private int cantidad;

    public Item(String nombre, String descripcion, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad=cantidad;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void usar(Jugador jugador) {
        
    }

}
