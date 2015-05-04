package services.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.InitAppLocal;
import services.interfaces.InitAppRemote;
import domain.Admin;
import domain.Event;
import domain.Theater;
import domain.Visitor;
import domain.Show;


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
		Event event = new Event("Grammy Award", "01/05/2015 jusqu’à 08/05/2015");
		Event event1 = new Event("Thes Oscars","15/05/2015 jusqu' a 30/05/2015");
		Event event2 = new Event("JCC", "15/05/2015 jusqu' a 30/05/2015");
		Event event3 = new Event("African Film Festival", "01/05/2015 jusqu’à 08/05/2015");
		Event event4 = new Event("Boston Festival of Films from Iran", "15/05/2015 jusqu' a 30/05/2015");
		Event event5 = new Event("Chicago International Film Festival", "01/05/2015 jusqu’à 08/05/2015");
		entityManager.persist(admin);
		entityManager.persist(visitor);
		entityManager.persist(event);
		entityManager.persist(event1);
		entityManager.persist(event2);
		entityManager.persist(event3);
		entityManager.persist(event4);
		entityManager.persist(event5);
	Show show = new Show("test","test","test") ;
	Theater theater=new Theater("Theater1", 300, "typ");
	entityManager.persist(theater);
	entityManager.persist(show);


	
	
	}

}
