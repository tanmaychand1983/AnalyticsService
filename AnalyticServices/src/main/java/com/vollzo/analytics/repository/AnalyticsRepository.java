package com.vollzo.analytics.repository;

import java.util.List;

import com.vollzo.analytics.entity.AccidentIncidentEntity;
import com.vollzo.analytics.entity.NearMissEntity;
import com.vollzo.analytics.entity.NonConformityEntity;
import com.vollzo.analytics.entity.PurchaseOrderEntity;

public interface AnalyticsRepository {
	public List<NearMissEntity> getNeaMissData(String procedureName);
	public List<AccidentIncidentEntity> getAccidentIncidentData(String procedureName);
	public List<NonConformityEntity> getNonConformityData(String procedureName);
	public List<PurchaseOrderEntity> getPurchaseOrderData(String procedureName);
}
