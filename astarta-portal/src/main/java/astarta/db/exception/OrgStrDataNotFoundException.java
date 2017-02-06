package astarta.db.exception;

import java.util.List;
import java.util.Map;

import astarta.business.model.ParamMsg;

public class OrgStrDataNotFoundException extends AbstractPortalDBException {
	private static final long serialVersionUID = -5231672091989321195L;

	public OrgStrDataNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrgStrDataNotFoundException(String message, Map<String, List<ParamMsg>> params, Throwable cause) {
		super(message, params, cause);
		// TODO Auto-generated constructor stub
	}

	public OrgStrDataNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OrgStrDataNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OrgStrDataNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
