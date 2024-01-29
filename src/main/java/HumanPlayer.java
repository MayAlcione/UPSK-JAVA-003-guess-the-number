import java.util.InputMismatchException;
import java.util.Scanner;

public final class HumanPlayer extends Player {

    private final ScannerWrapper scannerWrapper;

    // Constructor que acepta el nombre del jugador y un ScannerWrapper
    public HumanPlayer(String playerName, ScannerWrapper scannerWrapper) {
        super(playerName);
        this.scannerWrapper = scannerWrapper;
    }

    // Constructor por defecto que utiliza el nombre ingresado y un ScannerWrapper
    public HumanPlayer() {
        this(enterPlayerName(), new ScannerWrapper());
    }

    // Método estático para usar el nombre ingresado
    private static String enterPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al juego de adivinanza de números!");
        System.out.print("Ingresa tu nombre: ");
        return scanner.nextLine();
    }

    // Implementación del método abstracto makeGuess() de la clase Player
    @Override
    public int makeGuess() {
        while (true) {
            try {
                System.out.println("Turno de " + getName());

                System.out.print("Ingresa tu conjetura (entre 1 y 100): ");
                int guessedNumber = scannerWrapper.nextInt();

                // Validar que la conjetura sea un numero de 1 a 100
                if (guessedNumber < 1 || guessedNumber > 100) {
                    // Solicitar una nueva conjetura si está fuera del rango
                    System.out.println("Por favor, ingresa un número válido entre 1 y 100.");
                    continue;
                }

                // Devuelve la conjetura realizada por el jugador
                return guessedNumber;

            } catch (InputMismatchException e) {
                // Captura la excepción si el usuario ingresa algo que no es un número
                System.out.println("Por favor, ingresa solo números.");
                scannerWrapper.nextLine(); // Consumir la entrada no válida antes de solicitar nuevamente
            }
        }
    }

    // Método para cerrar el ScannerWrapper
    public void closeScanner() {
        scannerWrapper.close();
    }
}

final class ScannerWrapper {
    private final Scanner scanner = new Scanner(System.in);

    int nextInt() throws InputMismatchException {
        return scanner.nextInt();
    }

    String nextLine() {
        return scanner.nextLine();
    }

    void close() {
        scanner.close();
    }
}
