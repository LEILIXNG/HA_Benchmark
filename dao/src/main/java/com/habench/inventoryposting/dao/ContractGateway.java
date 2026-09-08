package com.habench.inventoryposting.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ContractGateway {

    public static void dispatch(String value) {
        try (SqlSession session = MapperSessions.open(ContractMapper.class)) {
            collect(session.getMapper(ContractMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void collect(ContractMapper mapper, String value) {
        mapper.forward(value);
    }
}
