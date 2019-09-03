package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Recruit;
import com.tensquare.recruit.service.RecruitService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;


    /**
     * 查询全部
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功!",recruitService.findAll());
    }

    /**
     * 增加
     * @param recruit
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Recruit recruit){
        this.recruitService.save(recruit);
        return new Result(true, StatusCode.OK,"查询成功!");
    }

    /**
     * 根据id查询
     * @param recruitId
     * @return
     */
    @RequestMapping(value = "/{recruitId}",method = RequestMethod.GET)
    public Result finddById(@PathVariable("recruitId")String recruitId){
        Recruit rec = this.recruitService.findById(recruitId);
        return new Result(true, StatusCode.OK,"查询成功!",rec);
    }

    /**
     * 根据id修改
     * @param recruitId
     * @return
     */
    @RequestMapping(value = "/{recruitId}",method = RequestMethod.PUT)
    public Result udpate(@PathVariable("recruitId")String recruitId,@RequestBody Recruit recruit){
        recruit.setId(recruitId);
        this.recruitService.update(recruit);

        return new Result(true, StatusCode.OK,"修改成功!");
    }

    /**
     * 根据id删除
     * @param recruitId
     * @return
     */
    @RequestMapping(value = "/{recruitId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("recruitId")String recruitId){
       this.recruitService.delete(recruitId);

        return new Result(true, StatusCode.OK,"删除成功!");
    }
    /**
     *
     * 根据条件查询招聘列表
     * @param recruit
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result search(@RequestBody Recruit  recruit){
        List<Recruit> list = this.recruitService.sqlQuery(recruit);
        return new Result(true, StatusCode.OK,"查询成功!",list);
    }
    /**
     *
     *
     * 招聘分页
     * @param recruit
     * @return
     */
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result searchQuery(@RequestBody Recruit  recruit,@PathVariable int page,@PathVariable int size){

        return new Result(true, StatusCode.OK,"查询成功!",this.recruitService.sqlSearchQuery(recruit,page,size));
    }


}
