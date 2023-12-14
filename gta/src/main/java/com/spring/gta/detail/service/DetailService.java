package com.spring.gta.detail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gta.detail.dao.IDetailDAO;
import com.spring.gta.detail.vo.DetailChartVO;


@Service
public class DetailService {
	@Autowired
	IDetailDAO dao;
	
	public List<DetailChartVO> getChartData(DetailChartVO vo) {
        return dao.getChartData(vo);
    }
}
