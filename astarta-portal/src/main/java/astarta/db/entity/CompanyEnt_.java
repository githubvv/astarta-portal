package astarta.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-06T09:56:24.541+0200")
@StaticMetamodel(CompanyEnt.class)
public class CompanyEnt_ {
	public static volatile SingularAttribute<CompanyEnt, String> edrpou;
	public static volatile SingularAttribute<CompanyEnt, String> name;
	public static volatile ListAttribute<CompanyEnt, EmployeeEnt> employees;
}
