package com.cry.forum.mapper;

import com.cry.forum.model.User;
import util.MyMapper;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
    User queryByOpenid(String openid);
    List<User> queryList(String value);
    List<User> queryListDefault();

}
