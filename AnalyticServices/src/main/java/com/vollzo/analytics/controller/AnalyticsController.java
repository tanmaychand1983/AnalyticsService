package com.vollzo.analytics.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vollzo.analytics.entity.NonConformityEntity;
import com.vollzo.analytics.entity.PurchaseOrderEntity;
import com.vollzo.analytics.service.AnalyticsService;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;
import lombok.extern.slf4j.Slf4j;

/**
 * {@summary}: This is the Controller class for Analytical module.
 * 
 * @className: AnalyticsController
 * @author Ajaya Kar
 * @since: Jan 23, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */

@RestController
@RequestMapping("/analytics")
@CrossOrigin("*")
@Slf4j
public class AnalyticsController {
	
	private static final String CLASS_NAME = AnalyticsController.class.getName();

	@Autowired
	private AnalyticsService analyticsServices;
	
	/**
     * Returns NearMiss Filter, Graph and Grid data by date range from Service layer.
     * 
     * @methodName: getNearMissData
     * @serviceURL: http://<host:port>/analytics/nearmiss?startDate=""&endDate=""
     * @param startDate - Start Date (defaultValue = "")
     * @param endDate -  End Date (defaultValue = "")
     * @return - AnalyticsVO (JSON Object)
     * 
     */
	@GetMapping(value ="/nearmiss", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AnalyticsResponseVO getNearMissData(@RequestBody AnalyticsRequestVO requestVO) {
		log.info(CLASS_NAME+"::Inside [getNearMissData] method!");
		return analyticsServices.getNearMissData(requestVO);	
	}
	
	/**
     * Returns AccidentIncident Filter, Graph and Grid data from Service layer.
     * 
     * @methodName: getAccidentIncidentData
     * @serviceURL: http://<host:port>/analytics/accidentincident
     * @return - AnalyticsVO (JSON Object)
     * 
     */
	@GetMapping(value ="/accidentincident", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AnalyticsResponseVO getAccidentIncidentData(@RequestBody AnalyticsRequestVO requestVO) {
		log.info(CLASS_NAME+"::Inside [getAccidentIncidentData] method!");
		return analyticsServices.getAccidentIncidentData(requestVO);	
	}
	
	@GetMapping(value ="/nonconformity", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NonConformityEntity> getNonConformityData() {
		log.info(CLASS_NAME+"::Inside [getNonConformityData] method!");
		return analyticsServices.getNonConformityData();	
	}
	
	@GetMapping(value ="/purchaseorder", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PurchaseOrderEntity> getPurchaseOrderData() {
		log.info(CLASS_NAME+"::Inside [getPurchaseOrderData] method!");
		return analyticsServices.getPurchaseOrderData();	
	}
}
