package astarta.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-29T12:02:53.998+0200")
@StaticMetamodel(GroupMemberEnt.class)
public class GroupMemberEnt_ {
	public static volatile SingularAttribute<GroupMemberEnt, Long> id;
	public static volatile SingularAttribute<GroupMemberEnt, String> username;
	public static volatile SingularAttribute<GroupMemberEnt, GroupEnt> group;
}
