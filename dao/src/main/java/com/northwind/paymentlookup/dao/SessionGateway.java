package com.northwind.paymentlookup.dao;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;

/**
 * 支付主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class SessionGateway {

    public static void attach(String value) {
        try (SqlSession session = MapperSessions.open(SessionMapper.class)) {
            prepare(session.getMapper(SessionMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void prepare(SessionMapper mapper, String value) {
        mapper.merge(value);
    }
}
