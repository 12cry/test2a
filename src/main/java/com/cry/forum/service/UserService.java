package com.cry.forum.service;

import com.cry.forum.mapper.UserMapper;
import com.cry.forum.model.User;
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

    public List<User> queryUserList(User user){
        if (user.getPage() != null && user.getRows() != null) {
            PageHelper.startPage(user.getPage(), user.getRows()).setOrderBy("create_time desc");
        }
        String value = user.getName();
        if(StringUtils.isEmpty(value)){
            return userMapper.queryListDefault();
        }
        value = "%"+value+"%";
        List<User> list = userMapper.queryList(value);
        return list;
    }
    public User queryCurrentUser(){
        String userId = Request.getCurrentUserId();
        User user = new User();
        List<User> list = userMapper.select(user);
        return list.isEmpty()?new User():list.get(0);
    }
    public void updateUser(User user){
        user.setUpdateTime(new Date());
        userMapper.updateByPrimaryKey(user);
    }
    public void setUseInfo(User user) {
        String userId = Request.getCurrentUserId();
        User existUser = userMapper.selectByPrimaryKey(userId);
        existUser.setNickName(user.getNickName());
        existUser.setAvatarUrl(user.getAvatarUrl());
        existUser.setCountry(user.getCountry());
        existUser.setCity(user.getCity());
        existUser.setProvince(user.getProvince());
        existUser.setGender(user.getGender());
        existUser.setUpdateTime(new Date());
        userMapper.updateByPrimaryKey(existUser);
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

            user.setBirthday("2000-01");
            user.setEntrance("2019");
            user.setHometown("中国");
            userMapper.insert(user);
        } else {
            user.setUpdateTime(now);
        }

        String token = Jwt.createJWT(user.getId());
        return token;
    }
}
