package cardgame;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import database.factories.DAOFactory;

@Entity
@Table(name = "scores")
public class Score {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id", insertable = false, updatable = false)
	private Game game;
    
	@Column(name = "score")
    private int score;
	
	@Column(name = "name")
	private String name;
    
    
	public Score(Game game, int score) {
		this.game = game;
		this.score = score;
	}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    @Override
	public String toString() {
		return "" + score;
	}
    
	public void save() {
		DAOFactory.getTheFactory().getScoreDAO().saveOrUpdate(this);
    }
}
