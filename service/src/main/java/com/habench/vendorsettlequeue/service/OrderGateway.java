package com.habench.vendorsettlequeue.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class OrderGateway {

    public static void register(String value) {
        try (SqlSession session = MapperSessions.open(OrderMapper.class)) {
            attach(session.getMapper(OrderMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void attach(OrderMapper mapper, String value) {
        mapper.collect(value);
    }
}
