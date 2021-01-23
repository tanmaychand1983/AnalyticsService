package com.vollzo.analytics.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataVO {

	private int vesselId;
	private int categoryId;
	private int statusId;
	private int unitId;
	private String refNumber;
	private String reportedDate;
	private String reportedBy;
	private String title;

}
