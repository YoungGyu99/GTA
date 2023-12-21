package com.spring.gta.detail.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.gta.detail.service.DetailService;
import com.spring.gta.detail.vo.DetailChartVO;

@Controller
public class DetailController {
	
	
	@Autowired
	DetailService service;
	
	@RequestMapping("/detail")
	public String dashBoardList(Model model,HttpSession session ) {
		if(session.getAttribute("login") == null) {
			return "redirect:/";
		}
		return "detail/detail";
	}
	
	
	@PostMapping("/detail/chart.do")
	@ResponseBody
	public List<DetailChartVO> getChartData(@RequestBody DetailChartVO detailChartVO) {
	    return service.getChartData(detailChartVO);
	}

}
