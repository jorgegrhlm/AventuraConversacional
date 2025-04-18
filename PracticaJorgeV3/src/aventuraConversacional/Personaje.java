package aventuraConversacional;

public abstract class Personaje {
    private String nombre;
    private int vida;

    public Personaje(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void modificarVida(int cantidad) {
        this.vida += cantidad;
        if (this.vida<0){
            this.vida=0;
        }
    }
}
