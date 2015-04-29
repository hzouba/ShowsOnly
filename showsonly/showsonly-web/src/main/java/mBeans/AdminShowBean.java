package mBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.AssignmentManagementLocal;
import services.interfaces.ShowManagementLocal;
import domain.Event;
import domain.Show;

@ManagedBean
@SessionScoped
public class AdminShowBean {
	private boolean visibilityadd = false;
	private boolean visibilityupdate = false;
	private List<Show> shows;
	private Show show = new Show();
	private Show showSelected = new Show();
	private List<Event> events;
	private Event event = new Event();
	private Event eventSelected = new Event();

	@EJB
	private AssignmentManagementLocal assignmentmanagementlocal;
	@EJB
	private ShowManagementLocal showmanagementlocal;

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

	public List<Show> getShows() {
		shows = showmanagementlocal.findAllShows();
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Show getShowSelected() {
		return showSelected;
	}

	public void setShowSelected(Show showSelected) {
		this.showSelected = showSelected;
	}

	public String doEditShow() {
		visibilityupdate = true;
		visibilityadd = false;
		return "";
	}

	public String doDeleteShow(int id) {
		showmanagementlocal.deleteShow(id);
		visibilityupdate = false;
		visibilityadd = false;
		return "";
	}

	public String doAddShow() {
		showmanagementlocal.addShow(show);
		visibilityadd = false;
		return "";
	}

	public String doUpdateShow() {
		showmanagementlocal.updateShow(showSelected);
		visibilityupdate = false;
		visibilityadd = false;
		return "";
	}

	public String showAddShow() {
		visibilityadd = true;
		visibilityupdate = false;
		return "";
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Event getEventSelected() {
		return eventSelected;
	}

	public void setEventSelected(Event eventSelected) {
		this.eventSelected = eventSelected;
	}

}