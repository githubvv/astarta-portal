package astarta.web.model;

import com.fasterxml.jackson.databind.JsonNode;
import java.sql.Date;

public class PaySlipModel {
	private String inn;
	private Date period;
	private String edrpou;
	private JsonNode json;

	public PaySlipModel() {
		
	}

	public PaySlipModel(String inn, Date period, String edrpou, JsonNode json) {
		this.inn = inn;
		this.period = period;
		this.edrpou = edrpou;
		this.json = json;
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

	public Date getPeriod() {
		return period;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}

	public JsonNode getJson() {
		return json;
	}

	public void setJson(JsonNode json) {
		this.json = json;
	}

	@Override
	public String toString() {
		return "PaySlipModel [inn=" + inn + ", period=" + period + ", edrpou=" + edrpou + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edrpou == null) ? 0 : edrpou.hashCode());
		result = prime * result + ((inn == null) ? 0 : inn.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
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
		PaySlipModel other = (PaySlipModel) obj;
		if (edrpou == null) {
			if (other.edrpou != null)
				return false;
		} else if (!edrpou.equals(other.edrpou))
			return false;
		if (inn == null) {
			if (other.inn != null)
				return false;
		} else if (!inn.equals(other.inn))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		return true;
	}
	
	
	
}
