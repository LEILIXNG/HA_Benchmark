package com.habench.paymentlookup.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class SessionGateway {

    public static void attach(String value) {
        try (SqlSession session = MapperSessions.open(SessionMapper.class)) {
            prepare(session.getMapper(SessionMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void prepare(SessionMapper mapper, String value) {
        mapper.merge(value);
    }
}
