package com.tensquare.qa.service;

import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class ProblemService {

    @Autowired
    private ProblemDao problemDao;

    @Autowired
    private IdWorker idWorker;



    public Page<Problem> newlist(String labelid,int page, int rows){
        PageRequest pageable = PageRequest.of(page - 1, rows);
        return this.problemDao.newlist(labelid, pageable);
    }

    public Page<Problem> hostlist(String labelid,int page, int rows){
        PageRequest pageable = PageRequest.of(page - 1, rows);
        return this.problemDao.hostlist(labelid, pageable);
    }


    public Page<Problem> waitlist(String labelid,int page, int rows){
        PageRequest pageable = PageRequest.of(page - 1, rows);
        return this.problemDao.waitlist(labelid, pageable);
    }

    //新增
    public void save(Problem problem) {
        problem.setId(this.idWorker.nextId()+"");
        this.problemDao.save(problem);
    }

    //查询所有
    public Object findAll() {
        return this.problemDao.findAll();
    }

    //根据id查询
    public Problem findById(String problemId) {
        return this.problemDao.findById(problemId).get();
    }
}
