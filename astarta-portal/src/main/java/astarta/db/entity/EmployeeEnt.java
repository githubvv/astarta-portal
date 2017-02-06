package astarta.db.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name = "employees")

public class EmployeeEnt implements Serializable {
	private static final long serialVersionUID = -8759430552119973507L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String department;

	private Boolean enabled;

	private String position;

	private String tabel;

	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.MERGE})
	@JoinColumn(name = "\"compEdrpou\"")
	@Fetch(FetchMode.JOIN)
	private CompanyEnt company;

	// bi-directional many-to-one association to User
	@JsonIgnore
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name = "\"userId\"")
	private UserEnt user;

	public EmployeeEnt() {
	}
	
	public EmployeeEnt(String department, Boolean enabled, String position, String tabel, CompanyEnt company) {
		super();
		this.department = department;
		this.enabled = enabled;
		this.position = position;
		this.tabel = tabel;
		this.company = company;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTabel() {
		return this.tabel;
	}

	public void setTabel(String tabel) {
		this.tabel = tabel;
	}

	public CompanyEnt getCompany() {
		return this.company;
	}

	public void setCompany(CompanyEnt company) {
		this.company = company;
	}

	public UserEnt getUser() {
		return this.user;
	}

	public void setUser(UserEnt user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tabel == null) ? 0 : tabel.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		EmployeeEnt other = (EmployeeEnt) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tabel == null) {
			if (other.tabel != null)
				return false;
		} else if (!tabel.equals(other.tabel))
			return false;
		if (getUser() == null) {
			if (other.getUser() != null)
				return false;
		} else if (!getUser().equals(other.getUser()))
			return false;
		return true;
	}
	
	

}