package com.cry.forum.service;

import com.cry.forum.mapper.ArticleMapper;
import com.cry.forum.model.Article;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;


    public List<Article> query2(Article article) {
        if (article.getPage() != null && article.getRows() != null) {
            PageHelper.startPage(article.getPage(), article.getRows()).setOrderBy("create_time desc");
        }
        List<Article> list = articleMapper.select(article);
        return list;
    }

    public List<Article> query(Article article) {
        if (article.getPage() != null && article.getRows() != null) {
            PageHelper.startPage(article.getPage(), article.getRows()).setOrderBy("create_time desc");
        }
        List<Article> list = articleMapper.select(article);
        return list;
    }

    public Article queryById(String id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    public Article save(Article article) {
        Date now = new Date();
        article.setUpdateTime(now);
        article.setPublicTime(now);
        if (article.getId() != null) {
            articleMapper.updateByPrimaryKey(article);
        } else {
            article.setCreateTime(now);
            articleMapper.insert(article);
        }
        return article;
    }
}
