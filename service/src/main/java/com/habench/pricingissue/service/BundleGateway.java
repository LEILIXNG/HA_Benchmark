package com.habench.pricingissue.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class BundleGateway {

    public static void refine(String value) {
        try (SqlSession session = MapperSessions.open(BundleMapper.class)) {
            expand(session.getMapper(BundleMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void expand(BundleMapper mapper, String value) {
        mapper.register(value);
    }
}
