package com.habench.billingintake.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class InvoiceGateway {

    public static void translate(String value) {
        try (SqlSession session = MapperSessions.open(InvoiceMapper.class)) {
            collect(session.getMapper(InvoiceMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void collect(InvoiceMapper mapper, String value) {
        mapper.forward(value);
    }
}
