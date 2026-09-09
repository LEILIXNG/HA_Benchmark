package com.habench.customergrant.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ShipmentGateway {

    public static void reconcile(String value) {
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            translate(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void translate(ShipmentMapper mapper, String value) {
        mapper.merge(value);
    }
}
