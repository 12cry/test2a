package com.cry.forum.controller;

import com.cry.forum.model.Comment;
import com.cry.forum.service.CommentService;
import com.cry.forum.vo.CommentVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;


    @RequestMapping(value = "query")
    public PageInfo<CommentVO> query(@RequestBody Comment comment) {
        List<CommentVO> list = commentService.query(comment);
        return new PageInfo<CommentVO>(list);
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CommentVO save(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @RequestMapping(value = "test")
    public List<Comment> test(Comment comment) {
        List<Comment> list = commentService.test(comment);
        return list;
    }

    @RequestMapping
    public PageInfo<Comment> getAll(Comment comment) {
        List<Comment> commentList = commentService.getAll(comment);
        return new PageInfo<Comment>(commentList);
    }

    @RequestMapping(value = "/add")
    public Comment add() {
        return new Comment();
    }

    @RequestMapping(value = "/view/{id}")
    public Comment view(@PathVariable Integer id) {
        ModelAndView result = new ModelAndView();
        Comment comment = commentService.getById(id);
        return comment;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelMap delete(@PathVariable Integer id) {
        ModelMap result = new ModelMap();
        commentService.deleteById(id);
        result.put("msg", "删除成功!");
        return result;
    }

}
