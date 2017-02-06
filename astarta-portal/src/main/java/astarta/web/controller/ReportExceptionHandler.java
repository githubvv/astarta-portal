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
import astarta.db.exception.ReportDataSaveException;
import astarta.db.exception.ReportDataNotFoundException;
import astarta.web.resp.ErrorMsgResp;

@ControllerAdvice
public class ReportExceptionHandler extends AbstractExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ReportExceptionHandler.class);
	
	/* DB */
	@ExceptionHandler({ ReportDataSaveException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorMsgResp handleDataSaveException(ReportDataSaveException ex, HttpServletRequest httpServletRequest, WebRequest request, Locale locale) {
		String ip = httpServletRequest.getRemoteAddr();
		String msg = getMessageSource().getMessage(ex.getMessage(), null, locale);
		String msgLog = getMessageSource().getMessage(ex.getMessage(), null, new Locale("uk"));
		Map<String, List<ParamMsg>> details = ex.getParams();
		logger.error("USER: {}; IP-ADRESS: {}; APP-MESSAGE CODE: [C0002]; MESSAGE DESCRIPTION: {}; MESSAGE DETAILS: {}; EXCEPTION: {}",request.getRemoteUser(),ip,msgLog,details,ex.getStackTrace());
		return new ErrorMsgResp("C0121", "CLIENT", msg);
	}
	
	@ExceptionHandler({ ReportDataNotFoundException.class })
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ErrorMsgResp handleReportDataNotFoundException(ReportDataNotFoundException ex, HttpServletRequest httpServletRequest, WebRequest request, Locale locale) {
		String ip = httpServletRequest.getRemoteAddr();
		String msg = getMessageSource().getMessage(ex.getMessage(), null, locale); 
		String msgLog = getMessageSource().getMessage(ex.getMessage(), null, new Locale("uk"));
		Map<String, List<ParamMsg>> details = ex.getParams();
		logger.warn("USER: {}; IP-ADRESS: {}; APP-MESSAGE CODE: [C0003]; MESSAGE DESCRIPTION: {}; MESSAGE DETAILS: {}; EXCEPTION: {}",request.getRemoteUser(),ip,msgLog,details,ex.getStackTrace());
		return new ErrorMsgResp("C0122", "CLIENT", msg);
	}
		
}