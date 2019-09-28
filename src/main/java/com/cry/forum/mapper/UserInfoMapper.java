package com.cry.forum.mapper;

import com.cry.forum.model.UserInfo;
import util.MyMapper;

import java.util.List;

public interface UserInfoMapper extends MyMapper<UserInfo> {
    public List<UserInfo> queryUserInfoList(String value);
}