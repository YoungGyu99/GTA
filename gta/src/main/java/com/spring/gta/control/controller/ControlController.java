
package com.spring.gta.control.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.gta.control.service.ControlService;
import com.spring.gta.control.vo.ControlVO;

@Controller
public class ControlController<getDegcList> {

    @Autowired
    ControlService service;

    @RequestMapping("/control")
    public String control(HttpSession session,Model model) {
    	if(session.getAttribute("login") == null) {
			return "redirect:/";
		}
    	String bwId = (String) session.getAttribute("login");
    	List<ControlVO> result = service.getControlList(bwId);
    	System.out.println(result);
    	model.addAttribute("data" ,result);
    	
        return "control/control";
    }
    
    @PostMapping("/control/getControlList")
    @ResponseBody
    public List<ControlVO> getControlList(HttpSession session,Model model) {
    	
    	String bwId = (String) session.getAttribute("login");
    	List<ControlVO> result = service.getControlList(bwId);
    	System.out.println("여기"+result);
    	
       
        return result;
    }
    
}
