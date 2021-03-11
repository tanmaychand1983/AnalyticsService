/**
 * {@summary}: This is the Entity class for Ship Visit Dashboard.
 * @className: ShipVisitEntity
 * @author Deepak Bansal
 * @since: Mar 11, 2021
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
public class ShipVisitEntity extends BaseEntity {
	
	@Column(name = "unit_id")
	private int unitId;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "vessel_id")
	private int vesselId;
	
	@Column(name = "vessel_name")
	private String vesselName;
	
	@Column(name = "visitor")
	private String visitor;
	
	@Column(name = "port_from")
	private String portFrom;
	
	@Column(name = "visit_type")
	private String visitType;
	
	@Column(name = "date_in")
	private String dateIn;
	
	@Column(name = "vir_date")
	private String virDate;
	
	@Column(name = "visit_days")
	private String visitDays;
	
	@Column(name = "next_duedate")
	private String nextDuedate;
	
	@Column(name = "vir_senttoowner")
	private String virSenttoowner;
	
}
