package astarta.business.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import astarta.db.entity.CompanyEnt;
import astarta.db.entity.UserEnt;
import astarta.db.enumeration.TypeUserKey;
import astarta.db.exception.AbstractPortalDBException;
import astarta.web.model.EmployeeMaker;
import astarta.web.model.UserModel;

public interface OrgStructureService {
	
	CompanyEnt getCompanyByEdrpou(String edrpou)  throws AbstractPortalDBException;
	
	List<CompanyEnt> getAllCompanies()  throws AbstractPortalDBException;
	
	void saveCompanies(List<CompanyEnt> companies)  throws AbstractPortalDBException;
	
	Map<String, UserEnt> getUsers(List<String> userNames) throws AbstractPortalDBException;
	
	UserEnt getUsers(String key, TypeUserKey type) throws AbstractPortalDBException;
 	
	void saveUsers(Collection <UserModel> userList) throws AbstractPortalDBException;
	
	void setEmplsEnable(List<EmployeeMaker> emplsMaker) throws AbstractPortalDBException;
}
