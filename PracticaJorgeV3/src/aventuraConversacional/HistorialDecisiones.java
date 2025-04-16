package aventuraConversacional;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistorialDecisiones {
    private List<String> decisiones = new ArrayList<>();

    // Registra una decisión con formato: "Escenario X - Elección: Y - Fecha: Z"
    public void registrarDecision(String escenario, String decision) {
        String registro = "Escenario: " + escenario + " | Decisión: " + decision + " | Fecha: " + LocalDateTime.now();
        decisiones.add(registro);
    }

    // Guarda el historial en un archivo `historial.txt`
    public void guardarEnArchivo() {
        try (PrintWriter writer = new PrintWriter("historial.txt")) {
            for (String registro : decisiones) {
                writer.println(registro);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el historial: " + e.getMessage());
        }
    }

    // Muestra el historial por consola
    public void mostrarHistorial() {
        System.out.println("=== HISTORIAL DE DECISIONES ===");
        for (String registro : decisiones) {
            System.out.println(registro);
        }
    }
}
