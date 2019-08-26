package com.cry.forum.controller;

import com.cry.forum.model.Post;
import com.cry.forum.model.UserPost;
import com.cry.forum.service.PostService;
import com.cry.forum.vo.PostVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.Request;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "appreciate")
    public void appreciate(@RequestBody UserPost userPost){
        postService.updateUserPost(userPost);
    }

    @RequestMapping(value = "query")
    public PageInfo<PostVO> query(@RequestBody Post post) {
        List<PostVO> list = postService.query(post);
        return new PageInfo<PostVO>(list);
    }

    @PostMapping("/save")
    public PostVO save(@RequestBody Post post) {
        PostVO postVO = postService.save(post);
        return postVO;
    }
}
