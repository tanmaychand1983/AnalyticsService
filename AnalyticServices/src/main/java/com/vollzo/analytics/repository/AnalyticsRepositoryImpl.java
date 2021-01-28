package com.vollzo.analytics.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import com.vollzo.analytics.entity.AccidentIncidentEntity;
import com.vollzo.analytics.entity.NearMissEntity;
import com.vollzo.analytics.entity.NonConformityEntity;
import com.vollzo.analytics.entity.PurchaseOrderEntity;
import com.vollzo.analytics.vo.AnalyticsRequestVO;

/**
 * {@summary}: This is the Analytics Repository implementation.
 * 
 * @className: AnalyticsRepositoryImpl
 * @author: Ajaya Kar
 * @since: Jan 23, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */
@Repository
public class AnalyticsRepositoryImpl implements AnalyticsRepository{

	@PersistenceContext
	EntityManager entityManager;

	
	/**
     * Returns NearMissData Filter, Graph and Grid data from DB.
     * 
     * @methodName: getNeaMissData
     * @param:  procedureName - Procedure Name
     * @param: vesselId - Vessel Id List (Required)
     * @param: startDate - Start Date (defaultValue = "")
     * @param: endDate -  End Date (defaultValue = "")
     * @return - List<NearMissEntity>
     * 
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<NearMissEntity> getNeaMissData(String procedureName, AnalyticsRequestVO requestVO) {
		StoredProcedureQuery  query = entityManager.createStoredProcedureQuery(procedureName, NearMissEntity.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		
		query.setParameter(1, requestVO.getVesselIds());
		query.setParameter(2, requestVO.getStartDate());
		query.setParameter(3, requestVO.getEndDate());
		
		query.execute();
		
		return query.getResultList();
	}

	/**
     * Returns AccidentIncidentData Filter, Graph and Grid data from DB.
     * 
     * @methodName: getAccidentIncidentData
     * @param:  procedureName - Procedure Name
     * @param: vesselId - Vessel Id List (Required)
     * @return - List<AccidentIncidentEntity>
     * 
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<AccidentIncidentEntity> getAccidentIncidentData(String procedureName, AnalyticsRequestVO requestVO) {
		StoredProcedureQuery  query = entityManager.createStoredProcedureQuery(procedureName, AccidentIncidentEntity.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, requestVO.getVesselIds());
		query.execute();
		
		return query.getResultList();
	}


	@Override
	public List<NonConformityEntity> getNonConformityData(String procedureName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<PurchaseOrderEntity> getPurchaseOrderData(String procedureName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
