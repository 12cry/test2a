package com.cry.forum.mapper;

import com.cry.forum.model.Article;
import com.cry.forum.vo.ArticleVO;
import util.MyMapper;

import java.util.List;

public interface ArticleMapper extends MyMapper<Article> {
    public List<ArticleVO> query();
    public List<Article> queryByPage(Article article);
}
