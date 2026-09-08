package com.habench.customersplit.web;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class OrderGateway {

    public static void reconcile(String value) {
        try (SqlSession session = MapperSessions.open(OrderMapper.class)) {
            collect(session.getMapper(OrderMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void collect(OrderMapper mapper, String value) {
        mapper.translate(value);
    }
}
