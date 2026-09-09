package com.northwind.inventoryadjust.dao;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ShipmentGateway {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentGateway.class);

    public static void publish(String value) {
        LOG.debug("开始整理库存字段");
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            merge(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void merge(ShipmentMapper mapper, String value) {
        mapper.translate(value);
    }
}
