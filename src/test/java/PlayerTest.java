import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PlayerTest {

    // Test para verificar que el constructor de Player inicializa correctamente el nombre del jugador
    @Test
    void testPlayerConstructorAndGetName() {

        String playerName = "TestPlayer";

        Player player = new ConcretePlayer(playerName);

        assertEquals(playerName, player.getName());
    }

    // Test para verificar que el método makeGuess de Player genera una conjetura no negativa.
    @Test
    void testMakeGuess() {

        Player player = new ConcretePlayer("TestPlayer");

        int guess = player.makeGuess();

        assertTrue(guess >= 0); // Simple comprobación para asegurar que la conjetura es no negativa
    }

    // Test para verificar que el método getGuesses de Player devuelve la lista de conjeturas esperada
    @Test
    void testGetGuesses() {

        Player player = new ConcretePlayer("TestPlayer");
        ArrayList<Integer> expectedGuesses = new ArrayList<>();
        expectedGuesses.add(42);
        expectedGuesses.add(55);
        player.getGuesses().addAll(expectedGuesses);

        ArrayList<Integer> actualGuesses = player.getGuesses();

        assertEquals(expectedGuesses, actualGuesses);
    }

    // Para proporcionar una implementación específica para las pruebas del método makeGuess
    private static class ConcretePlayer extends Player {
        public ConcretePlayer(String name) {
            super(name);
        }

        @Override
        public int makeGuess() {
            return 0;
        }
    }
}
