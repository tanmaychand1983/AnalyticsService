package com.vollzo.analytics.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vollzo.analytics.service.AccidentIncidentService;
import com.vollzo.analytics.service.MaintenanceService;
import com.vollzo.analytics.service.NearMissDetailsService;
import com.vollzo.analytics.service.NearMissService;
import com.vollzo.analytics.service.NonConformityDetailsService;
import com.vollzo.analytics.service.NonConformityService;
import com.vollzo.analytics.service.PurchaseOrderDetailsService;
import com.vollzo.analytics.service.PurchaseOrderService;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;
import com.vollzo.analytics.vo.NearMissDetailsVO;
import com.vollzo.analytics.vo.NearMissVO;
import com.vollzo.analytics.vo.NonConformityDetailsVO;
import com.vollzo.analytics.vo.PurchaseOrderDetailsVO;

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
	private NearMissService nearMissService;
	
	@Autowired
	private AccidentIncidentService accidentIncidentService;
	
	@Autowired
	private PurchaseOrderService purchaseOrderService;
	
	@Autowired
	private NonConformityService nonConformityService;
	
	@Autowired
	private MaintenanceService maintenanceService;
	
	@Autowired
	private NearMissDetailsService nearMissDetailsService;
	
	@Autowired
	private PurchaseOrderDetailsService purchaseOrderDetailsService;
	
	@Autowired
	private NonConformityDetailsService nonConformityDetailsService;
	
	/**
     * Returns NearMiss Filter, Graph and Grid data by date range from Service layer.
     * 
     * @methodName: getNearMissData
     * @serviceURL: http://<host:port>/analytics/nearmiss?startDate=""&endDate=""
     * @param startDate - Start Date (defaultValue = "")
     * @param endDate -  End Date (defaultValue = "")
     * @return - List<AnalyticsResponseVO> (JSON Object)
     * 
     */
	@GetMapping(value ="/nearmiss", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NearMissVO> getNearMissData(@RequestBody AnalyticsRequestVO requestVO) {
		log.info(CLASS_NAME+"::Inside [getNearMissData] method!");
		return nearMissService.getNearMissData(requestVO);	
	}
	
	/**
     * Returns AccidentIncident Filter, Graph and Grid data from Service layer.
     * 
     * @methodName: getAccidentIncidentData
     * @serviceURL: http://<host:port>/analytics/accidentincident
     * @return - List<AnalyticsResponseVO> (JSON Object)
     * 
     */
	@GetMapping(value ="/accidentincident", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AnalyticsResponseVO> getAccidentIncidentData(@RequestBody AnalyticsRequestVO requestVO) {
		log.info(CLASS_NAME+"::Inside [getAccidentIncidentData] method!");
		return accidentIncidentService.getAccidentIncidentData(requestVO);	
	}
	
	
	/**
     * Returns Purchase Order Filter, Graph and Grid data by date range and vesselIds from Service layer.
     * 
     * @methodName: getPurchaseOrderData
     * @serviceURL: http://<host:port>/analytics/purchaseorder
     * @param: requestVO - AnalyticsRequestVO {Vessel Id List (Required), Start Date (defaultValue = ""), End Date (defaultValue = "")
     * @return - List<AnalyticsResponseVO> (JSON Object)
     * 
     */
	@GetMapping(value ="/purchaseorder", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AnalyticsResponseVO> getPurchaseOrderData(@RequestBody AnalyticsRequestVO requestVO) {
		log.info(CLASS_NAME+"::Inside [getPurchaseOrderData] method!");
		return purchaseOrderService.getPurchaseOrderData(requestVO);	
	}
	
	/**
     * Returns Non Conformity Filter, Graph and Grid data by date range from Service layer.
     * @author Deepak Bansal
     * @methodName: getNonConformityData
     * @serviceURL: http://<host:port>/analytics/nonconformity
     * @param: requestVO - AnalyticsRequestVO {Vessel Id List (Required), Start Date (defaultValue = ""), End Date (defaultValue = "")
     * @return -  List<AnalyticsResponseVO> (JSON Object)
     * 
     */
	
	@GetMapping(value ="/nonconformity", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AnalyticsResponseVO> getNonConformityData(@RequestBody AnalyticsRequestVO requestVO) {
		log.info(CLASS_NAME+"::Inside [getNonConformityData] Controller method!");
		return nonConformityService.getNonConformityData(requestVO);	
	}
	
	/**
     * Returns Maintenance Filter, Graph and Grid data by date range from Service layer.
     * @author Deepak Bansal
     * @methodName: getMaintenanceData
     * @serviceURL: http://<host:port>/analytics/maintenance
     * @param: requestVO - AnalyticsRequestVO {Vessel Id List (Required), Status (defaultValue = "")
     * @return -  List<AnalyticsResponseVO> (JSON Object)
     * 
     */
	
	@GetMapping(value ="/maintenance", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AnalyticsResponseVO> getMaintenanceData(@RequestBody AnalyticsRequestVO requestVO) {
		log.info(CLASS_NAME+"::Inside [getMaintenanceData] Controller method!");
		return maintenanceService.getMaintenanceData(requestVO);	
	}
	
	/**
     * Returns Near Miss Details data from Service layer.
     * @author Deepak Bansal
     * @methodName: getNearMissDetails
     * @serviceURL: http://<host:port>/analytics/nearmiss
     * @param: Nearmiss Id (Required)
     * @return -  List<NearMissDetailsVO> (JSON Object)
     * 
     */
	@GetMapping(value="/nearmissbyid/{nearmissId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NearMissDetailsVO> getNearMissDetails(@PathVariable("nearmissId") String nearmissId){
		log.info(CLASS_NAME+"::Inside [getNearMissDetails] Controller method!");
		
		return nearMissDetailsService.getNearMissDetails(nearmissId);
	}
	
	/**
     * Returns Purchase Order Details data from Service layer.
     * @author Deepak Bansal
     * @methodName: getPurchaseOrderDetails
     * @serviceURL: http://<host:port>/analytics/purchaseorder/{poid}
     * @param: PO Id (Required)
     * @return -  List<PurchaseOrderDetailsVO> (JSON Object)
     * 
     */
	@GetMapping(value="/purchaseorderbyid/{poid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PurchaseOrderDetailsVO> getPurchaseOrderDetails(@PathVariable("poid") String poId){
		log.info(CLASS_NAME+"::Inside [getPurchaseOrderDetails] Controller method!");
		
		return purchaseOrderDetailsService.getPurchaseOrderDetails(poId);
	}
	
	/**
     * Returns Non Conformity Details data from Service layer.
     * @author Deepak Bansal
     * @methodName: getNonConformityDetails
     * @serviceURL: http://<host:port>/analytics/nonconformity/{auditncid}
     * @param: auditncid (Required)
     * @return -  List<NonConformityDetailsVO> (JSON Object)
     * 
     */
	@GetMapping(value="/nonconformity/{auditncid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NonConformityDetailsVO> getNonConformityDetails(@PathVariable("auditncid") String auditncid){
		
		log.info(CLASS_NAME+"::Inside [getNonConformityDetails] Controller method!");
		
		return nonConformityDetailsService.getNonConformityDetails(auditncid);
	}
	
}
