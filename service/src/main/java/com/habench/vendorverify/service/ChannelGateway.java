package com.habench.vendorverify.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ChannelGateway {

    public static void resolve(String value) {
        try (SqlSession session = MapperSessions.open(ChannelMapper.class)) {
            attach(session.getMapper(ChannelMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void attach(ChannelMapper mapper, String value) {
        mapper.translate(value);
    }
}
