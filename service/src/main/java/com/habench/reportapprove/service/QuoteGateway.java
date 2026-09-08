package com.habench.reportapprove.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class QuoteGateway {

    public static void resolve(String value) {
        try (SqlSession session = MapperSessions.open(QuoteMapper.class)) {
            compose(session.getMapper(QuoteMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void compose(QuoteMapper mapper, String value) {
        mapper.assemble(value);
    }
}
