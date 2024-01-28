package org.example;
import java.util.Random;

public class ComputerPlayer extends Player {
    private final Random random;

    public ComputerPlayer(Random random) {
        super("Computadora");
        this.random = random;
    }

    @Override
    public int makeGuess() {
        // Muestra el mensaje indicando el turno del jugador
        System.out.println("Turno de la Computadora ");
        // Elegir un número aleatorio
        int guessedNumber = random.nextInt(100);

        // Mostrar la conjetura de la computadora
        System.out.println("Computadora: " + guessedNumber);

        return guessedNumber;
    }
}
