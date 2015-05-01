package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Admin;
import domain.User;
import domain.Visitor;

@Local
public interface AccountManagementLocal {
	Boolean addUser(User user);

	User findUserById(Integer id);

	Boolean deleteUser(Integer id);

	Boolean updateUser(User user);

	Boolean updateAdmin(Admin admin);

	Boolean updateVisitor(Visitor visitor);

	List<User> findAllUsers();

	List<Admin> findAllAdmins();

	List<Visitor> findAllVisitors();

	User login(String login, String password);

}
