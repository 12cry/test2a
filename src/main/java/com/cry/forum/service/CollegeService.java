package com.cry.forum.service;

import com.cry.forum.mapper.CollegeMapper;
import com.cry.forum.mapper.MajorMapper;
import com.cry.forum.model.College;
import com.cry.forum.model.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private MajorMapper majorMapper;


    public List<College> queryAll() {
        List<College> colleges = collegeMapper.selectAll();
        return colleges;
    }

    public List<Major> queryMajorByCollegeId(String collegeId) {
        return majorMapper.queryByCollegeId(collegeId);
    }


}
