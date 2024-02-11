import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GuessTheNumberGameTest {

    @Test
    //Jugador humano adivinando el numero correcto
    void testGuessTooHigh() {
        Player humanPlayerMock = Mockito.mock(HumanPlayer.class);
        Mockito.when(humanPlayerMock.makeGuess()).thenReturn(GuessTheNumberGame.getTargetNumber() + 1);
        assertFalse(GuessTheNumberGame.checkGuess(humanPlayerMock));
    }

    @Test
    //Jugador humano con conjetura mas bajo que el numero objetivo
    void testGuessTooLow() {
        Player humanPlayerMock = Mockito.mock(HumanPlayer.class);
        Mockito.when(humanPlayerMock.makeGuess()).thenReturn(GuessTheNumberGame.getTargetNumber() - 1);
        assertFalse(GuessTheNumberGame.checkGuess(humanPlayerMock));
    }

    @Test
    //Jugador humano con conjetura mas alta que el numero objetivo
    void testGuessCorrect() {
        Player humanPlayerMock = Mockito.mock(HumanPlayer.class);
        int targetNumber = GuessTheNumberGame.getTargetNumber();
        Mockito.when(humanPlayerMock.makeGuess()).thenReturn(targetNumber);
        assertTrue(GuessTheNumberGame.checkGuess(humanPlayerMock));
    }
}
