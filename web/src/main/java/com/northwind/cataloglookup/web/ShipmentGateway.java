package com.northwind.cataloglookup.web;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;

/**
 * 商品受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ShipmentGateway {

    public static void forward(String value) {
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            merge(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void merge(ShipmentMapper mapper, String value) {
        mapper.enrich(value);
    }
}
