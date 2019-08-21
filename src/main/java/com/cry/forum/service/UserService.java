package com.cry.forum.service;

import com.cry.forum.controller.UserController;
import com.cry.forum.mapper.UserMapper;
import com.cry.forum.model.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.Http;
import util.Jwt;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String login(UserController.LoginVO vo) throws JSONException {
        User user = vo.user;
        String code = vo.code;
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxc65254be8b92d145&secret=8800d9da40266baa0c70f3b5de62ad9a&" +
                "js_code=" + code + "&grant_type=authorization_code";
        String res = Http.get(url);
        JSONObject jsonObject = new JSONObject(res);
        String openid = jsonObject.getString("openid");
        User existUser= userMapper.selectByPrimaryKey(openid);
        Date now = new Date();
        if (existUser != null) {
            existUser.setUpdateTime(now);
            existUser.setAvatarUrl(user.getAvatarUrl());
            existUser.setNickName(user.getNickName());
            userMapper.updateByPrimaryKey(existUser);
        } else {
            user.setId(openid);
            user.setCreateTime(now);
            userMapper.insert(user);
        }

        String token = Jwt.createJWT(openid);
        return token;
    }
}
