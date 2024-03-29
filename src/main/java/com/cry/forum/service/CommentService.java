package com.cry.forum.service;

import com.cry.forum.mapper.CommentMapper;
import com.cry.forum.mapper.UserCommentMapper;
import com.cry.forum.mapper.UserMapper;
import com.cry.forum.model.Comment;
import com.cry.forum.model.UserComment;
import com.cry.forum.model.UserInfo;
import com.cry.forum.vo.CommentVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.Request;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserCommentMapper userCommentMapper;
    @Autowired
    UserService userService;

    public void appreciate(UserComment userComment) {

        String userId = Request.getCurrentUserId();
        userCommentMapper.saveOrUpdate(userId, userComment.getCommentId(), userComment.getAppreciate());

    }
    public List<CommentVO> query(Comment comment) {
        if (comment.getPage() != null && comment.getRows() != null) {
            PageHelper.startPage(comment.getPage(), comment.getRows()).setOrderBy("create_time desc");
        }
        List<CommentVO> list = commentMapper.queryByTargetId(Request.getCurrentUserId(),comment.getTargetId());
        for (CommentVO c : list) {
            List<CommentVO> children = commentMapper.queryByPid(c.getId());
            c.setChildren(children);
        }
        return list;
    }

    public CommentVO save(Comment comment) {
        String userId= Request.getCurrentUserId();
//        User user = userMapper.selectByPrimaryKey(userId);
        UserInfo userInfo = userService.queryCurrentUserInfo();
        comment.setUserId(userId);
        comment.setCreateTime(new Date());
        commentMapper.insert(comment);

        CommentVO commentVO = new CommentVO();
        BeanUtils.copyProperties(userInfo,commentVO);
        BeanUtils.copyProperties(comment, commentVO);

        return commentVO;
    }


    public List<Comment> test(Comment comment) {
        if (comment.getPage() != null && comment.getRows() != null) {
            PageHelper.startPage(comment.getPage(), comment.getRows()).setOrderBy("create_time desc");
        }
        List list = commentMapper.test();
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

}
