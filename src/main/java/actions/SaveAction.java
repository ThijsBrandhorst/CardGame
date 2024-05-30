package actions;

import java.sql.Connection;

import com.opensymphony.xwork2.ActionSupport;

import freemarker.log.Logger;

public class SaveAction extends ActionSupport {
	
	private Logger log = Logger.getLogger(GameAction.class.getName());
	private String naam;
	
	public String save() {
		log.info("Save success!");
		return SUCCESS;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

}