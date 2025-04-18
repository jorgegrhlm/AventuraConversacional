package aventuraConversacional;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Jugador extends Personaje {
    private ArrayList<Item> inventario;
    

    public Jugador(String nombre, int vida, List<Item> inventario) {
        super(nombre, vida);
        this.inventario = new ArrayList<>();
    }

    public void agregarItem(Item item){
        inventario.add(item);
    }

    public void eliminarItem(Item item){
        inventario.remove(item);
    }

    public void mostrarInventario() {
        System.out.println("\nMostrando inventario:");
        if (inventario.isEmpty()){
            System.out.println(" ---------------------------------------------------------------------------------------------- ");
            System.out.println("Inventario vacio!");
            System.out.println(" ---------------------------------------------------------------------------------------------- ");

        }

        for (Item item : inventario) {
               System.out.println(" ---------------------------------------------------------------------------------------------- ");
               System.out.println("*"+item.getNombre()+":"+" "+item.getDescripcion()+" "+"("+item.getCantidad()+")");
               System.out.println(" ---------------------------------------------------------------------------------------------- ");
           
           
        }
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public Item getItem(int i) {
        return inventario.get(i);
    }
    public void mostrarInventario2(Casa casa, Jugador jugador) {
        System.out.println("\nMostrando inventario:");
        if (inventario.isEmpty()){
            System.out.println(" ---------------------------------------------------------------------------------------------- ");
            System.out.println("Inventario vacio!");
            System.out.println(" ---------------------------------------------------------------------------------------------- ");
            casa.menuMisionAceptada2(casa, jugador);
        }

        for (Item item : inventario) {
            System.out.println(" ---------------------------------------------------------------------------------------------- ");
            System.out.println("*"+item.getNombre()+":"+" "+item.getDescripcion()+" "+"("+item.getCantidad()+")");
            System.out.println(" ---------------------------------------------------------------------------------------------- ");


        }
    }

    public List<Item> getInventario2() {
        return inventario;
    }

    public Item getItem2(int i) {
        return inventario.get(i);
    }

    public void derrota() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¡Has perdido!");
        System.out.println("==== Historial de Decisiones ====");
        RegistroDecision.mostrarHistorial();

        System.out.println("1. Volver a jugar");
        System.out.println("2. Salir del juego");


        int opcion = 0;

        while (true) {
            try {
                System.out.print("Elige una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                if (opcion == 1) {
                    System.out.println("Reiniciando juego...");
                    Main.main(null);
                    break;
                } else if (opcion == 2) {
                    System.out.println("Saliendo del juego...");
                    System.exit(0);
                } else {
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Debes ingresar un valor numerico.");
                sc.nextLine();
            }
        }
    }



}
