package database.factories;

import java.lang.reflect.InvocationTargetException;

import database.interfaces.IGameDAO;
import database.interfaces.IScoreDAO;

public abstract class DAOFactory {
	
	private static DAOFactory theFactory;

	/**
	 * @return the theFactory
	 */
	public static DAOFactory getTheFactory() {
		return theFactory;
	}
	

	/**
	 * @param factory the theFactory to set
	 */
	public static void setTheFactory(Class<? extends DAOFactory> factory) {
		try {
//			theFactory = factory.newInstance();
			theFactory = factory.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to create DAOFactory: " + factory);
		}
	}

	public abstract IGameDAO getGameDAO();
	public abstract IScoreDAO getScoreDAO();

	
}