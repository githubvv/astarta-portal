package astarta.db.exception;

import java.util.List;
import java.util.Map;

import astarta.business.model.ParamMsg;

public class OrgStrCrUpdEntityException extends AbstractPortalDBRuntimeException  {
	private static final long serialVersionUID = 7555211618462353649L;

	public OrgStrCrUpdEntityException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrgStrCrUpdEntityException(String message, Map<String, List<ParamMsg>> params, Throwable cause) {
		super(message, params, cause);
		// TODO Auto-generated constructor stub
	}

	public OrgStrCrUpdEntityException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OrgStrCrUpdEntityException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OrgStrCrUpdEntityException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
