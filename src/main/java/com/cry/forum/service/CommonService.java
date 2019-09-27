package com.cry.forum.service;

import com.cry.forum.mapper.CommonMapper;
import com.cry.forum.model.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommonService {

    @Autowired
    CommonMapper commonMapper;



//    public List<CommonNum> getAll(CommonNum commonNum) {
//        List<CommonNum> list = commonNumMapper.selectAll();
//        return list;
//    }


    public Map<String, List<Common>> queryByTargetId(String targetId){
        List<Common> list = commonMapper.queryScore(targetId);
        Map<String, List<Common>> map = list.stream().collect(Collectors.groupingBy(Common::getZ1));
        return map;
    }
}
