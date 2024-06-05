package actions;

import com.opensymphony.xwork2.ActionSupport;
import cardgame.Game;
import cardgame.Game.HigherOrLower;
import database.factories.DAOFactories;
import database.factories.DAOFactory;

public class GameAction extends ActionSupport {

    private static Game game;

    public String higher() {
        System.out.println("Current card: " + game.getCurrentCard() + ", next card: " + game.getNextCard());

        if (!game.gameTurn(HigherOrLower.HIGHER)) {
            game.saveFinalScore("Player 1");
            return "gameover";
        }

        System.out.println("\nUser selected HIGHER, new score: " + game.getScores() + "!");
        return SUCCESS;
    }

    public String lower() {
        System.out.println("Current card: " + game.getCurrentCard() + ", next card: " + game.getNextCard());

        if (!game.gameTurn(HigherOrLower.LOWER)) {
            game.saveFinalScore("Player 1");
            return "gameover";
        }

        System.out.println("\nUser selected LOWER, new score: " + game.getScores() + "!");
        return SUCCESS;
    }

    public String setup() {
        DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
        game = new Game();
        game.setup();
        game.save();
        return SUCCESS;
    }

    public static Game getGame() {
        return game;
    }
}
