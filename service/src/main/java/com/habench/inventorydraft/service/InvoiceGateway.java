package com.habench.inventorydraft.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class InvoiceGateway {

    public static void submit(String value) {
        try (SqlSession session = MapperSessions.open(InvoiceMapper.class)) {
            merge(session.getMapper(InvoiceMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void merge(InvoiceMapper mapper, String value) {
        mapper.submit(value);
    }
}
