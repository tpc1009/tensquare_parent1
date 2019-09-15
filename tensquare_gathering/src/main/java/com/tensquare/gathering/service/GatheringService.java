package com.tensquare.gathering.service;

import com.tensquare.gathering.dao.GatheringDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatheringService {

    @Autowired
    private GatheringDao gatheringDao;
}
