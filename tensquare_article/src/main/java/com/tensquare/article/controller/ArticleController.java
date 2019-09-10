package com.tensquare.article.controller;

import com.tensquare.article.service.ArticleService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    //点赞
    @RequestMapping(value = "/thumbup/{articleId}",method = RequestMethod.PUT)
    public Result thumbup(@PathVariable String articleId){
        this.articleService.thumbup(articleId);
        return new Result(true, StatusCode.OK,"点赞成功!");
    }

    //文章审核
    @RequestMapping(value = "/examine/{articleId}",method = RequestMethod.PUT)
    public Result examine(@PathVariable String articleId){
        this.articleService.examine(articleId);
        return new Result(true, StatusCode.OK,"审核成功!");
    }

    //查询
    @RequestMapping(value = "/article",method = RequestMethod.GET)
    public Result findAll(){

        return new Result(true, StatusCode.OK,"查询成功!",this.articleService.findAll());
    }
}
