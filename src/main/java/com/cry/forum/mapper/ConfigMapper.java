package com.cry.forum.mapper;

import com.cry.forum.model.Config;
import util.MyMapper;

import java.util.List;

public interface ConfigMapper extends MyMapper<Config> {
    List<String> querySceneryImage();
}