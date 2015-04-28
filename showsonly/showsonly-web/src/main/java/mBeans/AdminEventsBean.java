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
	private boolean visibilityadd = false;
	private boolean visibilityupdate = false;
	private List<Event> events;
	private Event event = new Event();
	private Event eventSeleted = new Event();

	@EJB
	private EventManagementLocal eventmanagementlocal;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<Event> getEvents() {
		events = eventmanagementlocal.findAllEvents();
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public String doEdit() {
		visibilityupdate = true;
		visibilityadd = false;
		return "";
	}

	public String doDelete(int id) {
		eventmanagementlocal.deleteEvent(id);
		visibilityupdate = false;
		visibilityadd = false;
		return "";
	}

	public String doAddEvent() {
		eventmanagementlocal.addEvent(event);
		visibilityadd = false;
		return "";
	}

	public String doUpdateEvent() {
		eventmanagementlocal.updateEvent(eventSeleted);
		visibilityupdate = false;
		visibilityadd = false;
		return "";
	}

	public String show() {
		visibilityadd = true;
		visibilityupdate = false;
		return "";
	}

	public boolean isVisibilityadd() {
		return visibilityadd;
	}

	public void setVisibilityadd(boolean visibilityadd) {
		this.visibilityadd = visibilityadd;
	}

	public boolean isVisibilityupdate() {
		return visibilityupdate;
	}

	public void setVisibilityupdate(boolean visibilityupdate) {
		this.visibilityupdate = visibilityupdate;
	}

	public Event getEventSeleted() {
		return eventSeleted;
	}

	public void setEventSeleted(Event eventSeleted) {
		this.eventSeleted = eventSeleted;
	}

}
