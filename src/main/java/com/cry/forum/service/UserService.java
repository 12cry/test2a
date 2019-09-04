package com.cry.forum.service;

import com.cry.forum.controller.UserController;
import com.cry.forum.mapper.UserMapper;
import com.cry.forum.model.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import util.Http;
import util.Jwt;
import util.Request;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void setUseInfo(User user){
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
//        User user = vo.user;
//        String code = vo.code;
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxc65254be8b92d145&secret=8800d9da40266baa0c70f3b5de62ad9a&" +
                "js_code=" + code + "&grant_type=authorization_code";
        String res = Http.get(url);
        JSONObject jsonObject = new JSONObject(res);
        String openid = jsonObject.getString("openid");

        User user = userMapper.queryByOpenid(openid);
        Date now = new Date();
//        if (existUser != null) {
//            if (user != null) {
//                existUser.setUpdateTime(now);
//                if (!StringUtils.isEmpty(user.getAvatarUrl())) {
//                    existUser.setAvatarUrl(user.getAvatarUrl());
//                }
//                if (!StringUtils.isEmpty(user.getNickName())) {
//                    existUser.setNickName(user.getNickName());
//                }
//                userMapper.updateByPrimaryKey(existUser);
//            }
//        } else {
        if (user == null) {
            user = new User();
            user.setCreateTime(now);
            user.setOpenid(openid);
            userMapper.insert(user);
        } else {
            user.setUpdateTime(now);
        }
//        }

        String token = Jwt.createJWT(user.getId());
        return token;
    }
}
