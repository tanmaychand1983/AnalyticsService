/**
 * {@summary}: This is the Service class for Ship Visit Dashboard.
 * @className: ShipVisitService
 * @author Deepak Bansal
 * @since: Mar 11, 2021
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

import com.vollzo.analytics.entity.ShipVisitEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;
import com.vollzo.analytics.vo.ReferenceDataVO;
import com.vollzo.analytics.vo.UnitsVO;
import com.vollzo.analytics.vo.VesselVO;
import com.vollzo.analytics.vo.VisitTypeVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShipVisitService {
	
	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = ShipVisitService.class.getName();
	
	public List<AnalyticsResponseVO> getShipVisitData(AnalyticsRequestVO requestVO){
		
		log.info(CLASS_NAME+"::Inside [getShipVisitData] Service method!");
		List<ShipVisitEntity> entityList = repository.getShipVisitData(
					QueryRepository.STORPROC_DASHBOARD_SHIPVISIT, requestVO);
		Map<Integer, String> unitsMap = new HashMap<>();
		List<AnalyticsResponseVO> responseVOList = new ArrayList<>();
		List<VesselVO> vesselVOList = new ArrayList<VesselVO>();
		for(ShipVisitEntity entity : entityList) {
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
			VisitTypeVO visitTypeVO				= new VisitTypeVO();
			
			visitTypeVO.setVisitType(entity.getVisitType());
			
			referenceDataVO.setVisitor(entity.getVisitor());
			referenceDataVO.setPortFrom(entity.getPortFrom());
			referenceDataVO.setDateIn(entity.getDateIn());
			referenceDataVO.setVirDate(entity.getVirDate());
			referenceDataVO.setVisitDays(entity.getVisitDays());
			referenceDataVO.setNextDuedate(entity.getNextDuedate());
			referenceDataVO.setVirSenttoowner(entity.getVirSenttoowner());
			
			vesselVO.setVesselId(entity.getVesselId());
			vesselVO.setVesselDesc(entity.getVesselName());
			vesselVO.setVisitTypeVO(visitTypeVO);
			vesselVO.setReferenceDataVO(referenceDataVO);
			
			vesselVOList.add(vesselVO);			
			unitsMap.get(unitId);
		}
		return responseVOList;
	}
}
