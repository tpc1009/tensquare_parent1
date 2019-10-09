package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FriendDao extends JpaRepository<Friend,String>, JpaSpecificationExecutor<Friend> {


    public Friend findByUseridAndFriendid(String userid,String friendid);


    @Modifying
    @Query(value = "UPDATE tb_friend SET islike = ? WHERE userid = ? AND friendid =?",nativeQuery = true)
    public void upateIslike(String islike,String userid,String friendid);
}
