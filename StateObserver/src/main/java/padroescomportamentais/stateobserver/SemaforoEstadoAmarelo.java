package padroescomportamentais.stateobserver;

public class SemaforoEstadoAmarelo extends SemaforoEstado {

    private SemaforoEstadoAmarelo() {};
    private static SemaforoEstadoAmarelo instance = new SemaforoEstadoAmarelo();

    public static SemaforoEstadoAmarelo getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Amarelo";
    }

    public boolean mudarEstado(Semaforo semaforo) {
        semaforo.setEstado(SemaforoEstadoVermelho.getInstance());
        return true;
    }
}