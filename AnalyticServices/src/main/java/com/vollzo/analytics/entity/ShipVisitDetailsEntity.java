/**
 * {@summary}: This is the Entity class for Ship Visit Dashboard Madal Dialog.
 * @className: ShipVisitDetailsEntity
 * @author Deepak Bansal
 * @since: Mar 12, 2021
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
public class ShipVisitDetailsEntity extends BaseEntity {
	
	@Column(name = "vessel_name")
	private String vesselName;
	
	@Column(name = "visitor")
	private String visitor;
	
	@Column(name = "port_from")
	private String portFrom;
	
	@Column(name = "port_to")
	private String portTo;
	
	@Column(name = "visit_type")
	private String visitType;
	
	@Column(name = "date_in")
	private String dateIn;
	
	@Column(name = "date_out")
	private String dateOut;
	
	@Column(name = "vir_date")
	private String virDate;
	
	@Column(name = "visit_days")
	private String visitDays;
	
	@Column(name = "next_duedate")
	private String nextDuedate;
	
	@Column(name = "review_date")
	private String reviewDate;
	
	@Column(name = "vir_senttoowner")
	private String virSenttoowner;
	
	@Column(name = "remark")
	private String remark;
}
