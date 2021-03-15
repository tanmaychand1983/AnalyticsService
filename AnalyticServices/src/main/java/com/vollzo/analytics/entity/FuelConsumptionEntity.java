/**
 * {@summary}: This is the Entity class for Fuel Consumption Dashboard.
 * @className: FuelConsumptionEntity
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
public class FuelConsumptionEntity extends BaseEntity{
	
	@Column(name = "unit_id")
	private int unitId;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "vessel_id")
	private int vesselId;
	
	@Column(name = "vessel_name")
	private String vesselName;
	
	@Column(name = "speed")
	private String speed;
	
	@Column(name = "mainengine_consumption")
	private String mainengineConsumption;
	
	@Column(name = "auxilliaryengine_consumption")
	private String auxilliaryengineConsumption;
	
	@Column(name = "bolier_consumption")
	private String bolierConsumption;
	
	@Column(name = "weather")
	private String weather;
	
	@Column(name = "sea")
	private String sea;
	
	@Column(name = "activity")
	private String activity;
	
	@Column(name = "conditions")
	private String conditions;
	
	@Column(name = "report_date")
	private String reportDate;
	
	
}
