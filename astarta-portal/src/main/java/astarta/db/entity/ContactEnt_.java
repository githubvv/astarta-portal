package astarta.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-20T17:04:10.400+0200")
@StaticMetamodel(ContactEnt.class)
public class ContactEnt_ {
	public static volatile SingularAttribute<ContactEnt, Integer> id;
	public static volatile SingularAttribute<ContactEnt, String> adress;
	public static volatile SingularAttribute<ContactEnt, String> mobile;
	public static volatile SingularAttribute<ContactEnt, String> phone;
	public static volatile SingularAttribute<ContactEnt, UserEnt> user;
}
