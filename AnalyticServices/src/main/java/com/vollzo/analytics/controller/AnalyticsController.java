package com.vollzo.analytics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vollzo.analytics.service.AccidentIncidentService;
import com.vollzo.analytics.service.DownTimeService;
import com.vollzo.analytics.service.FuelConsumptionService;
import com.vollzo.analytics.service.InvoiceDetailService;
import com.vollzo.analytics.service.MaintenanceDetailService;
import com.vollzo.analytics.service.MaintenanceService;
import com.vollzo.analytics.service.NearMissDetailsService;
import com.vollzo.analytics.service.NearMissService;
import com.vollzo.analytics.service.NonConformityDetailsService;
import com.vollzo.analytics.service.NonConformityService;
import com.vollzo.analytics.service.PortStateControlDetailsService;
import com.vollzo.analytics.service.PortStateControlService;
import com.vollzo.analytics.service.PurchaseOrderDetailsService;
import com.vollzo.analytics.service.PurchaseOrderService;
import com.vollzo.analytics.service.ShipVisitDetailsService;
import com.vollzo.analytics.service.ShipVisitService;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;
import com.vollzo.analytics.vo.InvoiceDetailVO;
import com.vollzo.analytics.vo.MaintenanceDetailVO;
import com.vollzo.analytics.vo.NearMissDetailsVO;
import com.vollzo.analytics.vo.NearMissVO;
import com.vollzo.analytics.vo.NonConformityDetailsVO;
import com.vollzo.analytics.vo.PortStateControlDetailsVO;
import com.vollzo.analytics.vo.PortStateControlVO;
import com.vollzo.analytics.vo.PurchaseOrderDetailsVO;
import com.vollzo.analytics.vo.ShipVisitDetailsVO;

import lombok.extern.slf4j.Slf4j;

/**
 * {@summary}: This is the Controller class for Analytical module.
 * 
 * @className: AnalyticsController
 * @author Ajaya Kar
 * @since: Mar 16, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
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
	
	@Autowired
	private PortStateControlDetailsService portStateControlDetailsService;
	
	@Autowired
	private PortStateControlService portStateControlService;
	
	@Autowired
	private ShipVisitService shipVisitService;
	
	@Autowired
	private ShipVisitDetailsService shipVisitDetailsService;
	
	@Autowired
	private InvoiceDetailService invoiceDetailService;
	
	@Autowired
	private MaintenanceDetailService maintenanceDetailService;
	
	@Autowired
	private FuelConsumptionService fuelConsumptionService;
	
	@Autowired
	private DownTimeService downTimeService;
	
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
	@GetMapping(value ="/nearmiss/{vesselIds}/{startDate}/{endDate}")
	@ResponseBody
	public List<NearMissVO> getNearMissData(@PathVariable String vesselIds,
			                                @PathVariable String startDate,
			                                @PathVariable String endDate) {
		log.info(CLASS_NAME+"::Inside [getNearMissData] method#######!");
		System.out.println("[getNearMissData]########NearMiss##########vesselIds:"+vesselIds+"##StartDate:"+startDate+"##EndDate:"+endDate);
		 AnalyticsRequestVO requestVO  = new AnalyticsRequestVO();
		 requestVO.setVesselIds(vesselIds);
		 requestVO.setStartDate(startDate);
		 requestVO.setEndDate(endDate);
		 List<NearMissVO> listObj = nearMissService.getNearMissData(requestVO);	
		 if(listObj != null) {
			 System.out.println("[getNearMissData]########NearMiss##########"+listObj.size()); 
		 }else {
			 System.out.println("[getNearMissData]########No Data Return##########"); 
		 }
		
		return listObj;
	}
	
	/**
     * Returns AccidentIncident Filter, Graph and Grid data from Service layer.
     * 
     * @methodName: getAccidentIncidentData
     * @serviceURL: http://<host:port>/analytics/accidentincident
     * @return - List<AnalyticsResponseVO> (JSON Object)
     * 
     */
	@GetMapping(value ="/accidentincident/{vesselIds}/{startDate}/{endDate}")
	@ResponseBody
	public List<AnalyticsResponseVO> getAccidentIncidentData(@PathVariable String vesselIds,
												             @PathVariable String startDate,
												             @PathVariable String endDate) {
		
		log.info(CLASS_NAME+"::Inside [getAccidentIncidentData] method!");
		System.out.println("########AccidentIncident##########vesselIds:"+vesselIds+"##StartDate:"+startDate+"##EndDate:"+endDate);
		 AnalyticsRequestVO requestVO  = new AnalyticsRequestVO();
		 requestVO.setVesselIds(vesselIds);
		 requestVO.setStartDate(startDate);
		 requestVO.setEndDate(endDate);
		 List<AnalyticsResponseVO> listObj = accidentIncidentService.getAccidentIncidentData(requestVO);	
		 if(listObj != null) {
			 System.out.println("[getAccidentIncidentData]########AccidentIncident##########"+listObj.size()); 
		 }else {
			 System.out.println("[getAccidentIncidentData]########No Data Return##########"); 
		 }
		
		return listObj;		 
	}
	
	
	/**
     * Returns Purchase Order Filter, Graph and Grid data by date range and vesselIds from Service layer.
     * 
     * @methodName: getPurchaseOrderData
     * @serviceURL: http://<host:port>/analytics/purchaseorder
     * @param: requestVO - AnalyticsRequestVO {
     * Service Type(Required)
     * Vessel Id List (Required), 
     * Start Date (defaultValue = ""), 
     * End Date (defaultValue = "")}
     * @return - List<AnalyticsResponseVO> (JSON Object)
     * 
     */
	@GetMapping(value ="/purchaseorder/{serviceType}/{vesselIds}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AnalyticsResponseVO> getPurchaseOrderData(@PathVariable String serviceType,
														@PathVariable String vesselIds,
											            @PathVariable String startDate,
											            @PathVariable String endDate) {
		log.info(CLASS_NAME+"::Inside [getPurchaseOrderData] method!");
		System.out.println("########PurchaseOrder##########vesselIds:"+vesselIds+"##StartDate:"+startDate+"##EndDate:"+endDate);
		AnalyticsRequestVO requestVO  = new AnalyticsRequestVO();
		requestVO.setServiceType(serviceType);
		requestVO.setVesselIds(vesselIds);
		requestVO.setStartDate(startDate);
		requestVO.setEndDate(endDate);
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
	
	@GetMapping(value ="/nonconformity/{vesselIds}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AnalyticsResponseVO> getNonConformityData(@PathVariable String vesselIds,
											            @PathVariable String startDate,
											            @PathVariable String endDate
														) {
		log.info(CLASS_NAME+"::Inside [getNonConformityData] Controller method!");
		AnalyticsRequestVO requestVO  = new AnalyticsRequestVO();
		requestVO.setVesselIds(vesselIds);
		requestVO.setStartDate(startDate);
		requestVO.setEndDate(endDate);
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
	
	@GetMapping(value ="/maintenance/{vesselIds}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AnalyticsResponseVO> getMaintenanceData(@PathVariable String vesselIds,
											            @PathVariable String startDate,
											            @PathVariable String endDate) {
		log.info(CLASS_NAME+"::Inside [getMaintenanceData] Controller method!");
		AnalyticsRequestVO requestVO  = new AnalyticsRequestVO();
		requestVO.setVesselIds(vesselIds);
		requestVO.setStartDate(startDate);
		requestVO.setEndDate(endDate);
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
		System.out.println("[getNearMissDetails]########NearMissby ID##########nearmissId:"+nearmissId);
		 List<NearMissDetailsVO>  listObj = nearMissDetailsService.getNearMissDetails(nearmissId);	
		 if(listObj != null) {
			 System.out.println("[getNearMissDetails]########nearmissbyid##########"+listObj.size()); 
		 }else {
			 System.out.println("[getNearMissDetails]########No Data Return##########"); 
		 }
		
		return listObj;	
		 
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
	@GetMapping(value="/nonconformitybyid/{auditncid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NonConformityDetailsVO> getNonConformityDetails(@PathVariable("auditncid") String auditncid){
		
		log.info(CLASS_NAME+"::Inside [getNonConformityDetails] Controller method!");
		
		return nonConformityDetailsService.getNonConformityDetails(auditncid);
	}
	
	/**
     * Returns Port State Control Details data from Service layer.
     * @author Deepak Bansal
     * @methodName: getPortStateControlDetails
     * @serviceURL: http://<host:port>/analytics/portstatecontrolbyid/{inspectionid}
     * @param: inspectionid (Required)
     * @return -  List<NonConformityDetailsVO> (JSON Object)
     * 
     */
	@GetMapping(value="/portstatecontrolbyid/{inspectionid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PortStateControlDetailsVO> getPortStateControlDetails(@PathVariable("inspectionid") String inspectionid){
		log.info(CLASS_NAME+"::Inside [getPortStateControlDetails] Controller method!");
		
		return portStateControlDetailsService.getPortStateControlDetails(inspectionid);
	}
	
	/**
     * Returns Port State Control Filter, Graph and Grid data 
     * by date range from Service layer.
     * @methodName: getPortStateData
     * @serviceURL: http://<host:port>/analytics/nearmiss?startDate=""&endDate=""
     * @param startDate - Start Date (defaultValue = "")
     * @param endDate -  End Date (defaultValue = "")
     * @return - List<AnalyticsResponseVO> (JSON Object)
     * 
     */
	@GetMapping(value ="/portstatecontrol/{vesselIds}/{startDate}/{endDate}")
	@ResponseBody
	public List<PortStateControlVO> getPortStateData(@PathVariable String vesselIds,
            @PathVariable String startDate,
            @PathVariable String endDate){
		log.info(CLASS_NAME+"::Inside [getPortStateData] Controller !");
		AnalyticsRequestVO requestVO  = new AnalyticsRequestVO();
		 requestVO.setVesselIds(vesselIds);
		 requestVO.setStartDate(startDate);
		 requestVO.setEndDate(endDate);
		 
		return portStateControlService.getPortStateData(requestVO);
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
	
	@GetMapping(value ="/shipvisit/{vesselIds}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AnalyticsResponseVO> getShipVisitData(@PathVariable String vesselIds,
											            @PathVariable String startDate,
											            @PathVariable String endDate) {
		log.info(CLASS_NAME+"::Inside [getShipVisitData] Controller method!");
		AnalyticsRequestVO requestVO  = new AnalyticsRequestVO();
		requestVO.setVesselIds(vesselIds);
		requestVO.setStartDate(startDate);
		requestVO.setEndDate(endDate);
		return shipVisitService.getShipVisitData(requestVO);	
	}
	
	/**
     * Returns Ship Visit Details data from Service layer.
     * @author Deepak Bansal
     * @methodName: getShipVisitDetails
     * @serviceURL: http://<host:port>/analytics/shipvisitbyid/{inspscheduledid}
     * @param: inspscheduledid (Required)
     * @return - List<ShipVisitDetailsVO> (JSON Object)
     * 
     */
	@GetMapping(value="/shipvisitbyid/{inspscheduledid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ShipVisitDetailsVO> getShipVisitDetails(@PathVariable("inspscheduledid") String inspscheduledid){
		log.info(CLASS_NAME+"::Inside [getShipVisitDetails] Controller method!");
		
		return shipVisitDetailsService.getShipVisitDetails(inspscheduledid);
	}
	
	/**
     * Returns Invoice Details data from Service layer.
     * @author Deepak Bansal
     * @methodName: getInvoiceDetails
     * @serviceURL: http://<host:port>/analytics/invoicebyid/{poid}
     * @param: poid (Required)
     * @return - List<InvoiceDetailVO> (JSON Object)
     */
	@GetMapping(value="/invoicebyid/{poid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<InvoiceDetailVO> getInvoiceDetails(@PathVariable("poid") String poid){
		log.info(CLASS_NAME+"::Inside [getInvoiceDetails] Controller method!");
		
		return invoiceDetailService.getInvoiceDetails(poid);
	}
	
	/**
     * Returns Invoice Details data from Service layer.
     * @author Deepak Bansal
     * @methodName: getMaintenanceDetails
     * @serviceURL: http://<host:port>/analytics/maintenancebyid/{jobid}
     * @param: poid (Required)
     * @return - List<MaintenanceDetailVO> (JSON Object)
     */
	@GetMapping(value="/maintenancebyid/{jobid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MaintenanceDetailVO> getMaintenanceDetails(@PathVariable("jobid") String jobid){
		log.info(CLASS_NAME+"::Inside [getMaintenanceDetails] Controller method!");
		
		return maintenanceDetailService.getMaintenanceDetails(jobid);
	}
	
	/**
     * Returns Fuel Consumption Filter, Graph and Grid data by date range from Service layer.
     * @author Deepak Bansal
     * @methodName: getFuelConsumptionData
     * @serviceURL: http://<host:port>/analytics/fuelconsumption
     * @param: requestVO - AnalyticsRequestVO {Vessel Id List (Required), Status (defaultValue = "")
     * @return -  List<AnalyticsResponseVO> (JSON Object)
     * 
     */
	
	@GetMapping(value ="/fuelconsumption/{vesselIds}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AnalyticsResponseVO> getFuelConsumptionData(@PathVariable String vesselIds,
											            @PathVariable String startDate,
											            @PathVariable String endDate) {
		log.info(CLASS_NAME+"::Inside [getFuelConsumptionData] Controller method!");
		AnalyticsRequestVO requestVO  = new AnalyticsRequestVO();
		requestVO.setVesselIds(vesselIds);
		requestVO.setStartDate(startDate);
		requestVO.setEndDate(endDate);
		return fuelConsumptionService.getFuelConsumptionData(requestVO);
	}
	
	/**
     * Returns Downtime Filter, Graph and Grid data by date range from Service layer.
     * @author Deepak Bansal
     * @methodName: getDownTimeData
     * @serviceURL: http://<host:port>/analytics/downtime
     * @param: requestVO - AnalyticsRequestVO {Vessel Id List (Required), Status (defaultValue = "")
     * @return -  List<AnalyticsResponseVO> (JSON Object)
     * 
     */
	
	@GetMapping(value ="/downtime/{vesselIds}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AnalyticsResponseVO> getDownTimeData(@PathVariable String vesselIds,
											            @PathVariable String startDate,
											            @PathVariable String endDate) {
		log.info(CLASS_NAME+"::Inside [getDownTimeData] Controller method!");
		AnalyticsRequestVO requestVO  = new AnalyticsRequestVO();
		requestVO.setVesselIds(vesselIds);
		requestVO.setStartDate(startDate);
		requestVO.setEndDate(endDate);
		return downTimeService.getDownTimeData(requestVO);
	}
}
