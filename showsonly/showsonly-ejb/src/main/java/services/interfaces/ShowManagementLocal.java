package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Show;

@Local
public interface ShowManagementLocal {

	Boolean addShow(Show show);

	Show findShowById(Integer id);

	Show findShowByName(String title);

	Boolean deleteShow(Integer id);

	Boolean updateShow(Show show);

	List<Show> findAllShows();

}
