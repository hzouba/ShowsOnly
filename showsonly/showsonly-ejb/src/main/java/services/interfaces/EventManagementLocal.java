package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Event;

@Local
public interface EventManagementLocal {
	Boolean addEvent(Event event);

	Event findEventById(Integer id);

	Event findEventByName(String name);

	Boolean deleteEvent(Integer id);

	Boolean updateEvent(Event event);

	List<Event> findAllEvents();

}
