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

@Repository
public class AnalyticsRepositoryImpl implements AnalyticsRepository{

	@PersistenceContext
	EntityManager entityManager;

	
	@Override
	public List<NearMissEntity> getNeaMissData(String procedureName) {
		StoredProcedureQuery  query = entityManager.createStoredProcedureQuery(procedureName, NearMissEntity.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		
		query.setParameter(1, "");
		query.setParameter(2, "");
		query.execute();
		
		return query.getResultList();
	}


	@Override
	public List<AccidentIncidentEntity> getAccidentIncidentData(String procedureName) {
		StoredProcedureQuery  query = entityManager.createStoredProcedureQuery(procedureName, AccidentIncidentEntity.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.OUT);
		
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
