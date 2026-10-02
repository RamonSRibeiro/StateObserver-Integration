package padroescomportamentais.stateobserver;

public abstract class SemaforoEstado {

    public abstract String getEstado();

    public boolean mudarEstado(Semaforo semaforo) {
        return false;
    }
}