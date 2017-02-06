package astarta.db.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import astarta.db.entity.GroupEnt;
import astarta.db.entity.GroupMemberEnt;
import astarta.db.enumeration.UserGroup;
import astarta.db.exception.AbstractPortalDBException;
import astarta.db.exception.UserPermissionSaveException;
public class PermissionDaoImpl implements PermissionDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void setUserGroupDB(List<String> userNameList, UserGroup userGroup) throws AbstractPortalDBException {
		GroupEnt group = new GroupEnt(userGroup.getGroupId(),userGroup.toString());
		try {
			int i = 0;
			for (String userName : userNameList) {
				entityManager.merge(new GroupMemberEnt(userName,group));
				
				if (++i % 20 == 0) {
					entityManager.flush();
					entityManager.clear();
				}
			}
		} catch (Exception ex) {
			throw new UserPermissionSaveException("logics.permission.db.save-user-role",ex);
		}
		
	}

}
