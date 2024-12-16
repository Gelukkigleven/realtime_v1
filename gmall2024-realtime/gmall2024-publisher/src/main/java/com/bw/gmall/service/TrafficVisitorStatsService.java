package com.bw.gmall.service;

import com.atguigu.gmall.bean.TrafficVisitorStatsPerHour;
import com.atguigu.gmall.bean.TrafficVisitorTypeStats;

import java.util.List;

public interface TrafficVisitorStatsService {
    // 获取分时流量数据
    List<TrafficVisitorStatsPerHour> getVisitorPerHrStats(Integer date);
    List<TrafficVisitorTypeStats> getVisitorTypeStats(Integer date);

}