package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    //保存
    public void save(Spit spit) {
        spit.set_id(idWorker.nextId()+"");
        this.spitDao.save(spit);
    }

    //findall
    public List<Spit> findAll() {
        return this.spitDao.findAll();
    }

    //根据id查询
    public Spit findById(String spitId) {
        return this.spitDao.findById(spitId).get();
    }

    //根据id修改
    public void updateByID(String spitId, Spit spit) {
        spit.set_id(spitId);
        this.spitDao.save(spit);
    }

    //根据id删除
    public void delete(String spitId) {
        this.spitDao.deleteById(spitId);
    }
}
