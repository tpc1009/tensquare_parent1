package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleSearchService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {


    @Autowired
    private ArticleSearchService articleSearchService;


    //新增
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article){
        this.articleSearchService.save(article);
        return new Result(true, StatusCode.OK,"查询成功!");
    }


    //查询

    @RequestMapping(value = "/{keywords}/{page}/{size}",method = RequestMethod.GET)
    public Result findSearch(@PathVariable String keywords,@PathVariable int page,@PathVariable int size){
        Page<Article> pageResult = this.articleSearchService.findSearch(keywords,page,size);
        return new Result(true,StatusCode.OK,"查询成功!",new PageResult<Article>(pageResult.getTotalElements(),pageResult.getContent()));
    }


}
