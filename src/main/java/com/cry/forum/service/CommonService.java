package com.cry.forum.service;

import com.cry.forum.mapper.CommonNumMapper;
import com.cry.forum.model.CommonNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {
    @Autowired
    CommonNumMapper commonNumMapper;


    public List<CommonNum> getAll(CommonNum commonNum) {
        List<CommonNum> list = commonNumMapper.selectAll();
        return list;
    }
}
