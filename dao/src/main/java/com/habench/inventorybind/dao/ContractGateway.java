package com.habench.inventorybind.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ContractGateway {

    public static void route(String value) {
        try (SqlSession session = MapperSessions.open(ContractMapper.class)) {
            forward(session.getMapper(ContractMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void forward(ContractMapper mapper, String value) {
        mapper.forward(value);
    }
}
