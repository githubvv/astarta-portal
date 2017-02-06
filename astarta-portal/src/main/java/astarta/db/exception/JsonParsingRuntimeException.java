package astarta.db.exception;

import java.util.List;
import java.util.Map;

import astarta.business.model.ParamMsg;

public class JsonParsingRuntimeException extends AbstractPortalDBRuntimeException {
	private static final long serialVersionUID = 6432087126972249411L;

	public JsonParsingRuntimeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonParsingRuntimeException(String message, Map<String, List<ParamMsg>> params, Throwable cause) {
		super(message, params, cause);
		// TODO Auto-generated constructor stub
	}

	public JsonParsingRuntimeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public JsonParsingRuntimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public JsonParsingRuntimeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
