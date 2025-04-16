package aventuraConversacional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Item> inventario = new ArrayList<>();

        Jugador jugador = new Jugador("Heroe", 100, inventario);
        Casa casa = new Casa("*CASA*", "Estas tranquilo en tu casa cuando el Mensajero del rey toca tu puerta!\n");
        NPC mensajero = new NPC("*MENSAJERO*", 100, "Hola! necesitamos de tu ayuda para salvar a la princesa Fiona.\r\n" + "La pricnesa se encuentra en un castillo, bajo la custodia de un dragon.");
        Juego juego = new Juego(jugador, casa);
        juego.iniciarJuego();
        casa.mostrarEscenario();
        mensajero.interactuar(jugador);
        casa.misionAceptada(jugador);
        jugador.mostrarInventario();
        casa.obtenerSiguienteEscenario();

        Tienda tienda = new Tienda("*TIENDA*", "Perfecto, estás dentro de la tienda del pueblo. Aquí encontrarás lo necesario para tu misión.. te atenderá el vendedor.\n");
        NPC vendedor = new NPC("*VENDEDOR*", 100, "Hola, tenemos disponible:\n* Espadas. \n* Escudos. \n* Kit de comida-bebida. \n* Kit de recuperacion. \r\n");
        Item espada = new Item("Espada", "para luchar", 1);
        Item escudo = new Item("Escudo", "para protegerte", 1);
        Item kitComida = new Item("Comida-Bebida", "para aumentar energia", 1);
        Item kitRecuperacion = new Item("Kit de recuperacion", "para aumentar vida", 1);
        tienda.mostrarEscenario();
        vendedor.interactuar(jugador);
        tienda.menuPedirTodo(jugador, vendedor);
        jugador.agregarItem(espada);
        jugador.agregarItem(escudo);
        jugador.agregarItem(kitComida);
        jugador.agregarItem(kitRecuperacion);
        jugador.mostrarInventario();
        tienda.obtenerSiguienteEscenario();

        Bosque bosque = new Bosque("*BOSQUE*", "Sales de la tienda y te encuentras en el bosque, cuando se cruza en tu camino un oso salvaje, con intenciones de atacarte");
        bosque.mostrarEscenario();
        bosque.menuBosque(jugador);
        bosque.obtenerSiguienteEscenario();

        Castillo castillo = new Castillo("*CASTILLO*", "Llegas a la entrada del castillo, pero la misma esta custodiada por un minotauro.\n");
        NPC minotauro = new NPC("*MINOTAURO*", 100, "Si quieres entrar al castillo, tienes que enfrentarte a mi!");
        castillo.mostrarEscenario();
        castillo.entradaCastillo(jugador, minotauro);
        castillo.obtenerSiguienteEscenario();

        Sotano sotano = new Sotano("*SOTANO*", "Entras al castillo y escuchas un ruido en el sotano, decides investigar.");
        NPC dragon = new NPC("Dragon", 100, "Vaya vaya! Otra victima dispuesta a morir por la cobardia de un rey. Tengo 2 opciones para ti: \nHacer un juego para que liberes a la princesa, Ó Luchar contra mi y liberar a la princesa.");
        sotano.mostrarEscenario();
        dragon.interactuar(jugador);
        sotano.charlaDragon(jugador, dragon);
        sotano.obtenerSiguienteEscenario();

        Habitacion habitacion = new Habitacion("*HABITACION*", "te diriges a la habitacion, donde se encuentra la princesa\n");
        NPC princesa = new NPC("Princesa", 100, " “Entras a la habitacion y ves a la princes sentada en la cama esperandote y dice: \n¡¡Oh Sir Heroe!! gracias por salvarme de este sufrimiento”");
        habitacion.mostrarEscenario();
        princesa.interactuar(jugador);
        habitacion.menuFinal(jugador);
    }
}
