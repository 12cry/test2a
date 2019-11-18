package com.cry.forum.controller;

import com.cry.forum.model.College;
import com.cry.forum.model.Major;
import com.cry.forum.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @RequestMapping(value = "queryAll")
    public List<College> queryAll() {
        return collegeService.queryAll();
    }
    @RequestMapping(value="queryMajorByCollegeId")
    public List<Major> queryMajorByCollegeId(@RequestBody Major major){
        return collegeService.queryMajorByCollegeId(major.getCollegeId());
    }
}
