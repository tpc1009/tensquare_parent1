package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {

    public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);//根据创建时间查询状态为最新的前6个


    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);//根据创建时间查询最新的6个
}
