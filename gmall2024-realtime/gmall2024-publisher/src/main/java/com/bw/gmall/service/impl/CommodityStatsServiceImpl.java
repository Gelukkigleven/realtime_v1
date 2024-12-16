package com.bw.gmall.service.impl;

import com.atguigu.gmall.bean.CategoryCommodityStats;
import com.atguigu.gmall.bean.SpuCommodityStats;
import com.atguigu.gmall.bean.TrademarkCommodityStats;
import com.atguigu.gmall.bean.TrademarkOrderAmountPieGraph;
import com.atguigu.gmall.mapper.CommodityStatsMapper;
import com.atguigu.gmall.service.CommodityStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityStatsServiceImpl implements CommodityStatsService {

    @Autowired
    private CommodityStatsMapper commodityStatsMapper;

    @Override
    public List<TrademarkCommodityStats> getTrademarkCommodityStatsService(Integer date) {
        return commodityStatsMapper.selectTrademarkStats(date);
    }

    @Override
    public List<TrademarkOrderAmountPieGraph> getTmOrderAmtPieGra(Integer date) {
        return commodityStatsMapper.selectTmOrderAmtPieGra(date);
    }
}