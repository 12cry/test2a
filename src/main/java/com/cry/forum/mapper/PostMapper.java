package com.cry.forum.mapper;

import com.cry.forum.model.Comment;
import com.cry.forum.model.Post;
import util.MyMapper;

import java.util.List;

public interface PostMapper extends MyMapper<Post> {
    public List<Post> query();
    public List<Comment> queryCommentList(Integer id);
}