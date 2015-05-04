package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.AssignmentManagementLocal;
import services.interfaces.AssignmentManagementRemote;
import domain.Event;
import domain.Performance;
import domain.PerformanceId;
import domain.Show;
import domain.Theater;
import domain.Ticket;
import domain.User;

/**
 * Session Bean implementation class AssignmentManagement
 */
@Stateless
public class AssignmentManagement implements AssignmentManagementRemote,
		AssignmentManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AssignmentManagement() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Boolean assignShowToTheater(Integer idShow, Integer idTheater,
			String dateperformance) {
		Boolean b = false;
		try {
			Show showSelected = entityManager.find(Show.class, idShow);
			Theater theaterSelected  = entityManager.find(Theater.class, idTheater);
			Performance performance = new Performance(showSelected, theaterSelected);
			entityManager.persist(performance);
			b = true;
		} catch (Exception e) {
		}
		return b;
		
	}

	@Override
	public Boolean assignShowToEvent(Integer idShow, Integer idEvent) {
		Boolean b = false;
		try {
			Show showSelected = entityManager.find(Show.class, idShow);
			Event eventSelected = entityManager.find(Event.class, idEvent);
			eventSelected.getShows().add(showSelected);
			showSelected.setEvent(eventSelected);
			entityManager.merge(eventSelected);
			entityManager.merge(showSelected);
			b = true;
		} catch (Exception e) {

		}
		return b;

	}

	@Override
	public List<Ticket> findAllTicketByUserId(Integer id) {

		User userSelected = entityManager.find(User.class, id);
		return userSelected.getTickets();
	}

	@Override
	public List<Theater> findAllTheaterByShowId(Integer id) {
		List theaters = null;
		Show showSelected = entityManager.find(Show.class, id);
		String jpql = "select t from Theater t ,t.performance ps where ps.show:=parmam1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", showSelected);
		try {
			theaters = query.getResultList();
		} catch (Exception e) {
			System.err.println("empty room ...");
		}
		return theaters;

	}

	@Override
	public Date findDatePerformanceByShowAndTheaterID(Integer showID,
			Integer theaterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean BuyTicket(PerformanceId performance, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
