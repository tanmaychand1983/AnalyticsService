package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vollzo.analytics.entity.AccidentIncidentEntity;
import com.vollzo.analytics.entity.NearMissEntity;
import com.vollzo.analytics.entity.NonConformityEntity;
import com.vollzo.analytics.entity.PurchaseOrderEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.util.Constant;
import com.vollzo.analytics.util.Util;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;
import com.vollzo.analytics.vo.GridVO;
import com.vollzo.analytics.vo.AnalyticsVO;

/**
 * {@summary}: This is the Service class for Analytical module.
 * 
 * @className: AnalyticsService
 * @author Ajaya Kar
 * @since: Jan 23, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */

@Service
public class AnalyticsService {

	@Autowired
	private BaseRepository repository;
	
	/**
     * Returns NearMiss Filter, Graph and Grid data by date range from Data layer.
     * 
     * @methodName: getNearMissData
     * @param: vesselId - Vessel Id List (Required)
     * @param startDate - Start Date (defaultValue = "")
     * @param endDate -  End Date (defaultValue = "")
     * @return - AnalyticsVO
     * 
     */
	public AnalyticsResponseVO getNearMissData(AnalyticsRequestVO requestVO){
		List<NearMissEntity> nearMissEntityList 	= repository.getNeaMissData(QueryRepository.STORPROC_DASHBOARD_NEARMISS, requestVO);
		AnalyticsResponseVO analyticsResponseVO 					= new AnalyticsResponseVO();
		Map<String, AnalyticsVO> unitMapList 		= new HashMap<>();
		GridVO gridVO 								= null;
		AnalyticsVO analyticsVO						= null;
		List<Map<String, String>> categoryList 		= null;
		Map<String, String> categoryMap 			= null;
		List<Map<String, String>> vesselList 		= null;
		Map<String, String> vesselMap 				= null;
		List<Map<String, String>> statusList 		= null;
		Map<String, String> statusMap 				= null;
		for(NearMissEntity entity :  nearMissEntityList) {
			gridVO 		= new GridVO();
			categoryMap = new HashMap<>();
			vesselMap 	= new HashMap<>();
			statusMap 	= new HashMap<>();
			if(!unitMapList.containsKey(entity.getUnitName())) {
				analyticsVO 	= new AnalyticsVO();
				categoryList 	= new ArrayList<>();
				statusList 		= new ArrayList<>();
				vesselList 		= new ArrayList<>();
				
				/*@Set Category list*/
				categoryMap.put(Constant.CATEGORY_ID, Util.nullCheck(entity.getCategoryId()));
				categoryMap.put(Constant.CATEGORY_NAME, Util.nullCheck(entity.getCategoryName()));
				categoryList.add(categoryMap);
				
				/*@Set Status list*/
				statusMap.put(Constant.STATUS_ID, Util.nullCheck(entity.getStatusId()));
				statusMap.put(Constant.STATUS_NAME, Util.nullCheck(entity.getStatusName()));
				statusList.add(statusMap);
				
				/*@Set Vessel list*/
				vesselMap.put(Constant.VESSEL_ID, Util.nullCheck(entity.getVesselId()));
				vesselMap.put(Constant.VESSEL_NAME, Util.nullCheck(entity.getVesselName()));
				vesselList.add(vesselMap);
				
				/*@Set NearMiss VO*/
				analyticsVO.setUnitId(Util.nullCheck(entity.getUnitId()));
				analyticsVO.setUnitName(Util.nullCheck(entity.getUnitName()));
				analyticsVO.setCategoryList(categoryList);
				analyticsVO.setStatusList(statusList);
				analyticsVO.setVesselList(vesselList);
				analyticsVO.setDataList(new ArrayList<>());
				
				/*@Set Unit Map list*/
				unitMapList.put(entity.getUnitName(), analyticsVO);
			}else {
				/*@Add Category list*/
				setFilters(unitMapList.get(entity.getUnitName()).getCategoryList(), Constant.CATEGORY_ID, 
						Constant.CATEGORY_NAME, categoryMap, entity.getCategoryId(), entity.getCategoryName());
				
				/*@Add Status list*/
				setFilters(unitMapList.get(entity.getUnitName()).getStatusList(), Constant.STATUS_ID, 
						Constant.STATUS_NAME, statusMap, entity.getStatusId(), entity.getStatusName());
								
				/*@Add Vessel list*/
				setFilters(unitMapList.get(entity.getUnitName()).getVesselList(), Constant.VESSEL_ID, 
						Constant.VESSEL_NAME, vesselMap, entity.getVesselId(), entity.getVesselName());
			}
			
			/*@Set Data list*/
			gridVO.setId(entity.getId());
			gridVO.setVesselId(Util.nullCheck(entity.getVesselId()));
			gridVO.setVesselName(Util.nullCheck(entity.getVesselName()));
			gridVO.setCategoryId(Util.nullCheck(entity.getCategoryId()));
			gridVO.setCategoryName(Util.nullCheck(entity.getCategoryName()));
			gridVO.setTitle(Util.nullCheck(entity.getTitle()));
			gridVO.setRefNumber(Util.nullCheck(entity.getRefNumber()));
			gridVO.setReportedDate(Util.nullCheck(entity.getReportedDate()));
			gridVO.setReportedBy(Util.nullCheck(entity.getReportedBy()));
			gridVO.setStatusId(Util.nullCheck(entity.getStatusId().toString()));
			gridVO.setStatusName(Util.nullCheck(entity.getStatusName()));
			unitMapList.get(entity.getUnitName()).getDataList().add(gridVO);
		}	
		analyticsResponseVO.setUnitList(unitMapList);
		return analyticsResponseVO;
	}
	
	/**
     * Returns AccidentIncidentData Filter, Graph and Grid data from Data layer.
     * 
     * @methodName: getAccidentIncidentData
     * @return - AnalyticsVO
     * 
     */
	public AnalyticsResponseVO getAccidentIncidentData(AnalyticsRequestVO requestVO){
		List<AccidentIncidentEntity> accidentIncidentEntityList = repository.getAccidentIncidentData(QueryRepository.STORPROC_DASHBOARD_ACCINC, requestVO);
		AnalyticsResponseVO analyticsResponseVO 	= new AnalyticsResponseVO();
		Map<String, AnalyticsVO> unitMapList 		= new HashMap<>();
		
		GridVO gridVO 								= null;
		AnalyticsVO analyticsVO						= null;
		List<Map<String, String>> categoryList 		= null;
		Map<String, String> categoryMap 			= null;
		List<Map<String, String>> vesselList 		= null;
		Map<String, String> vesselMap 				= null;
		List<Map<String, String>> statusList 		= null;
		Map<String, String> statusMap 				= null;
		List<Map<String, String>> severityList 		= null;
		Map<String, String> severityMap 			= null;
		for(AccidentIncidentEntity entity :  accidentIncidentEntityList) {
			categoryMap = new HashMap<>();
			vesselMap 	= new HashMap<>();
			statusMap 	= new HashMap<>();
			gridVO 		= new GridVO();
			severityMap	= new HashMap<>();
			if(!unitMapList.containsKey(entity.getUnitName())) {
				analyticsVO 	= new AnalyticsVO();
				categoryList 	= new ArrayList<>();
				statusList 		= new ArrayList<>();
				vesselList 		= new ArrayList<>();
				severityList	= new ArrayList<>();
				
				/*@Set Category list*/
				categoryMap.put(Constant.CATEGORY_ID, Util.nullCheck(entity.getCategoryId()));
				categoryMap.put(Constant.CATEGORY_NAME, Util.nullCheck(entity.getCategoryName()));
				categoryList.add(categoryMap);
				
				/*@Set Status list*/
				statusMap.put(Constant.STATUS_ID, Util.nullCheck(entity.getStatusId()));
				statusMap.put(Constant.STATUS_NAME, Util.nullCheck(entity.getStatusName()));
				statusList.add(statusMap);
				
				/*@Set Vessel list*/
				vesselMap.put(Constant.VESSEL_ID, Util.nullCheck(entity.getVesselId()));
				vesselMap.put(Constant.VESSEL_NAME, Util.nullCheck(entity.getVesselName()));
				vesselList.add(vesselMap);
				
				/*@Set Severity list*/
				severityMap.put(Constant.SEVERITY, Util.nullCheck(entity.getSeverity()));
				severityList.add(severityMap);
				
				/*@Set AccidentIncident VO*/
				analyticsVO.setUnitId(Util.nullCheck(entity.getUnitId()));
				analyticsVO.setUnitName(Util.nullCheck(entity.getUnitName()));
				analyticsVO.setCategoryList(categoryList);
				analyticsVO.setStatusList(statusList);
				analyticsVO.setVesselList(vesselList);
				analyticsVO.setSeverityList(severityList);
				analyticsVO.setDataList(new ArrayList<>());
				
				/*@Set Unit Map list*/
				unitMapList.put(entity.getUnitName(), analyticsVO);
			}else {
				
				/*@Add Category list*/
				setFilters(unitMapList.get(entity.getUnitName()).getCategoryList(), Constant.CATEGORY_ID, 
						Constant.CATEGORY_NAME, categoryMap, entity.getCategoryId(), entity.getCategoryName());
				
				/*@Add Status list*/
				setFilters(unitMapList.get(entity.getUnitName()).getStatusList(), Constant.STATUS_ID, 
						Constant.STATUS_NAME, statusMap, entity.getStatusId(), entity.getStatusName());
								
				/*@Add Vessel list*/
				setFilters(unitMapList.get(entity.getUnitName()).getVesselList(), Constant.VESSEL_ID, 
						Constant.VESSEL_NAME, vesselMap, entity.getVesselId(), entity.getVesselName());
				
				/*@Add Severity list*/
				setFilters(unitMapList.get(entity.getUnitName()).getSeverityList(),  
						Constant.SEVERITY, "", severityMap, entity.getSeverity(), null);
			}
			
			/*@Set Data list*/
			gridVO.setId(entity.getId());
			gridVO.setVesselId(Util.nullCheck(entity.getVesselId()));
			gridVO.setVesselName(Util.nullCheck(entity.getVesselName()));
			gridVO.setCategoryId(Util.nullCheck(entity.getCategoryId()));
			gridVO.setCategoryName(Util.nullCheck(entity.getCategoryName()));
			gridVO.setTitle(Util.nullCheck(entity.getTitle()));
			gridVO.setRefNumber(Util.nullCheck(entity.getRefNumber()));
			gridVO.setReportedDate(Util.nullCheck(entity.getReportedDate()));
			gridVO.setReportedBy(Util.nullCheck(entity.getReportedBy()));
			gridVO.setStatusId(Util.nullCheck(entity.getStatusId().toString()));
			gridVO.setStatusName(Util.nullCheck(entity.getStatusName()));
			unitMapList.get(entity.getUnitName()).getDataList().add(gridVO);
		}	
		analyticsResponseVO.setUnitList(unitMapList);
		return analyticsResponseVO;
	}
	
	/**
     * Returns Non Conformity Filter, Graph and Grid data by date range from Data layer.
     * 
     * @methodName: getNonConformityData
     * @param: vesselId - Vessel Id List (Required)
     * @param startDate - Start Date (defaultValue = "")
     * @param endDate -  End Date (defaultValue = "")
     * @return - AnalyticsResponseVO
     * 
     */
	public AnalyticsResponseVO getNonConformityData(AnalyticsRequestVO requestVO){
		List<NonConformityEntity> nonConformityEntityList = 
					repository.getNonConformityData(QueryRepository.STORPROC_DASHBOARD_NONCONF, requestVO);
		AnalyticsResponseVO analyticsResponseVO = new AnalyticsResponseVO();
		Map<String, AnalyticsVO> unitMapList 	= new HashMap<>();
		
		GridVO gridVO 							= null;
		AnalyticsVO analyticsVO					= null;
		List<Map<String, String>> vesselList 	= null;
		Map<String, String> vesselMap 			= null;
		List<Map<String, String>> statusList 	= null;
		Map<String, String> statusMap 			= null;
		List<Map<String, String>> auditTypeList = null;
		Map<String, String> auditTypeMap 		= null;
		for(NonConformityEntity entity : nonConformityEntityList) {
			gridVO 			= new GridVO();
			vesselMap 		= new HashMap<>();
			statusMap 		= new HashMap<>();
			auditTypeMap 	= new HashMap<>();
			
			if(!unitMapList.containsKey(entity.getUnitName())) {
				analyticsVO 	= new AnalyticsVO();
				vesselList 		= new ArrayList<>();
				statusList 		= new ArrayList<>();
				auditTypeList 	= new ArrayList<>();
				
				/*@Set Vessel list*/
				vesselMap.put(Constant.VESSEL_ID, Util.nullCheck(entity.getVesselId()));
				vesselMap.put(Constant.VESSEL_NAME, Util.nullCheck(entity.getVesselName()));
				vesselList.add(vesselMap);
				
				/*@Set Status list*/
				statusMap.put(Constant.STATUS_ID, Util.nullCheck(entity.getStatusId()));
				statusMap.put(Constant.STATUS_NAME, Util.nullCheck(entity.getStatusName()));
				statusList.add(statusMap);
				
				/*@Set AuditType list*/
				auditTypeMap.put(Constant.AUDIT_TYPE, Util.nullCheck(entity.getAuditType()));
				auditTypeList.add(auditTypeMap);
				
				/*@Set NonConformity VO*/
				analyticsVO.setUnitId(Util.nullCheck(entity.getUnitId()));
				analyticsVO.setUnitName(Util.nullCheck(entity.getUnitName()));
				analyticsVO.setStatusList(statusList);
				analyticsVO.setVesselList(vesselList);
				analyticsVO.setAuthTypeList(auditTypeList);
				analyticsVO.setDataList(new ArrayList<>());
				
				/*@Set Unit Map list*/
				unitMapList.put(entity.getUnitName(), analyticsVO);
			}else{
				/*@Add Vessel list*/
				setFilters(unitMapList.get(entity.getUnitName()).getVesselList(), Constant.VESSEL_ID, 
						Constant.VESSEL_NAME, vesselMap, entity.getVesselId(), entity.getVesselName());
				
				/*@Add Status list*/
				setFilters(unitMapList.get(entity.getUnitName()).getStatusList(), Constant.STATUS_ID, 
						Constant.STATUS_NAME, statusMap, entity.getStatusId(), entity.getStatusName());
				
				/*@Add AuditType list*/
				setFilters(unitMapList.get(entity.getUnitName()).getAuthTypeList(),  
						Constant.AUDIT_TYPE, "", auditTypeMap, entity.getAuditType(), null);
			}
			
			/*@Set Data list*/
			gridVO.setId(entity.getId());
			gridVO.setVesselId(Util.nullCheck(entity.getVesselId()));
			gridVO.setVesselName(Util.nullCheck(entity.getVesselName()));
			gridVO.setRefNumber(Util.nullCheck(entity.getRefNumber()));
			gridVO.setPortName(Util.nullCheck(entity.getPortName()));
			gridVO.setAuditType(Util.nullCheck(entity.getAuditType()));
			gridVO.setStage(Util.nullCheck(entity.getStage()));
			gridVO.setAuditDate(Util.nullCheck(entity.getAuditDate()));
			gridVO.setDueDate(Util.nullCheck(entity.getDueDate()));
			gridVO.setStatusId(Util.nullCheck(entity.getStatusId()));
			gridVO.setStatusName(Util.nullCheck(entity.getStatusName()));
			unitMapList.get(entity.getUnitName()).getDataList().add(gridVO);
		}
		analyticsResponseVO.setUnitList(unitMapList);
		return analyticsResponseVO;
	}
	
	public List<PurchaseOrderEntity> getPurchaseOrderData(){
		return repository.getPurchaseOrderData(QueryRepository.STORPROC_DASHBOARD_PURORD);
	}
	
	private static void setFilters(List<Map<String, String>> listMap, String idKey, String nameKey, Map<String, String> mapObj, Object id, Object name) {
		
		if(listMap != null) {
			if(listMap.stream()
				     .filter(item -> item.get(idKey).equals(Util.nullCheck(id))).collect(Collectors.toList()).size() < 1) {
				if(!"".equals(idKey))
					mapObj.put(idKey, Util.nullCheck(id));
				if(!"".equals(nameKey))
					mapObj.put(nameKey, Util.nullCheck(name));
				listMap.add(mapObj);
			}
		}
	}
}
