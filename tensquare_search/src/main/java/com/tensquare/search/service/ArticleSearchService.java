package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ArticleSearchService {

    @Autowired
    private ArticleSearchDao articleSearchDao;


    public void save(Article article) {
        this.save(article);
    }

    public Page<Article> findSearch(String keywords, int page, int size) {
        PageRequest source = PageRequest.of(page, size);
        return this.articleSearchDao.findByTitleOrContentLike(keywords,keywords,source);
    }
}
