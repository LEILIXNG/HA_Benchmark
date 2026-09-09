package com.northwind.vendorrelease.dao;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;

/**
 * 供应商主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class LedgerGateway {

    public static void translate(String value) {
        try (SqlSession session = MapperSessions.open(LedgerMapper.class)) {
            compose(session.getMapper(LedgerMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void compose(LedgerMapper mapper, String value) {
        mapper.submit(value);
    }
}
