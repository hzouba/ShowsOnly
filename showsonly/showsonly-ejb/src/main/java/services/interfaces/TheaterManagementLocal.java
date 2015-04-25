package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Show;
import domain.Theater;


@Local
public interface TheaterManagementLocal {
	
	Boolean addTheater(Theater theater);

	Show findTheaterById(Integer id);

	Boolean deleteTheater(Integer id);

	Boolean updateTheater(Theater theater);

	List<Theater> findAllShows();

	
}
