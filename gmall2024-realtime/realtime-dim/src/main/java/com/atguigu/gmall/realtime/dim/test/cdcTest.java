package com.atguigu.gmall.realtime.dim.test;

import com.ververica.cdc.connectors.mysql.MySqlSource;
import com.ververica.cdc.debezium.JsonDebeziumDeserializationSchema;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

/**
 * 测试cdc
 */
public class cdcTest {
    public static void main(String[] args) throws Exception {

        SourceFunction<String> sourceFunction = MySqlSource.<String>builder()
                .hostname("hadoop110")
                .port(3306)
                .databaseList("gmall") // monitor all tables under inventory database
                .tableList("gmall.order_info")
                .username("root")
                .password("123456")
                .deserializer(new JsonDebeziumDeserializationSchema()) // converts SourceRecord to String
                .build();

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env
                .addSource(sourceFunction)
                .print().setParallelism(1); // use parallelism 1 for sink to keep message ordering

        env.execute();
    }
}