package com.tensquare.base.controller;


import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin  //处理跨域问题
@RequestMapping("/label")
public class LabelController {


    @Autowired
    private LabelService labelService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功!",labelService.findAll());
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id")String id){
        return new Result(true,StatusCode.OK,"success",labelService.findById(id));
    }

    /**
     * 修改标签
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result updata(@PathVariable("id")String id){
        return new Result(true,StatusCode.OK,"success");
    }

    /**
     * 删除标签
     */

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("id")String id){

        return new Result(true,StatusCode.OK,"success");
    }


    /**
     * 搜索
     */

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result search(@RequestBody Label label){
        List<Label> list = labelService.search(label);
        return new Result(true,StatusCode.OK,"查询成功!",list);
    }

    /**
     * 分页搜索
     */
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)//url
    public Result pageQuery(@RequestBody Label label,@PathVariable("page")int page,@PathVariable("size")int size){
        Page<Label> pagelist = labelService.pageQuery(label,page,size);
        return new Result(true,StatusCode.OK,"查询成功!",new PageResult<>(pagelist.getTotalElements(),pagelist.getContent()));
    }

}
