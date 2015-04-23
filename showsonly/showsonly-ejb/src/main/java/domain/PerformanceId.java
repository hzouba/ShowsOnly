package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: PlayId
 * 
 */
@Embeddable
public class PerformanceId implements Serializable {

	private Integer idShow;
	private Integer idTheater;
	private Date dateOfPerformance;
	private static final long serialVersionUID = 1L;

	public PerformanceId() {
		super();
	}

	public PerformanceId(Integer idSubscription, Integer idGame, Date dateOfGame) {
		super();
		this.idShow = idSubscription;
		this.idTheater = idGame;
		this.dateOfPerformance = dateOfGame;
	}

	public PerformanceId(Integer idSubscription, Integer idGame) {
		super();
		this.idShow = idSubscription;
		this.idTheater = idGame;
		this.dateOfPerformance = new Date();
	}

	public Integer getIdSubscription() {
		return this.idShow;
	}

	public void setIdSubscription(Integer IdSubscription) {
		this.idShow = IdSubscription;
	}

	public Integer getIdGame() {
		return this.idTheater;
	}

	public void setIdGame(Integer IdGame) {
		this.idTheater = IdGame;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTheater == null) ? 0 : idTheater.hashCode());
		result = prime * result
				+ ((idShow == null) ? 0 : idShow.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerformanceId other = (PerformanceId) obj;
		if (idTheater == null) {
			if (other.idTheater != null)
				return false;
		} else if (!idTheater.equals(other.idTheater))
			return false;
		if (idShow == null) {
			if (other.idShow != null)
				return false;
		} else if (!idShow.equals(other.idShow))
			return false;
		return true;
	}
@Temporal(TemporalType.DATE)
	public Date getDateOfGame() {
		return dateOfPerformance;
	}

	public void setDateOfGame(Date dateOfGame) {
		this.dateOfPerformance = dateOfGame;
	}

}
