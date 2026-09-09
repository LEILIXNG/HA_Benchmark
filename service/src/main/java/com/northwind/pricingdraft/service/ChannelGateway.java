package com.northwind.pricingdraft.service;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;

/**
 * 定价明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelGateway {

    public static void translate(String value) {
        try (SqlSession session = MapperSessions.open(ChannelMapper.class)) {
            submit(session.getMapper(ChannelMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void submit(ChannelMapper mapper, String value) {
        mapper.register(value);
    }
}
