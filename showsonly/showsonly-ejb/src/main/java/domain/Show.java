package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Show implements Serializable {

	private Integer id;
	private String name;
	private static final long serialVersionUID = 1L;
	private Event event;
	private List<Performance> plays;
	@OneToMany(mappedBy = "show")
	public List<Performance> getPlays() {
		return plays;
	}

	public void setPlays(List<Performance> plays) {
		this.plays = plays;
	}

	@ManyToOne
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	

	public Show() {
		super();
	}

	public Show(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
