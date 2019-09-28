package com.cry.forum.service;

import com.cry.forum.mapper.UserInfoMapper;
import com.cry.forum.mapper.UserMapper;
import com.cry.forum.model.User;
import com.cry.forum.model.UserInfo;
import com.github.pagehelper.PageHelper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import util.Http;
import util.Jwt;
import util.Request;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> queryUserInfoList(UserInfo userInfo){
        if (userInfo.getPage() != null && userInfo.getRows() != null) {
            PageHelper.startPage(userInfo.getPage(), userInfo.getRows()).setOrderBy("create_time desc");
        }
        String value = userInfo.getName();
        if(StringUtils.isEmpty(value)){
            return userInfoMapper.queryListDefault();
        }
        value = "%"+value+"%";
        List<UserInfo> list = userInfoMapper.queryList(value);
        return list;
    }
//    public User queryCurrentUser(){
//        String userId = Request.getCurrentUserId();
//        User user = new User();
//        List<User> list = userMapper.select(user);
//        return list.isEmpty()?new User():list.get(0);
//    }
    public void updateUserInfo(UserInfo userInfo){
        userInfo.setUpdateTime(new Date());
        userInfoMapper.updateByPrimaryKey(userInfo);
    }
    public UserInfo queryCurrentUserInfo(){
        String userId = Request.getCurrentUserId();
        UserInfo userInfoQuery = new UserInfo();
        userInfoQuery.setUserId(userId);
        List<UserInfo> list = userInfoMapper.select(userInfoQuery);
        UserInfo existUserInfo = list.get(0);
        return existUserInfo;
    }
    public void setUserInfo(UserInfo userInfo) {
        UserInfo existUserInfo = queryCurrentUserInfo();
        existUserInfo.setNickName(userInfo.getNickName());
        existUserInfo.setAvatarUrl(userInfo.getAvatarUrl());
        existUserInfo.setCountry(userInfo.getCountry());
        existUserInfo.setCity(userInfo.getCity());
        existUserInfo.setProvince(userInfo.getProvince());
        existUserInfo.setGender(userInfo.getGender());
        existUserInfo.setUpdateTime(new Date());
        userInfoMapper.updateByPrimaryKey(existUserInfo);
    }

    public String loginByCode(String code) throws JSONException {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxc65254be8b92d145&secret=8800d9da40266baa0c70f3b5de62ad9a&" +
                "js_code=" + code + "&grant_type=authorization_code";
        String res = Http.get(url);
        JSONObject jsonObject = new JSONObject(res);
        String openid = jsonObject.getString("openid");

        User user = userMapper.queryByOpenid(openid);
        Date now = new Date();
        if (user == null) {
            user = new User();
            user.setCreateTime(now);
            user.setOpenid(openid);
            userMapper.insert(user);

            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(user.getId());
            userInfo.setCreateTime(now);
            userInfo.setBirthday("2000-01");
            userInfo.setEntrance("2019");
            userInfo.setHometown("中国");
            userInfoMapper.insert(userInfo);
        }

        String token = Jwt.createJWT(user.getId());
        return token;
    }
}
