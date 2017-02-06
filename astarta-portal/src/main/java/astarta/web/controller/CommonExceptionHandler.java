package astarta.web.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import astarta.business.model.ParamMsg;
import astarta.db.exception.DataNotFoundException;
import astarta.db.exception.InfoException;
import astarta.db.exception.JsonParsingRuntimeException;
import astarta.web.resp.ErrorMsgResp;

@ControllerAdvice
public class CommonExceptionHandler extends AbstractExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	/* SECURITY */
	@ExceptionHandler({ AccessDeniedException.class })
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	@ResponseBody
	public ErrorMsgResp handleAccessDeniedException(Exception ex, HttpServletRequest httpServletRequest, WebRequest request, Locale locale) {
		String ip = httpServletRequest.getRemoteAddr();
		String msg = getMessageSource().getMessage("security.access_denied", null, locale);
		logger.error("USER: {}; IP-ADRESS: {}; APP-MESSAGE CODE: [S0001]; APP-MESSAGE DESCRIPTION: {}; EXCEPTION: {}",request.getRemoteUser(),ip,msg,ex.toString());
		return new ErrorMsgResp("ST0001", "SECURITY", msg);
	}
	
	/*DB*/
	@ExceptionHandler({ DataNotFoundException.class })
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ResponseBody
	public ErrorMsgResp handleDataNotFoundException(DataNotFoundException ex, HttpServletRequest httpServletRequest, WebRequest request, Locale locale) {
		String ip = httpServletRequest.getRemoteAddr();
		String msg = getMessageSource().getMessage(ex.getMessage(), null, locale);
		String msgLog = getMessageSource().getMessage(ex.getMessage(), null, new Locale("uk"));
		Map<String, List<ParamMsg>> details = ex.getParams();
		logger.warn("USER: {}; IP-ADRESS: {}; APP-MESSAGE CODE: [C0001]; APP-MESSAGE DESCRIPTION: {}; MESSAGE DETAILS: {}; EXCEPTION: {}",request.getRemoteUser(),ip,msgLog,details,ex.getStackTrace());
		return new ErrorMsgResp("C0001", "CLIENT", msg);
	}
	
	/* EXCEPTION */
	@ExceptionHandler({NullPointerException.class})
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	ErrorMsgResp handleNullPointerException(Exception ex, HttpServletRequest httpServletRequest, WebRequest request, Locale locale) {
		String ip = httpServletRequest.getRemoteAddr();
		String msg = getMessageSource().getMessage("exception.npe", null, locale);
		logger.error("USER: {}; IP-ADRESS: {}; APP-MESSAGE CODE: [E0001]; APP-MESSAGE DESCRIPTION: {}; EXCEPTION: {}",request.getRemoteUser(),ip,msg,ex.toString());
		return new ErrorMsgResp("SM0001", "SYSTEM", msg);
	}
	
	@ExceptionHandler({JsonParsingRuntimeException.class})
	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ResponseBody
	ErrorMsgResp handleJsonParsingRuntimeException(Exception ex, HttpServletRequest httpServletRequest, WebRequest request, Locale locale) {
		String ip = httpServletRequest.getRemoteAddr();
		String msg = getMessageSource().getMessage(ex.getMessage(), null, locale);
		logger.error("USER: {}; IP-ADRESS: {}; APP-MESSAGE CODE: [E0002]; APP-MESSAGE DESCRIPTION: {}; EXCEPTION: {}",request.getRemoteUser(),ip,msg,ex.getStackTrace());
		return new ErrorMsgResp("C0002", "CLIENT", msg);
	}
	
	
	@ExceptionHandler({ InfoException.class })
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ErrorMsgResp handlePermissionSaveException(InfoException ex, HttpServletRequest httpServletRequest, WebRequest request, Locale locale) {
		String ip = httpServletRequest.getRemoteAddr();
		String msg = getMessageSource().getMessage(ex.getMessage(), null, locale);
		String msgLog = getMessageSource().getMessage(ex.getMessage(), null, new Locale("uk"));
		Map<String, List<ParamMsg>> details = ex.getParams();
		logger.info("USER: {}; IP-ADRESS: {}; APP-MESSAGE CODE: [C0006]; MESSAGE DESCRIPTION: {}; MESSAGE DETAILS: {}; EXCEPTION: {}",request.getRemoteUser(),ip,msgLog, details,ex.getStackTrace());
		return new ErrorMsgResp("C0003", "CLIENT", msg, details);
	}


}
