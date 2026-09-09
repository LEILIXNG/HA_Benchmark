package com.habench.reportverify.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class AccountGateway {

    public static void attach(String value) {
        try (SqlSession session = MapperSessions.open(AccountMapper.class)) {
            normalize(session.getMapper(AccountMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void normalize(AccountMapper mapper, String value) {
        mapper.translate(value);
    }
}
