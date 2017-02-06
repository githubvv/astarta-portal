package astarta.db.exception;

import java.util.List;
import java.util.Map;

import astarta.business.model.ParamMsg;

public class ReportDataNotFoundException extends AbstractPortalDBException {
	private static final long serialVersionUID = -561685812083208699L;

	public ReportDataNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportDataNotFoundException(String message, Map<String, List<ParamMsg>> params, Throwable cause) {
		super(message, params, cause);
		// TODO Auto-generated constructor stub
	}

	public ReportDataNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ReportDataNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ReportDataNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
