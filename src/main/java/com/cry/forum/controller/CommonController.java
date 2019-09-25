package com.cry.forum.controller;

import com.cry.forum.model.CommonNum;
import com.cry.forum.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private CommonService CommonNumService;

//    @RequestMapping
//    public PageInfo<CommonNum> getAll(CommonNum commonNum) {
//        List<CommonNum> commonNumList = CommonNumService.getAll(commonNum);
//        return new PageInfo<>(commonNumList);
//    }

    @RequestMapping
    public List<CommonNum> getAll(CommonNum commonNum) {
        List<CommonNum> list = this.CommonNumService.getAll(commonNum);
        return list;
    }

}
