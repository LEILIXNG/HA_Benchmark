package com.habench.paymentreopen.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class VoucherGateway {

    public static void refine(String value) {
        try (SqlSession session = MapperSessions.open(VoucherMapper.class)) {
            normalize(session.getMapper(VoucherMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void normalize(VoucherMapper mapper, String value) {
        mapper.submit(value);
    }
}
