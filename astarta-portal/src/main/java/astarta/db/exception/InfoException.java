package astarta.db.exception;

import java.util.List;
import java.util.Map;

import astarta.business.model.ParamMsg;

public class InfoException extends AbstractPortalDBException {
	private static final long serialVersionUID = 7352041173269496282L;

	public InfoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InfoException(String message, Map<String, List<ParamMsg>> params, Throwable cause) {
		super(message, params, cause);
		// TODO Auto-generated constructor stub
	}

	public InfoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InfoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InfoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
