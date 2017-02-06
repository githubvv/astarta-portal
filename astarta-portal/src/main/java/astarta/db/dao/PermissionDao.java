package astarta.db.dao;

import java.util.List;

import astarta.db.enumeration.UserGroup;
import astarta.db.exception.AbstractPortalDBException;

public interface PermissionDao {

	void setUserGroupDB(List<String> userNameList, UserGroup group) throws AbstractPortalDBException;
	
}
