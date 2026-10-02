package padroescomportamentais.stateobserver;

public class SemaforoEstadoVermelho extends SemaforoEstado {

    private SemaforoEstadoVermelho() {};
    private static SemaforoEstadoVermelho instance = new SemaforoEstadoVermelho();

    public static SemaforoEstadoVermelho getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Vermelho";
    }

    public boolean mudarEstado(Semaforo semaforo) {
        semaforo.setEstado(SemaforoEstadoVerde.getInstance());
        return true;
    }
}