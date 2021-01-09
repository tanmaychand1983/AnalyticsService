package com.vollzo.nearMiss.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VesselActiveVO {

	private double onPassage;
	private double atAnchor;
	private double atBerth;
	private double drifting;
	
	
}
