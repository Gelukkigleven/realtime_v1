package com.bw.gmall.service.impl;

import com.atguigu.gmall.bean.TrafficUvCt;
import com.atguigu.gmall.bean.TrafficVisitorTypeStats;
import com.atguigu.gmall.mapper.TrafficStatsMapper;
import com.atguigu.gmall.service.TrafficStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Felix
 * @date 2024/6/14
 * 流量域统计service接口实现类
 */

@Service
public class TrafficStatsServiceImpl implements TrafficStatsService {
    @Autowired
    private TrafficStatsMapper trafficStatsMapper;

    @Override
    public List<TrafficUvCt> getChUvCt(Integer date, Integer limit) {
        return trafficStatsMapper.selectChUvCt(date,limit);
    }

//    @Override
//    public List<TrafficVisitorTypeStats> getVisitorTypeStats(Integer date) {
//        return trafficVisitorStatsMapper.selectVisitorTypeStats(date);
//    }
}
