package aventuraConversacional;

public class Juego {
    private Jugador jugador;
    private Escenario escenarioActual;

    public void iniciarJuego() {
        System.out.println("Iniciando el juego...");
        System.out.println("-----------------------------------------------------");
        System.out.println("Bienvenido a 'Dungeons & Dragons' \nEl juego conversacional donde tu personaje enfrentará desafios a lo largo de 5 escenarios para rescatar a la Princesa.");
		System.out.println(" ---------------------------------------------------------------------------------------------- \r\n"
				        +      " *                                  INICIO DEL JUEGO                                          * \n"
				        +      " ---------------------------------------------------------------------------------------------- \n");
    }

    public void procesarComando(String comando) {
        System.out.println("Procesando comando: " + comando);
    }

    public void cambiarEscenario(Escenario nuevoEscenario) {
        this.escenarioActual = nuevoEscenario;
        this.escenarioActual.mostrarEscenario();
    }

    public Juego(Jugador jugador, Escenario escenarioInicial) {
        this.jugador = jugador;
        this.escenarioActual = escenarioInicial;
    }

    

    
}
