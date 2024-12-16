package com.bw.gmall.mapper;

import com.atguigu.gmall.bean.CategoryCommodityStats;
import com.atguigu.gmall.bean.SpuCommodityStats;
import com.atguigu.gmall.bean.TrademarkOrderAmountPieGraph;
import com.atguigu.gmall.bean.TrademarkCommodityStats;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommodityStatsMapper {
    @Select("select oct.trademark_name,\n" +
            "       order_amount,\n" +
            "       refund_count,\n" +
            "       refund_uu_count\n" +
            "from (select trademark_id,\n" +
            "             trademark_name,\n" +
            "             sum(order_amount) order_amount\n" +
            "      from dws_trade_sku_order_window\n" +
            "               partition (par#{date})\n" +
            "      group by trademark_id, trademark_name) oct full outer join\n" +
            "                 (select trademark_id,\n" +
            "                         trademark_name,\n" +
            "                         sum(refund_count)       refund_count,\n" +
            "                         count(distinct user_id) refund_uu_count\n" +
            "                  from dws_trade_trademark_category_user_refund_window\n" +
            "partition (par#{date})\n" +
            "                  group by trademark_id, trademark_name) rct\n" +
            "on oct.trademark_id = rct.trademark_id;")
    List<TrademarkCommodityStats> selectTrademarkStats(@Param("date") Integer date);

    @Select("select trademark_name,\n" +
            "       sum(order_amount) order_amount\n" +
            "from dws_trade_sku_order_window\n" +
            "         partition (par#{date})\n" +
            "group by trademark_id, trademark_name;")
    List<TrademarkOrderAmountPieGraph> selectTmOrderAmtPieGra(@Param("date")Integer date);
}