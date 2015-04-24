package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Subscription
 * 
 */
@Entity
public class Ticket implements Serializable {

	private Integer id;
	private Date dateOfTicket;
	private static final long serialVersionUID = 1L;

	private User user;
	private Performance performance;


	public Ticket() {
		super();
	}

	public Ticket(User user, Performance performance) {
		super();
		this.user = user;
		this.performance= performance;
		this.dateOfTicket = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}




	@ManyToOne
	public User getUser() {
		return user;
	}

	public Date getDateOfTicket() {
		return dateOfTicket;
	}

	public void setDateOfTicket(Date dateOfTicket) {
		this.dateOfTicket = dateOfTicket;
	}
	@ManyToOne
	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public void setUser(User user) {
		this.user = user;
	}



}
