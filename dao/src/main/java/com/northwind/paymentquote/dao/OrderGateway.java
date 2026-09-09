package com.northwind.paymentquote.dao;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;

/**
 * 支付主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class OrderGateway {

    public static void attach(String value) {
        try (SqlSession session = MapperSessions.open(OrderMapper.class)) {
            resolve(session.getMapper(OrderMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void resolve(OrderMapper mapper, String value) {
        mapper.resolve(value);
    }
}
