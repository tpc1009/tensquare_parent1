package com.tensquare.article.controller;

import com.tensquare.article.pojo.Article;
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


    //增加
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Article article){

        this.articleService.save(article);
        return new Result(true,StatusCode.OK,"新增成功!");

    }
    //获取
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功!",this.articleService.findA());
    }



    //根据id查询
    @RequestMapping(value = "/{articleId}",method = RequestMethod.GET)
    public Result findById(@PathVariable String articleId){
        return new Result(true,StatusCode.OK,"查询成功!",this.articleService.findById(articleId));
    }


    //根基id修改
    @RequestMapping(value = "/{articleId}",method = RequestMethod.PUT)
    public Result updataById(@RequestBody Article article){
        this.articleService.updataById(article);
        return new Result(true,StatusCode.OK,"修改成功!");
    }


}
