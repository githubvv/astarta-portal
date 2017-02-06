package astarta.db.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the group_authorities database table.
 * 
 */
@Embeddable
public class GroupAuthorityPK implements Serializable {
	private static final long serialVersionUID = -5647420328459074309L;

	@Column(name="group_id", insertable=false, updatable=false)
	private Long groupId;

	private String authority;

	public GroupAuthorityPK() {
	}
	public Long getGroupId() {
		return this.groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getAuthority() {
		return this.authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GroupAuthorityPK)) {
			return false;
		}
		GroupAuthorityPK castOther = (GroupAuthorityPK)other;
		return 
			this.groupId.equals(castOther.groupId)
			&& this.authority.equals(castOther.authority);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.groupId.hashCode();
		hash = hash * prime + this.authority.hashCode();
		
		return hash;
	}
}