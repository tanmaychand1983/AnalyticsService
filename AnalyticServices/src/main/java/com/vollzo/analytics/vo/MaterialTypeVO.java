package com.vollzo.analytics.vo;

import com.vollzo.analytics.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MaterialTypeVO {

	private String materialType;
	
	public void setMaterialType(String materialType){
        this.materialType = Util.stringFormat(materialType);
    }
}
