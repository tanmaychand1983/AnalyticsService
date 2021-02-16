package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vollzo.analytics.entity.AccidentIncidentEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;
import com.vollzo.analytics.vo.CategoryVO;
import com.vollzo.analytics.vo.ReferenceDataVO;
import com.vollzo.analytics.vo.SeverityVO;
import com.vollzo.analytics.vo.StatusVO;
import com.vollzo.analytics.vo.UnitsVO;
import com.vollzo.analytics.vo.VesselVO;

/**
 * {@summary}: This is the Service class for AccidentIncident module.
 * 
 * @className: AccidentIncidentService
 * @author Ajaya Kar
 * @since: Feb 1, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */

@Service
public class AccidentIncidentService {
	
	@Autowired
	private BaseRepository repository;
	
	/**
     * Returns AccidentIncidentData Filter, Graph and Grid data from Data layer.
     * 
     * @methodName: getAccidentIncidentData
     * @param: requestVO - AnalyticsRequestVO {Vessel Id List (Required))
     * @return - List<AnalyticsResponseVO>
     * 
     */
	public List<AnalyticsResponseVO> getAccidentIncidentData(AnalyticsRequestVO requestVO){
		List<AccidentIncidentEntity> entityList = repository.getAccidentIncidentData(QueryRepository.STORPROC_DASHBOARD_ACCINC, requestVO);
		
		Map<Integer, String> unitsMap = new HashMap<>();
		List<AnalyticsResponseVO> responseVOList = new ArrayList<>();
		List<VesselVO> vesselVOList = new ArrayList<VesselVO>();
		
		for (AccidentIncidentEntity entity : entityList) {
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
			ReferenceDataVO refVO 	= new ReferenceDataVO();			
			VesselVO vesselVO 		= new VesselVO();
			CategoryVO categoryVO 	= new CategoryVO();
			SeverityVO severityVO 	= new SeverityVO();
			StatusVO statusVO = new StatusVO();
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
			
			severityVO.setSeverityDesc(entity.getSeverity());
			vesselVO.setSeverityVO(severityVO);
			
			vesselVOList.add(vesselVO);			
			unitsMap.get(unitId);
		}
		return responseVOList;
	}
	
}
