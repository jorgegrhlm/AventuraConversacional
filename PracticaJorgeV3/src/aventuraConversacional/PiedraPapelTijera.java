package aventuraConversacional;

import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera implements Minijuego {

    @Override
    public boolean jugar(Jugador jugador, NPC npc) {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        String respuestaMaquina;

        System.out.println("Juguemos piedra papel o tijera");
        System.out.println("Elige tu jugada: piedra, papel o tijera");
        respuesta = sc.nextLine().toLowerCase();
        while (!(respuesta.equals("piedra") || respuesta.equals("papel") || respuesta.equals("tijera"))) {
            System.out.println("Por favor ingresa una opcion valida");
            respuesta = sc.nextLine().toLowerCase();
        }
        Random random = new Random();
        int resultado = random.nextInt(3);
        switch (resultado) {
            case 0:
                respuestaMaquina = "piedra";
                break;
            case 1:
                respuestaMaquina = "papel";
                break;
            case 2:
                respuestaMaquina = "tijera";
                break;
            default:
                respuestaMaquina = "tijera";
                break;
        }
        System.out.println("Yo elegi: " + respuestaMaquina);
        if (respuesta.equals(respuestaMaquina)) {
            System.out.println("Empate");
            return jugar(jugador, npc);
        } else if ((respuesta.equals("piedra") && respuestaMaquina.equals("tijera")) ||
                (respuesta.equals("papel") && respuestaMaquina.equals("piedra")) ||
                (respuesta.equals("tijera") && respuestaMaquina.equals("papel"))) {
            System.out.println("¡Ganaste!");
            return true;
        } else {
            System.out.println("¡Perdiste!");
            return false;
        }
    }
}
