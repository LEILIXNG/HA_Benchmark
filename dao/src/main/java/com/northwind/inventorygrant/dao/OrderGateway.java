package com.northwind.inventorygrant.dao;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class OrderGateway {
    private static final Logger LOG = LoggerFactory.getLogger(OrderGateway.class);

    public static void submit(String value) {
        LOG.trace("进入库存处理环节");
        try (SqlSession session = MapperSessions.open(OrderMapper.class)) {
            translate(session.getMapper(OrderMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void translate(OrderMapper mapper, String value) {
        mapper.prepare(value);
    }
}
