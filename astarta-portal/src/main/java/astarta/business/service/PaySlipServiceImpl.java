package astarta.business.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.JsonNode;

import astarta.business.model.ParamMsg;
import astarta.db.dao.PaySlipDao;
import astarta.db.entity.PaySlipEnt;
import astarta.db.entity.PaySlipPK;
import astarta.db.exception.AbstractPortalDBException;
import astarta.db.exception.InfoException;
import astarta.db.exception.ReportDataSaveException;
import astarta.security.config.AuthenticationFacadeImpl;
import astarta.security.config.UserDetailsExt;
import astarta.db.exception.ReportDataNotFoundException;
import astarta.web.config.bundle.ExposedResourceMessageBundleSource;
import astarta.web.controller.ReportExceptionHandler;
import astarta.web.model.PaySlipModel;

@Service("paySlipService")
public class PaySlipServiceImpl implements PaySlipService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ReportExceptionHandler.class);

	@Autowired
	private PaySlipDao paySlipDao;
	/*@Autowired
	private OrgStructureService orgStructureService;*/
	@Autowired
	private ExposedResourceMessageBundleSource messageSource;
	@Autowired
	private AuthenticationFacadeImpl authenticationFacadeImpl;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE, rollbackFor = {
			ReportDataSaveException.class }, noRollbackFor = { ReportDataNotFoundException.class })
	public void saveEmplPaySlip(List<PaySlipModel> paySlipList) throws AbstractPortalDBException {
		Map<String, List<ParamMsg>> notValidModels = new HashMap<>();
		Collection<PaySlipEnt> paySlipEntList = prepLoadList(paySlipList, notValidModels);
		paySlipDao.saveEmplPaySlipDB(paySlipEntList);

		if (!notValidModels.isEmpty())
			throw new InfoException("common.data.not_valid", notValidModels, null);
	}

	private Collection<PaySlipEnt> prepLoadList(List<PaySlipModel> paySlipModelList,
			Map<String, List<ParamMsg>> notValidModels) throws AbstractPortalDBException {
		List<PaySlipEnt> paySlipEntList = new ArrayList<>();

		for (PaySlipModel payslip : paySlipModelList) {
			
			boolean isValid = true;
			List<ParamMsg> paramMsgList = new ArrayList<>();
			StringBuilder paySlipStr = new StringBuilder();
			paySlipStr.append("INN: ").append(payslip.getInn()).append(" EDRPOU:").append(payslip.getEdrpou())
					.append(" PERIOD ").append(payslip.getPeriod());

			if (payslip.getInn()==null || payslip.getInn().isEmpty()) {
				paramMsgList.add(new ParamMsg("[INN]", messageSource.getMessage("common.data.is_empty",null,new Locale("uk"))));
				isValid = false;
			}
			if (payslip.getEdrpou()==null || payslip.getEdrpou().isEmpty()) {
				paramMsgList.add(new ParamMsg("[COMPANY EDRPOU]", messageSource.getMessage("common.data.is_empty",null,new Locale("uk"))));
				isValid = false;

			}
			if (payslip.getPeriod() == null) {
				paramMsgList.add(new ParamMsg("[PERIOD]", messageSource.getMessage("common.data.is_empty",null,new Locale("uk"))));
				isValid = false;
			}

			if (!isValid) {
				notValidModels.put(paySlipStr.toString(), paramMsgList);
				continue;
			}

			PaySlipPK pk = new PaySlipPK();
			pk.setInn(payslip.getInn());
			pk.setEdrpou(payslip.getEdrpou());
			pk.setPeriod(payslip.getPeriod());

			PaySlipEnt paySlipEnt = new PaySlipEnt();
			paySlipEnt.setId(pk);
			paySlipEnt.setJson(payslip.getJson());
			paySlipEntList.add(paySlipEnt);
		}

		return paySlipEntList;
	}

	@Override
	public JsonNode getEmplPaySlip(Date period, String edrpou) throws AbstractPortalDBException {

		Authentication auth = authenticationFacadeImpl.getAuthentication();
		UserDetailsExt userDetailsExt = (UserDetailsExt) auth.getPrincipal();
		String username = userDetailsExt.getUserData().getUsername();

		return paySlipDao.getPaySlipDB(username, edrpou, period);
	}

}
