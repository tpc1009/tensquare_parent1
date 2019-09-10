package com.tensquare.qa.controller;

import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    //最新查询
    @RequestMapping(value = "/newlist/{labelid}/{page}/{size}",method = RequestMethod.GET)
    public Result newlist(@PathVariable String labelid,@PathVariable int page,@PathVariable int size){
        Page<Problem> pageDate = this.problemService.newlist(labelid, page, size);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Problem>(pageDate.getTotalElements(),pageDate.getContent()));
    }

    //热门查询
    @RequestMapping(value = "/hotlist/{labelid}/{page}/{size}",method = RequestMethod.GET)
    public Result hostlist(@PathVariable String labelid,@PathVariable int page,@PathVariable int size){
        Page<Problem> pageDate = this.problemService.hostlist(labelid, page, size);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Problem>(pageDate.getTotalElements(),pageDate.getContent()));
    }

    //未回答
    @RequestMapping(value = "/waitlist/{labelid}/{page}/{size}",method = RequestMethod.GET)
    public Result waitlist(@PathVariable String labelid,@PathVariable int page,@PathVariable int size){
        Page<Problem> pageDate = this.problemService.waitlist(labelid, page, size);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Problem>(pageDate.getTotalElements(),pageDate.getContent()));
    }

    //增加
    @RequestMapping(value = "/problem",method = RequestMethod.POST)
    public Result save(@RequestBody Problem problem){
        this.problemService.save(problem);
        return new Result(true,StatusCode.OK,"新增成功!");
    }

    //查询
    @RequestMapping(value = "/problem",method = RequestMethod.GET)
    public Result findAll(){
       return new Result(true,StatusCode.OK,"查询成功!",this.problemService.findAll());
    }

    //根据id查询
    @RequestMapping(value = "/problem/{problemId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("problemId")String problemId){
        return new Result(true,StatusCode.OK,"查询成功!",this.problemService.findById(problemId));
    }
}
