package com.habench.pricingtrace.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class TariffGateway {

    public static void translate(String value) {
        try (SqlSession session = MapperSessions.open(TariffMapper.class)) {
            assemble(session.getMapper(TariffMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void assemble(TariffMapper mapper, String value) {
        mapper.resolve(value);
    }
}
