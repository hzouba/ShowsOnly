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

	/*
	 * List<Ticket> games = null; User userSelected =
	 * entityManager.find(User.class, id); String jpql =
	 * "select g from Game g ,Room r where r=:param1 and r member of g.rooms";
	 * Query query = entityManager.createQuery(jpql);
	 * query.setParameter("param1", roomSelected); try { games =
	 * query.getResultList(); } catch (Exception e) {
	 * System.err.println("empty room ..."); } return games; return null;
	 */

	/*
	 * @Override public Boolean subscribePlayerToRoom(Integer idPlayer, Integer
	 * idRoom) { Boolean b = false; try { Player playerSelected =
	 * entityManager.find(Player.class, idPlayer); Room roomSelected =
	 * entityManager.find(Room.class, idRoom); Subscription subscription = new
	 * Subscription(playerSelected, roomSelected);
	 * entityManager.persist(subscription); b = true; } catch (Exception e) { }
	 * return b; }
	 * 
	 * @Override public Boolean playGame(Subscription subscription, Game game) {
	 * Boolean b = false; try { Play play = new Play(subscription, game);
	 * entityManager.persist(play); b = true; } catch (Exception e) { } return
	 * b; }
	 */
	@Override
	public Boolean assignShowToTheater(Integer idShow, Integer idTheater,
			String dateperformance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean assignShowToEvent(Integer idShow, Integer idEvent) {
		Boolean b = false;
		try {
			Show showSelected = entityManager.find(Show.class, idShow);
			Event eventSelected = entityManager.find(Event.class, idEvent);
			eventSelected.getShows().add(showSelected);
			entityManager.merge(eventSelected);
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
