package com.cry.forum.controller;

import com.cry.forum.model.Common;
import com.cry.forum.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private CommonService commonService;


//    @RequestMapping
//    public PageInfo<CommonNum> getAll(CommonNum commonNum) {
//        List<CommonNum> commonNumList = CommonNumService.getAll(commonNum);
//        return new PageInfo<>(commonNumList);
//    }

//    @RequestMapping
//    public List<CommonNum> getAll(CommonNum commonNum) {
//        List<CommonNum> list = this.commonService.getAll(commonNum);
//        return list;
//    }

    @RequestMapping(value = "queryScore")
    public Map queryScore() {
        Map<String, List<Common>> map = this.commonService.queryByTargetId("1");
        return map;
    }

}
