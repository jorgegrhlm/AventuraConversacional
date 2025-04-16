package aventuraConversacional;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tienda extends Escenario {

    private static int dinero = 0;
    
        public Tienda(String nombre, String descripcion) {
            super(nombre, descripcion);
           
        }
    
        public void menuPedirTodo(Jugador jugador, NPC npc) {
            System.out.println(" ---------------------------------------------------------------------------------------------- \n");
            System.out.println(" 1. Pedir uno de cada cosa. \r\n");
            System.out.println(" ---------------------------------------------------------------------------------------------- \n");
            Scanner sc = new Scanner(System.in);
            boolean opcionValida = false;
            while (!opcionValida) {
                try {
                    int menuTienda = sc.nextInt();
                    switch (menuTienda) {

                        case 1 -> {
                            System.out.println(" ---------------------------------------------------------------------------------------------- \n");
                            System.out.println("Perfecto aqui tiene, son 5 monedas de oro.\r\n");
                            System.out.println(" ---------------------------------------------------------------------------------------------- \n");
                            menuPago(jugador, npc);
                            opcionValida = true;

                        }

                        default -> {
                            System.out.println(" Introduce una opción válida");
                            menuPedirTodo(jugador, npc);
                        }

                    }
                } catch (InputMismatchException ime) {
                    System.out.println("Debes ingresar un valor numerico");
                    sc.nextLine();
                }
            }
            
        }

    public void menuPago(Jugador jugador, NPC npc) {
        Scanner sc = new Scanner(System.in);
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                System.out.println(" 1. Pagar.\r\n" + "\r\n" + " 2. Decirle al vendedor que no tienes dinero.\r\n" + "\r\n" + " 3. Robar la tienda");
                System.out.print("Elige una opción: ");
                int opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1 -> {
                        System.out.println(" ---------------------------------------------------------------------------------------------- \n");
                        revisarDinero(jugador, npc);
                        opcionValida = true;
                    }
                    case 2 -> {
                        System.out.println(" ---------------------------------------------------------------------------------------------- \n");
                        System.out.println("Preferiría el dinero, pero como lo necesitas, te entrego todo si me adivinas la palabra que tengo en mente:\n");
                        System.out.println("La palabra que tengo en mente se puede decir que es una munición. \r\n ");

                        Ahorcado ahorcado = new Ahorcado();
                        boolean gano = ahorcado.jugar(jugador, npc);
                        if (gano) {
                            System.out.println("¡Te llevas los objetos gratis!");

                        } else {
                            System.out.println("Lo siento, no adivinaste la palabra. No te puedo dar los objetos.");
                        }
                        opcionValida = true;
                    }
                    case 3 -> {
                        System.out.println(" ---------------------------------------------------------------------------------------------- \n");
                        System.out.println("¡Perdiste! Te asesina el vendedor por intentar robarlo.");
                        jugador.derrota();
                        opcionValida = true;
                    }
                    default -> System.out.println("Introduce una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un valor numerico");
                sc.nextLine();
            }
        }
    }
    
    public void revisarDinero(Jugador jugador, NPC npc) {
            if (dinero <= 0) {
                System.out.println("No tienes monedas!!!.\n");
                System.out.println(" ---------------------------------------------------------------------------------------------- \n");
        	    menuPago(jugador, npc);

		    } else {
			    System.out.println("---------------------------------------------------------------------------------------------- \n");
			    System.out.println("pagaste");
            }
	}

}
