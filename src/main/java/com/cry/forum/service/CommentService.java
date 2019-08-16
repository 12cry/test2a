package com.cry.forum.service;

import com.cry.forum.mapper.CommentMapper;
import com.cry.forum.model.Comment;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    public List<Comment> query(Comment comment) {
        if (comment.getPage() != null && comment.getRows() != null) {
            PageHelper.startPage(comment.getPage(), comment.getRows()).setOrderBy("create_time desc");
        }
        List<Comment> list = commentMapper.query();
        for (Comment c : list) {
            List<Comment> children = commentMapper.queryByPid(c.getId());
            c.setChildren(children);
        }
        return list;
    }

    public List<Comment> test(Comment comment) {
        if (comment.getPage() != null && comment.getRows() != null) {
            PageHelper.startPage(comment.getPage(), comment.getRows()).setOrderBy("create_time desc");
        }

//        List list = commentMapper.test();
        List list = commentMapper.query();
        return list;
    }

    public List<Comment> getAll(Comment comment) {
        if (comment.getPage() != null && comment.getRows() != null) {
            PageHelper.startPage(comment.getPage(), comment.getRows()).setOrderBy("create_time desc");
        }
        return commentMapper.selectAll();
    }

    public Comment getById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        commentMapper.deleteByPrimaryKey(id);
    }

    public void save(Comment comment) {

        if (comment.getId() != null) {
            commentMapper.updateByPrimaryKey(comment);
        } else {
            comment.setCreateTime(new Date());
            commentMapper.insert(comment);
        }
    }
}
