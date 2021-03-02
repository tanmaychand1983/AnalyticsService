package com.vollzo.analytics.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@summary}: This is the Entity class for PurchaseOrder.
 * 
 * @className: PurchaseOrderEntity
 * @author Ajaya Kar
 * @since: Jan 29, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseOrderEntity extends BaseEntity{
	
	@Column(name = "unit_id")
	private Integer unitId;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "vessel_id")
	private Integer vesselId;
	
	@Column(name = "vessel_name")
	private String vesselName;
	
	@Column(name = "vendor_id")
	private Integer vendorId;
	
	@Column(name = "vendor_name")
	private String vendorName;
	
	@Column(name = "budget_code")
	private Integer budgetCode;
	
	@Column(name = "material_type")
	private String materialType;	
	
	@Column(name = "requisition_number")
	private String requisitionNumber;
	
	@Column(name = "po_number")
	private String poNumber;
	
	@Column(name = "po_date")
	private String poDate;
	
	@Column(name = "summary")
	private String poTitle;
	
	@Column(name = "status_id")
	private Integer statusId;
	
	@Column(name = "status_name")
	private String statusName;	
	
	@Column(name = "currency_totalamount")
	private String currencyTotalamount;	
	
	@Column(name = "usd_totalamount")
	private String usdTotalamount;	
	
	
	@Column(name = "invoice_number")
	private String invoiceNumber;
	
	@Column(name = "invoice_amount")
	private Double invoiceAmount;
	
	@Column(name = "net_pay")
	private Double netPay;
	

	
}
