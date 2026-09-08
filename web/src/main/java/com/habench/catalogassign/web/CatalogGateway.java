package com.habench.catalogassign.web;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class CatalogGateway {

    public static void submit(String value) {
        try (SqlSession session = MapperSessions.open(CatalogMapper.class)) {
            expand(session.getMapper(CatalogMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void expand(CatalogMapper mapper, String value) {
        mapper.register(value);
    }
}
