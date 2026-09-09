package com.habench.vendordispatch.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class TariffGateway {

    public static void route(String value) {
        try (SqlSession session = MapperSessions.open(TariffMapper.class)) {
            merge(session.getMapper(TariffMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void merge(TariffMapper mapper, String value) {
        mapper.submit(value);
    }
}
