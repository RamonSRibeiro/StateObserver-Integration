package padroescomportamentais.stateobserver;

public class MotoristaObserver implements SemaforoObserver {

    private String ultimaMensagem;

    @Override
    public void atualizar(Semaforo semaforo) {
        ultimaMensagem = "Motorista: semáforo está " + semaforo.getNomeEstado();
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }
}