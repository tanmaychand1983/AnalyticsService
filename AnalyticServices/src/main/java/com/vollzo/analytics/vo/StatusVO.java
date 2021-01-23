package com.vollzo.analytics.vo;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatusVO {
	
	private Integer statusId;
	private String statusName;
	private int unitId;
}
