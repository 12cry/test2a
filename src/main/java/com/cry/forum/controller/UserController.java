package com.cry.forum.controller;

import com.cry.forum.model.User;
import com.cry.forum.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    }

    @PostMapping("/login")
    public ModelMap login(@RequestBody LoginVO vo) throws JSONException {
        ModelMap mm = new ModelMap();

        String token = userService.login(vo);
        mm.addAttribute("token", token);
        return mm;


    }

}
