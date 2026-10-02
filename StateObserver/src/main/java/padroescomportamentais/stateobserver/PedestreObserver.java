package padroescomportamentais.stateobserver;

public class PedestreObserver implements SemaforoObserver {

    private String ultimaMensagem;

    @Override
    public void atualizar(Semaforo semaforo) {
        ultimaMensagem = "Pedestre: semáforo está " + semaforo.getNomeEstado();
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }
}