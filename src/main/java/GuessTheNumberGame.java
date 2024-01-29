import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    // Generar números aleatorios
    private static final Random random$ = new Random();

    // Variable para almacenar el número objetivo que los jugadores deben adivinar
    private static int targetNumber$;

    // Método principal que inicia el juego
    public static void main(String[] args) {
        playGame(); // Llama a la función playGame para comenzar el juego
    }

    // Función que maneja la lógica principal del juego y permite jugar nuevamente
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);

        do {
            // Genera un nuevo número objetivo aleatorio entre 1 y 100
            targetNumber$ = random$.nextInt(100) + 1;

            // Crea instancias de los jugadores (humano y computadora)
            Player humanPlayer = new HumanPlayer();
            Player computerPlayer = new ComputerPlayer(new Random());

            // Llama a la función que contiene la lógica del juego
            playNumberGuessingGame(humanPlayer, computerPlayer);

            // Pregunta al usuario si quiere jugar nuevamente
            System.out.print("¿Quieres jugar nuevamente? (s/n): ");
            String playAgain = scanner.nextLine().toLowerCase();

            // Sale del bucle si el usuario no quiere jugar nuevamente
            if (!playAgain.equals("s")) {
                System.out.println("¡Gracias por jugar! ¡Hasta luego!");
                break;
            }

        } while (true); // Bucle que permite jugar múltiples rondas

        scanner.close(); // Cierra el scanner al final del programa
    }

    // Getter para obtener el número objetivo actual
    public static int getTargetNumber() {
        return targetNumber$;
    }

    // Función que contiene la lógica del juego de adivinanza de números
    public static void playNumberGuessingGame(Player humanPlayer, Player computerPlayer) {
        System.out.println("Intenta adivinar el número entre 1 y 100.");

        Player winner = null;

        // Bucle que continúa hasta que un jugador adivina el número
        while (true) {

            if (checkGuess(humanPlayer)) {
                winner = humanPlayer;
                break; // Sale del bucle si el jugador humano adivina
            }

            // Pausa antes del turno del jugador computadora
            pauseForSeconds(3);


            if (checkGuess(computerPlayer)) {
                winner = computerPlayer;
                break; // Sale del bucle si el jugador computadora adivina
            }

            // Pausa antes de mostrar los resultados
            pauseForSeconds(3);
        }

        // Muestra resultados y lista de conjeturas del ganador
        System.out.println("¡El juego ha terminado!");
        System.out.println("El ganador es: " + winner.getName());
        System.out.println("Lista de conjeturas:");
        for (int guess : winner.getGuesses()) {
            System.out.println(guess);
        }
    }

    // Función que pausa la ejecución durante un número de segundos específico
    public static void pauseForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Función que verifica si la conjetura del jugador es correcta
    public static boolean checkGuess(Player player) {
        int guessedNumber = player.makeGuess();
        player.getGuesses().add(guessedNumber);

        if (guessedNumber > getTargetNumber()) {
            System.out.println(player.getName() + ": ¡Demasiado alto!");
            return false;
        } else if (guessedNumber < getTargetNumber()) {
            System.out.println(player.getName() + ": ¡Demasiado bajo!");
            return false;
        } else {
            System.out.println(player.getName() + "¡Felicidades! Adivinaste el número correcto: " + getTargetNumber());
            return true; // Devuelve verdadero si la conjetura es correcta
        }
    }
}