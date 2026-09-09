package com.habench.billingnotice.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ContractGateway {

    public static void stage(String value) {
        try (SqlSession session = MapperSessions.open(ContractMapper.class)) {
            submit(session.getMapper(ContractMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void submit(ContractMapper mapper, String value) {
        mapper.translate(value);
    }
}
