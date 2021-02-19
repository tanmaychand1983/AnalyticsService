/**
 * {@summary}: This is the Entity class for Port State Control Dashboard.
 * 
 * @className: PortStateControlEntity
 * @author Deepak Bansal
 * @since: Feb 19, 2021
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
public class PortStateControlEntity extends BaseEntity {
	
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
	
	@Column(name = "inspection_id")
	private String inspectionId;
	
	@Column(name = "inspection_number")
	private String inspectionNumber;
	
	@Column(name = "inspection_date")
	private String inspectionDate;
	
	@Column(name = "port_name")
	private String portName;
	
	@Column(name = "mou")
	private String mou;
	
	@Column(name = "inspector_name")
	private String inspectorName;
	
	@Column(name = "inspection_status")
	private String inspectionStatus;
	
	@Column(name = "deficiencie_status")
	private String deficiencieStatus;
	
	@Column(name = "deficiencie_count")
	private String deficiencieCount;
}
