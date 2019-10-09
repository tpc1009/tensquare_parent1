package com.tensquare.qa.controller;

import com.tensquare.qa.feign.LabelClient;
import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;


    @Autowired
    private LabelClient labelClient;


    @RequestMapping(value = "/label/{id}",method = RequestMethod.GET)
    public Result labelfindById(@PathVariable("id")String id){
        return this.labelClient.findById(id);
    }

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

    //根据id修改问题
    @RequestMapping(value = "/problem/{problemId}",method = RequestMethod.PUT)
    public Result updata(@PathVariable("problemId")String problemId,@RequestBody Problem problem){
        this.problemService.update(problemId,problem);
        return new Result(true,StatusCode.OK,"修改成功!");
    }

    //根据id删除
    @RequestMapping(value = "/problem/{problemId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("problemId")String problemId){
        this.problemService.delete(problemId);
        return new Result(true,StatusCode.OK,"删除成功!");
    }

    //search
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result search(@RequestBody Problem problem){

        return new Result(true,StatusCode.OK,"查询成功!",this.problemService.search(problem));
    }
    //search
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result search(@RequestBody Problem problem,@PathVariable int page,@PathVariable int size){

        Page<Problem> list = this.problemService.findSearch(problem,page,size);

        return new Result(true,StatusCode.OK,"查询成功!",new PageResult<Problem>(list.getTotalElements(),list.getContent()));
    }
}
