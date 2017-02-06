package astarta.business.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import astarta.business.model.ParamMsg;
import astarta.db.dao.OrgStructureDao;
import astarta.db.dao.PermissionDao;
import astarta.db.entity.CompanyEnt;
import astarta.db.entity.ContactEnt;
import astarta.db.entity.EmployeeEnt;
import astarta.db.entity.UserEnt;
import astarta.db.enumeration.TypeUserKey;
import astarta.db.enumeration.UserGroup;
import astarta.db.exception.AbstractPortalDBException;
import astarta.db.exception.InfoException;
import astarta.db.exception.OrgStrCrUpdEntityException;
import astarta.db.exception.OrgStrDataNotFoundException;
import astarta.web.config.bundle.ExposedResourceMessageBundleSource;
import astarta.web.model.EmployeeMaker;
import astarta.web.model.UserModel;
import astarta.web.model.UserModel.Contact;
import astarta.web.model.UserModel.Employee;

@Service("orgStructureService")
public class OrgStructureServiceImpl implements OrgStructureService {

	@Autowired
	private OrgStructureDao orgStructureDao;
	@Autowired
	private PermissionDao permissionDao;
	@Autowired
	private ExposedResourceMessageBundleSource messageSource;
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_UNCOMMITTED, rollbackFor = {
			OrgStrDataNotFoundException.class })
	public List<CompanyEnt> getAllCompanies() throws AbstractPortalDBException {
		List<CompanyEnt> companies = orgStructureDao.getAllCompaniesDB();
		return companies;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = {
			OrgStrCrUpdEntityException.class })
	@Override
	public void saveCompanies(List<CompanyEnt> companies) throws AbstractPortalDBException {
		orgStructureDao.saveCompaniesDB(companies);
	}

	@Override
	public CompanyEnt getCompanyByEdrpou(String edrpou) throws AbstractPortalDBException {
		CompanyEnt company = orgStructureDao.getCompanyByEdrpouDB(edrpou);
		return company;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public Map<String, UserEnt> getUsers(List<String> usersINNList) throws AbstractPortalDBException {
		Map<String, UserEnt> users = orgStructureDao.getUsersDB(usersINNList);
		return users;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public UserEnt getUsers(String key, TypeUserKey type) throws AbstractPortalDBException {
		return orgStructureDao.getUserDB(key, TypeUserKey.USERNAME);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = {
			OrgStrCrUpdEntityException.class }, noRollbackFor={InfoException.class})
	public void saveUsers(Collection<UserModel> userModellList) throws AbstractPortalDBException {

		// New users to set default user group USER
		Set<String> newUserNames = new HashSet<>();
		Map<String, List<ParamMsg>> notValidModels = new HashMap<>();
		// User's list to save to DB
		List<UserEnt> usersToSave = new ArrayList<>();

		for (UserModel userModel : userModellList) {
			if (!checkUserModelValid(userModel, notValidModels))
				continue;
			Contact contactModel = userModel.getContact();
			UserEnt userEnt = null;
			
			try{
				userEnt = getUsers(userModel.getInn(), TypeUserKey.USERNAME);
			}
			catch(OrgStrDataNotFoundException e){
				userEnt = new UserEnt();
				userEnt.setEmployees(new ArrayList<>(2));
				userEnt.setContacts(new ContactEnt());
			}

			userEnt.getContacts().setAdress(contactModel.getAdress());
			userEnt.getContacts().setMobile(contactModel.getMobile());
			userEnt.getContacts().setPhone(contactModel.getPhone());
			for (Employee emplModel : userModel.getEmployees()) {
				boolean emplIsNew = true;
				CompanyEnt companyEnt = getCompanyByEdrpou(emplModel.getCompany().getEdrpou());
				if (companyEnt == null)
					companyEnt = new CompanyEnt();
				companyEnt.setEdrpou(emplModel.getCompany().getEdrpou());
				companyEnt.setName(emplModel.getCompany().getName());

				String edrpouIN = emplModel.getCompany().getEdrpou();
				// find in empl list of userEnt
				
				Optional<EmployeeEnt> emplOpt = userEnt.getEmployees().stream().filter(empl->empl.getCompany().getEdrpou().equals(edrpouIN)).findFirst();
				emplIsNew = !emplOpt.isPresent();
				EmployeeEnt emplEnt = emplOpt.orElse(new EmployeeEnt());

				emplEnt.setCompany(companyEnt);
				emplEnt.setDepartment(emplModel.getDepartment());
				emplEnt.setEnabled(true);
				emplEnt.setPosition(emplModel.getPosition());
				emplEnt.setTabel(emplModel.getTabel());
				
				if (emplIsNew)
					userEnt.addEmployee(emplEnt);
			}
			userEnt.setUsername(userModel.getInn());
			userEnt.setPassword(userModel.getPassword());
			userEnt.setFirstName(userModel.getFirstName());
			userEnt.setLastName(userModel.getLastName());
			userEnt.setEmail(userModel.getEmail());
			userEnt.setEnabled(true);

			usersToSave.add(userEnt);
			newUserNames.add(userEnt.getUsername());
		}
		orgStructureDao.saveUsersDB(usersToSave);
		// set permissions USER_ROLE for loaded users from 1C.
		permissionDao.setUserGroupDB(new ArrayList<String>(newUserNames), UserGroup.USER);
		if (!notValidModels.isEmpty())
			throw new InfoException("common.data.not_valid", notValidModels, null);
		
	}

	private boolean checkUserModelValid(UserModel userModel, Map<String, List<ParamMsg>> notValidModels)
			throws AbstractPortalDBException {
		boolean status = true;
		StringBuilder user = new StringBuilder();
		List<ParamMsg> paramMsgList = new ArrayList<>();
		user.append("USERNAME: ").append(userModel.getInn()).append(" FIO:").append(userModel.getFirstName())
				.append(" ").append(userModel.getLastName()).append(" EMAIL:").append(userModel.getEmail());
		if (userModel.getInn().isEmpty()) {
			paramMsgList.add(new ParamMsg("[INN]", messageSource.getMessage("common.data.is_empty",null,new Locale("uk"))));
			status = false;
		}
		for (Employee empl : userModel.getEmployees()) {
			if (empl.getCompany().getEdrpou().isEmpty()) {
				paramMsgList.add(new ParamMsg("[COMPANY EDRPOU]", messageSource.getMessage("common.data.is_empty",null,new Locale("uk"))));
				status = false;
			}
		}
		if (!status)
			notValidModels.put(user.toString(), paramMsgList );
		return status;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE, rollbackFor = {
			OrgStrCrUpdEntityException.class })
	public void setEmplsEnable(List<EmployeeMaker> emplsMaker) throws AbstractPortalDBException {
		List<String> userNameList = emplsMaker.stream().map(EmployeeMaker::getInn).collect(Collectors.toList());
		Map<String, UserEnt> usersMap = orgStructureDao.getUsersDB(userNameList);

		for (EmployeeMaker emplMaker : emplsMaker) {
			UserEnt userEnt = usersMap.get(emplMaker.getInn());
			userEnt.getEmployees().stream()
					.filter(empl -> empl.getCompany().getEdrpou().contains(emplMaker.getEdrpou()))
					.forEach(empl -> empl.setEnabled(emplMaker.getEnabled()));
		}
		for (UserEnt userEnt : usersMap.values()) {
			Boolean noCompanies = userEnt.getEmployees().stream().allMatch(empl -> empl.getEnabled() == Boolean.FALSE);
			if (noCompanies)
				userEnt.setEnabled(false);
		}
		orgStructureDao.saveUsersDB(new ArrayList<UserEnt>(usersMap.values()));
	}

}
