package com.cry.forum.controller;

import com.cry.forum.model.Article;
import com.cry.forum.service.ArticleService;
import com.cry.forum.vo.ArticleVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "query2")
    public PageInfo<Article> query2(@RequestBody Article article) {
        List<Article> list = articleService.query2(article);
        return new PageInfo<Article>(list);
    }

    @RequestMapping(value = "query")
    public PageInfo<ArticleVO> query(@RequestBody Article article) {
        List<ArticleVO> list = articleService.query(article);
        return new PageInfo<ArticleVO>(list);
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
