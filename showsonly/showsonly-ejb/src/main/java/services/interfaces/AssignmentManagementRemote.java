package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import domain.PerformanceId;
import domain.Theater;
import domain.Ticket;

@Remote
public interface AssignmentManagementRemote {

	Boolean assignShowToTheater(Integer idShow, Integer idTheater, String dateperformance);
	
	Boolean assignShowToEvent(Integer idShow, Integer idEvent);

	List<Ticket> findAllTicketByUserId(Integer id);

	List<Theater> findAllTheaterByShowId(Integer id);

	Date findDatePerformanceByShowAndTheaterID(Integer showID, Integer theaterId);

	Boolean BuyTicket(PerformanceId performance, Integer userId);

}
