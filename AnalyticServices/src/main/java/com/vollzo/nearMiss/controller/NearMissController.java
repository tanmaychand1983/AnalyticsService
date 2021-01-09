package com.vollzo.nearMiss.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vollzo.nearMiss.entity.NearMissEntity;
import com.vollzo.nearMiss.service.NearMissService;
import com.vollzo.nearMiss.vo.CategoryVO;
import com.vollzo.nearMiss.vo.DayNightVO;
import com.vollzo.nearMiss.vo.VesselActiveVO;

@RestController
@RequestMapping("/nearmiss")
@CrossOrigin("*")
public class NearMissController {

	@Autowired
	private NearMissService nearMissServices;
	
	@GetMapping(value ="/daynight", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DayNightVO getDayNightData() {
		DayNightVO daynightObj = new DayNightVO();
		daynightObj.setDay(214);
		daynightObj.setNight(74);
	   return daynightObj;	
	}
	
	
	  @GetMapping(value ="/test")	  
	  @ResponseBody 
	  public String getTestData() {
	  
	  return "Hello World!";
	  
	  }
	 
	
	@GetMapping(value ="/vesselactive", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public VesselActiveVO getVesselActiveData() {
		VesselActiveVO vesselObj =  new VesselActiveVO();
		vesselObj.setOnPassage(190);
		vesselObj.setAtAnchor(46);
		vesselObj.setAtBerth(23);
		vesselObj.setDrifting(12);
	   return vesselObj;	
	}
	
	@GetMapping(value ="/category", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Integer> getCategory() {		 
		List<NearMissEntity> listObj = nearMissServices.getAllCategoryData();
		String category = null;
		int count = 0;
 		
		
		Map<String, List<CategoryVO>> mapObj = new HashMap<>();
		CategoryVO categoryObj = null;
					
		for (NearMissEntity nearMissEntity : listObj) {
			category = nearMissEntity.getCategory();
			if(!mapObj.containsKey(category)) {
				count = 0;
				List<CategoryVO> listCatg = new ArrayList<CategoryVO>();
				categoryObj = new CategoryVO();
				categoryObj.setCategoryName(category);
			    categoryObj.setCategoryValue(count);
				listCatg.add(categoryObj);
				mapObj.put(category, listCatg);
			}else {
				categoryObj = new CategoryVO();
				categoryObj.setCategoryName(category);
			    categoryObj.setCategoryValue(count);
			    mapObj.get(category).add(categoryObj);
			    count++;
			}	    
			
								
			
		}
		
		Map<String, Integer> finalMapObj = new HashMap<String, Integer>();
		for (Map.Entry<String, List<CategoryVO>> map : mapObj.entrySet()) {
			finalMapObj.put(map.getKey(), map.getValue().size());
			//System.out.println(map.getKey()+">>"+map.getValue().size());
		}
		
		//System.out.println(mapObj.size());
	   //return nearMissServices.getAllCategoryData();
		return finalMapObj;
	}
	
}
