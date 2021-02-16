/**
 * {@summary}: This is the Entity class for PurchaseOrder Details Modal Dialog.
 * 
 * @className: PurchaseOrderDetailsEntity
 * @author Deepak Bansal
 * @since: Feb 16, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */
package com.vollzo.analytics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseOrderDetailsEntity extends BaseEntity {
	
	@Column(name = "po_number")
	private String poNumber;
	
	@Column(name = "status_name")
	private String statusName;
	
	@Column(name = "vessel_name")
	private String vesselName;
	
	@Column(name = "vendor_name")
	private String vendorName;
	
	@Column(name = "po_type")
	private String poType;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "po_date")
	private String poDate;
	
	@Column(name = "expected_readiness_date")
	private String expectedReadinessDate;
	
	@Column(name = "po_amount")
	private String poAmount;
	
	@Column(name = "po_amount_usd")
	private String poAmountUSD;
	
	@Column(name = "account_code")
	private String accountCode;
	
	@Column(name = "requisition_number")
	private String requisitionNumber;
	
	@Column(name = "expected_delivery_time")
	private String expectedDeliveryTime;
	
	@Column(name = "billing_address")
	private String billingAddress;
	
	@Override
    public String toString() {
		 return "PurchaseOrderDetailsEntity [poNumber=" + poNumber + ", statusName=" + statusName +
				 ", vesselName=" + vesselName + ", vendorName="+ vendorName +
				 ", poType=" + poType + ", category="+ category +
				 ", summary=" + summary + ", poDate="+ poDate +
				 ", expectedReadinessDate=" + expectedReadinessDate + ", poAmount="+ poAmount +
				 ", poAmountUSD=" + poAmountUSD + ", accountCode="+ accountCode +
				 ", requisitionNumber=" + requisitionNumber + ", expectedDeliveryTime="+ expectedDeliveryTime +
				 ", billingAddress=" + billingAddress +
				 "]";
	}
}
