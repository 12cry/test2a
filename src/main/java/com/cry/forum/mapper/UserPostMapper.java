package com.cry.forum.mapper;

import com.cry.forum.model.UserPost;
import util.MyMapper;

public interface UserPostMapper extends MyMapper<UserPost> {
    public void saveOrUpdate(String userId, String postId, Boolean appreciate);
}