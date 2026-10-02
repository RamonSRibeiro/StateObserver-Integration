package padroescomportamentais.stateobserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SemaforoTest {

    Semaforo semaforo;
    MotoristaObserver motorista;
    PedestreObserver pedestre;

    @BeforeEach
    public void setUp() {
        semaforo = new Semaforo();
        motorista = new MotoristaObserver();
        pedestre = new PedestreObserver();

        semaforo.adicionarObserver(motorista);
        semaforo.adicionarObserver(pedestre);
    }

    // Semaforo verde

    @Test
    public void deveIniciarSemaforoVerde() {
        assertEquals(SemaforoEstadoVerde.getInstance(), semaforo.getEstado());
        assertEquals("Verde", semaforo.getNomeEstado());
    }

    @Test
    public void deveMudarSemaforoVerdeParaAmarelo() {
        assertTrue(semaforo.getEstado().mudarEstado(semaforo));
        assertEquals(SemaforoEstadoAmarelo.getInstance(), semaforo.getEstado());
    }

    // Semaforo amarelo

    @Test
    public void deveMudarSemaforoAmareloParaVermelho() {
        semaforo.setEstado(SemaforoEstadoAmarelo.getInstance());

        assertTrue(semaforo.getEstado().mudarEstado(semaforo));
        assertEquals(SemaforoEstadoVermelho.getInstance(), semaforo.getEstado());
    }

    // Semaforo vermelho

    @Test
    public void deveMudarSemaforoVermelhoParaVerde() {
        semaforo.setEstado(SemaforoEstadoVermelho.getInstance());

        assertTrue(semaforo.getEstado().mudarEstado(semaforo));
        assertEquals(SemaforoEstadoVerde.getInstance(), semaforo.getEstado());
    }

    // Ciclo completo do semaforo

    @Test
    public void deveExecutarCicloCompletoDoSemaforo() {
        assertEquals(SemaforoEstadoVerde.getInstance(), semaforo.getEstado());

        semaforo.mudarEstado();
        assertEquals(SemaforoEstadoAmarelo.getInstance(), semaforo.getEstado());

        semaforo.mudarEstado();
        assertEquals(SemaforoEstadoVermelho.getInstance(), semaforo.getEstado());

        semaforo.mudarEstado();
        assertEquals(SemaforoEstadoVerde.getInstance(), semaforo.getEstado());
    }

    // Observer motorista

    @Test
    public void deveNotificarMotoristaQuandoEstadoMudar() {
        semaforo.mudarEstado();

        assertEquals(
                "Motorista: semáforo está Amarelo",
                motorista.getUltimaMensagem()
        );
    }

    // Observer pedestre

    @Test
    public void deveNotificarPedestreQuandoEstadoMudar() {
        semaforo.mudarEstado();

        assertEquals(
                "Pedestre: semáforo está Amarelo",
                pedestre.getUltimaMensagem()
        );
    }

    @Test
    public void deveNotificarMotoristaEpedestreQuandoEstadoMudar() {
        semaforo.mudarEstado();

        assertEquals(
                "Motorista: semáforo está Amarelo",
                motorista.getUltimaMensagem()
        );

        assertEquals(
                "Pedestre: semáforo está Amarelo",
                pedestre.getUltimaMensagem()
        );
    }

    // Observer em diferentes estados

    @Test
    public void deveNotificarObservadoresQuandoSemaforoFicarVermelho() {
        semaforo.setEstado(SemaforoEstadoAmarelo.getInstance());
        semaforo.mudarEstado();

        assertEquals(
                "Motorista: semáforo está Vermelho",
                motorista.getUltimaMensagem()
        );

        assertEquals(
                "Pedestre: semáforo está Vermelho",
                pedestre.getUltimaMensagem()
        );
    }

    @Test
    public void deveNotificarObservadoresQuandoSemaforoFicarVerde() {
        semaforo.setEstado(SemaforoEstadoVermelho.getInstance());
        semaforo.mudarEstado();

        assertEquals(
                "Motorista: semáforo está Verde",
                motorista.getUltimaMensagem()
        );

        assertEquals(
                "Pedestre: semáforo está Verde",
                pedestre.getUltimaMensagem()
        );
    }

    // Remocao de Observer

    @Test
    public void naoDeveNotificarMotoristaRemovido() {
        semaforo.removerObserver(motorista);

        semaforo.mudarEstado();

        assertNull(motorista.getUltimaMensagem());

        assertEquals(
                "Pedestre: semáforo está Amarelo",
                pedestre.getUltimaMensagem()
        );
    }

    @Test
    public void naoDeveNotificarPedestreRemovido() {
        semaforo.removerObserver(pedestre);

        semaforo.mudarEstado();

        assertNull(pedestre.getUltimaMensagem());

        assertEquals(
                "Motorista: semáforo está Amarelo",
                motorista.getUltimaMensagem()
        );
    }

    // Factory Method

    @Test
    public void deveCriarSemaforoComFactory() {
        SemaforoFactory factory = new SemaforoFactoryPadrao();

        Semaforo semaforoFactory = factory.criarSemaforo();

        assertNotNull(semaforoFactory);
        assertEquals(
                SemaforoEstadoVerde.getInstance(),
                semaforoFactory.getEstado()
        );
    }

    @Test
    public void deveCriarSemaforoComEstadoInicialVerde() {
        SemaforoFactory factory = new SemaforoFactoryPadrao();

        Semaforo semaforoFactory = factory.criarSemaforo();

        assertEquals("Verde", semaforoFactory.getNomeEstado());
    }

    @Test
    public void devePermitirMudancaDeEstadoNoSemaforoCriadoPelaFactory() {
        SemaforoFactory factory = new SemaforoFactoryPadrao();

        Semaforo semaforoFactory = factory.criarSemaforo();

        semaforoFactory.mudarEstado();

        assertEquals(
                SemaforoEstadoAmarelo.getInstance(),
                semaforoFactory.getEstado()
        );
    }

}

