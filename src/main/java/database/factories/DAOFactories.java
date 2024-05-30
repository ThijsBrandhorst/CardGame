package database.factories;

import database.factories.DAOFactory;
import database.factories.HibernateDAOfactory;


public enum DAOFactories {

	HIBERNATE(HibernateDAOfactory.class);
	
	private final Class<? extends DAOFactory> theFactory;
	
	private DAOFactories(Class<? extends DAOFactory> factory) {
		this.theFactory = factory;
	}

	/**
	 * @return the theFactory
	 */
	public Class<? extends DAOFactory> getTheFactory() {
		return theFactory;
	}
	
	
	
}
