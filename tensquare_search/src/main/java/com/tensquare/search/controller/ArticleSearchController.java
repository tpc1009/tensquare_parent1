package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/atricle")
public class ArticleSearchController {

    @Autowired
    private ArticleService articleService;

    //保存
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article){
        this.articleService.save(article);
        return new Result(true, StatusCode.OK,"添加成功!");
    }

    //查询
    @RequestMapping(value = "/{key}/{page}/{size}",method = RequestMethod.GET)
    public Result search(@PathVariable String key,@PathVariable int page,Integer size){
        Page<Article> pageResult = this.articleService.search(key,page,size);
        return new Result(true, StatusCode.OK,"添加成功!",new PageResult<Article>(pageResult.getTotalElements(),pageResult.getContent()));
    }
}
