
# Adivina el Número - Guess the Number

## Índice

- [1. Preámbulo](#1-preámbulo)
- [2. Resumen del Proyecto](#2-resumen-del-proyecto)
- [3. Instrucciones de Uso:](#3-objetivos-de-aprendizaje)
- [4. Consideraciones Técnicas](#5-consideraciones-técnicas)

---

## 1. Preámbulo

En la actualidad, Java es uno de los lenguajes de programación más utilizados en
el mundo. A pesar de la diversidad de plataformas y herramientas disponibles, es
fundamental tener una base sólida en los conceptos fundamentales de Java y en la
programación orientada a objetos (OOP). El objetivo de este proyecto es
introducirte al mundo de Java a través de un juego simple y divertido.

![GUESS THE NUMBER](https://firebasestorage.googleapis.com/v0/b/laboratoria-945ea.appspot.com/o/guess-the-number.png?alt=media)

## 2. Resumen del Proyecto

Es un juego interactivo que se desarrolla en el terminal, donde la jugadora y el
ordenador se turnan para intentar adivinar un número aleatorio entre 1 y 100.
Deben tener en cuenta la tentativa anterior, si fue "muy alta" o "muy baja".

![GUESS THE NUMBER DEMO](https://firebasestorage.googleapis.com/v0/b/laboratoria-945ea.appspot.com/o/guess-the-number-demo.gif?alt=media)

## 3. Instrucciones de Uso: 

Una vez que el juego se inicie, seguirá el siguiente flujo:

  1. Le pedirá que escriba su nombre.

  2. El programa generará un número aleatorio entre 1 y 100.

  3. Tendrás la opción de adivinar como jugador humano o dejar que la computadora adivine.

  4. Después de cada conjetura, el programa te indicará si el número es demasiado alto o demasiado bajo.

  5. El juego continuará hasta que adivines correctamente el número.

  6. Una vez que adivines correctamente, se mostrará el número de intentos realizados y se te preguntará si deseas jugar nuevamente.

  7. Si eliges jugar nuevamente, el juego reiniciará con un nuevo número objetivo. Si decides no jugar, el juego finalizará.


## 4. Consideraciones Técnicas

- El juego se llevará a cabo en el terminal usando Java.
- La lógica del juego se basará en estructuras de control, incluyendo bucles,
  condicionales y colecciones.
- Es necesario dividir el código y mejorar su legibilidad y mantenimiento.
- Se debe utilizar una funcionalidad de la biblioteca de utilidades de Java para
  la generación de números aleatorios.
- Se deben realizar **pruebas unitarias** para sus clases y métodos
  utilizando JUnit y simulación de generación de números aleatorios con Mockito.


### Diagrama de Clases

![Diagrama de Clases](https://firebasestorage.googleapis.com/v0/b/laboratoria-945ea.appspot.com/o/class-diagram.png?alt=media)

#### `GuessTheNumberGame`

**Propósito:**
Maneja la lógica principal, decide qué jugador asume el próximo turno.

**Atributos:**

- `random`: Generador de números aleatorios.
- `targetNumber`: Número aleatorio entre 1 y 100 a adivinar en la partida actual.

**Métodos estáticos (`static`):**

- `main(String[] args)`: Inicia el juego y genera el número aleatorio.
- `checkGuess(Player player)`: Ejecuta un turno, obtiene la suposición
  y evalúa el nuevo estado de la partida.

#### `Player`

**Propósito:**
Representa a una jugadora genérica. Es una clase abstracta.
Define los atributos y métodos que todas las _clases_ de jugadoras deben compartir:

**Atributos:**

- `name`: El nombre de la jugadora.
- `guesses`: El historial de suposiciones de la jugadora.

**Métodos:**

- `makeGuess()`: Devuelve la suposición de la jugadora. Es un método abstracto.
- `getName()`: Devuelve el nombre de la jugadora.
- `getGuesses()`: Devuelve el historial de suposiciones de la jugadora.

#### `HumanPlayer` y `ComputerPlayer` (heredan de `Player`)

**Propósito:**
Representa a las jugadoras _Humana_ y _Computadora_, respectivamente.

**Métodos:**

- `makeGuess()`: Método que cada clase que hereda de `Player` debe implementar.

**Relaciones:**

- La clase `GuessTheNumberGame` interactúa con las clases `HumanPlayer`
  y `ComputerPlayer` para gestionar el juego.
- Tanto la clase `HumanPlayer` como `Computer Player` son subclases de `Player`,
  lo que implica que heredan todas sus propiedades y métodos,
  pero también tienen algunas características adicionales propias.


**Nota:**

- Disfruta jugando y trata de adivinar el número en la menor cantidad de intentos posible!

**_¡Diviértete y buena suerte!🎲🎮_**
