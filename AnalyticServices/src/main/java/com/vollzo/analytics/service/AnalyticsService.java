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
import com.vollzo.analytics.util.Util;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;
import com.vollzo.analytics.vo.CategoryVO;
import com.vollzo.analytics.vo.GridVO;
import com.vollzo.analytics.vo.SeverityVO;
import com.vollzo.analytics.vo.AnalyticsVO;
import com.vollzo.analytics.vo.StatusVO;
import com.vollzo.analytics.vo.VesselVO;

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
     * @param startDate - Start Date (defaultValue = "")
     * @param endDate -  End Date (defaultValue = "")
     * @return - AnalyticsVO
     * 
     */
	public AnalyticsResponseVO getNearMissData(AnalyticsRequestVO requestVO){
		List<NearMissEntity> nearMissEntityList 	= repository.getNeaMissData(QueryRepository.STORPROC_DASHBOARD_NEARMISS, requestVO);
		AnalyticsResponseVO analyticsResponseVO 					= new AnalyticsResponseVO();
		Map<String, AnalyticsVO> unitMapList 		= new HashMap<>();
		List<StatusVO> statusList 					= null;
		List<CategoryVO> categoryList 				= null;
		List<VesselVO> vesselList 					= null;
		StatusVO statusVO 							= null;
		CategoryVO categoryVO 						= null;
		VesselVO vesselVO 							= null;
		GridVO gridVO 								= null;
		AnalyticsVO analyticsVO						= null;
		for(NearMissEntity entity :  nearMissEntityList) {
			categoryVO 		= new CategoryVO();
			statusVO 		= new StatusVO();
			vesselVO 		= new VesselVO();
			gridVO 	= new GridVO();
			if(!unitMapList.containsKey(entity.getUnitName())) {
				analyticsVO 		= new AnalyticsVO();
				categoryList 	= new ArrayList<>();
				statusList 		= new ArrayList<>();
				vesselList 		= new ArrayList<>();
				
				/*@Set Category list*/
				categoryVO.setCategoryId(Util.nullCheck(entity.getCategoryId()));
				categoryVO.setCategoryName(Util.nullCheck(entity.getCategoryName()));
				categoryList.add(categoryVO);
				
				/*@Set Status list*/
				statusVO.setStatusId(Util.nullCheck(entity.getStatusId()));
				statusVO.setStatusName(Util.nullCheck(entity.getStatusName()));
				statusList.add(statusVO);
				
				/*@Set Vessel list*/
				vesselVO.setVesselId(Util.nullCheck(entity.getVesselId()));
				vesselVO.setVesselName(Util.nullCheck(entity.getVesselName()));
				vesselList.add(vesselVO);
				
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
				if(unitMapList.get(entity.getUnitName()).getCategoryList().stream()
					     .filter(item -> item.getCategoryId().equals(Util.nullCheck(entity.getCategoryId()))).collect(Collectors.toList()).size() < 1) {
					categoryVO.setCategoryId(Util.nullCheck(entity.getCategoryId()));
					categoryVO.setCategoryName(Util.nullCheck(entity.getCategoryName()));
					unitMapList.get(entity.getUnitName()).getCategoryList().add(categoryVO);
				}
				
				/*@Add Status list*/
				if(unitMapList.get(entity.getUnitName()).getStatusList().stream()
					     .filter(item -> item.getStatusId().equals(Util.nullCheck(entity.getStatusId()))).collect(Collectors.toList()).size() < 1) {
					statusVO.setStatusId(Util.nullCheck(entity.getStatusId().toString()));
					statusVO.setStatusName(Util.nullCheck(entity.getStatusName()));
					unitMapList.get(entity.getUnitName()).getStatusList().add(statusVO);
				}
				
				/*@Add Vessel list*/
				if(unitMapList.get(entity.getUnitName()).getVesselList().stream()
					     .filter(item -> item.getVesselId().equals(Util.nullCheck(entity.getVesselId()))).collect(Collectors.toList()).size() < 1) {
					vesselVO.setVesselId(Util.nullCheck(entity.getVesselId()));
					vesselVO.setVesselName(Util.nullCheck(entity.getVesselName()));
					unitMapList.get(entity.getUnitName()).getVesselList().add(vesselVO);
				}
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
		List<StatusVO> statusList 					= null;
		List<CategoryVO> categoryList 				= null;
		List<VesselVO> vesselList 					= null;
		List<SeverityVO> severityList 				= null;
		StatusVO statusVO 							= null;
		CategoryVO categoryVO 						= null;
		VesselVO vesselVO 							= null;
		GridVO gridVO 								= null;
		AnalyticsVO analyticsVO						= null;
		SeverityVO severityVO						= null;
		for(AccidentIncidentEntity entity :  accidentIncidentEntityList) {
			categoryVO 		= new CategoryVO();
			statusVO 		= new StatusVO();
			vesselVO 		= new VesselVO();
			gridVO 			= new GridVO();
			severityVO		= new SeverityVO();
			if(!unitMapList.containsKey(entity.getUnitName())) {
				analyticsVO 	= new AnalyticsVO();
				categoryList 	= new ArrayList<>();
				statusList 		= new ArrayList<>();
				vesselList 		= new ArrayList<>();
				severityList	= new ArrayList<>();
				
				/*@Set Category list*/
				categoryVO.setCategoryId(Util.nullCheck(entity.getCategoryId()));
				categoryVO.setCategoryName(Util.nullCheck(entity.getCategoryName()));
				categoryList.add(categoryVO);
				
				/*@Set Status list*/
				statusVO.setStatusId(Util.nullCheck(entity.getStatusId()));
				statusVO.setStatusName(Util.nullCheck(entity.getStatusName()));
				statusList.add(statusVO);
				
				/*@Set Vessel list*/
				vesselVO.setVesselId(Util.nullCheck(entity.getVesselId()));
				vesselVO.setVesselName(Util.nullCheck(entity.getVesselName()));
				vesselList.add(vesselVO);
				
				/*@Set Severity list*/
				severityVO.setSeverity(Util.nullCheck(entity.getSeverity()));
				severityList.add(severityVO);
				
				/*@Set AccidentIncident VO*/
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
				if(unitMapList.get(entity.getUnitName()).getCategoryList().stream()
					     .filter(item -> item.getCategoryId().equals(Util.nullCheck(entity.getCategoryId()))).collect(Collectors.toList()).size() < 1) {
					categoryVO.setCategoryId(Util.nullCheck(entity.getCategoryId()));
					categoryVO.setCategoryName(Util.nullCheck(entity.getCategoryName()));
					unitMapList.get(entity.getUnitName()).getCategoryList().add(categoryVO);
				}
				
				/*@Add Status list*/
				if(unitMapList.get(entity.getUnitName()).getStatusList().stream()
					     .filter(item -> item.getStatusId().equals(Util.nullCheck(entity.getStatusId()))).collect(Collectors.toList()).size() < 1) {
					statusVO.setStatusId(Util.nullCheck(entity.getStatusId().toString()));
					statusVO.setStatusName(Util.nullCheck(entity.getStatusName()));
					unitMapList.get(entity.getUnitName()).getStatusList().add(statusVO);
				}
				
				/*@Add Vessel list*/
				if(unitMapList.get(entity.getUnitName()).getVesselList().stream()
					     .filter(item -> item.getVesselId().equals(Util.nullCheck(entity.getVesselId()))).collect(Collectors.toList()).size() < 1) {
					vesselVO.setVesselId(Util.nullCheck(entity.getVesselId()));
					vesselVO.setVesselName(Util.nullCheck(entity.getVesselName()));
					unitMapList.get(entity.getUnitName()).getVesselList().add(vesselVO);
				}
				
				/*@Add Severity list*/
				if(unitMapList.get(entity.getUnitName()).getSeverityList().stream()
					     .filter(item -> item.getSeverity().equals(Util.nullCheck(entity.getSeverity()))).collect(Collectors.toList()).size() < 1) {
					severityVO.setSeverity(Util.nullCheck(entity.getSeverity()));
					unitMapList.get(entity.getUnitName()).getSeverityList().add(severityVO);
				}
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
	
	public List<NonConformityEntity> getNonConformityData(){
		return repository.getNonConformityData(QueryRepository.STORPROC_DASHBOARD_NONCONF);
	}
	
	public List<PurchaseOrderEntity> getPurchaseOrderData(){
		return repository.getPurchaseOrderData(QueryRepository.STORPROC_DASHBOARD_PURORD);
	}
}
