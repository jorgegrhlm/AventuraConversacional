package aventuraConversacional;

import java.util.Scanner;

public class Ahorcado implements Minijuego {

    @Override
    public boolean jugar(Jugador jugador, NPC npc) {
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "flecha";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " ("
                    + palabraSecreta.length() + " letras)");
            System.out.println("Introduce una letra, por favor");

            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos.");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                System.out.println("¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
                
                palabraAdivinada = true;
            }

        }

        if (!palabraAdivinada) {
            System.out.println(" ¡Qué pena te has quedado sin intentos! GAME OVER");
        }

        scanner.nextLine();
        return palabraAdivinada;
    }
}
