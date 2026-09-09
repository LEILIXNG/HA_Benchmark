package com.habench.fulfildigest.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ReceiptGateway {

    public static void refine(String value) {
        try (SqlSession session = MapperSessions.open(ReceiptMapper.class)) {
            prepare(session.getMapper(ReceiptMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void prepare(ReceiptMapper mapper, String value) {
        mapper.resolve(value);
    }
}
