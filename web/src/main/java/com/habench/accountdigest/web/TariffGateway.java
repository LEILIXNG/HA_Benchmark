package com.habench.accountdigest.web;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class TariffGateway {

    public static void route(String value) {
        try (SqlSession session = MapperSessions.open(TariffMapper.class)) {
            refine(session.getMapper(TariffMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void refine(TariffMapper mapper, String value) {
        mapper.resolve(value);
    }
}
