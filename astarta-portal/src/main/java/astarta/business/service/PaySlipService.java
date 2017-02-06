package astarta.business.service;

import java.sql.Date;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.fasterxml.jackson.databind.JsonNode;
import astarta.db.exception.AbstractPortalDBException;
import astarta.web.model.PaySlipModel;

public interface PaySlipService {
	
	public void saveEmplPaySlip(List<PaySlipModel> paySlipList) throws AbstractPortalDBException;
	
	@PreAuthorize(value = "isAuthenticated()")
	public JsonNode getEmplPaySlip(Date period, String edrpou) throws AbstractPortalDBException;

}
