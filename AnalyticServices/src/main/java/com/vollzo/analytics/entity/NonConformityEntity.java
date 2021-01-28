package com.vollzo.analytics.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@summary}: This is the Entity class for Non Conformity Dashboard.
 * 
 * @className: NonConformityEntity
 * @author Deepak Bansal
 * @since: Jan 28, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class NonConformityEntity extends BaseEntity{
	
	@Column(name = "unit_id")
	private int unitId;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "vessel_id")
	private int vesselId;
	
	@Column(name = "vessel_name")
	private String vesselName;
	
	@Column(name = "audit_type")
	private String auditType;
	
	@Column(name = "status_id")
	private Integer statusId;
	
	@Column(name = "status_name")
	private String statusName;	
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "ref_number")
	private String refNumber;
	
	@Column(name = "stage")
	private String stage;
	
	@Column(name = "port_name")
	private String portName;
	
	@Column(name = "audit_date")
	private String auditDate;
	
	@Column(name = "due_date")
	private String dueDate;
	
	
	@Override
    public String toString() {
        return "NearMissEntity [unitId=" + unitId + ", unitName=" + unitName + 
                ", vesselId=" + vesselId + ", vesselName=" + vesselName   + 
                ", statusId=" + statusId + ", statusName="+ statusName +
                ", auditType=" + auditType + ", stage="+ stage +
                ", refNumber=" + refNumber + ", auditDate="+ auditDate +
                ", dueDate=" + dueDate + ", portName=" + portName +
                ", summary=" + summary +
                "]";
    }
	
}
