package com.habench.inventoryadjust.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ShipmentGateway {

    public static void publish(String value) {
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            merge(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void merge(ShipmentMapper mapper, String value) {
        mapper.translate(value);
    }
}
