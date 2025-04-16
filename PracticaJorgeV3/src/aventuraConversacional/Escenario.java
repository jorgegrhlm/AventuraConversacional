package aventuraConversacional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Escenario {
    private String nombre;
    private String descripcion;
    private List<NPC> npcs;
    private List<Minijuego> miniJuegos;

        public Escenario(String nombre, String descripcion) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.npcs = new ArrayList<>();
            this.miniJuegos = new ArrayList<>();
        }

    
        public void mostrarEscenario() {
            System.out.println(nombre);
            System.out.println(descripcion);
        }

        public void obtenerSiguienteEscenario() {
            System.out.println("\nPresiona 'C' para continuar:");
            Scanner sc=new Scanner(System.in);
            String respuesta = sc.nextLine().toLowerCase();
    
            while (!respuesta.equals("c")) {
                System.out.println("Ingresa una letra válida:");
                respuesta = sc.nextLine().toLowerCase();
            }
        }
                
        
    

        public void agregarNPC(NPC npc) {
            npcs.add(npc);
        }

        public void agregarMinijuego(Minijuego minijuego) {
            miniJuegos.add(minijuego);
        }


        public String getNombre() {
            return nombre;
        }


        public String getDescripcion() {
            return descripcion;
        }


        public List<NPC> getNpcs() {
            return npcs;
        }


        public List<Minijuego> getMiniJuegos() {
            return miniJuegos;
        }
    }
