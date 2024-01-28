package org.example;
// Importa la clase ArrayList desde el paquete java.util
import java.util.ArrayList;

// Declaración de una clase abstracta llamada Player
public abstract class Player {
    // Atributos protegidos: name (nombre del jugador) y guesses (conjeturas del jugador)
    protected String name;
    protected ArrayList<Integer> guesses;

    // Constructor que inicializa el nombre y la lista de conjeturas del jugador
    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<>(); // Se crea una nueva lista para almacenar las conjeturas
    }

    // Método abstracto que representa la acción de realizar una conjetura
    public abstract int makeGuess();

    // Método para obtener el nombre del jugador
    public String getName() {
        return name;
    }

    // Método para obtener la lista de conjeturas del jugador
    public ArrayList<Integer> getGuesses() {
        return guesses;
    }
}