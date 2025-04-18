package aventuraConversacional;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Castillo extends Escenario {

    public Castillo(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    public void entradaCastillo(Jugador jugador, NPC npc) {
        boolean opcionValida = false;
        while (!opcionValida) {
            Scanner sc = null;
            try {
                System.out.println(" ---------------------------------------------------------------------------------------------- \n");
                System.out.println("1. Enfrentarte al minotauro." + "\n" + "2. Llamar al oso para que se encargue del minotauro.\n");
                sc = new Scanner(System.in);
                int respuesta = sc.nextInt();
                switch (respuesta) {
                    case 1 -> {
                        Decision decision = new Decision("Castillo", "Enfrentarte al minotauro.");
                        RegistroDecision.guardarDecision(decision);
                        System.out.println(" ---------------------------------------------------------------------------------------------- \n");
                        System.out.println("El minotauro te ha retado a que lo venzas en un juego de Piedra, Papel o Tijeras.\n");
                        PiedraPapelTijera piedraPapelTijera = new PiedraPapelTijera();
                        boolean gano = piedraPapelTijera.jugar(jugador, npc);

                        if (gano) {
                            System.out.println("¡Felicidades! has ganado, puedes ingresar al castillo.\n");
                        } else {
                            System.out.println("PERDISTE! GAME OVER.");
                            jugador.derrota();
                        }
                        opcionValida = true;
                    }
                    case 2 -> {
                        Decision decision = new Decision("Castillo", "Llamar al oso para que se encargue del minotauro.");
                        RegistroDecision.guardarDecision(decision);
                        System.out.println(" ---------------------------------------------------------------------------------------------- \n");
                        System.out.println("Continúa la misión mientras el oso pelea con el minotauro.\n");
                        opcionValida = true;
                    }
                    default -> {
                        System.out.println(" Introduce una opción válida");
                    }
                }
            } catch (InputMismatchException ime) {
                System.out.println("Debes ingresar un valor numerico");
                sc.nextLine();
            }
        }
    }
}



