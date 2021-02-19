package com.vollzo.analytics.repository;

import java.util.List;

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
	public List<MaintenanceEntity> getMaintenanceData(String procedureName, 
			AnalyticsRequestVO requestVO);
	
	//For Near Miss Dashboard
	public List<NearMissEntity> getNeaMissData(String procedureName, 
			AnalyticsRequestVO requestVO);
	
	//For Accident-Incident Dashboard
	public List<AccidentIncidentEntity> getAccidentIncidentData(String procedureName, 
			AnalyticsRequestVO requestVO);
	
	//Method for near miss & Accident-Incident details
	public List<NearMissDetailsEntity> getNearMissDetails(String procedureName,
			String nearmissId);
	
	//For Purchase Order Dashboard 
	public List<PurchaseOrderEntity> getPurchaseOrderData(String procedureName,
			AnalyticsRequestVO requestVO);
	
	//For purchase order details
	public List<PurchaseOrderDetailsEntity> getPurchaseOrderDetails(String procedureName,
			String poId);
	
	//For Non Conformity Dashboard
	public List<NonConformityEntity> getNonConformityData(String procedureName, 
			AnalyticsRequestVO requestVO);
	
	//For Non Conformity details
	public List<NonConformityDetailsEntity> getNonConformityDetails(String procedureName,
				String auditncid);
		
	//For Port State Control details
	public List<PortStateControlDetailsEntity> getPortStateControlDetails(String procedureName,
				String inspectionid);
	
	//For Port State Control Dashboard
	public List<PortStateControlEntity> getPortStateData(String procedureName, 
			AnalyticsRequestVO requestVO);	
}
