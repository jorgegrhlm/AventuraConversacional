package aventuraConversacional;

import java.util.ArrayList;
import java.util.List;

public class RegistroDecision {
    private static List<Decision> historialDecisiones = new ArrayList<>();

    public RegistroDecision() {
        this.historialDecisiones = historialDecisiones;
    }

    public static void guardarDecision(Decision nuevaDecision) {
        historialDecisiones.add(nuevaDecision);
    }

    public static void mostrarHistorial() {
        for (Decision decision : historialDecisiones) {
            System.out.println(decision.toString()+ "\n" );
        }
    }

    public static List<Decision> getHistorialDecisiones() {
        return historialDecisiones;
    }

}

