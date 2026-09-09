package com.northwind.catalogexport.service;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentGateway {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentGateway.class);

    public static void attach(String value) {
        LOG.trace("进入商品处理环节");
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            forward(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void forward(ShipmentMapper mapper, String value) {
        mapper.publish(value);
    }
}
