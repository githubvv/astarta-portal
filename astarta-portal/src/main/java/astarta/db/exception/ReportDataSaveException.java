package astarta.db.exception;

import java.util.List;
import java.util.Map;

import astarta.business.model.ParamMsg;

public class ReportDataSaveException extends AbstractPortalDBException {
	private static final long serialVersionUID = 2622302479662574016L;

	public ReportDataSaveException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportDataSaveException(String message, Map<String, List<ParamMsg>> params, Throwable cause) {
		super(message, params, cause);
		// TODO Auto-generated constructor stub
	}

	public ReportDataSaveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ReportDataSaveException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ReportDataSaveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
