package com.habench.pricingassign.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ShipmentGateway {

    public static void expand(String value) {
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            refine(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void refine(ShipmentMapper mapper, String value) {
        mapper.refine(value);
    }
}
