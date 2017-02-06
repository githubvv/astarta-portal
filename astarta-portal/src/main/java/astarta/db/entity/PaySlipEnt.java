package astarta.db.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.databind.JsonNode;

import astarta.db.converter.JpaConverterJson;

@Entity
@Table(name="payslips")
public class PaySlipEnt implements Serializable {
	private static final long serialVersionUID = 5528544918013930765L;

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.AUTO)
	private PaySlipPK id;

	@Column(name="json")
	@Convert(converter=JpaConverterJson.class)
	private  JsonNode json;

	public PaySlipEnt() {
	}

	public PaySlipPK getId() {
		return this.id;
	}

	public void setId(PaySlipPK id) {
		this.id = id;
	}

	public JsonNode getJson() {
		return this.json;
	}

	public void setJson(JsonNode json) {
		this.json = json;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PaySlipEnt other = (PaySlipEnt) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}