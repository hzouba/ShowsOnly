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
import services.interfaces.TheaterManagementLocal;
import services.interfaces.TheaterManagementRemote;
import domain.Event;
import domain.Show;
import domain.Theater;

/**
 * Session Bean implementation class AccountManagement
 */
@Stateless
public class TheaterManagement implements TheaterManagementRemote,
		TheaterManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public TheaterManagement() {
	}

	

	



	@SuppressWarnings("unchecked")


	@Override
	public Boolean addTheater(Theater theater) {
		Boolean b = false;
		try {
			entityManager.persist(theater);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Theater findTheaterById(Integer id) {
		return entityManager.find(Theater.class, id);
	}

	@Override
	public Boolean deleteTheater(Integer id) {

		Boolean b = false;
		try {
			entityManager.remove(findTheaterById(id));
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateTheater(Theater theater) {
		Boolean b = false;
		try {
			entityManager.merge(theater);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public List<Theater> findAllTheaters() {
		List<Theater> theaters = null;
		try {
			String jpql = "select u from Theater u";
			Query query = entityManager.createQuery(jpql);
			theaters = query.getResultList();
		} catch (Exception e) {
		}
		return theaters;
	}

}
