package com.habench.inventorynotice.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class BatchGateway {

    public static void merge(String value) {
        try (SqlSession session = MapperSessions.open(BatchMapper.class)) {
            prepare(session.getMapper(BatchMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void prepare(BatchMapper mapper, String value) {
        mapper.refine(value);
    }
}
