package com.bw.gmall.service.impl;

import com.atguigu.gmall.bean.ActivityReduceStats;
import com.atguigu.gmall.mapper.ActivityStatsMapper;
import com.atguigu.gmall.service.ActivityReduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityReduceServiceImpl implements ActivityReduceService {

    @Autowired
    private ActivityStatsMapper activityStatsMapper;

    @Override
    public List<ActivityReduceStats> getActivityStats(Integer date) {
        return activityStatsMapper.selectActivityStats(date);
    }
}