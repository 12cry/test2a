package com.cry.forum.mapper;

import com.cry.forum.model.Major;
import util.MyMapper;

import java.util.List;

public interface MajorMapper extends MyMapper<Major> {
    public List<Major> queryByCollegeId(String collegeId);
}
