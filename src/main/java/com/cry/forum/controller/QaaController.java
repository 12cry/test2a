package com.cry.forum.controller;

import com.cry.forum.model.Qaa;
import com.cry.forum.service.QaaService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/qaa")
public class QaaController {
    @Autowired
    private QaaService qaaService;

    @RequestMapping(value = "query")
    public PageInfo<Qaa> query(Qaa qaa) {
        List<Qaa> list = qaaService.query(qaa);
        return new PageInfo<Qaa>(list);
    }
}
