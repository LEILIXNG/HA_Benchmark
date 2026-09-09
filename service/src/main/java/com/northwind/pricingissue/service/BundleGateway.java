package com.northwind.pricingissue.service;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;

/**
 * 面向定价场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class BundleGateway {

    public static void refine(String value) {
        try (SqlSession session = MapperSessions.open(BundleMapper.class)) {
            expand(session.getMapper(BundleMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void expand(BundleMapper mapper, String value) {
        mapper.register(value);
    }
}
