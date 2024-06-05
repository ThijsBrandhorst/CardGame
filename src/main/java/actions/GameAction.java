package actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import cardgame.Game;
import cardgame.Game.HigherOrLower;
import database.factories.DAOFactories;
import database.factories.DAOFactory;

public class GameAction extends ActionSupport {

    private static Game game;
    private String playerName;

    public String higher() {
        System.out.println("Current card: " + game.getCurrentCard() + ", next card: " + game.getNextCard());

        if (!game.gameTurn(HigherOrLower.HIGHER)) {
        	HttpServletRequest request = ServletActionContext.getRequest();
            playerName = request.getParameter("name");
        	game.saveFinalScore(playerName);
//            game.saveFinalScore("Player 1");
            return "gameover";
        }

        System.out.println("\nUser selected HIGHER, new score: " + game.getScores() + "!");
        return SUCCESS;
    }

    public String lower() {
        System.out.println("Current card: " + game.getCurrentCard() + ", next card: " + game.getNextCard());

        if (!game.gameTurn(HigherOrLower.LOWER)) {
        	HttpServletRequest request = ServletActionContext.getRequest();
            playerName = request.getParameter("name");
//            game.saveFinalScore("Player 1");
        	game.saveFinalScore(playerName);
            return "gameover";
        }
        System.out.println("\nUser selected LOWER, new score: " + game.getScores() + "!");
        return SUCCESS;
    }

    public String setup() {
        HttpServletRequest request = ServletActionContext.getRequest();
        playerName = request.getParameter("name");
        DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
        game = new Game();
        game.setup(playerName);
        game.save();
        return SUCCESS;
    }

    public static Game getGame() {
        return game;
    }

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}
