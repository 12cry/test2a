package com.cry.forum.mapper;

import com.cry.forum.model.UserInfo;
import util.MyMapper;

import java.util.List;

public interface UserInfoMapper extends MyMapper<UserInfo> {
    List<UserInfo> queryList(String value);
    List<UserInfo> queryListDefault();
}