package database.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import cardgame.Score;
import database.interfaces.IScoreDAO;
import database.session.HibernateSessionManager;

public class ScoreDAO extends GenericHibernateDAO<Score, String> implements IScoreDAO {

	public List<Score> getTopScores(int limit) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Query<Score> query = session.createQuery("FROM Score ORDER BY score DESC", Score.class);
		query.setMaxResults(limit);
		List<Score> topScores = query.list();
		session.getTransaction().commit();
		session.close();
		return topScores;
	}
}
