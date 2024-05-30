package database.factories;

import org.hibernate.Session;

import cardgame.Score;
import database.dao.GenericHibernateDAO;
import database.dao.ScoreDAO;
import database.interfaces.IScoreDAO;
import database.session.HibernateSessionManager;

public class HibernateDAOfactory extends DAOFactory {

	protected Session getCurrentSession() {
		return HibernateSessionManager.getSessionFactory().openSession();
	}



	@Override
	public IScoreDAO getScoreDAO() {
		GenericHibernateDAO<Score, Integer> dao = null;
		try {
			dao = ScoreDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (IScoreDAO) dao;
	}
}