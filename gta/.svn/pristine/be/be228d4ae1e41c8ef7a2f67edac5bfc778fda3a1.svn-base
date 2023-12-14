/**
 * 
 */
package com.spring.gta.eepad.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.gta.eepad.service.EepadService;
import com.spring.gta.eepad.vo.EepadVO;

/**
 * Class Name  : DashboardController
 * Author      : ksj
 * Created Date: 2023. 11. 22.
 * Version: 1.0
 * Purpose:   
 * Description: 
 */

@Controller
public class EepadController {
	@Autowired
	EepadService service;
	
	@RequestMapping("/eepad")
	//여기는 나무를 제외한 모든값의 target 부분
	   public String EepadList(HttpSession session, Model model) {
		if(session.getAttribute("login") == null) {
			return "redirect:/";
		}
		EepadVO vo = new EepadVO();
		vo.setbId((String)session.getAttribute("login"));
		EepadVO data = service.getEepadList1(vo);
		
		//나무를 제외한 모든 값의 current 부분
	    int money=data.getMoney()-data.getAverageMoney();
	    data.setCurrentMoney(money*(-1));
	    int energy=(int) (data.getEnergy()-data.getAverageEnergy());
	    data.setCurrentEnergy(energy*(-1));
	    int co2=(int) (data.getCo2()-data.getAverageCo2());
	    data.setCurrentCo2(co2*(-1));
	    
       //나무  식  (나무는 co2에  *30 을 해줘야 하므로 co2 값에 30만 곱해서 출력했음)
	    int avgtree=(int) (data.getAverageCo2())/30;
	    data.setAvgtree(avgtree*(1));
	    int tree=(int) (data.getCo2())/30;
	    data.setTree(tree);
	    
	    //여기는 모델 
		model.addAttribute("result", data);
		return "eepad/eepad";

	}
}


