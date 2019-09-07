package com.cry.forum.controller;

import com.cry.forum.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    ConfigService configService;

    @PostMapping(value = "querySceneryImage")
    public List<String> querySceneryImage() {
        return configService.querySceneryImage();
    }
}
