package com.habench.fulfilissue.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class PaymentGateway {

    public static void stage(String value) {
        try (SqlSession session = MapperSessions.open(PaymentMapper.class)) {
            translate(session.getMapper(PaymentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void translate(PaymentMapper mapper, String value) {
        mapper.collect(value);
    }
}
