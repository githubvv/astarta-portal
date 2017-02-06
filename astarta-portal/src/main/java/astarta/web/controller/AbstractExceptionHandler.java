package astarta.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import astarta.web.config.bundle.ExposedResourceMessageBundleSource;

public class AbstractExceptionHandler extends ResponseEntityExceptionHandler {
 
    @Autowired
    private ExposedResourceMessageBundleSource messageSource;

	public ExposedResourceMessageBundleSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(ExposedResourceMessageBundleSource messageSource) {
		this.messageSource = messageSource;
	}
}