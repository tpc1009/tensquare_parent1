package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;


import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private EnterpriseDao enterpriseDao;


    public List<Enterprise> findByIshost(String isHost){
        return  enterpriseDao.findByIshot(isHost);
    }
    //查询所有
    public List<Enterprise> findAll() {
        return enterpriseDao.findAll();
    }
    //新增
    public void save(Enterprise enterprise){

        enterprise.setId(idWorker.nextId()+"");
        enterpriseDao.save(enterprise);
    }

    //根基id删除
    public void delete(String id) {

        enterpriseDao.deleteById(id);
    }
}
