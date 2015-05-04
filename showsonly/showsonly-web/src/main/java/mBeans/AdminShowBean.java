package mBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.AssignmentManagementLocal;
import services.interfaces.EventManagementLocal;
import services.interfaces.ShowManagementLocal;
import domain.Event;
import domain.Show;

@ManagedBean
@SessionScoped
public class AdminShowBean {
	private boolean visibilityadd = false;
	private boolean visibilityupdate = false;
	private boolean visibilityattach = false;
	private List<Show> shows;
	private List<Show> showsSelectedAttach;
	private Show show = new Show();
	private Show showSelected = new Show();
	private Show showSelectedAttach = new Show();
	private List<Event> events;
	private Event event = new Event();
	private Event eventSelected = new Event();
	private Event eventSelectedAttach = new Event();
	private List<Event> eventsSelected;

	@EJB
	private AssignmentManagementLocal assignmentmanagementlocal;
	@EJB
	private ShowManagementLocal showmanagementlocal;
	@EJB
	private EventManagementLocal eventmanagementlocal;

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
		visibilityattach = false;
		return "";
	}

	public String doDeleteShow(int id) {
		showmanagementlocal.deleteShow(id);
		visibilityupdate = false;
		visibilityadd = false;
		visibilityattach = false;
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
		visibilityattach = false;
		return "";
	}

	public String showAddShow() {
		visibilityadd = true;
		visibilityupdate = false;
		visibilityattach = false;
		return "";
	}

	public String showAttachShow() {
		visibilityadd = false;
		visibilityupdate = false;
		visibilityattach = true;
		return "";
	}

	public String doAssignShowToEvent() {
		for (Show s : showsSelectedAttach) {
			//assignmentmanagementlocal.assignShowToEvent(s.getId(),eventSelectedAttach.getId());
		}
		return "";
	}
	public String doAssignShowToEvent2() {
		 {
			assignmentmanagementlocal.assignShowToEvent(1,1);
		}
		return "";
	}
	public String doCreatePerformance() {
		 {
			assignmentmanagementlocal.assignShowToTheater(1, 1, "2012");
		}
		return "";
	}
	
	public Show doFindShowById(Integer id){
		return showmanagementlocal.findShowById(id);
	}

	public Event doFindEventByName(String name) {
		return eventmanagementlocal.findEventByName(name);
	}

	public Show doFindShowtByName(String title) {
		return showmanagementlocal.findShowByName(title);
	}

	public List<Event> getEvents() {
		events = eventmanagementlocal.findAllEvents();
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

	public List<Event> getEventsSelected() {
		return eventsSelected;
	}

	public void setEventsSelected(List<Event> eventsSelected) {
		this.eventsSelected = eventsSelected;
	}

	public boolean isVisibilityattach() {
		return visibilityattach;
	}

	public void setVisibilityattach(boolean visibilityattach) {
		this.visibilityattach = visibilityattach;
	}

	public Event getEventSelectedAttach() {
		return eventSelectedAttach;
	}

	public void setEventSelectedAttach(Event eventSelectedAttach) {
		this.eventSelectedAttach = eventSelectedAttach;
	}

	public Show getShowSelectedAttach() {
		return showSelectedAttach;
	}

	public void setShowSelectedAttach(Show showSelectedAttach) {
		this.showSelectedAttach = showSelectedAttach;
	}

	public List<Show> getShowsSelectedAttach() {
		showsSelectedAttach = showmanagementlocal.findAllShows();
		return showsSelectedAttach;
	}

	public void setShowsSelectedAttach(List<Show> showsSelectedAttach) {
		this.showsSelectedAttach = showsSelectedAttach;
	}

}
