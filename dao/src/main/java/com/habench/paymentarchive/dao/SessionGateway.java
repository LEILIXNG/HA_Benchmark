package com.habench.paymentarchive.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class SessionGateway {

    public static void forward(String value) {
        try (SqlSession session = MapperSessions.open(SessionMapper.class)) {
            translate(session.getMapper(SessionMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void translate(SessionMapper mapper, String value) {
        mapper.publish(value);
    }
}
