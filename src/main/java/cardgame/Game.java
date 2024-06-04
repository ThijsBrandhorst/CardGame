package cardgame;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import database.factories.DAOFactory;

@Entity
@Table(name = "game")
public class Game {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "game_name")
	@OneToMany(mappedBy="game")
	private List<Score> scores;
	
	@Transient
	private Card currentCard;
	@Transient
	private Card nextCard;
	@Transient
	private Deck deck = new Deck();
	
	public enum HigherOrLower {HIGHER, LOWER};
	
	public boolean gameTurn(HigherOrLower higherOrLower) {
		
		if (!deck.areCardsLeft())
			return false;
		
		if (higherOrLower == HigherOrLower.HIGHER && nextCard.isHigherOrEqual(currentCard) || 
			higherOrLower == HigherOrLower.LOWER && !nextCard.isHigherOrEqual(currentCard)) {
			currentCard = deck.getNextCard();
			nextCard = deck.getNextCard();
			scores.add(new Score(this, this.getScores().get(this.getScores().size() - 1).getScore() + 1));
			return true;
		}
		
		// Wrong guess, game over
		return false;
	}
	
	public void setup() {
		currentCard = deck.getNextCard();
		nextCard = deck.getNextCard();
		scores = new ArrayList<>();
		scores.add(new Score(this, 0));
	}
	
	public List<Score> getScores() {
		return scores;
	}
	
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
	public Card getCurrentCard() {
		return currentCard;
	}
	
	public Card getNextCard() {
		return nextCard;
	}
	
    @Override
	public String toString() {
		return "" + scores.get(scores.size() - 1);
	}
	public void save() {
		DAOFactory.getTheFactory().getGameDAO().saveOrUpdate(this);
    }
}
