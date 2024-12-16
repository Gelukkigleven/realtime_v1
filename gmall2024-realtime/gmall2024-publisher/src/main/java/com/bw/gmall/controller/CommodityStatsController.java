package com.bw.gmall.controller;

import com.atguigu.gmall.bean.CategoryCommodityStats;
import com.atguigu.gmall.bean.SpuCommodityStats;
import com.atguigu.gmall.bean.TrademarkCommodityStats;
import com.atguigu.gmall.bean.TrademarkOrderAmountPieGraph;
import com.atguigu.gmall.service.CommodityStatsService;
import com.atguigu.gmall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gmall/realtime/commodity")
public class CommodityStatsController {

    @Autowired
    private CommodityStatsService commodityStatsService;

    @RequestMapping("/trademark")
    public String getTrademarkCommodityStats(
            @RequestParam(value = "date", defaultValue = "1") Integer date) {
        if (date == 1) {
            date = DateUtil.now();
        }
        List<TrademarkCommodityStats> trademarkCommodityStatsList = commodityStatsService.getTrademarkCommodityStatsService(date);
        if (trademarkCommodityStatsList == null) {
            return "";
        }
        StringBuilder rows = new StringBuilder("[");
        for (int i = 0; i < trademarkCommodityStatsList.size(); i++) {
            TrademarkCommodityStats trademarkCommodityStats = trademarkCommodityStatsList.get(i);
            String trademarkName = trademarkCommodityStats.getTrademarkName();
            Double orderAmount = trademarkCommodityStats.getOrderAmount();
            Integer refundCt = trademarkCommodityStats.getRefundCt();
            Integer refundUuCt = trademarkCommodityStats.getRefundUuCt();

            rows.append("{\n" +
                    "\t\"trademark\": \"" + trademarkName + "\",\n" +
                    "\t\"order_amount\": \"" + orderAmount + "\",\n" +
                    "\t\"refund_count\": \"" + refundCt + "\",\n" +
                    "\t\"refund_uu_count\": \"" + refundUuCt + "\"\n" +
                    "}");
            if (i < trademarkCommodityStatsList.size() - 1) {
                rows.append(",");
            } else {
                rows.append("]");
            }
        }
        return "{\n" +
                "  \"status\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"data\": {\n" +
                "    \"columns\": [\n" +
                "      {\n" +
                "        \"name\": \"品牌名称\",\n" +
                "        \"id\": \"trademark\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"订单金额\",\n" +
                "        \"id\": \"order_amount\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"退单数\",\n" +
                "        \"id\": \"refund_count\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"退单人数\",\n" +
                "        \"id\": \"refund_uu_count\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"rows\": " + rows + "\n" +
                "  }\n" +
                "}";
    }

    @RequestMapping("/tmPieGraph")
    public String getTmOrderAmtPieGra(
            @RequestParam(value = "date", defaultValue = "1") Integer date) {
        if(date == 1) {
            date = DateUtil.now();
        }
        List<TrademarkOrderAmountPieGraph> tmOrderAmtPieGraList = commodityStatsService.getTmOrderAmtPieGra(date);
        if(tmOrderAmtPieGraList == null || tmOrderAmtPieGraList.size() == 0) {
            return "";
        }
        StringBuilder dataSet = new StringBuilder("[");
        for (int i = 0; i < tmOrderAmtPieGraList.size(); i++) {
            TrademarkOrderAmountPieGraph trademarkOrderAmountPieGraph = tmOrderAmtPieGraList.get(i);
            String trademarkName = trademarkOrderAmountPieGraph.getTrademarkName();
            Double orderAmount = trademarkOrderAmountPieGraph.getOrderAmount();
            dataSet.append("{\n" +
                    "      \"name\": \""+ trademarkName +"\",\n" +
                    "      \"value\": "+ orderAmount +"\n" +
                    "    }");
            if(i < tmOrderAmtPieGraList.size() - 1) {
                dataSet.append(",");
            } else {
                dataSet.append("]");
            }
        }

        return "{\n" +
                "  \"status\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"data\": "+ dataSet +"\n" +
                "}";
    }
}