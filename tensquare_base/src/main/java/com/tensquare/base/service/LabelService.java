package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

    /**
     * 根据条件 查询
     * @param label
     * @return
     */
    public List<Label> search(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //封装集合
                ArrayList<Predicate> list = new ArrayList<>();
                if (label.getLabelname() !=null && "".equals(label.getLabelname())){
                    Predicate predicate = cb.like(root.get("labelname").as(String.class),"%"+label.getLabelname()+"%");//like语句
                    list.add(predicate);
                }
                if (label.getLabelname() !=null && "".equals(label.getLabelname())){
                    Predicate predicate = cb.equal(root.get("state").as(String.class),label.getState());//=赋值语句
                    list.add(predicate);
                }
                //创建需要返回的数组结果集
                Predicate[] predicates = new Predicate[list.size()];
                //list集合转为数组
                list.toArray(predicates);

                return cb.and(predicates);
            }
        });
      //  return null;
    }

}
