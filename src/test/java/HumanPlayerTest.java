import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanPlayerTest {

    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testInput;

    @BeforeEach
    public void setUp() {
        testInput = new ByteArrayInputStream("42".getBytes());
        System.setIn(testInput);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(systemIn);
    }

    @Test
    public void testMakeGuessWithValidInput() {
        HumanPlayer humanPlayer = new HumanPlayer("TestPlayer", new ScannerWrapper());
        int guess = humanPlayer.makeGuess();
        assertEquals(42, guess);
    }
}
