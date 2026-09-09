package com.northwind.customergrant.service;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ShipmentGateway {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentGateway.class);

    public static void reconcile(String value) {
        LOG.debug("客户流程转下一环节");
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            translate(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void translate(ShipmentMapper mapper, String value) {
        mapper.merge(value);
    }
}
