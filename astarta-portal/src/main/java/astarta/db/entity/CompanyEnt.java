package astarta.db.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name="companies")
public class CompanyEnt implements Serializable {
	private static final long serialVersionUID = 7969763985325704361L;

	@Id
	private String edrpou;

	private String name;

	//bi-directional many-to-one association to Employee
	@JsonIgnore
	@OneToMany(mappedBy="company")
	private List<EmployeeEnt> employees;

	public CompanyEnt() {
	}

	public CompanyEnt(String edrpou, String name) {
		this.edrpou = edrpou;
		this.name = name;
	}

	public String getEdrpou() {
		return this.edrpou;
	}

	public void setEdrpou(String edrpou) {
		this.edrpou = edrpou;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeEnt> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<EmployeeEnt> employees) {
		this.employees = employees;
	}

	public EmployeeEnt addEmployee(EmployeeEnt employee) {
		getEmployees().add(employee);
		employee.setCompany(this);

		return employee;
	}

	public EmployeeEnt removeEmployee(EmployeeEnt employee) {
		getEmployees().remove(employee);
		employee.setCompany(null);

		return employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 4651;
		result = result * prime + ((getEdrpou() == null) ? 0 : getEdrpou().hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		CompanyEnt other = (CompanyEnt) obj;
		if (getEdrpou() == null) {
			if (other.getEdrpou() != null)
				return false;
		} else if (!getEdrpou().equals(other.getEdrpou()))
			return false;
		return true;
	}

}


/*@Column(name="json")
@Convert(converter=JpaConverterJson.class)
private  JsonNode json;*/