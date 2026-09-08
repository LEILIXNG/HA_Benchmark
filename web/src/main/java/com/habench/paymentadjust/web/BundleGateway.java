package com.habench.paymentadjust.web;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class BundleGateway {

    public static void dispatch(String value) {
        try (SqlSession session = MapperSessions.open(BundleMapper.class)) {
            reconcile(session.getMapper(BundleMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void reconcile(BundleMapper mapper, String value) {
        mapper.resolve(value);
    }
}
