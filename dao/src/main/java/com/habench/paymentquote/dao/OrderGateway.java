package com.habench.paymentquote.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class OrderGateway {

    public static void attach(String value) {
        try (SqlSession session = MapperSessions.open(OrderMapper.class)) {
            resolve(session.getMapper(OrderMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void resolve(OrderMapper mapper, String value) {
        mapper.resolve(value);
    }
}
