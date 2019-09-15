package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private RedisTemplate redisTemplate;


    public void thumbup(String articleId) {
        this.articleDao.addthumbup(articleId);
    }

    public void examine(String articleId) {
        this.articleDao.addstate(articleId);
    }

    //新增
    public void save(Article article) {
        this.articleDao.save(article);
    }

    //查询所有
    public List<Article> findA() {
        return this.articleDao.findAll();
    }

    //根据id查询
    public Article findById(String articleId) {
        //首先从缓存中查找
        Article article = (Article) this.redisTemplate.opsForValue().get("article_" + articleId);

        //如果没有从数据查询,并放入缓存中
        if (article == null){
           article =  this.articleDao.findById(articleId).get();
           //设置过期时间
           this.redisTemplate.opsForValue().set("article_" + articleId,article,10, TimeUnit.MINUTES);
        }

        return article;
    }

    //修改
    public void updataById(Article article) {
        this.articleDao.save(article);
        this.redisTemplate.delete("article_"+article.getId());
    }

}
