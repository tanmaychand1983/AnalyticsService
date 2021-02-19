/**
 * {@summary}: This is the Service class for Port State Control module.
 * @className: PortStateControlService
 * @author Deepak Bansal
 * @since: Feb 19, 2021
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

import com.vollzo.analytics.entity.PortStateControlEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.MouVO;
import com.vollzo.analytics.vo.PortStateControlVO;
import com.vollzo.analytics.vo.ReferenceDataVO;
import com.vollzo.analytics.vo.UnitsVO;
import com.vollzo.analytics.vo.VesselVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PortStateControlService {
	
	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = PortStateControlService.class.getName();
	
	public List<PortStateControlVO> getPortStateData(AnalyticsRequestVO requestVO){
		log.info(CLASS_NAME+"::Inside [getPortStateData] Service method!");
		
		List<PortStateControlEntity> entityList = repository.getPortStateData(
				QueryRepository.STORPROC_DASHBOARD_INSPECTION, requestVO);
		Map<Integer, String> unitsMap 	= new HashMap<>();
		List<PortStateControlVO> portStateControlVOList = new ArrayList<>();
		List<VesselVO> vesselVOList 	= new ArrayList<VesselVO>();
		
		for(PortStateControlEntity entity: entityList) {
			int unitId = entity.getUnitId();
			String unitName = entity.getUnitName();	
			PortStateControlVO portStateControlVO = new PortStateControlVO();
			if(!unitsMap.containsKey(unitId)) {
				UnitsVO unitVO = new UnitsVO();
				vesselVOList = new ArrayList<VesselVO>();
				unitsMap.put(unitId, new String());
				unitVO.setUnitId(unitId);
				unitVO.setUnitDesc(unitName);
				unitVO.setVesselVO(vesselVOList);
				portStateControlVO.setUnitsVO(unitVO);
				portStateControlVOList.add(portStateControlVO);
			}
			ReferenceDataVO referenceDataVO 	= new ReferenceDataVO();			
			VesselVO vesselVO 					= new VesselVO();
			MouVO mouVO 						= new MouVO();
			mouVO.setMOU(entity.getMou());
			referenceDataVO.setInspectionId(entity.getInspectionId());
			referenceDataVO.setAge(entity.getAge());
			referenceDataVO.setInspectionNumber(entity.getInspectionNumber());
			referenceDataVO.setInspectionDate(entity.getInspectionDate());
			referenceDataVO.setPortName(entity.getPortName());
			referenceDataVO.setMou(entity.getMou());
			referenceDataVO.setInspectorName(entity.getInspectorName());
			referenceDataVO.setInspectionStatus(entity.getInspectionStatus());
			referenceDataVO.setDeficiencieStatus(entity.getDeficiencieStatus());
			referenceDataVO.setDeficiencieCount(entity.getDeficiencieCount());
			
			referenceDataVO.setId(entity.getId());
			
			vesselVO.setVesselId(entity.getVesselId());
			vesselVO.setVesselDesc(entity.getVesselName());
			vesselVO.setMouVO(mouVO);
			vesselVO.setReferenceDataVO(referenceDataVO);
			vesselVOList.add(vesselVO);
			unitsMap.get(unitId);
		}
		return portStateControlVOList;
	}

}
