package com.habench.cataloglookup.web;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ShipmentGateway {

    public static void forward(String value) {
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            merge(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void merge(ShipmentMapper mapper, String value) {
        mapper.enrich(value);
    }
}
