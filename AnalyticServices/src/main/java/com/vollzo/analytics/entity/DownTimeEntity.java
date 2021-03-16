/**
 * {@summary}: This is the Entity class for DownTime Dashboard.
 * @className: DownTimeEntity
 * @author Deepak Bansal
 * @since: Mar 15, 2021
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
public class DownTimeEntity extends BaseEntity {
	
	@Column(name = "unit_id")
	private int unitId;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "vessel_id")
	private int vesselId;
	
	@Column(name = "vessel_name")
	private String vesselName;
	
	@Column(name = "age")
	private String age;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "from_date")
	private String fromDateTime;
	
	@Column(name = "to_date")
	private String toDateTime;
	
	@Column(name = "down_time")
	private String downTime;
	
	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "office_remarks")
	private String officeRemarks;
	
	@Column(name = "reported_by")
	private String reportedBy;
}
