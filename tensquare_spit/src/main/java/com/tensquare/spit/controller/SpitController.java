package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;


    //add
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Spit spit){
        this.spitService.save(spit);
        return new Result(true, StatusCode.OK,"保存成功!");
    }

    //findall
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功!",this.spitService.findAll());
    }


    //根据id查询
    @RequestMapping(value = "/{spitId}",method = RequestMethod.GET)
    public Result findById(@PathVariable String spitId){
        return new Result(true,StatusCode.OK,"查询成功!",this.spitService.findById(spitId));
    }
    //根据id修改
    @RequestMapping(value = "/{spitId}",method = RequestMethod.PUT)
    public Result udpataById(@PathVariable String spitId,@RequestBody Spit spit){
        this.spitService.updateByID(spitId,spit);
        return new Result(true,StatusCode.OK,"修改成功!");
    }

    //根据id删除
    @RequestMapping(value = "/{spitId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String spitId){
        this.spitService.delete(spitId);
        return new Result(true,StatusCode.OK,"删除成功!");
    }

    //根据父节点id查询
    @RequestMapping(value = "/comment/{parentid}/{page}/{size}",method = RequestMethod.GET)
    public Result findByParent(@PathVariable String parentid,@PathVariable int page,@PathVariable int size){
        Page<Spit> pageList = this.spitService.findByParentId(parentid,page,size);
        return new Result(true,StatusCode.OK,"查询成功", new PageResult<Spit>(pageList.getTotalElements(),pageList.getContent()));
    }

    //根据id点赞
    @RequestMapping(value = "/thumbup/{spitId}",method = RequestMethod.PUT)
    public Result thumbup(@PathVariable String spitId){
        this.spitService.thumbup(spitId);
        return new Result(true,StatusCode.OK,"点赞成功!");
    }

}
