package com.vollzo.analytics.vo;

import com.vollzo.analytics.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryVO {
	
	private Integer categoryId;
	private String categoryDesc;
	
	public void setCategoryDesc(String categoryDesc){
        this.categoryDesc = Util.stringFormat(categoryDesc);
    }
}
