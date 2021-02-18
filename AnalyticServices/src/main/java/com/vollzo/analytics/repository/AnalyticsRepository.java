package com.vollzo.analytics.repository;

import java.util.List;

import com.vollzo.analytics.entity.AccidentIncidentEntity;
import com.vollzo.analytics.entity.MaintenanceEntity;
import com.vollzo.analytics.entity.NearMissDetailsEntity;
import com.vollzo.analytics.entity.NearMissEntity;
import com.vollzo.analytics.entity.NonConformityDetailsEntity;
import com.vollzo.analytics.entity.NonConformityEntity;
import com.vollzo.analytics.entity.PortStateControlDetailsEntity;
import com.vollzo.analytics.entity.PurchaseOrderDetailsEntity;
import com.vollzo.analytics.entity.PurchaseOrderEntity;
import com.vollzo.analytics.vo.AnalyticsRequestVO;

/**
 * {@summary}: This is the Analytics Repository interface.
 * 
 * @className: AnalyticsRepository
 * @author Ajaya Kar
 * @since: Jan 23, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */
public interface AnalyticsRepository {
	public List<NearMissEntity> getNeaMissData(String procedureName, 
			AnalyticsRequestVO requestVO);
	public List<AccidentIncidentEntity> getAccidentIncidentData(String procedureName, 
			AnalyticsRequestVO requestVO);
	public List<PurchaseOrderEntity> getPurchaseOrderData(String procedureName,
			AnalyticsRequestVO requestVO);
	
	public List<NonConformityEntity> getNonConformityData(String procedureName, 
			AnalyticsRequestVO requestVO);
	
	public List<MaintenanceEntity> getMaintenanceData(String procedureName, 
			AnalyticsRequestVO requestVO);
	
	//Method for near miss details
	
	public List<NearMissDetailsEntity> getNearMissDetails(String procedureName,
			String nearmissId);
	
	//Method for purchase order details
	public List<PurchaseOrderDetailsEntity> getPurchaseOrderDetails(String procedureName,
			String poId);
	
	//Method for Non Conformity details
		public List<NonConformityDetailsEntity> getNonConformityDetails(String procedureName,
				String auditncid);
		
	//Method for Port State Control details
		public List<PortStateControlDetailsEntity> getPortStateControlDetails(String procedureName,
				String inspectionid);
}
