package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import domain.Event;
import domain.Show;
import domain.Theater;
import domain.User;

@Remote
public interface TheaterManagementRemote {
	Boolean addTheater(Theater theater);

	Theater findTheaterById(Integer id);

	Boolean deleteTheater(Integer id);

	Boolean updateTheater(Theater theater);

	List<Theater> findAllTheaters();
	
	
	

}
