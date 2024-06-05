package cardgame;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import database.factories.DAOFactory;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Score> scores = new ArrayList<>();

    @Transient
    private Card currentCard;
    @Transient
    private Card nextCard;
    @Transient
    private Deck deck = new Deck();

    public enum HigherOrLower { HIGHER, LOWER }

    public boolean gameTurn(HigherOrLower higherOrLower) {
        if (!deck.areCardsLeft())
            return false;

        if (higherOrLower == HigherOrLower.HIGHER && nextCard.isHigherOrEqual(currentCard) || 
            higherOrLower == HigherOrLower.LOWER && !nextCard.isHigherOrEqual(currentCard)) {
            currentCard = deck.getNextCard();
            nextCard = deck.getNextCard();
            int newScore = scores.isEmpty() ? 1 : scores.get(scores.size() - 1).getScore() + 1;
            scores.add(new Score(this, newScore));
            return true;
        }

        return false;
    }

    public void setup() {
        currentCard = deck.getNextCard();
        nextCard = deck.getNextCard();
        // No initial score is added here
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
        return "" + (scores.isEmpty() ? 0 : scores.get(scores.size() - 1));
    }

    public int getLastDigitOfScore() {
        return scores.isEmpty() ? 0 : scores.get(scores.size() - 1).getScore();
    }

    public void save() {
        System.out.println("Saving game with scores: " + scores);
        DAOFactory.getTheFactory().getGameDAO().saveOrUpdate(this);
    }

    public void saveFinalScore(String playerName) {
        if (!scores.isEmpty()) {
            Score highestScore = scores.get(scores.size() - 1);
            highestScore.setPlayerName(playerName);
            System.out.println("Saving final high score: " + highestScore.getScore());
            DAOFactory.getTheFactory().getScoreDAO().saveOrUpdate(highestScore);
        }
    }
}
