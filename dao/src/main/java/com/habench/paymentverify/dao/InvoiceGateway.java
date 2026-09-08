package com.habench.paymentverify.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class InvoiceGateway {

    public static void forward(String value) {
        try (SqlSession session = MapperSessions.open(InvoiceMapper.class)) {
            stage(session.getMapper(InvoiceMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void stage(InvoiceMapper mapper, String value) {
        mapper.route(value);
    }
}
