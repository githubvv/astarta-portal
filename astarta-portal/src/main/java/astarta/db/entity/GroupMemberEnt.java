package astarta.db.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="group_members")
public class GroupMemberEnt implements Serializable {
	private static final long serialVersionUID = 6066898365893182717L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	private String username;

	//bi-directional many-to-one association to Group
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@Fetch(FetchMode.JOIN)
	private GroupEnt group;

	public GroupMemberEnt() {
	}
	
	public GroupMemberEnt(String username, GroupEnt group) {
		super();
		this.username = username;
		this.group = group;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public GroupEnt getGroup() {
		return this.group;
	}

	public void setGroup(GroupEnt group) {
		this.group = group;
	}

}