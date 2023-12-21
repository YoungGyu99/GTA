/**
 * 
 */
package com.spring.gta.dashboard.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.gta.dashboard.service.DashboardService;
import com.spring.gta.dashboard.vo.DashChartVO;
import com.spring.gta.dashboard.vo.DashboardVO;
import com.spring.gta.dashboard.vo.DashboardsearchVO;
import com.spring.gta.inform.service.InformService;
import com.spring.gta.inform.vo.InformVO;

/**
 * Class Name  : DashboardController
 * Author      : ksj
 * Created Date: 2023. 11. 22.
 * Version: 1.0
 * Purpose:   
 * Description: 
 */
@Controller
public class DashboardController {
	
	@Autowired
	DashboardService dashBoardService;
	@Autowired
	InformService informservice;
	
	@RequestMapping("/dashboard")
	public String dashBoardList(Model model, HttpSession session) {
		if(session.getAttribute("login") == null) {
			return "redirect:/";
		}
		 List<InformVO> list =informservice.getInformList();
		model.addAttribute("info",list);
		return "dashboard/dashboard";
	}
	
	@ResponseBody
	@PostMapping("/dashBoardData.do")
    public DashboardVO dashBoardData(@RequestBody DashboardsearchVO search,HttpSession session) throws Exception {
		search.setbId((String)session.getAttribute("login"));
		DashboardVO result = dashBoardService.getdashboardSearchList(search);
		return result;
	}
	@PostMapping("/chart.do")
	@ResponseBody
	public List<DashChartVO> getChartData(@RequestBody Map<String, String> requestData) {
	    String currentDataset = requestData.get("dataset");
	    return dashBoardService.getChartData(currentDataset);
	}
	@PostMapping("/chart2.do")
	@ResponseBody
	public DashboardVO getChart2Data() {
		DashboardVO horizontalData = dashBoardService.getHorizontal();
		
		return horizontalData;
	}

}
