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
import com.vollzo.analytics.vo.NearMissVO;
import com.vollzo.analytics.vo.ReferenceDataVO;
import com.vollzo.analytics.vo.StatusVO;
import com.vollzo.analytics.vo.UnitsVO;
import com.vollzo.analytics.vo.VesselVO;
import com.vollzo.analytics.vo.AnalyticsVO;
import com.vollzo.analytics.vo.CategoryVO;

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
public class AnalyticsServiceTest {

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
	//public Map<Integer, Map<Integer, List<UnitsVO>>>  getNearMissData(AnalyticsRequestVO requestVO){
	public  List<NearMissVO> getNearMissData(AnalyticsRequestVO requestVO){
		List<NearMissEntity> nearMissEntityList 	= repository.getNeaMissData(QueryRepository.STORPROC_DASHBOARD_NEARMISS, requestVO);
		 
	    Map<Integer, String> unitsMapObj = new HashMap<>();
		List<NearMissVO> listObj = new ArrayList<>();
		List<VesselVO> listVesselObj = new ArrayList<VesselVO>();
		for (NearMissEntity nearMissEntity : nearMissEntityList) {
			
			int unitId = nearMissEntity.getUnitId();
			String unitName = nearMissEntity.getUnitName();				 
			NearMissVO nearMissVO = new NearMissVO();
			if(!unitsMapObj.containsKey(unitId)) {	
				   UnitsVO unitVO = new UnitsVO();
				   listVesselObj = new ArrayList<VesselVO>();
				   unitsMapObj.put(unitId, new String());
				   unitVO.setUnitId(unitId);
				   unitVO.setUnitDesc(unitName);
				   unitVO.setVesselVO(listVesselObj);
				   nearMissVO.setUnitsVO(unitVO);
				   listObj.add(nearMissVO);
			 }
			ReferenceDataVO refVO = new ReferenceDataVO();			
			VesselVO vesselVO = new VesselVO();
			CategoryVO categoryVO = new CategoryVO();
			StatusVO statusVO = new StatusVO();
			statusVO.setStatusId(nearMissEntity.getStatusId());
			statusVO.setStatusDesc(nearMissEntity.getStatusName());
			categoryVO.setCategoryId(nearMissEntity.getCategoryId());
			categoryVO.setCategoryDesc(nearMissEntity.getCategoryName());
			refVO.setRefNumber(nearMissEntity.getRefNumber());
			refVO.setReportedBy(nearMissEntity.getReportedBy());
			refVO.setReportedDate(nearMissEntity.getReportedDate());
			refVO.setTitle(nearMissEntity.getTitle());
			
			vesselVO.setVesselId(nearMissEntity.getVesselId());
			vesselVO.setVesselDesc(nearMissEntity.getVesselName());
			vesselVO.setCategoryVO(categoryVO);
			vesselVO.setStatusVO(statusVO);
			vesselVO.setReferenceDataVO(refVO);
			
			listVesselObj.add(vesselVO);			
			unitsMapObj.get(unitId);
		}
		
		
	 	//mapObj = listObj.stream().collect(Collectors.toMap("", valueMapper));
	 	 
	 
		return listObj;
	}
	 
	
}
