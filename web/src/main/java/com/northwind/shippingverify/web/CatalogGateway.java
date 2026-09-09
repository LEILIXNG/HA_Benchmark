package com.northwind.shippingverify.web;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class CatalogGateway {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogGateway.class);

    public static void compose(String value) {
        LOG.debug("发运流程转下一环节");
        try (SqlSession session = MapperSessions.open(CatalogMapper.class)) {
            normalize(session.getMapper(CatalogMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void normalize(CatalogMapper mapper, String value) {
        mapper.compose(value);
    }
}
