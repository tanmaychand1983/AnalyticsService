package com.vollzo.analytics.repository;

/**
 * {@summary}: This is the Store Proc/Query Repository class.
 * 
 * @className: QueryRepository
 * @author Ajaya Kar
 * @since: Jan 23, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */
public class QueryRepository {
	public static final String STORPROC_DASHBOARD_NEARMISS 				= 	"sp_get_dashboard_nearmiss";
	public static final String STORPROC_DASHBOARD_ACCINC				= 	"sp_get_dashboard_incident";
	public static final String STORPROC_DASHBOARD_NONCONF 				= 	"sp_get_dashboard_nonconformity";
	public static final String STORPROC_DASHBOARD_PURORD 				= 	"sp_get_dashboard_purchaseorder";
	public static final String STORPROC_DASHBOARD_MAINTENANCE 			= 	"sp_get_dashboard_maintenance";
	public static final String STORPROC_DASHBOARD_MAINTENANCE_DETAILS	= 	"sp_get_dashboard_maintenance_details";
	public static final String STORPROC_DASHBOARD_INSPECTION 			= 	"sp_get_dashboard_inspection";
	public static final String STORPROC_DASHBOARD_NEARMISS_DETAILS 		= 	"sp_get_dashboard_nearmiss_details";
	public static final String STORPROC_DASHBOARD_PO_DETAILS 			= 	"sp_get_dashboard_po_details";
	public static final String STORPROC_DASHBOARD_NONCONF_DETAILS 		= 	"sp_get_dashboard_nonconfirmity_details";
	public static final String STORPROC_DASHBOARD_INSPECTION_DETAILS 	= 	"sp_get_dashboard_inspection_details";
	public static final String STORPROC_DASHBOARD_SHIPVISIT 			= 	"sp_get_dashboard_shipvisit";
	public static final String STORPROC_DASHBOARD_SHIPVISIT_DETAILS 	= 	"sp_get_dashboard_shipvisitdetails";
	public static final String STORPROC_DASHBOARD_INVOICE_DETAILS 		= 	"sp_get_dashboard_invoice_details";
	
}
