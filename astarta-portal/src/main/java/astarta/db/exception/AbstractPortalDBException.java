package astarta.db.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import astarta.business.model.ParamMsg;

public abstract class AbstractPortalDBException  extends Exception {
	private static final long serialVersionUID = 7794641104644967693L;
	private Map<String,List<ParamMsg>> params = new HashMap<>();
	
	public AbstractPortalDBException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbstractPortalDBException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	public AbstractPortalDBException(String message, Map<String,List<ParamMsg>> params, Throwable cause) {
		super(message, cause);
		this.params = params;
		// TODO Auto-generated constructor stub
	}

	public AbstractPortalDBException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AbstractPortalDBException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public Map<String, List<ParamMsg>> getParams() {
		return params;
	}
	
}
