package com.cry.forum.controller;

import com.cry.forum.model.User;
import com.cry.forum.service.UserService;
import com.github.pagehelper.PageInfo;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public static class LoginVO {
        public LoginVO() {
        }

        public User user;
        public String code;
        public String username;
    }


    @PostMapping("/queryList")
    public PageInfo<User> queryUserList(@RequestBody User user) {
        List<User> list =  userService.queryUserList(user);
        return new PageInfo<>(list);
    }

    @PostMapping("/queryCurrentUser")
    public User queryCurrentUser(){
        return userService.queryCurrentUser();
    }
    @PostMapping("/updateUser")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }
    @PostMapping("/setUserInfo")
    public void setUser(@RequestBody User user){
        userService.setUseInfo(user);
    }
    @PostMapping("/loginByCode")
    public ModelMap loginByCode(@RequestBody Map<String,String> map) throws JSONException {
        ModelMap mm = new ModelMap();

        String code = map.get("code");
        String token = userService.loginByCode(code);
        mm.addAttribute("token", token);
        return mm;
    }

    @PostMapping("/login2")
    public ModelMap login2(@RequestBody LoginVO vo) throws JSONException {
        ModelMap mm = new ModelMap();
        if ("yy".equals(vo.username)) {
            mm.addAttribute("token", "aaaaaaaaaaaaaaaaaaaaaaaaa");
            mm.addAttribute("code", 20000);
        }
        return mm;
    }

    @RequestMapping("/info")
    public ModelMap getUser() {
        ModelMap mm = new ModelMap();
        mm.addAttribute("code", 20000);
        Map<String, List<String>> data = new HashMap<>();
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        data.put("roles",roles);
        mm.addAttribute("data", data);
        return mm;
    }
}
