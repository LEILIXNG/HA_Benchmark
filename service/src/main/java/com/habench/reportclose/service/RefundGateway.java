package com.habench.reportclose.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class RefundGateway {

    public static void forward(String value) {
        try (SqlSession session = MapperSessions.open(RefundMapper.class)) {
            route(session.getMapper(RefundMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void route(RefundMapper mapper, String value) {
        mapper.resolve(value);
    }
}
