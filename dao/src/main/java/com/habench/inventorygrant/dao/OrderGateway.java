package com.habench.inventorygrant.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class OrderGateway {

    public static void submit(String value) {
        try (SqlSession session = MapperSessions.open(OrderMapper.class)) {
            translate(session.getMapper(OrderMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void translate(OrderMapper mapper, String value) {
        mapper.prepare(value);
    }
}
