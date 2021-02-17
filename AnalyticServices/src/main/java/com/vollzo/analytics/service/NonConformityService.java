/**
 * {@summary}: This is the Service class for Non Conformity module.
 * @className: NonConformityService
 * @author Deepak Bansal
 * @since: Feb 1, 2021
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

import com.vollzo.analytics.entity.NonConformityEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;
import com.vollzo.analytics.vo.AuditTypeVO;
import com.vollzo.analytics.vo.ReferenceDataVO;
import com.vollzo.analytics.vo.StatusVO;
import com.vollzo.analytics.vo.UnitsVO;
import com.vollzo.analytics.vo.VesselVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NonConformityService {
	
	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = NonConformityService.class.getName();
	
	public List<AnalyticsResponseVO> getNonConformityData(AnalyticsRequestVO requestVO){
		
		log.info(CLASS_NAME+"::Inside [getNonConformityData] Service method!");
		List<NonConformityEntity> entityList = repository.getNonConformityData(QueryRepository.STORPROC_DASHBOARD_NONCONF, requestVO);
		
		Map<Integer, String> unitsMap = new HashMap<>();
		List<AnalyticsResponseVO> responseVOList = new ArrayList<>();
		List<VesselVO> vesselVOList = new ArrayList<VesselVO>();
		
		for(NonConformityEntity entity: entityList) {
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
			AuditTypeVO auditTypeVO 			= new AuditTypeVO();
			StatusVO statusVO 					= new StatusVO();
			statusVO.setStatusId(entity.getStatusId());
			statusVO.setStatusDesc(entity.getStatusName());
			auditTypeVO.setAuditType(entity.getAuditType());
			
			referenceDataVO.setRefNumber(entity.getRefNumber());
			referenceDataVO.setPortName(entity.getPortName());
			referenceDataVO.setStage(entity.getStage());
			referenceDataVO.setAuditDate(entity.getAuditDate());
			referenceDataVO.setDueDate(entity.getDueDate());
			referenceDataVO.setId(entity.getId());
			
			vesselVO.setVesselId(entity.getVesselId());
			vesselVO.setVesselDesc(entity.getVesselName());
			vesselVO.setStatusVO(statusVO);
			vesselVO.setAuditTypeVO(auditTypeVO);
			vesselVO.setReferenceDataVO(referenceDataVO);
			
			vesselVOList.add(vesselVO);
			unitsMap.get(unitId);
		}
		return responseVOList;
	}
}
