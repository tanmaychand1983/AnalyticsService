//Deepak Bansal
package com.vollzo.analytics.vo;

import com.vollzo.analytics.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VisitTypeVO {
	
	private String visitType;
	
	public void setVisitType(String visitType){
        this.visitType = Util.stringFormat(visitType);
    }
}
