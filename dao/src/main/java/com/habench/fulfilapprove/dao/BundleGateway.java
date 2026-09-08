package com.habench.fulfilapprove.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class BundleGateway {

    public static void enrich(String value) {
        try (SqlSession session = MapperSessions.open(BundleMapper.class)) {
            assemble(session.getMapper(BundleMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void assemble(BundleMapper mapper, String value) {
        mapper.route(value);
    }
}
