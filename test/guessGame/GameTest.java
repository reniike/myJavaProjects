package guessGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game(3);

    @Test void registerPlayerTest(){
        game.registerPlayer("Renike", 0);
        game.registerPlayer("Aliyah", 1);
        game.registerPlayer("Moyinoluwa", 2);
        Player[] players = game.getPlayers();
        assertEquals("Renike", players[0].getName());
        assertEquals("Aliyah", players[1].getName());
    }

    @Test void playersCanPlayInterchangeably(){
//        game.play()
    }

}