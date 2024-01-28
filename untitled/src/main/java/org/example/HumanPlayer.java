package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

// Declaración de la clase HumanPlayer, que extiende la clase abstracta Player
public class HumanPlayer extends Player {

    // Constructor que permite que el usuario ingrese el nombre
    public HumanPlayer() {
        super(enterPlayerName());
    }

    // Método estático para ingresar el nombre del jugador
    private static String enterPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al juego de adivinanza de números!");
        System.out.print("Ingresa tu nombre: ");
        return scanner.nextLine();
    }

    // Implementación del método abstracto makeGuess() de la clase Player
    @Override
    public int makeGuess() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // Muestra el mensaje indicando el turno del jugador
                System.out.println("Turno de " + getName());

                // Solicita al usuario ingresar su conjetura entre 1 y 100
                System.out.print("Ingresa tu conjetura (entre 1 y 100): ");
                int guessedNumber = scanner.nextInt();

                // Validar que la conjetura esté en el rango adecuado
                if (guessedNumber < 1 || guessedNumber > 100) {
                    System.out.println("Por favor, ingresa un número válido entre 1 y 100.");
                    continue;  // Solicitar una nueva conjetura si está fuera del rango
                }

                // Devuelve la conjetura realizada por el jugador
                return guessedNumber;

            } catch (InputMismatchException e) {
                // Captura la excepción si el usuario ingresa algo que no es un número
                System.out.println("Por favor, ingresa solo números.");
                scanner.nextLine(); // Consumir la entrada no válida antes de solicitar nuevamente
            }
        }
    }
}