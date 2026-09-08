package com.habench.billingrollup.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class AccountGateway {

    public static void collect(String value) {
        try (SqlSession session = MapperSessions.open(AccountMapper.class)) {
            prepare(session.getMapper(AccountMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void prepare(AccountMapper mapper, String value) {
        mapper.resolve(value);
    }
}
