package astarta.web.model;

import java.util.List;

public class UserModel {
	private String firstName;
	private String lastName;
	private String email;
	private String inn;
	private String password;
	private Contact contact;
	private List<Employee> employees;
	
	
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(String firstName, String lastName, String email, String inn, String password, Contact contact,
			List<Employee> employees) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.inn = inn;
		this.password = password;
		this.contact = contact;
		this.employees = employees;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInn() {
		return inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inn == null) ? 0 : inn.hashCode());
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
		UserModel other = (UserModel) obj;
		if (inn == null) {
			if (other.inn != null)
				return false;
		} else if (!inn.equals(other.inn))
			return false;
		return true;
	}



	public static class Contact {
		private String phone;
		private String mobile;
		private String adress;
		
		public Contact() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Contact(String phone, String mobile, String adress) {
			super();
			this.phone = phone;
			this.mobile = mobile;
			this.adress = adress;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getAdress() {
			return adress;
		}

		public void setAdress(String adress) {
			this.adress = adress;
		}

	}

	public static class Employee {
		private String department;
		private String position;
		private String tabel;
		private Company company;

		
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Employee(String department, String position, String tabel, Company company) {
			super();
			this.department = department;
			this.position = position;
			this.tabel = tabel;
			this.company = company;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getTabel() {
			return tabel;
		}

		public void setTabel(String tabel) {
			this.tabel = tabel;
		}

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}

	}

	public static class Company extends astarta.db.entity.CompanyEnt {
		private static final long serialVersionUID = 1L;
		private String edrpou;
		private String name;

		public Company() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Company(String edrpou, String name) {
			super();
			this.edrpou = edrpou;
			this.name = name;
		}

		public String getEdrpou() {
			return edrpou;
		}

		public void setEdrpou(String edrpou) {
			this.edrpou = edrpou;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	/*	@Override
		public int hashCode() {
			final int prime = 31;
			int result = 4651;
			result = result * prime + ((edrpou == null) ? 0 : edrpou.hashCode());
			return result;
		}*/

	}
}
