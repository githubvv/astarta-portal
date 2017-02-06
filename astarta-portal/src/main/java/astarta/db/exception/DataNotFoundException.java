package astarta.db.exception;

import java.util.List;
import java.util.Map;

import astarta.business.model.ParamMsg;

public class DataNotFoundException extends AbstractPortalDBException {
	private static final long serialVersionUID = -5692770386698531370L;

	public DataNotFoundException() {
		super();
	}
	
	public DataNotFoundException(String message, Map<String, List<ParamMsg>> params, Throwable cause) {
		super(message, params, cause);
		// TODO Auto-generated constructor stub
	}

	public DataNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DataNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataNotFoundException(String message) {
		super(message);
	}

}
