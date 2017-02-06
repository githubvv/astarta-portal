package astarta.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import astarta.db.entity.CompanyEnt;
import astarta.db.entity.UserEnt;
import astarta.db.enumeration.TypeUserKey;
import astarta.db.exception.AbstractPortalDBException;
import astarta.db.exception.OrgStrCrUpdEntityException;
import astarta.db.exception.OrgStrDataNotFoundException;

public class OrgStructureDaoImpl implements OrgStructureDao {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void saveCompaniesDB(List<CompanyEnt> companyList) throws AbstractPortalDBException {
		try {
			companyList.forEach((comp) -> {
				entityManager.merge(comp);
			});
		} catch (Exception ex) {
			throw new OrgStrCrUpdEntityException("logics.org_structure.db.create_update_company",ex);
		}
	}

	@Override
	public List<CompanyEnt> getAllCompaniesDB() throws AbstractPortalDBException {
		TypedQuery<CompanyEnt> query = entityManager.createQuery("SELECT c FROM CompanyEnt c", CompanyEnt.class);
		try{
			List<CompanyEnt> rezult = query.getResultList();
			return rezult;
		}
		catch(javax.persistence.NoResultException ex){
			throw new OrgStrDataNotFoundException("common.exception.norezult",ex);
		}
	}
	
	@Override
	public CompanyEnt getCompanyByEdrpouDB(String edrpou) throws AbstractPortalDBException {
		TypedQuery<CompanyEnt> query = entityManager.createQuery("SELECT c FROM CompanyEnt c where edrpou =:edrpou", CompanyEnt.class);
		query.setParameter("edrpou", edrpou);
		try{
			CompanyEnt rezult = query.getSingleResult();
			return rezult;
		}
		catch (javax.persistence.NoResultException ex) {
			/*throw new OrgStrDataNotFoundException("logics.org_structure.db.company_not-found",ex);*/
			return null;
		}
	}
	
	@Override
	public UserEnt getUserDB(String key, TypeUserKey type)  throws AbstractPortalDBException  {
		String sql = "";
		switch (type) {
		case EMAIL:
			sql = "SELECT u FROM UserEnt u WHERE email = :findParam";
			break;
		case USERNAME:
			;
			sql = "SELECT u FROM UserEnt u WHERE username = :findParam";
			break;
		}
		TypedQuery<UserEnt> query = getEntityManager().createQuery(sql, UserEnt.class);
		query.setParameter("findParam", key);
		try {
			UserEnt rezult = query.getSingleResult();
			return rezult;
		} catch (javax.persistence.NoResultException ex) {
			throw new OrgStrDataNotFoundException("Data is not found. Error getting user account by parameter: "+ type + " value: " + key);
		}
	}
	

	@Override
	public Map<String,UserEnt> getUsersDB(List<String> userINNList) throws AbstractPortalDBException {
		
		TypedQuery<UserEnt> query = getEntityManager().createQuery("SELECT u FROM UserEnt u WHERE username IN :userNames", UserEnt.class);
		query.setParameter("userNames", userINNList);
		try {
			List<UserEnt> rezult = query.getResultList();
			Map<String,UserEnt> userMap = new HashMap<>();
			rezult.forEach(user->userMap.put(user.getUsername(), user));
			return userMap;
		} catch (javax.persistence.NoResultException ex) {
			throw new OrgStrDataNotFoundException("common.exception.norezult",ex);
		}
	}

	@Override
	public void saveUsersDB(List<UserEnt> userList) throws AbstractPortalDBException{
		try {
			int i = 0;
			for (UserEnt userEnt : userList) {
				entityManager.merge(userEnt);
				if (++i % 20 == 0) {
					entityManager.flush();
					entityManager.clear();
				}
			}
		} catch (Exception ex) {
			throw new OrgStrCrUpdEntityException("logics.org_structure.db.user_create_update_exception",ex);
		}
		
	}
}
