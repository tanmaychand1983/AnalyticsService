/**
 * {@summary}: This is the Entity class for Invoice Dashboard Madal Dialog.
 * @className: InvoiceDetailEntity
 * @author Deepak Bansal
 * @since: Mar 12, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 */
package com.vollzo.analytics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class InvoiceDetailEntity extends BaseEntity {
	
	@Column(name = "vessel_name")
	private String vesselName;
	
	@Column(name = "vendor_name")
	private String vendorName;
	
	@Column(name = "status_name")
	private String statusName;
	
	@Column(name = "requisition_number")
	private String requisitionNumber;
	
	@Column(name = "po_number")
	private String poNumber;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "po_date")
	private String poDate;
	
	@Column(name = "po_totalamount")
	private String poTotalamount;
	
	@Column(name = "po_usdamount")
	private String poUsdamount;
	
	@Column(name = "invoice_number")
	private String invoiceNumber;
	
	@Column(name = "invoice_amount")
	private String invoiceAmount;
	
	@Column(name = "net_pay")
	private String netPay;
	
	@Column(name = "invoice_date")
	private String invoiceDate;
	
	@Column(name = "pay_date")
	private String payDate;
	
	@Column(name = "material_type")
	private String materialType;
}
