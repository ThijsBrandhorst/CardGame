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
			System.out.println("\nUser selected HIGHER, game over with score: " + game.getScores() + "!");
			game.save();
			return "gameover";
		}
		
		System.out.println("\nUser selected HIGHER, new score: " + game.getScores() + "!");
		return SUCCESS;
	}
	
	public String lower() {
		
		System.out.println("Current card: " + game.getCurrentCard() + ", next card: " + game.getNextCard());
		
		if (!game.gameTurn(HigherOrLower.LOWER)) {
			System.out.println("\nUser selected LOWER, game over with score: " + game.getScores() + "!");
			game.save();
			return "gameover";
		}
		
		System.out.println("\nUser selected LOWER, new score: " + game.getScores() + "!");
		return SUCCESS;
	}
	
	public String setup() {
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
		game = new Game();
		game.setup();
		return SUCCESS;
	}
	
	public static Game getGame() {
		return game;
	}
}
