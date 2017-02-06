package astarta.db.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import astarta.business.model.ParamMsg;

public class AbstractPortalDBRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -6361369409878703201L;
	private Map<String, List<ParamMsg>> params = new HashMap<>();

	public AbstractPortalDBRuntimeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbstractPortalDBRuntimeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	public AbstractPortalDBRuntimeException(String message, Map<String,List<ParamMsg>> params, Throwable cause) {
		super(message, cause);
		this.params = params;
	}

	public AbstractPortalDBRuntimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AbstractPortalDBRuntimeException(Throwable cause) {
		super(cause);
	}

	public Map<String, List<ParamMsg>> getParams() {
		return params;
	}
	
}
