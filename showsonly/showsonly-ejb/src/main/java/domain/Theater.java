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
public class Theater implements Serializable {

	private Integer id;
	private String name;
	private Integer nbMaxPerson;
	private String Adresse;
	private static final long serialVersionUID = 1L;
	private List<Performance> plays;
	public Theater() {
		super();
	}

	public Theater(String name, Integer nbMaxPerson, String type) {
		super();
		this.name = name;
		this.nbMaxPerson = nbMaxPerson;
		this.Adresse = type;
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

	public Integer getNbMaxPerson() {
		return this.nbMaxPerson;
	}

	public void setNbMaxPerson(Integer nbMaxPerson) {
		this.nbMaxPerson = nbMaxPerson;
	}

	
	
	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	@OneToMany(mappedBy = "theater")
	public List<Performance> getPlays() {
		return plays;
	}

	public void setPlays(List<Performance> plays) {
		this.plays = plays;
	}

	

}
