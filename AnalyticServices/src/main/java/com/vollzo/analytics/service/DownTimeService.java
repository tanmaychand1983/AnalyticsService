/**
 * {@summary}: This is the Service class for Downtime Dashboard.
 * @className: DownTimeService
 * @author Deepak Bansal
 * @since: Mar 15, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 */
package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vollzo.analytics.entity.DownTimeEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;
import com.vollzo.analytics.vo.ReasonVO;
import com.vollzo.analytics.vo.ReferenceDataVO;
import com.vollzo.analytics.vo.UnitsVO;
import com.vollzo.analytics.vo.VesselVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DownTimeService {
	
	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = DownTimeService.class.getName();
	
	public List<AnalyticsResponseVO> getDownTimeData(AnalyticsRequestVO requestVO){
		log.info(CLASS_NAME+"::Inside [getDownTimeData] Service method!");
		
		List<DownTimeEntity> entityList = repository.getDownTimeData(
				QueryRepository.STORPROC_DASHBOARD_DOWNTIME, requestVO);
		Map<Integer, String> unitsMap = new HashMap<>();
		List<AnalyticsResponseVO> responseVOList = new ArrayList<>();
		List<VesselVO> vesselVOList = new ArrayList<VesselVO>();
		for(DownTimeEntity entity : entityList) {
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
			ReasonVO reasonVO					= new ReasonVO();
			
			reasonVO.setReason(entity.getReason());
			referenceDataVO.setId(entity.getId());
			referenceDataVO.setAge(entity.getAge());
			referenceDataVO.setFromDateTime(entity.getFromDateTime());
			referenceDataVO.setToDateTime(entity.getToDateTime());
			referenceDataVO.setRemarks(entity.getRemarks());
			referenceDataVO.setOfficeRemarks(entity.getOfficeRemarks());
			referenceDataVO.setReportedBy(entity.getReportedBy());
			
			vesselVO.setVesselId(entity.getVesselId());
			vesselVO.setVesselDesc(entity.getVesselName());
			vesselVO.setReasonVO(reasonVO);
			vesselVO.setReferenceDataVO(referenceDataVO);
			
			vesselVOList.add(vesselVO);
			unitsMap.get(unitId);
		}
		return responseVOList;
	}
}
