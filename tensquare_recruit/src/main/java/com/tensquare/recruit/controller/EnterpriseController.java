package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService  enterpriseService;


    /**
     * 展示全部企业
     * @return
     */

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功!",enterpriseService.findAll());
    }

    //根据热门查询
    @RequestMapping(value = "/search/hotlist",method = RequestMethod.GET)
    public Result findByIsHost(){

        List<Enterprise> list = enterpriseService.findByIshost("1");

        return new Result(true,StatusCode.OK,"查询成功!",list );
    }

    /**
     *新增
     * @param enterprise
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Enterprise enterprise){
        this.enterpriseService.save(enterprise);
        return new Result(true,StatusCode.OK,"新增成功!");
    }

    /**
     *根据id删除
     * @param enterpriseId
     * @return
     */
    @RequestMapping(value = "/{enterpriseId}",method = RequestMethod.DELETE)
    public Result  delete(@PathVariable("enterpriseId")String enterpriseId){
        this.enterpriseService.delete(enterpriseId);
        return new Result(true,StatusCode.OK,"删除成功!");
    }
}
