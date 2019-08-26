package com.cry.forum.mapper;

import com.cry.forum.model.UserComment;
import util.MyMapper;

public interface UserCommentMapper extends MyMapper<UserComment> {
    public void saveOrUpdate(String userId, String commentId, Boolean appreciate);
}