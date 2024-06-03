package actions;

import com.opensymphony.xwork2.ActionSupport;

import cardgame.Game;
import cardgame.Game.HigherOrLower;
import freemarker.log.Logger;

public class GameAction extends ActionSupport {
	
	private Logger log = Logger.getLogger(GameAction.class.getName());
	private static Game game;
	
	public String higher() {
		
		log.info("Current card: " + game.getCurrentCard() + ", next card: " + game.getNextCard());
		
		if (!game.gameTurn(HigherOrLower.HIGHER)) {
			log.info("\nUser selected HIGHER, game over with score: " + game.getScore() + "!");
			return "gameover";
		}
		
		log.info("\nUser selected HIGHER, new score: " + game.getScore() + "!");
		return SUCCESS;
	}
	
	public String lower() {
		
		log.info("Current card: " + game.getCurrentCard() + ", next card: " + game.getNextCard());
		
		if (!game.gameTurn(HigherOrLower.LOWER)) {
			log.info("\nUser selected LOWER, game over with score: " + game.getScore() + "!");
			return "gameover";
		}
		
		log.info("\nUser selected LOWER, new score: " + game.getScore() + "!");
		return SUCCESS;
	}
	
	public String setup() {
		game = new Game();
		game.setup();
		return SUCCESS;
	}
	
	public static Game getGame() {
		return game;
	}
}
