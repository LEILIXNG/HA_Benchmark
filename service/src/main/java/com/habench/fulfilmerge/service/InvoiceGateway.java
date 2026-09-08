package com.habench.fulfilmerge.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class InvoiceGateway {

    public static void reconcile(String value) {
        try (SqlSession session = MapperSessions.open(InvoiceMapper.class)) {
            prepare(session.getMapper(InvoiceMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void prepare(InvoiceMapper mapper, String value) {
        mapper.merge(value);
    }
}
