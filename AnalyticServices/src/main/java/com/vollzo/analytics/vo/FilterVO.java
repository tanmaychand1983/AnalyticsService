package com.vollzo.analytics.vo;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterVO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Map<String, String>> CategoryList;
}
