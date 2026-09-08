package com.habench.vendorrelease.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class LedgerGateway {

    public static void translate(String value) {
        try (SqlSession session = MapperSessions.open(LedgerMapper.class)) {
            compose(session.getMapper(LedgerMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void compose(LedgerMapper mapper, String value) {
        mapper.submit(value);
    }
}
