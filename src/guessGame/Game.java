package guessGame;

import java.security.SecureRandom;

public class Game {
    private boolean isWon;
    private Player[] players;
    private int luckyNumber;
    private int currentPlayer;
    public Game(int noOfPlayers){
        players = new Player[noOfPlayers];
        for (int i = 0; i < players.length; i++) players[i] = new Player();
        SecureRandom random = new SecureRandom();
        luckyNumber = 1 + random.nextInt(100);
    }

    public void registerPlayer(String playerName, int index) {
        players[index].setName(playerName);
    }

    public Player[] getPlayers() {
        return players;
    }

    public String getCurrentPlayerName() {
        return players[currentPlayer].getName();
    }

    public String  play(int guess) {
        if(guess == luckyNumber) {
            isWon = true;
            return "Congratulations! You got the number right! ";
        }
       if(guess < luckyNumber){
           return "Number too low, please try again! ";
       }
        if(guess > luckyNumber){
            return "Number too high, please try again! ";
        }
        currentPlayer++;
        resetCurrentPlayer();
        return "Wrong number, please try again! ";
    }

    private void resetCurrentPlayer() {
        if (currentPlayer == players.length) currentPlayer = 0;
    }

    public boolean isWon(){
        return isWon;
    }

}
