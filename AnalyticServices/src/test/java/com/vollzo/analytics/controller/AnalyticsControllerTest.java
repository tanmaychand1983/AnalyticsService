package com.vollzo.analytics.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vollzo.analytics.service.NearMissService;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;

@WebMvcTest(AnalyticsController.class)
public class AnalyticsControllerTest {
	
	@MockBean
	private NearMissService nearMissService;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	@DisplayName("NearMiss Dashboard Should list all the data")
	public void nearMissShouldReturnDataForGivenParameter()throws Exception {
		AnalyticsRequestVO requestVO = new AnalyticsRequestVO();
		requestVO.setVesselIds("75");
		requestVO.setStartDate("2020-09-16");
		requestVO.setEndDate("2020-09-16");
		
		List<AnalyticsResponseVO> responseVO = new ArrayList<>();
		
		//Mockito.when(nearMissService.getNearMissData(requestVO)).thenReturn(responseVO);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/analytics/nearmiss/")
					.accept(MediaType.APPLICATION_JSON_VALUE)
					.content(asJsonString(requestVO)))
					.andDo(print())
					.andReturn();
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
