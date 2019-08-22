package com.cry.forum.mapper;

import com.cry.forum.model.User;
import util.MyMapper;

public interface UserMapper extends MyMapper<User> {

    public User queryByOpenid(String openid);
}