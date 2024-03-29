package com.cry.forum.service;

import com.cry.forum.common.FileProperties;
import com.cry.forum.mapper.ArticleMapper;
import com.cry.forum.model.Article;
import com.cry.forum.vo.ArticleVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.FileUtil;

import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    private FileProperties fileProperties;

    public List<Article> queryByPage(Article article) {
        if (article.getPage() != null && article.getRows() != null) {
            PageHelper.startPage(article.getPage(), article.getRows()).setOrderBy("public_time desc");
        }
        List<Article> list = articleMapper.queryByPage(article);
        return list;
    }

    public List<ArticleVO> query(Article article) {
        if (article.getPage() != null && article.getRows() != null) {
            PageHelper.startPage(article.getPage(), article.getRows()).setOrderBy("public_time desc");
        }
        List<ArticleVO> list = articleMapper.query();
        return list;
    }

    public Article queryById(String id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    public void updateState(String id,String state){
        Article article = new Article();
        article.setId(id);
        article.setState(state);
        article.setUpdateTime(new Date());
        articleMapper.updateByPrimaryKeySelective(article);
    }
    public Article save(Article article) {
        if ("02".equals(article.getState()) || "01".equals(article.getState())) {
            FileUtil.replaceImgTag(article, fileProperties.getUploadPath(), fileProperties.getDownloadPath());
        }
        Date now = new Date();
        article.setUpdateTime(now);
//        article.setPublicTime(now);
        if (article.getId() != null) {
            articleMapper.updateByPrimaryKey(article);
        } else {
            article.setCreateTime(now);
            articleMapper.insert(article);
        }
        return article;
    }
}
