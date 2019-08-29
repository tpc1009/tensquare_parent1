package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    /**
     * 查询全部
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }
    /**
     * 根据id查询
     */

    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    /**
     * 修改标签
     */
    public void upateById(Label id){
        labelDao.save(id);
    }
    /**
     * 删除标签
     */

    public void delete(Label id){
        labelDao.delete(id);
    }
}
