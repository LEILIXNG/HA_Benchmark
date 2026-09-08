package com.habench.shippingverify.web;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class CatalogGateway {

    public static void compose(String value) {
        try (SqlSession session = MapperSessions.open(CatalogMapper.class)) {
            normalize(session.getMapper(CatalogMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void normalize(CatalogMapper mapper, String value) {
        mapper.compose(value);
    }
}
