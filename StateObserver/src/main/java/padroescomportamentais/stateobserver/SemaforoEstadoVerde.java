package padroescomportamentais.stateobserver;

public class SemaforoEstadoVerde extends SemaforoEstado {

    private SemaforoEstadoVerde() {};
    private static SemaforoEstadoVerde instance = new SemaforoEstadoVerde();

    public static SemaforoEstadoVerde getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Verde";
    }

    public boolean mudarEstado(Semaforo semaforo) {
        semaforo.setEstado(SemaforoEstadoAmarelo.getInstance());
        return true;
    }
}