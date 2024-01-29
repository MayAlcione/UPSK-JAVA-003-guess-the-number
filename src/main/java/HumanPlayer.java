import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {

    private ScannerWrapper scannerWrapper;

    public HumanPlayer(String playerName, ScannerWrapper scannerWrapper) {
        super(playerName);
        this.scannerWrapper = scannerWrapper;
    }

    public HumanPlayer() {
        this(enterPlayerName(), new ScannerWrapper());
    }

    private static String enterPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al juego de adivinanza de números!");
        System.out.print("Ingresa tu nombre: ");
        return scanner.nextLine();
    }

    @Override
    public int makeGuess() {
        while (true) {
            try {
                System.out.println("Turno de " + getName());

                System.out.print("Ingresa tu conjetura (entre 1 y 100): ");
                int guessedNumber = scannerWrapper.nextInt();

                if (guessedNumber < 1 || guessedNumber > 100) {
                    System.out.println("Por favor, ingresa un número válido entre 1 y 100.");
                    continue;
                }

                return guessedNumber;

            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingresa solo números.");
                scannerWrapper.nextLine();
            }
        }
    }

    public void closeScanner() {
        scannerWrapper.close();
    }
}

class ScannerWrapper {
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
