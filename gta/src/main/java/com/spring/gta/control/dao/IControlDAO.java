
package com.spring.gta.control.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.gta.control.vo.ControlVO;

import java.util.List;

@Repository
public class IControlDAO {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public IControlDAO(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<ControlVO> getControlList(String bwId) {
        // TODO: 실제로 데이터를 조회하고 반환하는 로직을 구현해야 합니다.
        return sqlSessionTemplate.selectList("com.spring.gta.control.dao.IControlDAO.getControlList", bwId);
    }
}
