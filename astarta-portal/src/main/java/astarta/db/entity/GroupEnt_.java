package astarta.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-29T12:02:54.352+0200")
@StaticMetamodel(GroupEnt.class)
public class GroupEnt_ {
	public static volatile SingularAttribute<GroupEnt, Long> id;
	public static volatile SingularAttribute<GroupEnt, String> groupName;
	public static volatile ListAttribute<GroupEnt, GroupAuthorityEnt> groupAuthorities;
	public static volatile ListAttribute<GroupEnt, GroupMemberEnt> groupMembers;
}
