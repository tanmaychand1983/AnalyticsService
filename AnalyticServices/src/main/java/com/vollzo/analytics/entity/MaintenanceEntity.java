/**
 * {@summary}: This is the Entity class for Maintenance Dashboard.
 * 
 * @className: MaintenanceEntity
 * @author Deepak Bansal
 * @since: Feb 02, 2021
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
public class MaintenanceEntity extends BaseEntity {
	
	@Column(name = "unit_id")
	private Integer unitId;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "vessel_id")
	private Integer vesselId;
	
	@Column(name = "vessel_name")
	private String vesselName;
	
	@Column(name = "age")
	private String age;
	
	@Column(name = "rank_id")
	private Integer rankId;
	
	@Column(name = "rank_name")
	private String rankName;
	
	@Column(name = "job_number")
	private String jobNumber;
	
	@Column(name = "job_type")
	private String jobType;
	
	@Column(name = "frequency_type")
	private String frequency;
	
	@Column(name = "summary")
	private String title;
	
	@Column(name = "last_done")
	private String lastDone;
	
	@Column(name = "next_due")
	private String nextDue;
	
}
