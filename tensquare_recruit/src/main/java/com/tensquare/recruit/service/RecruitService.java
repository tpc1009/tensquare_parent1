package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Recruit;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class RecruitService {


    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RecruitDao recruitDao;


    public List<Recruit> findAll() {
        return recruitDao.findAll();
    }
}
