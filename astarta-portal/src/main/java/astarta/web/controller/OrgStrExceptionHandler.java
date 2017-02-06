package astarta.web.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import astarta.business.model.ParamMsg;
import astarta.db.exception.OrgStrCrUpdEntityException;
import astarta.db.exception.OrgStrDataNotFoundException;
import astarta.db.exception.UserPermissionSaveException;
import astarta.web.resp.ErrorMsgResp;

@ControllerAdvice
public class OrgStrExceptionHandler extends AbstractExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(OrgStrExceptionHandler.class);

	/* DB */
	@ExceptionHandler({ OrgStrDataNotFoundException.class })
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ResponseBody
	public ErrorMsgResp handleDataNotFoundException(OrgStrDataNotFoundException ex, HttpServletRequest httpServletRequest, WebRequest request, Locale locale) {
		String ip = httpServletRequest.getRemoteAddr();
		String msg = getMessageSource().getMessage(ex.getMessage(), null, locale);
		String msgLog = getMessageSource().getMessage(ex.getMessage(), null, new Locale("uk"));
		Map<String, List<ParamMsg>> details = ex.getParams();
		logger.warn("USER: {}; IP-ADRESS: {}; APP-MESSAGE CODE: [C0100]; APP-MESSAGE DESCRIPTION: {}; MESSAGE DETAILS: {}; EXCEPTION: {}",request.getRemoteUser(),ip,msgLog,details,ex.getStackTrace());
		return new ErrorMsgResp("C0101", "CLIENT", msg, details);
	}
	
	@ExceptionHandler({ OrgStrCrUpdEntityException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorMsgResp handleDataSaveException(OrgStrCrUpdEntityException ex, HttpServletRequest httpServletRequest, WebRequest request, Locale locale) {
		String ip = httpServletRequest.getRemoteAddr();
		String msg = getMessageSource().getMessage(ex.getMessage(), null, locale);
		String msgLog = getMessageSource().getMessage(ex.getMessage(), null, new Locale("uk"));
		Map<String, List<ParamMsg>> details = ex.getParams();
		logger.error("USER: {}; IP-ADRESS: {}; APP-MESSAGE CODE: [C0101]; MESSAGE DESCRIPTION: {}; MESSAGE DETAILS: {}; EXCEPTION: {}",request.getRemoteUser(),ip,msgLog, details,ex.getStackTrace());
		return new ErrorMsgResp("C0102", "CLIENT", msg, details);
	}
	
	@ExceptionHandler({ UserPermissionSaveException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorMsgResp handlePermissionSaveException(UserPermissionSaveException ex, HttpServletRequest httpServletRequest, WebRequest request, Locale locale) {
		String ip = httpServletRequest.getRemoteAddr();
		String msg = getMessageSource().getMessage(ex.getMessage(), null, locale);
		String msgLog = getMessageSource().getMessage(ex.getMessage(), null, new Locale("uk"));
		Map<String, List<ParamMsg>> details = ex.getParams();
		logger.error("USER: {}; IP-ADRESS: {}; APP-MESSAGE CODE: [C0102]; MESSAGE DESCRIPTION: {}; MESSAGE DETAILS: {}; EXCEPTION: {}",request.getRemoteUser(),ip,msgLog, details,ex.getStackTrace());
		return new ErrorMsgResp("C0103", "CLIENT", msg, details);
	}
}
