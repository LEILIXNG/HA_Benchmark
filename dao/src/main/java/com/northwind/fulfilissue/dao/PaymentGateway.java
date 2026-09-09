package com.northwind.fulfilissue.dao;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class PaymentGateway {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentGateway.class);

    public static void stage(String value) {
        LOG.debug("接收到一次履约处理请求");
        try (SqlSession session = MapperSessions.open(PaymentMapper.class)) {
            translate(session.getMapper(PaymentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void translate(PaymentMapper mapper, String value) {
        mapper.collect(value);
    }
}
