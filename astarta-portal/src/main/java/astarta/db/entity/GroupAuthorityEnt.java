package astarta.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the group_authorities database table.
 * 
 */
@Entity
@Table(name="group_authorities")
public class GroupAuthorityEnt implements Serializable {
	private static final long serialVersionUID = -6087443374203306045L;

	@EmbeddedId
	private GroupAuthorityPK id;

	//bi-directional many-to-one association to Group
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="group_id",insertable=false, updatable = false)
	private GroupEnt group;

	public GroupAuthorityEnt() {
	}
	
	public GroupAuthorityPK getId() {
		return this.id;
	}

	public void setId(GroupAuthorityPK id) {
		this.id = id;
	}

	public GroupEnt getGroup() {
		return this.group;
	}

	public void setGroup(GroupEnt group) {
		this.group = group;
	}

}