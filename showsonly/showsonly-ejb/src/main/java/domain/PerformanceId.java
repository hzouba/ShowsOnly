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

	public PerformanceId(Integer idShow, Integer idTheater, Date dateOfPerformance) {
		super();
		this.idShow = idShow;
		this.idTheater = idTheater;
		this.dateOfPerformance = dateOfPerformance;
	}

	public PerformanceId(Integer idShow, Integer idTheater) {
		super();
		this.idShow = idShow;
		this.idTheater = idTheater;
		this.dateOfPerformance = new Date();
	}



	public Integer getIdShow() {
		return idShow;
	}

	public void setIdShow(Integer idShow) {
		this.idShow = idShow;
	}

	public Integer getIdTheater() {
		return idTheater;
	}

	public void setIdTheater(Integer idTheater) {
		this.idTheater = idTheater;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateOfPerformance() {
		return dateOfPerformance;
	}

	public void setDateOfPerformance(Date dateOfPerformance) {
		this.dateOfPerformance = dateOfPerformance;
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



}
