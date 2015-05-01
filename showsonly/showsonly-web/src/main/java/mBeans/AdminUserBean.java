package mBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.AccountManagementLocal;
import domain.Admin;
import domain.User;
import domain.Visitor;

@ManagedBean
@SessionScoped
public class AdminUserBean {
	private boolean visibilityadd = false;
	private boolean visibilityupdate = false;
	private List<User> users;
	private List<Admin> admins;
	private List<Visitor> visitors;
	private User user = new User();
	private Admin admin = new Admin();
	private Visitor visitor = new Visitor();
	private Admin adminSelected = new Admin();
	private Visitor visitorSelected = new Visitor();
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

	public String doAddAdmin() {
		accountmanagementlocal.addUser(admin);
		visibilityadd = false;
		return "";
	}

	public String doAddVisitor() {
		accountmanagementlocal.addUser(visitor);
		visibilityadd = false;
		return "";
	}

	public String doUpdateAdmin() {
		accountmanagementlocal.updateAdmin(adminSelected);
		visibilityupdate = false;
		visibilityadd = false;
		return "";
	}

	public String doUpdateVisitor() {
		accountmanagementlocal.updateVisitor(visitorSelected);
		visibilityupdate = false;
		visibilityadd = false;
		return "";
	}

	public String showAddUser() {
		visibilityadd = true;
		visibilityupdate = false;
		return "";
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public Admin getAdminSelected() {
		return adminSelected;
	}

	public void setAdminSelected(Admin adminSelected) {
		this.adminSelected = adminSelected;
	}

	public Visitor getVisitorSelected() {
		return visitorSelected;
	}

	public void setVisitorSelected(Visitor visitorSelected) {
		this.visitorSelected = visitorSelected;
	}

	public List<Admin> getAdmins() {
		admins =  accountmanagementlocal.findAllAdmins();
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public List<Visitor> getVisitors() {
		visitors =  accountmanagementlocal.findAllVisitors();
		return visitors;
	}

	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}

}
