package astarta.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-21T17:01:33.315+0200")
@StaticMetamodel(UserEnt.class)
public class UserEnt_ {
	public static volatile SingularAttribute<UserEnt, Integer> id;
	public static volatile SingularAttribute<UserEnt, String> email;
	public static volatile SingularAttribute<UserEnt, Boolean> enabled;
	public static volatile SingularAttribute<UserEnt, String> firstName;
	public static volatile SingularAttribute<UserEnt, String> lastName;
	public static volatile SingularAttribute<UserEnt, String> password;
	public static volatile SingularAttribute<UserEnt, String> username;
	public static volatile SingularAttribute<UserEnt, ContactEnt> contacts;
	public static volatile ListAttribute<UserEnt, EmployeeEnt> employees;
}
