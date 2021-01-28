package com.vollzo.analytics.repository;

import java.util.List;

import com.vollzo.analytics.entity.AccidentIncidentEntity;
import com.vollzo.analytics.entity.NearMissEntity;
import com.vollzo.analytics.entity.NonConformityEntity;
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
	public List<NonConformityEntity> getNonConformityData(String procedureName, 
			AnalyticsRequestVO requestVO);
	public List<PurchaseOrderEntity> getPurchaseOrderData(String procedureName);
}
