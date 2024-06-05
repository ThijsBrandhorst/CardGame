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
        HttpServletRequest request = ServletActionContext.getRequest();
        playerName = request.getParameter("name");
        
        System.out.println("Current card: " + game.getCurrentCard() + ", next card: " + game.getNextCard());

        if (!game.gameTurn(HigherOrLower.HIGHER)) {
            game.saveFinalScore();  // Use the playerName from the game instance
            return "gameover";
        }

        System.out.println("\nUser selected HIGHER, new score: " + game.getScores() + "!");
        return SUCCESS;
    }

    public String lower() {
        HttpServletRequest request = ServletActionContext.getRequest();
        playerName = request.getParameter("name");
        
        System.out.println("Current card: " + game.getCurrentCard() + ", next card: " + game.getNextCard());

        if (!game.gameTurn(HigherOrLower.LOWER)) {
            game.saveFinalScore();  // Use the playerName from the game instance
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
