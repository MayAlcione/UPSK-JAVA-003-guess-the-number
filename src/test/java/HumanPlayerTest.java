import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class HumanPlayerTest {

    @Test
    void testMakeGuessWithValidInput() {

        String playerName = "TestPlayer";

        // Crea un Spy para ScannerWrapper y configurarlo para simular la entrada del usuario
        // ScannerWrapper spyScannerWrapper = Mockito.spy(new ScannerWrapper());
        ScannerWrapper spyScannerWrapper = Mockito.mock(ScannerWrapper.class);
        when(spyScannerWrapper.nextInt()).thenReturn(42); // Entrada válida
       // doThrow(new InputMismatchException()).when(spyScannerWrapper).nextLine(); // Simular entrada no válida

        // Crea el objeto HumanPlayer usando el constructor modificado
        HumanPlayer humanPlayer = new HumanPlayer(playerName, spyScannerWrapper);

        int guess = humanPlayer.makeGuess();

        // Assert
        assertEquals(42, guess);
    }
}
