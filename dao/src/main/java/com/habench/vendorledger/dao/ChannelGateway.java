package com.habench.vendorledger.dao;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ChannelGateway {

    public static void merge(String value) {
        try (SqlSession session = MapperSessions.open(ChannelMapper.class)) {
            submit(session.getMapper(ChannelMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void submit(ChannelMapper mapper, String value) {
        mapper.attach(value);
    }
}
