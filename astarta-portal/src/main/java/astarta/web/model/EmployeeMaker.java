package astarta.web.model;

public class EmployeeMaker {
	
	private String inn;
	private String edrpou;
	private Boolean enabled;
	public EmployeeMaker() {
	}
	public EmployeeMaker(String inn, String edrpou, Boolean enabled) {
		this.inn = inn;
		this.edrpou = edrpou;
		this.enabled = enabled;
	}
	
	public String getInn() {
		return inn;
	}
	public void setInn(String inn) {
		this.inn = inn;
	}
	public String getEdrpou() {
		return edrpou;
	}
	public void setEdrpou(String edrpou) {
		this.edrpou = edrpou;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
