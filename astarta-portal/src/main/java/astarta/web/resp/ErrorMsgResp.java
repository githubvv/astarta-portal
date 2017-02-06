package astarta.web.resp;

import java.util.List;
import java.util.Map;
import astarta.business.model.ParamMsg;

public class ErrorMsgResp {
	private String code;
	private String status;
	private String error;
	private Map<String,List<ParamMsg>> details;
	
	public ErrorMsgResp() {}
	
	public ErrorMsgResp(String code, String status, String error, Map<String,List<ParamMsg>> details) {
		super();
		this.code = code;
		this.status = status;
		this.error = error;
		this.details = details;
	}

	public ErrorMsgResp(String code, String status, String error) {
		super();
		this.code = code;
		this.status = status;
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Map<String, List<ParamMsg>> getDetails() {
		return details;
	}

	public void setDetails(Map<String, List<ParamMsg>> details) {
		this.details = details;
	}
	
}
