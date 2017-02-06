package astarta.business.service;

import java.util.List;

import astarta.db.enumeration.UserGroup;
import astarta.db.exception.AbstractPortalDBException;

public interface PermissionService {
	
	void setUserPerm(List<String> user, UserGroup role) throws AbstractPortalDBException;

}
