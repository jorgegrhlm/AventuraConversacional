package aventuraConversacional;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bosque extends Escenario {

    public Bosque(String nombre, String descripcion) {
        super(nombre, descripcion);
        
    }

    public void menuBosque(Jugador jugador) {
		Scanner sc = new Scanner(System.in);
		boolean opcionValida = false;
		while (!opcionValida) {
			try {
				System.out.println(" ---------------------------------------------------------------------------------------------- \n");
				System.out.println(" 1. Sacar la espada y luchar contra el oso. \r\n" + "\r\n" + " 2. Dar kit de comida y bebida al oso. \r\n" + "\r\n" + " 3. Salir huyendo del bosque");
				int respuesta = sc.nextInt();
				switch (respuesta) {
					case 1 -> {
						System.out.println(" ---------------------------------------------------------------------------------------------- \n");
						System.out.println("Perdiste! el oso es mas grande que tú y te asesinó\n");
						jugador.derrota();
						opcionValida = true;
					}
					case 2 -> {
						System.out.println(" ---------------------------------------------------------------------------------------------- \n");
						System.out.println("Alimentaste al oso y ganaste un fiel compañero de ruta.\n");
						Item itemAEliminar = null;
						for (Item item : jugador.getInventario()) {
							if (item.getNombre().equalsIgnoreCase("Comida-Bebida")) {
								itemAEliminar = item;
								break;
							}
						}

						if (itemAEliminar != null) {
							jugador.eliminarItem(itemAEliminar);
							System.out.println("Has usado el Kit de Comida-Bebida.\n");
						} else {
							System.out.println("No tienes un Kit de Comida-Bebida en tu inventario.");
						}

						opcionValida = true;
					}
					case 3 -> {
						System.out.println(" ---------------------------------------------------------------------------------------------- \n");
						System.out.println("Perdiste! el oso te alcanzó y te asesinó.\n");
						jugador.derrota();
						opcionValida = true;
					}

					default -> {
						System.out.println("Introduce una opción válida");
						menuBosque(jugador);
					}

				}
			} catch (InputMismatchException ime) {
				System.out.println("Debes ingresar un valor numerico");
				sc.nextLine();
			}
		}
	}
}
