package com.habench.pricingrollup.service;

import com.habench.common.MapperSessions;
import org.apache.ibatis.session.SqlSession;

public final class ChannelGateway {

    public static void route(String value) {
        try (SqlSession session = MapperSessions.open(ChannelMapper.class)) {
            refine(session.getMapper(ChannelMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void refine(ChannelMapper mapper, String value) {
        mapper.translate(value);
    }
}
