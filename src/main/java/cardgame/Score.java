package cardgame;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "score", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", nullable =  false)
	private String name;

	@Column(name = "score", nullable =  false)
	private Integer score;
	
	
	public Score() {
		
	}
	
	public Score(Integer id, String name, Integer score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
}