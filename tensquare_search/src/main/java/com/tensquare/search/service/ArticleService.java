package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    //保存
    public void save(Article article){
        this.articleDao.save(article);
    }

    //查询
    public Page<Article> search(String key, int page, Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);
        return this.articleDao.findArticleByTitleOrContentLike(key,key,request);

    }
}
