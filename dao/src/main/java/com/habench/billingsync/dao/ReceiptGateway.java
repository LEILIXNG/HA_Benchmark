package com.habench.billingsync.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ReceiptGateway {

    public static void dispatch(String value) {
        try (SqlSession session = MapperSessions.open(ReceiptMapper.class)) {
            merge(session.getMapper(ReceiptMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void merge(ReceiptMapper mapper, String value) {
        mapper.enrich(value);
    }
}
