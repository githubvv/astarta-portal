package astarta.db.dao;

import java.sql.Date;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import com.fasterxml.jackson.databind.JsonNode;
import astarta.db.entity.PaySlipEnt;
import astarta.db.exception.AbstractPortalDBException;
import astarta.db.exception.ReportDataNotFoundException;
import astarta.db.exception.ReportDataSaveException;

public class PaySlipDaoImpl implements PaySlipDao {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public JsonNode getPaySlipDB(String inn, String edrpou, Date period) throws AbstractPortalDBException {
		TypedQuery<PaySlipEnt> query = getEntityManager().createQuery(
				"SELECT p FROM PaySlipEnt p WHERE p.id.inn = :inn AND p.id.edrpou = :edrpou AND p.id.period = :period", PaySlipEnt.class);
		query.setParameter("inn", inn);
		query.setParameter("edrpou", edrpou);
		query.setParameter("period", period);
		try {
			PaySlipEnt rezult = query.getSingleResult();
			return (JsonNode) rezult.getJson();

		} catch (javax.persistence.NoResultException ex) {
			throw new ReportDataNotFoundException("logics.payslip.db.data_not_found", ex);
		}
	}

	@Override
	public void saveEmplPaySlipDB(Collection<PaySlipEnt> paySlipList) throws AbstractPortalDBException {
		try {
			int i = 0;
			for (PaySlipEnt paySlipEnt : paySlipList) {
				entityManager.merge(paySlipEnt);
				if (++i % 20 == 0) {
					entityManager.flush();
					entityManager.clear();
				}
			}
		} catch (Exception ex) {
			throw new ReportDataSaveException("logics.payslip.db.data_save_error",ex);
		}

	}

}
