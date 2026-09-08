package com.habench.inventoryexport.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class RefundGateway {

    public static void register(String value) {
        try (SqlSession session = MapperSessions.open(RefundMapper.class)) {
            forward(session.getMapper(RefundMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void forward(RefundMapper mapper, String value) {
        mapper.prepare(value);
    }
}
