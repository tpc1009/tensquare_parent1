package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;
import java.util.List;

@Service
public class SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    //保存
    public void save(Spit spit) {
        spit.set_id(idWorker.nextId()+"");
        spit.setPublishtime(new Date());//发布日期
        spit.setVisits(0);//浏览量
        spit.setShare(0);//分享数
        spit.setThumbup(0);//点赞数
        spit.setComment(0);//回复数
        spit.setState("1");//状态
        //如果父节点有值,则父节点加1
        if(spit.getParentid() != null && !"".equals(spit.getParentid())){
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment",1);
            this.mongoTemplate.updateFirst(query,update,"spit");
        }

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

    //根据父节点id查询
    public Page<Spit> findByParentId(String parentid,int page,int size){

        PageRequest pageable = PageRequest.of(page-1, size);
        return this.spitDao.findByParentid(parentid, pageable);
    }

    //点赞(使用模板)
    public void thumbup(String spitId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(spitId));
        Update update = new Update();
        update.inc("thumbup",1);
        this.mongoTemplate.updateFirst(query,update,"spit");
    }

    //点赞原始方法
    /*public void thumbup(String spitId) {
        Spit spit = this.spitDao.findById(spitId).get();
        spit.setThumbup((spit.getThumbup()==null ? 0:spit.getThumbup())+1);
        this.spitDao.save(spit);
    }*/
}
