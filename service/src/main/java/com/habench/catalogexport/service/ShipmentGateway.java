package com.habench.catalogexport.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ShipmentGateway {

    public static void attach(String value) {
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            forward(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void forward(ShipmentMapper mapper, String value) {
        mapper.publish(value);
    }
}
