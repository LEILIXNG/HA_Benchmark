package com.habench.billinglookup.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ContractGateway {

    public static void assemble(String value) {
        try (SqlSession session = MapperSessions.open(ContractMapper.class)) {
            dispatch(session.getMapper(ContractMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void dispatch(ContractMapper mapper, String value) {
        mapper.prepare(value);
    }
}
