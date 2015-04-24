package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Play
 * 
 */
@Entity
public class Performance implements Serializable {

	private static final long serialVersionUID = 1L;

	private PerformanceId playeId;
	private Show show;
	private Theater theater;
	private List<Ticket> tickets;
	
	@OneToMany(mappedBy = "performance")
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Performance() {
		super();
	}

	public Performance(Show show, Theater theater) {
		super();
		this.show=show;
		this.theater=theater;
		this.playeId = new PerformanceId(show.getId(), theater.getId());
	}

	@EmbeddedId
	public PerformanceId getPlayeId() {
		return playeId;
	}

	public void setPlayeId(PerformanceId playeId) {
		this.playeId = playeId;
	}


	@ManyToOne
	@JoinColumn(name = "idShow", referencedColumnName = "id", insertable = false, updatable = false)

	public Show getShow() {
		return show;
	}
	
	public void setShow(Show show) {
		this.show = show;
	}
	@ManyToOne
	@JoinColumn(name = "idTheater", referencedColumnName = "id", insertable = false, updatable = false)
	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	

}
