package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Room
 * 
 */
@Entity
public class Event implements Serializable {

	private Integer id;
	private String name;
	private String type;
	private static final long serialVersionUID = 1L;

	private List<Show> shows;


	public Event() {
		super();
	}

	public Event(String name, String type) {
		super();
		this.name = name;
		this.type = type;
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

	

	public String getType() {
		return this.type;
	}
	@OneToMany(mappedBy = "event")
	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	public void setType(String type) {
		this.type = type;
	}



	
}
