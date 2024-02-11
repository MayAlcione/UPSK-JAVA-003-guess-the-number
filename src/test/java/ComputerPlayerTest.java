import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComputerPlayerTest {

    @Mock
    private Random random;

    @InjectMocks
    private ComputerPlayer computerPlayer;

    @Test
    void testMakeGuess() {
        // Configuración del escenario de prueba
        int expectedGuess = 42;

        // Cuando nextInt() se llama en el objeto Random, devuelve el valor esperado
        when(random.nextInt(100)).thenReturn(expectedGuess);

        // Ejecución de la prueba
        int actualGuess = computerPlayer.makeGuess();

        // Verificación de resultados
        assertEquals(expectedGuess, actualGuess);
    }
}
