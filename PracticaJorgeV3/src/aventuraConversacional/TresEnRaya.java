package aventuraConversacional;

import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.Scanner;

public class TresEnRaya implements Minijuego {

    @Override
    public boolean jugar(Jugador jugador, NPC npc) throws ArrayIndexOutOfBoundsException {
        char mat[][] = new char[3][3];
        Scanner sc = new Scanner(System.in);
        String jugador1 = jugador.getNombre();
        String jugador2 = "Dragon";

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = '-';
            }
        }

        char player = 'x';
        String jugadorActual = jugador1;
        int turnos = 0;
        boolean hayGanador = false;

        while (turnos < 9 && !hayGanador) {
            int fila = -1, columna = -1;
            boolean entradaValida = false;

            while (!entradaValida) {
                try {
                    System.out.println(jugadorActual + " (" + player + "), ¿dónde quieres poner tu ficha?");
                    System.out.print("Indica la fila (0-2): ");
                    fila = sc.nextInt();
                    System.out.print("Indica la columna (0-2): ");
                    columna = sc.nextInt();

                    if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
                        throw new ArrayIndexOutOfBoundsException("Movimiento inválido, fuera de rango.");
                    }

                    if (!pintar(fila, columna, mat, player)) {
                        continue;
                    }

                    entradaValida = true;

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (InputMismatchException ime) {
                    System.out.println("Entrada inválida. Introduce un número entre 0 y 2.");
                    sc.next();
                }
            }

            turnos++;
            mostrar(mat);

            if (filas(mat, player) || columnas(mat, player) || diagonal(mat, player) || diagonalInversa(mat, player)) {
                System.out.println("¡" + jugadorActual + " ha ganado!");
                hayGanador = true;
            } else if (turnos == 9) {
                System.out.println("¡Empate! No hay más movimientos posibles.");
            } else {
                player = (player == 'x') ? 'o' : 'x';
                jugadorActual = (jugadorActual.equals(jugador1)) ? jugador2 : jugador1;
            }
        }

        return hayGanador;
    }

    public static boolean diagonalInversa(char mat[][], char jugador) {
        return mat[0][2] == jugador && mat[1][1] == jugador && mat[2][0] == jugador;
    }

    public static boolean diagonal(char mat[][], char jugador) {
        return mat[0][0] == jugador && mat[1][1] == jugador && mat[2][2] == jugador;
    }

    public static boolean columnas(char mat[][], char jugador) {
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[0][j] == jugador && mat[1][j] == jugador && mat[2][j] == jugador) {
                return true;
            }
        }
        return false;
    }

    public static boolean filas(char mat[][], char jugador) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][0] == jugador && mat[i][1] == jugador && mat[i][2] == jugador) {
                return true;
            }
        }
        return false;
    }

    public static boolean pintar(int fila, int columna, char mat[][], char jugador) {
        if (mat[fila][columna] == '-') {
            mat[fila][columna] = jugador;
            return true;
        } else {
            System.out.println("Movimiento incorrecto, esa casilla ya está ocupada.");
            return false;
        }
    }

    public static void mostrar(char mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

    
