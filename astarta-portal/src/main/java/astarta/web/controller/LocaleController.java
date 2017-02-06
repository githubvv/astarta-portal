package astarta.web.controller;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import astarta.web.config.bundle.ExposedResourceMessageBundleSource;
import astarta.web.resp.LocaleMsgResp;

@RestController
public class LocaleController {
	public static String basename = "classpath:locale/client";

	@Autowired
	ExposedResourceMessageBundleSource messageSource;
	
	public ExposedResourceMessageBundleSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(ExposedResourceMessageBundleSource messageSource) {
		this.messageSource = messageSource;
	}

	@RequestMapping(value = "/locale", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ResponseEntity<LocaleMsgResp> getLocaleContainer(Locale locale) {
		String propFileName = basename + "_" + locale.toString();
		LocaleMsgResp localeContainer = new LocaleMsgResp(messageSource.getMessages(propFileName));
		return new ResponseEntity<LocaleMsgResp>(localeContainer, HttpStatus.OK);
	}

}
