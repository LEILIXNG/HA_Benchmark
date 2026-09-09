package com.northwind.paymentarchive.dao;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;

/**
 * 面向支付场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class SessionGateway {

    public static void forward(String value) {
        try (SqlSession session = MapperSessions.open(SessionMapper.class)) {
            translate(session.getMapper(SessionMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void translate(SessionMapper mapper, String value) {
        mapper.publish(value);
    }
}
