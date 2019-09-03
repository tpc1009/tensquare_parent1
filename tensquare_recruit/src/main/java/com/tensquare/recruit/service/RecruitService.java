package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecruitService {


    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RecruitDao recruitDao;


    //查询所有
    public List<Recruit> findAll() {
        return recruitDao.findAll();
    }

    //增加
    public void save(Recruit recruit) {
        recruit.setId(idWorker.nextId()+"");
        this.recruitDao.save(recruit);
    }

    //根据id查询
    public Recruit findById(String recruitId) {

        return this.recruitDao.findById(recruitId).get();
    }
    //修改
    public void update(Recruit recruit) {
        //对象
        Recruit rec = this.recruitDao.findById(recruit.getId()).get();
        recruit.setCreatetime(rec.getCreatetime());
        this.recruitDao.save(recruit);
    }
    //删除
    public void delete(String recruitId) {
        this.recruitDao.deleteById(recruitId);
    }
    //根据条件查询
    public List<Recruit> sqlQuery(Recruit recruit) {
        return this.recruitDao.findAll(new Specification<Recruit>() {
            @Override
            public Predicate toPredicate(Root<Recruit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                ArrayList<Predicate> list = new ArrayList<>();

                if(recruit.getJobname()!=null && !"".equals(recruit.getJobname())){
                   Predicate predicate = cb.like(root.get("jobname").as(String.class),"%"+recruit.getJobname()+"%");
                   list.add(predicate);
                }
                Predicate[] predicates = new Predicate[list.size()];
                return cb.and(predicates);
            }
        });
    }
}
