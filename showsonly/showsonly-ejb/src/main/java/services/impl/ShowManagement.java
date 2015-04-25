package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.EventManagementLocal;
import services.interfaces.EventManagementRemote;
import services.interfaces.ShowManagementLocal;
import services.interfaces.ShowManagementRemote;
import domain.Event;
import domain.Show;

/**
 * Session Bean implementation class AccountManagement
 */
@Stateless
public class ShowManagement implements ShowManagementRemote,
		ShowManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ShowManagement() {
	}

	@Override
	public Boolean addShow(Show show) {
		Boolean b = false;
		try {
			entityManager.persist(show);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Show findShowById(Integer id) {
		return entityManager.find(Show.class, id);
	}

	@Override
	public Boolean deleteShow(Integer id) {

		Boolean b = false;
		try {
			entityManager.remove(findShowById(id));
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateShow(Show show) {
		Boolean b = false;
		try {
			entityManager.merge(show);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Show> findAllShows() {
		List<Show> shows = null;
		try {
			String jpql = "select u from Show u";
			Query query = entityManager.createQuery(jpql);
			shows = query.getResultList();
		} catch (Exception e) {
		}
		return shows;
	}

}
