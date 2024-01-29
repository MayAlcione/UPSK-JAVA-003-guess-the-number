import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class HumanPlayerTest {

    @Test
    void testMakeGuessWithValidInput() {
        // Arrange
        String playerName = "TestPlayer";

        // Crear un Spy para ScannerWrapper y configurarlo para simular la entrada del usuario
        ScannerWrapper spyScannerWrapper = Mockito.spy(new ScannerWrapper());
        when(spyScannerWrapper.nextInt()).thenReturn(42);

        // Crear el objeto HumanPlayer usando el constructor modificado
        HumanPlayer humanPlayer = new HumanPlayer(playerName, spyScannerWrapper);

        // Act
        int guess = humanPlayer.makeGuess();

        // Assert
        assertEquals(42, guess);
    }
}
