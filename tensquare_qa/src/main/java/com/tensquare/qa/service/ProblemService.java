package com.tensquare.qa.service;

import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void update(String problemId, Problem problem) {
        problem.setId(problemId);
        this.problemDao.save(problem);

    }

    public void delete(String problemId) {
        this.problemDao.deleteById(problemId);
    }

    public List<Problem> search(Problem problem) {
        return this.problemDao.findAll(new Specification<Problem>() {
            @Override
            public Predicate toPredicate(Root<Problem> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                ArrayList<Predicate> list = new ArrayList<>();
                if(problem.getTitle() !=null && "".equals(problem.getTitle())){
                    Predicate predicate = cb.like(root.get("title").as(String.class),"%"+problem.getTitle()+"%");
                    list.add(predicate);
                }

                Predicate[] pr = new Predicate[list.size()];
                list.toArray(pr);
                return cb.and(pr);
            }
        });
    }
    //分页查询
    public Page<Problem> findSearch(Problem problem, int page, int size) {

        PageRequest request = PageRequest.of(page - 1, size);

        return this.problemDao.findAll(new Specification<Problem>() {
            @Override
            public Predicate toPredicate(Root<Problem> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                ArrayList<Predicate> list = new ArrayList<>();
                if(problem.getTitle() !=null && "".equals(problem.getTitle())){
                    Predicate predicate = cb.like(root.get("title").as(String.class),"%"+problem.getTitle()+"%");
                    list.add(predicate);
                }

                Predicate[] pr = new Predicate[list.size()];
                list.toArray(pr);
                return cb.and(pr);
            }
        },request);
    }
}
