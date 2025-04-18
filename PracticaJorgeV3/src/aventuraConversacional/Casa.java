package aventuraConversacional;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Casa extends Escenario {

	public Casa(String nombre, String descripcion) {
		super(nombre, descripcion);
	}

	public void misionAceptada(Jugador jugador) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println(" ---------------------------------------------------------------------------------------------- ");
		System.out.println(" 1. Aceptar la misión y continuar. \r\n" + "\r\n" + " 2. Ser rebelde y rechazar la misión.");
		System.out.println(" ---------------------------------------------------------------------------------------------- ");
		boolean opcionValida = false;
		while (!opcionValida) {
			try {
				int misionAceptada = sc1.nextInt(); // Leer opción
				switch (misionAceptada) {
					case 1 -> {
						System.out.println(" ---------------------------------------------------------------------------------------------- ");
						System.out.println("Muy bien, hasta luego. Suerte en tu misión.");
						System.out.println("No olvides llevar todo lo necesario para esta misión.");
						Decision decision = new Decision("Casa", "Aceptar la misión y continuar.");
						RegistroDecision.guardarDecision(decision);

						opcionValida = true;
					}
					case 2 -> {
						System.out.println("¡PERDISTE! El mensajero se ha molestado y te asesinó."+ "\n" );
						Decision decision = new Decision("Casa", "Ser rebelde y rechazar la misión.");
						RegistroDecision.guardarDecision(decision);
						RegistroDecision.mostrarHistorial();
						jugador.derrota();
						opcionValida = true;


					}
					default -> System.out.println("Introduce una opción válida.");
				}
			} catch (InputMismatchException ime) {
				System.out.println("Debes ingresar un valor numerico");
				sc1.nextLine();
			}
		}
	}

	public void menuMisionAceptada(Jugador jugador) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ---------------------------------------------------------------------------------------------- ");
		System.out.println(" 1. Revisar inventario. \r\n" + "\r\n" + " 2. Ir a la tienda por las cosas necesarias. \r\n");
		System.out.println(" ---------------------------------------------------------------------------------------------- ");
		boolean opcionValida = false;
		while (!opcionValida) {
			try {
				int opcion = sc.nextInt(); // Leer opción
				switch (opcion) {
					case 1 -> {
							Decision decision = new Decision("Casa", "Revisar inventario");
							RegistroDecision.guardarDecision(decision);
							jugador.mostrarInventario();
					}
					case 2 -> {
							System.out.println("¡PERDISTE! El mensajero se ha molestado y te asesinó.");
							jugador.derrota();
							opcionValida = true;
					}
					default -> System.out.println("Introduce una opción válida.");
				}
			} catch (InputMismatchException ime) {
				System.out.println("Debes ingresar un valor numerico");
				sc.nextLine();
			}
		}
	}
	public void menuMisionAceptada2(Casa casa, Jugador jugador) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ---------------------------------------------------------------------------------------------- ");
		System.out.println(" 1. Revisar inventario. \r\n" + "\r\n" + " 2. Ir a la tienda por las cosas necesarias. \r\n");
		System.out.println(" ---------------------------------------------------------------------------------------------- ");
		boolean opcionValida = false;
		while (!opcionValida) {
			try {
				int opcion = sc.nextInt(); // Leer opción
				switch (opcion) {
                    case 1 -> {
						Decision decision = new Decision("Casa", "Revisar inventario");
						RegistroDecision.guardarDecision(decision);
                        jugador.mostrarInventario();
                        casa.menuMisionAceptada2(casa,jugador);
                    }
                    case 2 -> {
						Decision decision = new Decision("Casa", "Ir a la tienda por las cosas necesarias.");
						RegistroDecision.guardarDecision(decision);
						casa.obtenerSiguienteEscenario();
					}
					default -> System.out.println("Introduce una opción válida.");
				}
			} catch (InputMismatchException ime) {
				System.out.println("Debes ingresar un valor numerico");
				sc.nextLine();
			}
		}
	}
}
