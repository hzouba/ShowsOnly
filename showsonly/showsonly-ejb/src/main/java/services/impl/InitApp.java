package services.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.InitAppLocal;
import services.interfaces.InitAppRemote;
import domain.Admin;
import domain.Visitor;


/**
 * Session Bean implementation class InitApp
 */
@Singleton
@Startup
public class InitApp implements InitAppRemote, InitAppLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public InitApp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@PostConstruct
	public void init() {
		Admin admin = new Admin("Admin","admin","admin");
		Visitor visitor=new Visitor("visitor", "visitor", "visitor");
		entityManager.persist(admin);
		entityManager.persist(visitor);
	
	}

}
