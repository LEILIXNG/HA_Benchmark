package com.northwind.accountdigest.web;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class TariffGateway {
    private static final Logger LOG = LoggerFactory.getLogger(TariffGateway.class);

    public static void route(String value) {
        LOG.debug("接收到一次账户处理请求");
        try (SqlSession session = MapperSessions.open(TariffMapper.class)) {
            refine(session.getMapper(TariffMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void refine(TariffMapper mapper, String value) {
        mapper.resolve(value);
    }
}
