package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import domain.Show;

@Remote
public interface ShowManagementRemote {
	Boolean addShow(Show show);

	Show findShowById(Integer id);

	Show findShowByName(String title);

	Boolean deleteShow(Integer id);

	Boolean updateShow(Show show);

	List<Show> findAllShows();

}
