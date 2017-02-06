package astarta.db.dao;

import java.sql.Date;
import java.util.Collection;
import com.fasterxml.jackson.databind.JsonNode;
import astarta.db.entity.PaySlipEnt;
import astarta.db.exception.AbstractPortalDBException;

public interface PaySlipDao {
	
	JsonNode getPaySlipDB(String username, String edrpou, Date period) throws AbstractPortalDBException;
	
	void saveEmplPaySlipDB(Collection<PaySlipEnt> paySlipList) throws AbstractPortalDBException;

}
