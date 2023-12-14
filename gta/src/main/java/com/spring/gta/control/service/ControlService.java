
package com.spring.gta.control.service;

import com.spring.gta.control.dao.IControlDAO;
import com.spring.gta.control.vo.ControlVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlService {

    @Autowired
    IControlDAO dao;

    public List<ControlVO> getControlList(String bwId) {
        return dao.getControlList(bwId);
    }
}
