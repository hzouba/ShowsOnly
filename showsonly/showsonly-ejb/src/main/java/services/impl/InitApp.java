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
		Show show = new Show("Fast&furious","Deckard Shaw seeks revenge against Dominic Toretto and his family for his comatose brother.","James Wan") ;
		Show show1 = new Show("Unfriended","A group of online chat room friends find themselves haunted by a mysterious, supernatural force using the account of their dead friend.","Levan Gabriadze") ;
		Show show2 = new Show("Mall cop 2","After six years of keeping our malls safe, Paul Blart has earned a well-deserved vacation. He heads to Vegas with his teenage daughter before she heads off to college. But safety never takes a holiday and when duty calls, Blart answers.","Andy Fickman") ;
		Show show3 = new Show("The longest ride","After an automobile crash, the lives of a young couple intertwine with a much older man, as he reflects back on a past love.","George Tillman Jr.") ;
		Show show4 = new Show("Woman in gold","Maria Altmann, an octogenarian Jewish refugee, takes on the Austrian government to recover artwork she believes rightfully belongs to her family.","Simon Curtis") ;
		entityManager.persist(show);
		entityManager.persist(show1);
		entityManager.persist(show2);
		entityManager.persist(show3);
		entityManager.persist(show4);
	Theater theater=new Theater("Cinema Village", 300, "22 E 12th StNew York, NY 10003 États-Unis");
	Theater theater1=new Theater("AMC Loews Kips Bay 15", 600, "143 E Houston St New York, NY 10002 États-Unis");
	Theater theater2=new Theater("Sunshine Cinema", 600, "850 Broadway New York, NY 10003 États-Unis");
	Theater theater3=new Theater("Regal Cinemas Union Square 14", 450, "323 Avenue of the Americas New York, NY 10014 États-Unis");
	Theater theater4=new Theater("Cinema 1, 2 & 3", 800, "890 Broadway");
	entityManager.persist(theater);
	entityManager.persist(theater1);
	entityManager.persist(theater2);
	entityManager.persist(theater3);
	entityManager.persist(theater4);


	
	
	}

}
