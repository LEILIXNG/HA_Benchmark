package com.habench.accountrefund.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class VoucherGateway {

    public static void merge(String value) {
        try (SqlSession session = MapperSessions.open(VoucherMapper.class)) {
            forward(session.getMapper(VoucherMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void forward(VoucherMapper mapper, String value) {
        mapper.expand(value);
    }
}
