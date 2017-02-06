package astarta.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import astarta.db.dao.PermissionDao;
import astarta.db.enumeration.UserGroup;
import astarta.db.exception.AbstractPortalDBException;
import astarta.db.exception.ReportDataSaveException;
import astarta.db.exception.UserPermissionSaveException;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
	 
	@Autowired 
	private PermissionDao permissionDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.SERIALIZABLE, rollbackFor = {
			ReportDataSaveException.class }, noRollbackFor={UserPermissionSaveException.class})
	public void setUserPerm(List<String> users, UserGroup role) throws AbstractPortalDBException {
		permissionDao.setUserGroupDB(users, role);
	}
}
