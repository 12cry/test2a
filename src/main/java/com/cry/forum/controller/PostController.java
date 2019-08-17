package com.cry.forum.controller;

import com.cry.forum.model.Post;
import com.cry.forum.service.PostService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;


    @RequestMapping(value = "query")
    public PageInfo<Post> query(Post post) {
        List<Post> list = postService.query(post);
        return new PageInfo<Post>(list);
    }

    @PostMapping("/save")
    public ModelMap save(@RequestBody Post post) {
        ModelMap result = new ModelMap();
        String msg = post.getId() == null ? "新增成功!" : "更新成功!";
        postService.save(post);
        result.put("post", post);
        result.put("msg", msg);
        return result;
    }
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ModelMap save(@RequestBody Post post) {
//        ModelMap result = new ModelMap();
//        String msg = post.getId() == null ? "新增成功!" : "更新成功!";
//        postService.save(post);
//        result.put("post", post);
//        result.put("msg", msg);
//        return result;
//    }
}
