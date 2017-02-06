package astarta.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import astarta.business.service.PaySlipService;
import astarta.db.exception.AbstractPortalDBException;
import astarta.security.config.AuthenticationFacadeImpl;
import astarta.web.model.PaySlipModel;

@RestController
public class PaySlipController {

	@SuppressWarnings("unused")
	@Autowired
	private AuthenticationFacadeImpl authenticationFacadeImpl;
	  
	@Autowired
	PaySlipService paySlipService;

	@RequestMapping(value = "/payslip/get", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getPaySlip(@RequestParam(value = "period", required = true) java.sql.Date period, @RequestParam(value = "edrpou", required = true) String edrpou)
			throws AbstractPortalDBException{
		return new ResponseEntity<String>(paySlipService.getEmplPaySlip(period, edrpou).toString(), HttpStatus.OK);
	}

	@RequestMapping(value = "/payslip/load-from-1c", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<HttpStatus> loadPaySlipsFrom1C(@RequestBody List<PaySlipModel> paySlipList)
			throws AbstractPortalDBException {
		if (paySlipList == null || paySlipList.isEmpty())
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		else{
			paySlipService.saveEmplPaySlip(paySlipList);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
	}
}
