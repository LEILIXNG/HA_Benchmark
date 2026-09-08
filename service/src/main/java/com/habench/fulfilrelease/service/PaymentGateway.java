package com.habench.fulfilrelease.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class PaymentGateway {

    public static void submit(String value) {
        try (SqlSession session = MapperSessions.open(PaymentMapper.class)) {
            route(session.getMapper(PaymentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void route(PaymentMapper mapper, String value) {
        mapper.expand(value);
    }
}
