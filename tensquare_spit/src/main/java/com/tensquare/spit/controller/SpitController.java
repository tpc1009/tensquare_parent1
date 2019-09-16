package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
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
        return new Result(true,StatusCode.OK,"查询成功!");
    }

    //根据id删除
    @RequestMapping(value = "/{spitId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String spitId){
        this.spitService.delete(spitId);
        return new Result(true,StatusCode.OK,"删除成功!");
    }

}
