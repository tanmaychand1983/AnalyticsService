package com.vollzo.analytics.repository;

import java.util.List;

import com.vollzo.analytics.entity.AccidentIncidentEntity;
import com.vollzo.analytics.entity.InvoiceDetailEntity;
import com.vollzo.analytics.entity.MaintenanceDetailEntity;
import com.vollzo.analytics.entity.MaintenanceEntity;
import com.vollzo.analytics.entity.NearMissDetailsEntity;
import com.vollzo.analytics.entity.NearMissEntity;
import com.vollzo.analytics.entity.NonConformityDetailsEntity;
import com.vollzo.analytics.entity.NonConformityEntity;
import com.vollzo.analytics.entity.PortStateControlDetailsEntity;
import com.vollzo.analytics.entity.PortStateControlEntity;
import com.vollzo.analytics.entity.PurchaseOrderDetailsEntity;
import com.vollzo.analytics.entity.PurchaseOrderEntity;
import com.vollzo.analytics.entity.ShipVisitDetailsEntity;
import com.vollzo.analytics.entity.ShipVisitEntity;
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
	
	//For Maintenance Dashboard
	public List<MaintenanceEntity> getMaintenanceData(String procedureName, 
			AnalyticsRequestVO requestVO);
	
	public List<MaintenanceDetailEntity> getMaintenanceDetails(String procedureName,
			String jobid);
	
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
	
	public List<PurchaseOrderDetailsEntity> getPurchaseOrderDetails(String procedureName,
			String poId);
	
	//For Invoice details
	public List<InvoiceDetailEntity> getInvoiceDetails(String procedureName,
				String poId);
	
	//For Non Conformity Dashboard
	public List<NonConformityEntity> getNonConformityData(String procedureName, 
			AnalyticsRequestVO requestVO);
	
	public List<NonConformityDetailsEntity> getNonConformityDetails(String procedureName,
				String auditncid);
		
	//For Port State Control Dashboard
	public List<PortStateControlEntity> getPortStateData(String procedureName, 
			AnalyticsRequestVO requestVO);
	
	public List<PortStateControlDetailsEntity> getPortStateControlDetails(String procedureName,
			String inspectionid);
	
	//For Ship Visit Dashboard
	public List<ShipVisitEntity> getShipVisitData(String procedureName, 
			AnalyticsRequestVO requestVO);
	public List<ShipVisitDetailsEntity> getShipVisitDetails(String procedureName,
			String inspscheduledid);
	
;
	
	
}
