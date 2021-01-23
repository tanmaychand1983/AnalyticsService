package com.vollzo.analytics.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseOrderEntity extends BaseEntity{
	
	@Column(name = "ref_number")
	private String refNumber;
	
	@Column(name = "unit_id")
	private int unitId;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "vessel_id")
	private int vesselId;
	
	@Column(name = "vesselName")
	private String vessel_name;
	
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "status_id")
	private Integer statusId;
	
	@Column(name = "status_name")
	private String statusName;	
	
	@Column(name = "reported_date")
	private String reportedDate;
	
	@Column(name = "reported_by")
	private String reportedBy;
	
	@Column(name = "title")
	private String title;
	
	
	@Override
    public String toString() {
        return "NearMissEntity [unitId=" + unitId + ", unitName=" + unitName + 
                ", vesselId=" + vesselId + ", vesselName=" + vessel_name   + 
                ", categoryId=" + categoryId + ", categoryName="+ categoryName +
                ", statusId=" + statusId + ", statusName="+ statusName +
                ", refNumber=" + refNumber + ", reportedDate="+ reportedDate +
                ", reportedBy=" + reportedBy + ", title=" + title +
                "]";
    }
	
}
