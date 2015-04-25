package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import domain.Event;
import domain.User;

@Remote
public interface EventManagementRemote {
	Boolean addEvent(Event event);

	Event findEventById(Integer id);

	Boolean deleteEvent(Integer id);

	Boolean updateEvent(Event event);

	List<Event> findAllEvents();

	
	
	

}
