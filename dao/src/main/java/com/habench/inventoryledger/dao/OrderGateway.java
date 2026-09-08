package com.habench.inventoryledger.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class OrderGateway {

    public static void compose(String value) {
        try (SqlSession session = MapperSessions.open(OrderMapper.class)) {
            stage(session.getMapper(OrderMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void stage(OrderMapper mapper, String value) {
        mapper.attach(value);
    }
}
