package com.habench.vendorapprove.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ReceiptGateway {

    public static void reconcile(String value) {
        try (SqlSession session = MapperSessions.open(ReceiptMapper.class)) {
            resolve(session.getMapper(ReceiptMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void resolve(ReceiptMapper mapper, String value) {
        mapper.reconcile(value);
    }
}
