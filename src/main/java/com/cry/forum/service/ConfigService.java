package com.cry.forum.service;

import com.cry.forum.mapper.ConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService {

    @Autowired
    ConfigMapper configMapper;

    public List<String> querySceneryImage() {
        return configMapper.querySceneryImage();
    }
}
