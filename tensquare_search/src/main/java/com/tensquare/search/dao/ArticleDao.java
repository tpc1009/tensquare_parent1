package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;



public interface ArticleDao extends ElasticsearchRepository<Article,String> {


  // public Page<Article> fin(String key, String key1, PageRequest request);
    //public Page<Article> findByTitleOrContentLike(String title,String content, Pageable pageable);

    public Page<Article> findArticleByTitleOrContentLike(String title,String content, Pageable pageable);

}
