package mBeans;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.TheaterManagementLocal;
import domain.Event;
import domain.Theater;


@ManagedBean
@SessionScoped
public class AdminTheatresBean {
	private boolean visibilityadd = false;
	private boolean visibilityupdate = false;
	private List<Theater> theatres;
	private Theater theatre = new Theater();
	private Theater theatreSelected = new Theater();
	
	@EJB
	private TheaterManagementLocal theatermanagementlocal;
	


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

	public List<Theater> getTheatres() {
		theatres = theatermanagementlocal.findAllTheaters();
		return theatres;
	}

	public void setTheatres(List<Theater> theatres) {
		this.theatres = theatres;
	}

	public Theater getTheatre() {
		return theatre;
	}

	public void setTheatre(Theater theatre) {
		this.theatre = theatre;
	}

	public Theater getTheatreSelected() {
		return theatreSelected;
	}

	public void setTheatreSelected(Theater theatreSelected) {
		this.theatreSelected = theatreSelected;
	}


	public String doEditTheatre() {
		visibilityupdate = true;
		visibilityadd = false;
		return "";
	}

	public String doDeleteTheatre(int id) {
		theatermanagementlocal.deleteTheater(id);
		visibilityupdate = false;
		visibilityadd = false;
		return "";
	}

	public String doAddTheatre() {
		theatermanagementlocal.addTheater(theatre);
		visibilityadd = false;
		return "";
	}

	public String doUpdateTheatre() {
		theatermanagementlocal.updateTheater(theatreSelected);
		visibilityupdate = false;
		visibilityadd = false;
		return "";
	}

	public String showAddTheatre() {
		visibilityadd = true;
		visibilityupdate = false;
		return "";
	}

	public Theater doFindTheatreByName(String name) {
		return theatermanagementlocal.findTheaterByName(name);
	}

}
