package com.habench.vendoradjust.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class InvoiceGateway {

    public static void refine(String value) {
        try (SqlSession session = MapperSessions.open(InvoiceMapper.class)) {
            dispatch(session.getMapper(InvoiceMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void dispatch(InvoiceMapper mapper, String value) {
        mapper.attach(value);
    }
}
