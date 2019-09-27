package com.cry.forum.mapper;

import com.cry.forum.model.Common;
import util.MyMapper;

import java.util.List;

public interface CommonMapper extends MyMapper<Common> {
    public List<Common> queryScore(String targetId);
}