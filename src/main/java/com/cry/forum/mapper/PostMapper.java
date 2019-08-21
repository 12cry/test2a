package com.cry.forum.mapper;

import com.cry.forum.model.Post;
import com.cry.forum.vo.PostVO;
import util.MyMapper;

import java.util.List;

public interface PostMapper extends MyMapper<Post> {
    public List<PostVO> query();
//    public List<Comment> queryCommentList(String id);
}