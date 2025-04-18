package aventuraConversacional;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sotano extends Escenario{

    public Sotano(String nombre, String descripcion) {
        super(nombre, descripcion);
      
    }

    public void charlaDragon(Jugador jugador, NPC npc) {
		Scanner sc = new Scanner(System.in);
		boolean opcionValida = false;
		while (!opcionValida) {
			try {
				System.out.println(" Escribe 'J' para hacer el juego ó escribe 'L' para luchar:\n");
				String respuesta = sc.next();
				respuesta = respuesta.toUpperCase();
				switch (respuesta) {
					case "J" -> {
						Decision decision = new Decision("Sotano", " J. ");
						RegistroDecision.guardarDecision(decision);
						System.out.println(
								" ---------------------------------------------------------------------------------------------- \n");
						System.out.println("Aqui está el juego. TRES EN RAYA. Tu serás la 'X' y yo la 'O'\n");
						TresEnRaya tresEnRaya = new TresEnRaya();
						boolean gano = tresEnRaya.jugar(jugador, npc);
						if (gano) {
							System.out.println("¡Felicidades! has ganado, puedes ingresar al castillo.");

						} else {
							System.out.println("PERDISTE! GAME OVER.");
							jugador.derrota();
						}
						opcionValida = true;
					}
					case "L" -> {
						Decision decision = new Decision("Sotano", " L. ");
						RegistroDecision.guardarDecision(decision);
						System.out.println(" ---------------------------------------------------------------------------------------------- \n");
						System.out.println(" ¡Perdiste! El dragon es mas fuerte que tu.\n");
						jugador.derrota();
						opcionValida = true;
					}
					default -> {
						System.out.println("Introduce una opción válida");
						charlaDragon(jugador, npc);
					}

				}
			} catch (InputMismatchException ime) {
				System.out.println("Debes ingresar un valor numerico");
				sc.nextLine();
			}
		}
	}

}
