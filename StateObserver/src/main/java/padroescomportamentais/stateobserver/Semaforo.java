package padroescomportamentais.stateobserver;

import java.util.ArrayList;
import java.util.List;

public class Semaforo {

    private SemaforoEstado estado;
    private List<SemaforoObserver> observers = new ArrayList<>();

    public Semaforo() {
        this.estado = SemaforoEstadoVerde.getInstance();
    }

    public void setEstado(SemaforoEstado estado) {
        this.estado = estado;
        notificarObservers();
    }

    public SemaforoEstado getEstado() {
        return estado;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public void mudarEstado() {
        estado.mudarEstado(this);
    }

    public void adicionarObserver(SemaforoObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(SemaforoObserver observer) {
        observers.remove(observer);
    }

    private void notificarObservers() {
        for (SemaforoObserver observer : observers) {
            observer.atualizar(this);
        }
    }
}