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
    UserInfoMapper userInfoMapper;

    public List<UserInfo> queryUserInfoList(UserInfo userInfo){
        if (userInfo.getPage() != null && userInfo.getRows() != null) {
            PageHelper.startPage(userInfo.getPage(), userInfo.getRows()).setOrderBy("create_time desc");
        }
        String value = userInfo.getName();
        if(StringUtils.isEmpty(value)){
            return userInfoMapper.selectAll();
        }
        value = "%"+value+"%";
        List<UserInfo> list = userInfoMapper.queryUserInfoList(value);
        return list;
    }
    public UserInfo queryUserInfo(){
        String userId = Request.getCurrentUserId();
        UserInfo userInfo = new UserInfo();
        List<UserInfo> list = userInfoMapper.select(userInfo);
        return list.isEmpty()?new UserInfo():list.get(0);
    }
    public void updateUserInfo(UserInfo userInfo){
        userInfo.setUpdateTime(new Date());
        userInfoMapper.updateByPrimaryKey(userInfo);
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
            userMapper.insert(user);

            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(user.getId());
            userInfo.setCreateTime(now);
            userInfo.setBirthday("2000-01");
            userInfo.setEntrance("2019");
            userInfo.setHometown("中国");
            userInfoMapper.insert(userInfo);
        } else {
            user.setUpdateTime(now);
        }

        String token = Jwt.createJWT(user.getId());
        return token;
    }
}
