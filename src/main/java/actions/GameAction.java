package actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cardgame.Game;
import cardgame.Game.HigherOrLower;
import cardgame.Score;
import database.dao.ScoreDAO;
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
            game.saveFinalScore();
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
            game.saveFinalScore();
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
        fetchTopScores();
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
    
    private void fetchTopScores() {
        ScoreDAO scoreDAO = (ScoreDAO) DAOFactory.getTheFactory().getScoreDAO();
        List<Score> topScores = scoreDAO.getTopScores(10);
        Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
        request.put("topScores", topScores);
    }
}
