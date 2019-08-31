package com.cry.forum.controller;

import com.cry.forum.model.Article;
import com.cry.forum.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "query")
    public PageInfo<Article> query(Article article) {
        List<Article> list = articleService.query(article);
        return new PageInfo<Article>(list);
    }

    @RequestMapping(value = "/queryById/{id}")
    public Article queryById(@PathVariable String id) {
        return articleService.queryById(id);
    }

    @PostMapping("/save")
    public Article save(@RequestBody Article article) {
        return articleService.save(article);
    }
}
