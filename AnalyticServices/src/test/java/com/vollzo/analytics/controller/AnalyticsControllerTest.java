package com.vollzo.analytics.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.vollzo.analytics.service.AnalyticsService;

/**
 * {@summary}: This is the JUNIT Test class for Analytics Controller class.
 * 
 * @className: AnalyticsControllerTest
 * @author Ajaya Kar
 * @since: Jan 23, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */

@WebMvcTest(AnalyticsController.class)
public class AnalyticsControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AnalyticsService service;

	@Test
	public void shouldReturnStatus200ForNearMiss() throws Exception {
		this.mockMvc.perform(get("/analytics/nearmiss")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnStatus200ForNearMissWithParameters() throws Exception {
		this.mockMvc.perform(get("/analytics/nearmiss?startDate=\"\"&endDate=\"\"")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnStatus404ForNearMiss() throws Exception {
		this.mockMvc.perform(get("/analytics/nearmiss1")).andDo(print()).andExpect(status().is(404));
	}
	
	@Test
	public void shouldReturnStatus200ForAccidentIncident() throws Exception {
		this.mockMvc.perform(get("/analytics/accidentincident")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnStatus404ForAccidentIncident() throws Exception {
		this.mockMvc.perform(get("/analytics/accidentincident1")).andDo(print()).andExpect(status().is(404));
	}
}
