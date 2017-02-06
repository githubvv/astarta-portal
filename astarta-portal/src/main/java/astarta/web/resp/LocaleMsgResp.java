package astarta.web.resp;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonSetter;

public class LocaleMsgResp {
	private Map<String,String> localeMap = new HashMap<>();

	public LocaleMsgResp() {
	}

	public LocaleMsgResp(Map<String,String> localeMap) {
		this.localeMap = localeMap;
	}

	public Map<String, String> getLocaleMap() {
		return localeMap;
	}

	@JsonSetter("localeMap")
	public void setLocaleMap(Map<String, String> localeMap) {
		this.localeMap = localeMap;
	}
	
}
