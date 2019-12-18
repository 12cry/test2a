package com.cry.forum.controller;

import com.cry.forum.model.Comment;
import com.cry.forum.model.Common;
import com.cry.forum.service.CommentService;
import com.cry.forum.service.CommonService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private CommentService commentService;

    @RequestMapping
    public PageInfo<Comment> getAll(Comment comment) {
        List<Comment> commentList = commentService.getAll(comment);
        return new PageInfo<Comment>(commentList);
    }

}
