package astarta.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-06T15:33:13.264+0200")
@StaticMetamodel(EmployeeEnt.class)
public class EmployeeEnt_ {
	public static volatile SingularAttribute<EmployeeEnt, Integer> id;
	public static volatile SingularAttribute<EmployeeEnt, String> department;
	public static volatile SingularAttribute<EmployeeEnt, Boolean> enabled;
	public static volatile SingularAttribute<EmployeeEnt, String> position;
	public static volatile SingularAttribute<EmployeeEnt, String> tabel;
	public static volatile SingularAttribute<EmployeeEnt, CompanyEnt> company;
	public static volatile SingularAttribute<EmployeeEnt, UserEnt> user;
}
