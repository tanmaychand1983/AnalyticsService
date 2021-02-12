/**
 * {@summary}: This is the Entity class for NearMiss Details.
 * @className: NearMissDetailsEntity
 * @author Deepak Bansal
 * @since: Feb 11, 2021
 * @version: 1.0.0
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
public class NearMissDetailsEntity extends BaseEntity {
	
	@Column(name = "vessel_Name")
	private String vesselName;
	
	@Column(name = "ref_number")
	private String refNumber;
	
	@Column(name = "reported_date")
	private String reportedDate;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "subcategory")
	private String subcategory;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "port_name")
	private String portName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "immediate_action")
	private String immediateAction;
	
	@Column(name = "root_cause")
	private String rootCause;
	
	@Column(name = "corrective_action")
	private String correctiveAction;
	
	@Column(name = "preventive_action")
	private String preventiveAction;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "master")
	private String master;
	
	@Column(name = "reported_by")
	private String reportedBy;
	
	@Column(name = "verification_instruction")
	private String verificationInstruction;
	
	@Column(name = "verification_date")
	private String verificationDate;
	
	@Column(name = "techsuprintendent_name")
	private String techsuprintendentName;
	
	@Override
    public String toString() {
        return "NearMissDetailsEntity [vesselName=" + vesselName + ", refNumber=" + refNumber + 
                ", reportedDate=" + reportedDate + ", type=" + type   + 
                ", category=" + category + ", subcategory="+ subcategory + ", latitude="+ latitude +
                ", longitude=" + longitude + ", portName="+ portName +
                ", description=" + description + ", immediateAction="+ immediateAction +
                ", rootCause=" + rootCause + ", correctiveAction=" + correctiveAction +
                ", preventiveAction=" + preventiveAction + ", createdDate=" + createdDate +
                ", master=" + master + ", reportedBy=" + reportedBy +
                ", verificationInstruction=" + verificationInstruction + ", verificationDate=" + verificationDate +
                ", techsuprintendentName=" + techsuprintendentName +
                "]";
    }
}
