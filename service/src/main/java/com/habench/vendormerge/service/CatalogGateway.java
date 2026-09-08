package com.habench.vendormerge.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class CatalogGateway {

    public static void stage(String value) {
        try (SqlSession session = MapperSessions.open(CatalogMapper.class)) {
            forward(session.getMapper(CatalogMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void forward(CatalogMapper mapper, String value) {
        mapper.translate(value);
    }
}
