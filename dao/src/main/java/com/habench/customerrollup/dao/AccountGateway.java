package com.habench.customerrollup.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class AccountGateway {

    public static void attach(String value) {
        try (SqlSession session = MapperSessions.open(AccountMapper.class)) {
            reconcile(session.getMapper(AccountMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void reconcile(AccountMapper mapper, String value) {
        mapper.publish(value);
    }
}
