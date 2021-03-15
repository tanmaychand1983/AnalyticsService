/**
 * {@summary}: This is the VO class use for Fuel Consumption Dashboard Filter.
 * @className: LoadingConditionVO
 * @author Deepak Bansal
 * @since: Mar 15, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 */
package com.vollzo.analytics.vo;

import com.vollzo.analytics.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherVO {
	private String weather;
	
	public void setWeather(String weather){
        this.weather = Util.stringFormat(weather);
    }
}
