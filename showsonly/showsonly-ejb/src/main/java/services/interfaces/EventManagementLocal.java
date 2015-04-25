package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Event;
import domain.User;

@Local
public interface EventManagementLocal {
	Boolean addEvent(Event event);

	Event findEventById(Integer id);

	Boolean deleteEvent(Integer id);

	Boolean updateEvent(Event event);

	List<Event> findAllEvents();

	
}
