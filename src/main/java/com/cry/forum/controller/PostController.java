package com.cry.forum.controller;

import com.cry.forum.model.Post;
import com.cry.forum.service.PostService;
import com.cry.forum.vo.PostVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "appreciate")
    public void appreciate(@RequestBody Map<String,String> map){
        int a;
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
