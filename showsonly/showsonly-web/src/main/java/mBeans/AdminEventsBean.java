package mBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.EventManagementLocal;
import domain.Event;

@ManagedBean
@SessionScoped
public class AdminEventsBean {
	private boolean visibility = false;
	private List<Event> events;
	private Event event = new Event();

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@EJB
	private EventManagementLocal eventmanagementlocal;

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public List<Event> getEvents() {
		events = eventmanagementlocal.findAllEvents();
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public String doSelect() {
		visibility = true;
		return "";
	}
	
	public String doDelete(int id){
		eventmanagementlocal.deleteEvent(id);
		return "";
	}

	public String doAddEvent() {
		eventmanagementlocal.addEvent(event);
		visibility = false;
		return "";
	}

	public String show() {
		visibility = true;
		return "";
	}

}
