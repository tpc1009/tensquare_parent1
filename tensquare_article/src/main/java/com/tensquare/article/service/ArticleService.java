package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;


    public void thumbup(String articleId) {
        this.articleDao.addthumbup(articleId);
    }

    public void examine(String articleId) {
        this.articleDao.addstate(articleId);
    }

    public List<Article> findAll() {
        return this.findAll();
    }
}
