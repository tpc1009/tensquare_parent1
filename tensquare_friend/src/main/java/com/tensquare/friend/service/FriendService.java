package com.tensquare.friend.service;

import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.dao.NoFriendDao;
import com.tensquare.friend.pojo.Friend;
import com.tensquare.friend.pojo.NoFriend;
import org.apache.tomcat.util.security.Escape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private NoFriendDao noFriendDao;

    //添加好友
    public int add(String userid, String friendid) {
        //1.判断userid到frindid是否有数据,如果有数据就是重复添加,返回0
        Friend friend = this.friendDao.findByUseridAndFriendid(userid,friendid);
        if(friend != null){
            return 0;
        }

        //2.添加好友,让好友列表中的userid到friendId方向的type为0
        friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        this.friendDao.save(friend);

        //3.判断friendid到userid是否有数据,如果有,把双方的状态改为1
        if(this.friendDao.findByUseridAndFriendid(friendid,userid) !=null){
            this.friendDao.upateIslike("1",userid,friendid);
            this.friendDao.upateIslike("1",friendid,userid);
        }
        return 1;
    }

    //添加非好友
    public int findNoFriend(String userid, String friendid) {
        NoFriend noFriend = this.noFriendDao.findByUseridAndFriendid(userid,friendid);
        if(noFriend !=null){
            return 0;
        }
        noFriend = new NoFriend();
        noFriend.setUserid(userid);
        noFriend.setFriendid(friendid);
        this.noFriendDao.save(noFriend);
        return 1;
    }
}
