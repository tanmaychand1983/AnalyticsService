/**
 * {@summary}: This is the Entity class for Non Conformity Details Model Dialog.
 * 
 * @className: NonConformityDetailsEntity
 * @author Deepak Bansal
 * @since: Feb 17, 2021
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
public class NonConformityDetailsEntity extends BaseEntity {
	
	@Column(name = "document_reference")
	private String documentReference;

	@Column(name = "thetis_code")
	private String thetisCode;
	
	@Column(name = "due_date")
	private String dueDate;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "immediate_action")
	private String immediateAction;
	
	@Column(name = "root_cause")
	private String rootCause;
	
	@Column(name = "corrective_action")
	private String correctiveAction;
	
	@Column(name = "longterm_action")
	private String longtermAction;
	
	@Column(name = "completion_date")
	private String completionDate;
	
	@Column(name = "closeout_date")
	private String closeoutDate;
	
	@Column(name = "closeout_remarks")
	private String closeoutRemarks;
	
	@Override
    public String toString() {
		 return "NonConformityDetailsEntity [documentReference=" + documentReference + 
				 ", thetisCode=" + thetisCode + ", dueDate="+ dueDate +
				 ", summary=" + summary + ", immediateAction="+ immediateAction +
				 ", rootCause=" + rootCause + ", correctiveAction="+ correctiveAction +
				 ", longtermAction=" + longtermAction + ", completionDate="+ completionDate +
				 ", closeoutDate=" + closeoutDate + ", closeoutRemarks="+ closeoutRemarks +
				 "]";
	}
}
