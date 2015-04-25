package domain;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Player
 * 
 */
@Entity
public class Visitor extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public Visitor() {
		super();
	}

	public Visitor(String name, String login, String password) {
		super(name, login, password);
	
	}



}
