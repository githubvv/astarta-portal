package astarta.db.exception;

import java.util.List;
import java.util.Map;

import astarta.business.model.ParamMsg;

public class UserPermissionSaveException extends AbstractPortalDBException {
	private static final long serialVersionUID = -4200610243564295621L;

	public UserPermissionSaveException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPermissionSaveException(String message, Map<String, List<ParamMsg>> params, Throwable cause) {
		super(message, params, cause);
		// TODO Auto-generated constructor stub
	}

	public UserPermissionSaveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserPermissionSaveException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserPermissionSaveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
