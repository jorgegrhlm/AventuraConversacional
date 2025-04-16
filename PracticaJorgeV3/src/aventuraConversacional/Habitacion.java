package aventuraConversacional;

public class Habitacion extends Escenario{

    public Habitacion(String nombre, String descripcion) {
        super(nombre, descripcion);
       
    }

    public void menuFinal(Jugador jugador) {
		System.out.println(" ---------------------------------------------------------------------------------------------- \n");
		System.out.println(" *                                      FIN DEL JUEGO                                        * \n");
		System.out.println(" ---------------------------------------------------------------------------------------------- \n");
		jugador.derrota();
	}

}
