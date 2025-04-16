package aventuraConversacional;

public class NPC extends Personaje {
    private String dialogo;


    public NPC(String nombre, int vida, String dialogo) {
            super(nombre, vida);
            this.dialogo=dialogo;
           
        }
    
    public void interactuar(Jugador jugador) {
        System.out.println(getNombre()+": ");
        System.out.println(dialogo);
    }
}
