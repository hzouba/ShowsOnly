package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.EventManagementLocal;
import services.interfaces.EventManagementRemote;
import domain.Event;

/**
 * Session Bean implementation class AccountManagement
 */
@Stateless
public class EventManagement implements EventManagementRemote,
		EventManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EventManagement() {
	}

	@Override
	public Boolean addEvent(Event event) {
		// TODO Auto-generated method stub
		Boolean b = false;
		try {
			entityManager.merge(event);
			b = true;
		} catch (Exception e) {
		}
		return b;

	}

	@Override
	public Event findEventById(Integer id) {
		return entityManager.find(Event.class, id);
	}

	@Override
	public Boolean deleteEvent(Integer id) {
		// TODO Auto-generated method stub

		Boolean b = false;
		try {
			entityManager.remove(findEventById(id));
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateEvent(Event event) {
		Boolean b = false;
		try {
			entityManager.merge(event);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAllEvents() {
		List<Event> events = null;
		try {
			String jpql = "select u from Event u";
			Query query = entityManager.createQuery(jpql);
			events = query.getResultList();
		} catch (Exception e) {
		}
		return events;
	}

	@Override
	public Event findEventByName(String name) {
	
			return entityManager
		.createQuery("select e from Event e where e.name=:param1",
						Event.class).setParameter("param1", name)
				.getSingleResult();
	
	}

}
