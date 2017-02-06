package astarta.db.dao;

import java.util.List;
import java.util.Map;

import astarta.db.entity.CompanyEnt;
import astarta.db.entity.UserEnt;
import astarta.db.enumeration.TypeUserKey;
import astarta.db.exception.AbstractPortalDBException;

public interface OrgStructureDao {
	
	void saveCompaniesDB(List<CompanyEnt> companyList) throws AbstractPortalDBException;
	
	List<CompanyEnt> getAllCompaniesDB() throws AbstractPortalDBException;

	CompanyEnt getCompanyByEdrpouDB(String edrpou) throws AbstractPortalDBException ;

	UserEnt getUserDB(String key, TypeUserKey type) throws AbstractPortalDBException;

	Map<String, UserEnt> getUsersDB(List<String> userINNList) throws AbstractPortalDBException;
	
	void saveUsersDB(List<UserEnt> userList) throws AbstractPortalDBException;
	
}
