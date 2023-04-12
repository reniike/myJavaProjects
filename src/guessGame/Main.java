package guessGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players want to play: ");
        int noOfPlayers = scanner.nextInt();

        Game game = new Game(noOfPlayers);

        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter player "+(i + 1)+" name");
            String name = scanner.next();
            game.registerPlayer(name, i);
        }

        do {
            String currentPlayerName = game.getCurrentPlayerName();
            System.out.println(currentPlayerName + ", it's your turn to play. Guess a number between 1 and 100: ");
            int guess = scanner.nextInt();
            System.out.println(game.play(guess));
        }while (game.isWon() == false);
    }
}
