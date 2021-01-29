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
	private int unitId;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "vessel_id")
	private int vesselId;
	
	@Column(name = "vessel_name")
	private String vesselName;
	
	@Column(name = "vendor_id")
	private int vendorId;
	
	@Column(name = "vendor_name")
	private String vendorName;
	
	@Column(name = "budget_code")
	private int budgetCode;
	
	@Column(name = "material_type")
	private String materialType;	
	
	@Column(name = "requisition_order_id")
	private int requisitionOrderId;
	
	@Column(name = "requisition_number")
	private String requisitionNumber;
	
	@Column(name = "po_number")
	private String poNumber;
	
	@Column(name = "status_id")
	private String statusId;
	
	@Column(name = "status_name")
	private String statusName;	
	
	@Column(name = "total_amount")
	private double totalAmount;	
	
	@Column(name = "invoice_number")
	private String invoiceNumber;
	
	@Column(name = "invoice_amount")
	private Double invoiceAmount;
	
	@Column(name = "net_pay")
	private Double netPay;
	
	
	@Override
    public String toString() {
        return "NearMissEntity [unitId=" + unitId + ", unitName=" + unitName + 
                ", vesselId=" + vesselId + ", vesselName=" + vesselName   + 
                ", vendorId=" + vendorId + ", vendorName="+ vendorName +
                ", statusId=" + statusId + ", statusName="+ statusName +
                ", budgetCode=" + budgetCode + ", materialType="+ materialType +
                ", requisitionOrderId=" + requisitionOrderId + ", requisitionOrderId=" + requisitionOrderId +
                ", requisitionNumber=" + requisitionNumber + ", poNumber=" + poNumber +
                ", totalAmount=" + totalAmount + ", invoiceNumber=" + invoiceNumber +
                ", invoiceAmount=" + invoiceAmount + ", netPay=" + netPay +
                "]";
    }
	
}
