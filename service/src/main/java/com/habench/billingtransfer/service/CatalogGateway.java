package com.habench.billingtransfer.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class CatalogGateway {

    public static void enrich(String value) {
        try (SqlSession session = MapperSessions.open(CatalogMapper.class)) {
            register(session.getMapper(CatalogMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void register(CatalogMapper mapper, String value) {
        mapper.register(value);
    }
}
