/**
 * 
 */
package com.spring.gta.eepad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gta.eepad.dao.EepadDAO;
import com.spring.gta.eepad.vo.EepadVO;

/**
 * Class Name  : EepadService
 * Author      : ksj
 * Created Date: 2023. 12. 6.
 * Version: 1.0
 * Purpose:   
 * Description: 
 */


@Service
public class EepadService {
	@Autowired
	EepadDAO dao;
	
    public EepadVO getEepadList1(EepadVO vo) {
    	EepadVO result = dao.getEepadList2(vo);
    	EepadVO result2 = dao.getUseEepadList2(vo);
    	System.out.println("여기"+dao.getUseEepadList2(vo));
    	result2.setAverageEnergy(result.getAverageEnergy());
    	result2.setAverageMoney(result.getAverageMoney());
    	result2.setAverageCo2(result.getAverageCo2());
    	System.out.println("dddd"+result2);
    	result2.setCo2(result2.getCo2());  		
    	return result2;
        
    }
}


