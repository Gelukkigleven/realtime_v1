package com.bw.gmall.service;

import com.atguigu.gmall.bean.CategoryCommodityStats;
import com.atguigu.gmall.bean.SpuCommodityStats;
import com.atguigu.gmall.bean.TrademarkCommodityStats;
import com.atguigu.gmall.bean.TrademarkOrderAmountPieGraph;

import java.util.List;

public interface CommodityStatsService {
    List<TrademarkCommodityStats> getTrademarkCommodityStatsService(Integer date);

    List<TrademarkOrderAmountPieGraph> getTmOrderAmtPieGra(Integer date);
}