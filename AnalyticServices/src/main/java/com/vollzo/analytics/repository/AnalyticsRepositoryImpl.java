package com.vollzo.analytics.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import com.vollzo.analytics.entity.AccidentIncidentEntity;
import com.vollzo.analytics.entity.MaintenanceEntity;
import com.vollzo.analytics.entity.NearMissDetailsEntity;
import com.vollzo.analytics.entity.NearMissEntity;
import com.vollzo.analytics.entity.NonConformityDetailsEntity;
import com.vollzo.analytics.entity.NonConformityEntity;
import com.vollzo.analytics.entity.PortStateControlDetailsEntity;
import com.vollzo.analytics.entity.PortStateControlEntity;
import com.vollzo.analytics.entity.PurchaseOrderDetailsEntity;
import com.vollzo.analytics.entity.PurchaseOrderEntity;
import com.vollzo.analytics.vo.AnalyticsRequestVO;

import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class AnalyticsRepositoryImpl implements AnalyticsRepository{

	@PersistenceContext
	EntityManager entityManager;

	private static final String CLASS_NAME = AnalyticsRepositoryImpl.class.getName();
	
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
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		
		query.setParameter(1, requestVO.getVesselIds());
		query.setParameter(2, requestVO.getStartDate());
		query.setParameter(3, requestVO.getEndDate());
		
		query.execute();
		
		return query.getResultList();
	}

	
	/**
     * Returns Purchase Order Filter, Graph and Grid data from DB.
     * 
     * @methodName: getPurchaseOrderData
     * @param:  procedureName - Procedure Name
     * @param: requestVO - AnalyticsRequestVO {Vessel Id List (Required), Start Date (defaultValue = ""), End Date (defaultValue = "")
     * @return - List<PurchaseOrderEntity>
     * 
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<PurchaseOrderEntity> getPurchaseOrderData(String procedureName, AnalyticsRequestVO requestVO) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(procedureName, 
				PurchaseOrderEntity.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		
		query.setParameter(1, requestVO.getServiceType());
		query.setParameter(2, requestVO.getVesselIds());
		query.setParameter(3, requestVO.getStartDate());
		query.setParameter(4, requestVO.getEndDate());
		query.execute();
		return query.getResultList();
	}
	
	/**
     * Returns NonConformityData Filter, Graph and Grid data from DB.
     * @author Deepak Bansal
     * @methodName: getNonConformityData
     * @param:  procedureName - Procedure Name
     * @param: requestVO - AnalyticsRequestVO {Vessel Id List (Required), Start Date (defaultValue = ""), End Date (defaultValue = "")
     * @return - List<NonConformityEntity>
     * 
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<NonConformityEntity> getNonConformityData(String procedureName, 
			AnalyticsRequestVO requestVO) {
		log.info(CLASS_NAME+"::Inside [getNonConformityData] Repository method!");
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(procedureName, 
				NonConformityEntity.class);
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
     * Returns Maintenace Filter, Graph and Grid data from DB.
     * @author Deepak Bansal
     * @methodName: getMaintenanceData
     * @param:  procedureName - Procedure Name
     * @param: requestVO - AnalyticsRequestVO {Vessel Id List (Required), Status (defaultValue = "")
     * @return - List<MaintenanceEntity>
     * 
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<MaintenanceEntity> getMaintenanceData(String procedureName, 
			AnalyticsRequestVO requestVO){
		log.info(CLASS_NAME+"::Inside [getMaintenanceData] Repository method!");
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(procedureName, 
				MaintenanceEntity.class);
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
     * Returns Near Miss details data from DB.
     * @author Deepak Bansal
     * @methodName: getNearMissDetails
     * @param:  procedureName - Procedure Name
     * @param: Nearmiss Id (Required)
     * @return - List<NearMissDetailsEntity>
     * 
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<NearMissDetailsEntity> getNearMissDetails(String procedureName,
			String nearmissId){
		log.info(CLASS_NAME+"::Inside [getNearMissDetails] Repository method!");
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(
				procedureName, NearMissDetailsEntity.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		
		query.setParameter(1,nearmissId);
		return query.getResultList();
	}
	
	/**
     * Returns PO details data from DB.
     * @author Deepak Bansal
     * @methodName: getPurchaseOrderDetails
     * @param:  procedureName - Procedure Name
     * @param: PO Id (Required)
     * @return - List<PurchaseOrderDetailsEntity>
     * 
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<PurchaseOrderDetailsEntity> getPurchaseOrderDetails(String procedureName,
			String poId){
		log.info(CLASS_NAME+"::Inside [getPurchaseOrderDetails] Repository method!");
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(
				procedureName, PurchaseOrderDetailsEntity.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,poId);
		
		return query.getResultList();
	}
	
	/**
     * Returns Non Conformity details data from DB.
     * @author Deepak Bansal
     * @methodName: getNonConformityDetails
     * @param:  procedureName - Procedure Name
     * @param: PO Id (Required)
     * @return - List<NonConformityDetailsEntity>
     * 
     */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NonConformityDetailsEntity> getNonConformityDetails(String procedureName,
			String auditncid){
		log.info(CLASS_NAME+"::Inside [getNonConformityDetails] Repository method!");
		
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(
				procedureName, NonConformityDetailsEntity.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,auditncid);
		
		return query.getResultList();
	}
	
	/**
     * Returns Port State Control details data from DB.
     * @author Deepak Bansal
     * @methodName: getPortStateControlDetails
     * @param:  procedureName - Procedure Name
     * @param: inspectionid (Required)
     * @return - List<PortStateControlDetailsEntity>
     * 
     */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PortStateControlDetailsEntity> getPortStateControlDetails(String procedureName,
			String inspectionid){
		log.info(CLASS_NAME+"::Inside [getPortStateControlDetails] Repository method!");
		
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(
				procedureName, PortStateControlDetailsEntity.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1,inspectionid);
		
		return query.getResultList();
	}
	
	/**
     * Returns Port State Control Filter, Graph and Grid data from DB.
     * @methodName: getPortStateData
     * @param:  procedureName - Procedure Name
     * @param: vesselId - Vessel Id List (Required)
     * @param: startDate - Start Date (defaultValue = "")
     * @param: endDate -  End Date (defaultValue = "")
     * @return - List<PortStateControlEntity>
     * 
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<PortStateControlEntity> getPortStateData(String procedureName, 
			AnalyticsRequestVO requestVO){
		log.info(CLASS_NAME+"::Inside [getPortStateData] Repository method!");
		
		StoredProcedureQuery  query = entityManager.createStoredProcedureQuery(procedureName, PortStateControlEntity.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		
		query.setParameter(1, requestVO.getVesselIds());
		query.setParameter(2, requestVO.getStartDate());
		query.setParameter(3, requestVO.getEndDate());
		
		query.execute();
		
		return query.getResultList();
	}
}

