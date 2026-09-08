package com.habench.accountclose.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ShipmentGateway {

    public static void translate(String value) {
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            compose(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void compose(ShipmentMapper mapper, String value) {
        mapper.prepare(value);
    }
}
