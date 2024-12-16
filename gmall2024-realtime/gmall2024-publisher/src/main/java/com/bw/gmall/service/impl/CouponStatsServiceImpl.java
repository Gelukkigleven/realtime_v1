package com.bw.gmall.service.impl;

import com.atguigu.gmall.bean.CouponReduceStats;
import com.atguigu.gmall.mapper.CouponStatsMapper;
import com.atguigu.gmall.service.CouponStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponStatsServiceImpl implements CouponStatsService {

    @Autowired
    private CouponStatsMapper couponStatsMapper;

    @Override
    public List<CouponReduceStats> getCouponStats(Integer date) {
        return couponStatsMapper.selectCouponStats(date);
    }
}