package astarta.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the groups database table.
 * 
 */
@Entity
@Table(name="groups")
public class GroupEnt implements Serializable {
	private static final long serialVersionUID = -2812919885802353499L;

	@Id
	private Long id;

	@Column(name="group_name")
	private String groupName;

	//bi-directional many-to-one association to GroupAuthority
	@OneToMany(mappedBy="group")
	private List<GroupAuthorityEnt> groupAuthorities;

	//bi-directional many-to-one association to GroupMember
	@OneToMany(mappedBy="group")
	private List<GroupMemberEnt> groupMembers;

	public GroupEnt() {
	}

	public GroupEnt(Long id, String groupName) {
		super();
		this.id = id;
		this.groupName = groupName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<GroupAuthorityEnt> getGroupAuthorities() {
		return this.groupAuthorities;
	}

	public void setGroupAuthorities(List<GroupAuthorityEnt> groupAuthorities) {
		this.groupAuthorities = groupAuthorities;
	}

	public GroupAuthorityEnt addGroupAuthority(GroupAuthorityEnt groupAuthority) {
		getGroupAuthorities().add(groupAuthority);
		groupAuthority.setGroup(this);

		return groupAuthority;
	}

	public GroupAuthorityEnt removeGroupAuthority(GroupAuthorityEnt groupAuthority) {
		getGroupAuthorities().remove(groupAuthority);
		groupAuthority.setGroup(null);

		return groupAuthority;
	}

	public List<GroupMemberEnt> getGroupMembers() {
		return this.groupMembers;
	}

	public void setGroupMembers(List<GroupMemberEnt> groupMembers) {
		this.groupMembers = groupMembers;
	}

	public GroupMemberEnt addGroupMember(GroupMemberEnt groupMember) {
		getGroupMembers().add(groupMember);
		groupMember.setGroup(this);

		return groupMember;
	}

	public GroupMemberEnt removeGroupMember(GroupMemberEnt groupMember) {
		getGroupMembers().remove(groupMember);
		groupMember.setGroup(null);

		return groupMember;
	}
	
	

}