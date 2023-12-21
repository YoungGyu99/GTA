package com.spring.gta.detail.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.gta.detail.vo.DetailChartVO;

@Mapper
public interface IDetailDAO {
	public List<DetailChartVO> getChartData(DetailChartVO vo);
}
