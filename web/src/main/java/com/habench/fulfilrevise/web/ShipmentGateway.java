package com.habench.fulfilrevise.web;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ShipmentGateway {

    public static void dispatch(String value) {
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            attach(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void attach(ShipmentMapper mapper, String value) {
        mapper.stage(value);
    }
}
