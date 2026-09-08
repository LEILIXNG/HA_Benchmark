package com.habench.inventorysplit.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ManifestGateway {

    public static void translate(String value) {
        try (SqlSession session = MapperSessions.open(ManifestMapper.class)) {
            assemble(session.getMapper(ManifestMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void assemble(ManifestMapper mapper, String value) {
        mapper.dispatch(value);
    }
}
