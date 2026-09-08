package com.habench.reportnotice.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ReceiptGateway {

    public static void merge(String value) {
        try (SqlSession session = MapperSessions.open(ReceiptMapper.class)) {
            submit(session.getMapper(ReceiptMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void submit(ReceiptMapper mapper, String value) {
        mapper.dispatch(value);
    }
}
