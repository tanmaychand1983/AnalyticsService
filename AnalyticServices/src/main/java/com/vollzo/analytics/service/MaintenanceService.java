/**
 * {@summary}: This is the Service class for Maintenace Dashboard.
 * @className: MaintenanceService
 * @author Deepak Bansal
 * @since: Feb 2, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 * 
 */
package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vollzo.analytics.entity.MaintenanceEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;
import com.vollzo.analytics.vo.RankVO;
import com.vollzo.analytics.vo.ReferenceDataVO;
import com.vollzo.analytics.vo.UnitsVO;
import com.vollzo.analytics.vo.VesselVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MaintenanceService {
	
	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = MaintenanceService.class.getName();
	
	public List<AnalyticsResponseVO> getMaintenanceData(AnalyticsRequestVO requestVO){
		
		log.info(CLASS_NAME+"::Inside [getMaintenanceData] Service method!");
		List<MaintenanceEntity> entityList = repository.getMaintenanceData(QueryRepository.STORPROC_DASHBOARD_MAINTENANCE, requestVO);
		Map<Integer, String> unitsMap = new HashMap<>();
		List<AnalyticsResponseVO> responseVOList = new ArrayList<>();
		List<VesselVO> vesselVOList = new ArrayList<VesselVO>();
		
		for(MaintenanceEntity entity : entityList) {
			int unitId = entity.getUnitId();
			String unitName = entity.getUnitName();				 
			AnalyticsResponseVO responseVO = new AnalyticsResponseVO();
			if(!unitsMap.containsKey(unitId)) {
				UnitsVO unitVO = new UnitsVO();
				vesselVOList = new ArrayList<VesselVO>();
				unitsMap.put(unitId, new String());
				unitVO.setUnitId(unitId);
				unitVO.setUnitDesc(unitName);
				unitVO.setVesselVO(vesselVOList);
				responseVO.setUnitsVO(unitVO);
				responseVOList.add(responseVO);
			}
			ReferenceDataVO referenceDataVO 	= new ReferenceDataVO();			
			VesselVO vesselVO 					= new VesselVO();
			RankVO rankVO						= new RankVO();
			
			rankVO.setRankId(entity.getRankId());
			rankVO.setRankName(entity.getRankName());
			referenceDataVO.setJobNumber(entity.getJobNumber());
			referenceDataVO.setJobType(entity.getJobType());
			referenceDataVO.setTitle(entity.getTitle());
			referenceDataVO.setFrequency(entity.getFrequency());
			referenceDataVO.setLastDone(entity.getLastDone());
			referenceDataVO.setNextDue(entity.getNextDue());
			
			vesselVO.setVesselId(entity.getVesselId());
			vesselVO.setVesselDesc(entity.getVesselName());
			vesselVO.setRankVO(rankVO);
			vesselVO.setReferenceDataVO(referenceDataVO);
			
			vesselVOList.add(vesselVO);			
			unitsMap.get(unitId);
		}
		
		return responseVOList;
	}
}
