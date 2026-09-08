package com.habench.ordertrace.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class QuoteGateway {

    public static void forward(String value) {
        try (SqlSession session = MapperSessions.open(QuoteMapper.class)) {
            submit(session.getMapper(QuoteMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void submit(QuoteMapper mapper, String value) {
        mapper.reconcile(value);
    }
}
