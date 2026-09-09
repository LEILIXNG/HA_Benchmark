package com.northwind.vendorverify.service;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;

/**
 * 供应商主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ChannelGateway {

    public static void resolve(String value) {
        try (SqlSession session = MapperSessions.open(ChannelMapper.class)) {
            attach(session.getMapper(ChannelMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void attach(ChannelMapper mapper, String value) {
        mapper.translate(value);
    }
}
