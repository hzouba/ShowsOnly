package mBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.AccountManagementLocal;
import domain.User;

@ManagedBean
@SessionScoped
public class AdminUserBean {
	private boolean visibilityadd = false;
	private boolean visibilityupdate = false;
	private List<User> users;
	private User user = new User();
	private User userSelected = new User();

	@EJB
	private AccountManagementLocal accountmanagementlocal;

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

	public List<User> getUsers() {
		users = accountmanagementlocal.findAllUsers();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(User userSelected) {
		this.userSelected = userSelected;
	}

	public String doEditUser() {
		visibilityupdate = true;
		visibilityadd = false;
		return "";
	}

	public String doDeleteUser(int id) {
		accountmanagementlocal.deleteUser(id);
		visibilityupdate = false;
		visibilityadd = false;
		return "";
	}

	public String doAddUser() {
		accountmanagementlocal.addUser(user);
		visibilityadd = false;
		return "";
	}

	public String doUpdateUser() {
		accountmanagementlocal.updateUser(userSelected);
		visibilityupdate = false;
		visibilityadd = false;
		return "";
	}

	public String showAddUser() {
		visibilityadd = true;
		visibilityupdate = false;
		return "";
	}

}
