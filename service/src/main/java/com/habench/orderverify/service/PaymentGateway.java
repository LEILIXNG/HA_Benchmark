package com.habench.orderverify.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class PaymentGateway {

    public static void route(String value) {
        try (SqlSession session = MapperSessions.open(PaymentMapper.class)) {
            register(session.getMapper(PaymentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void register(PaymentMapper mapper, String value) {
        mapper.dispatch(value);
    }
}
