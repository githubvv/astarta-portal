package astarta.db.entity;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class PaySlipPK implements Serializable {
	private static final long serialVersionUID = -2320118695032795333L;

	@Column(name="\"edrpou\"")
	private String edrpou;
	
	@Column(name="\"inn\"")
	private String inn;

	@Temporal(TemporalType.DATE)
	private java.util.Date period;

	public PaySlipPK() {
	}
	public String getInn() {
		return this.inn;
	}
	public void setInn(String inn) {
		this.inn = inn;
	}
	public java.util.Date getPeriod() {
		return this.period;
	}
	public void setPeriod(java.util.Date period) {
		this.period = period;
	}
	public String getEdrpou() {
		return edrpou;
	}
	public void setEdrpou(String edrpou) {
		this.edrpou = edrpou;
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
		PaySlipPK other = (PaySlipPK) obj;
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