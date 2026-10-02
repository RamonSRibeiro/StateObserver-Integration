package padroescomportamentais.stateobserver;

public class SemaforoFactoryPadrao extends SemaforoFactory {

    @Override
    public Semaforo criarSemaforo() {
        Semaforo semaforo = new Semaforo();

        semaforo.adicionarObserver(new MotoristaObserver());
        semaforo.adicionarObserver(new PedestreObserver());

        return semaforo;
    }
}