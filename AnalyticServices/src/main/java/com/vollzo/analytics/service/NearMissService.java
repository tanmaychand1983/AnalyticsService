package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vollzo.analytics.entity.NearMissEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.CategoryVO;
import com.vollzo.analytics.vo.NearMissVO;
import com.vollzo.analytics.vo.ReferenceDataVO;
import com.vollzo.analytics.vo.StatusVO;
import com.vollzo.analytics.vo.UnitsVO;
import com.vollzo.analytics.vo.VesselVO;

/**
 * {@summary}: This is the Service class for NearMiss module.
 * 
 * @className: NearMissService
 * @author Ajaya Kar
 * @since: Feb 1, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */

@Service
public class NearMissService {
	@Autowired
	private BaseRepository repository;
	
	/**
     * Returns NearMiss Filter, Graph and Grid data by date range from Data layer.
     * 
     * @methodName: getNearMissData
     * @param: requestVO - AnalyticsRequestVO {Vessel Id List (Required), Start Date (defaultValue = ""), End Date (defaultValue = "")
     * @return - List<NearMissVO>
     * 
     */
	
	public  List<NearMissVO> getNearMissData(AnalyticsRequestVO requestVO){
		List<NearMissEntity> entityList 	= repository.getNeaMissData(QueryRepository.STORPROC_DASHBOARD_NEARMISS, requestVO);
		 
	    Map<Integer, String> unitsMap 	= new HashMap<>();
		List<NearMissVO> nearMissVOList = new ArrayList<>();
		List<VesselVO> vesselVOList 	= new ArrayList<VesselVO>();
		for (NearMissEntity entity : entityList) {
			int unitId = entity.getUnitId();
			String unitName = entity.getUnitName();				 
			NearMissVO nearMissVO = new NearMissVO();
			if(!unitsMap.containsKey(unitId)) {	
				UnitsVO unitVO = new UnitsVO();
				vesselVOList = new ArrayList<VesselVO>();
				unitsMap.put(unitId, new String());
				unitVO.setUnitId(unitId);
				unitVO.setUnitDesc(unitName);
				unitVO.setVesselVO(vesselVOList);
				nearMissVO.setUnitsVO(unitVO);
				nearMissVOList.add(nearMissVO);
			 }
			ReferenceDataVO refVO 	= new ReferenceDataVO();			
			VesselVO vesselVO 		= new VesselVO();
			CategoryVO categoryVO 	= new CategoryVO();
			StatusVO statusVO 		= new StatusVO();
			statusVO.setStatusId(entity.getStatusId());
			statusVO.setStatusDesc(entity.getStatusName());
			categoryVO.setCategoryId(entity.getCategoryId());
			categoryVO.setCategoryDesc(entity.getCategoryName());
			refVO.setRefNumber(entity.getRefNumber());
			refVO.setReportedBy(entity.getReportedBy());
			refVO.setReportedDate(entity.getReportedDate());
			refVO.setTitle(entity.getTitle());
			refVO.setId(entity.getId());
			
			vesselVO.setVesselId(entity.getVesselId());
			vesselVO.setVesselDesc(entity.getVesselName());
			vesselVO.setCategoryVO(categoryVO);
			vesselVO.setStatusVO(statusVO);
			vesselVO.setReferenceDataVO(refVO);
			
			vesselVOList.add(vesselVO);			
			unitsMap.get(unitId);
		}
		return nearMissVOList;
	}

}
