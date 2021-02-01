package com.vollzo.analytics.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VesselVO {
	 
	private Integer vesselId;
	private String  vesselDesc;
	private CategoryVO categoryVO;	
	private StatusVO statusVO;
	private ReferenceDataVO referenceDataVO;
}
