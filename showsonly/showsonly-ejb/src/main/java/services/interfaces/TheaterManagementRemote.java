package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import domain.Event;
import domain.Show;
import domain.User;

@Remote
public interface TheaterManagementRemote {
	Boolean addShow(Show show);

	Show findShowById(Integer id);

	Boolean deleteShow(Integer id);

	Boolean updateShow(Show show);

	List<Show> findAllShows();
	
	
	

}
