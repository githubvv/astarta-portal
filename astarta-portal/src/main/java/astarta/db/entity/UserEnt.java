package astarta.db.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Entity
@Table(name="users")
public class UserEnt implements Serializable {
	private static final long serialVersionUID = -4235033198327918237L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String email;
	private Boolean enabled;

	@Column(name="\"firstName\"")
	private String firstName;

	@Column(name="\"lastName\"")
	private String lastName;

	@JsonIgnore
	private String password;

	private String username;
	
	@OneToOne(mappedBy="user", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	private ContactEnt contacts;
	
	@OneToMany(mappedBy = "user", fetch =  FetchType.EAGER, cascade={CascadeType.MERGE})
	@Fetch(FetchMode.JOIN)
	private List<EmployeeEnt> employees;

	public UserEnt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public ContactEnt getContacts() {
		return this.contacts;
	}

	public void setContacts(ContactEnt contacts) {
		this.contacts = contacts;
		contacts.setUser(this);
	}

	public List<EmployeeEnt> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<EmployeeEnt> employees) {
		this.employees = employees;
	}

	public EmployeeEnt addEmployee(EmployeeEnt employee) {
		getEmployees().add(employee);
		employee.setUser(this);

		return employee;
	}

	public EmployeeEnt removeEmployee(EmployeeEnt employee) {
		getEmployees().remove(employee);
		employee.setUser(null);

		return employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserEnt other = (UserEnt) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}