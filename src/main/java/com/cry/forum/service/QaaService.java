package com.cry.forum.service;

import com.cry.forum.mapper.QaaMapper;
import com.cry.forum.model.Qaa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QaaService {

    @Autowired
    QaaMapper qaaMapper;


    public List<Qaa> query(Qaa qaa) {
        List<Qaa> list = qaaMapper.selectAll();
        return list;
    }
}
