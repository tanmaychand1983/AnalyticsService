package com.vollzo.analytics.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NearMissVO {
	private List<DataVO> dataList;
	private List<UnitVO> unitList;
	private List<StatusVO> statusList;
	private List<CategoryVO> categoryList;
	private List<VesselVO> vesselList;
}
