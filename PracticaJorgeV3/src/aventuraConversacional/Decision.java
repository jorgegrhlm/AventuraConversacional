package aventuraConversacional;

public class Decision {
        private String escenario;
        private String decision;

        public Decision(String escenario, String decision) {
            this.escenario = escenario;
            this.decision = decision;
        }

        public String getEscenario() {
            return escenario;
        }

        public String getDecision() {
            return decision;
        }

        @Override
        public String toString() {
            return "Escenario: \"" + escenario + "\" - Decision: \"" + decision + "\"";
        }
    }


