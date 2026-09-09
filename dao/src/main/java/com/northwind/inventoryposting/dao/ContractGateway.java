package com.northwind.inventoryposting.dao;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;

/**
 * 库存处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ContractGateway {

    public static void dispatch(String value) {
        try (SqlSession session = MapperSessions.open(ContractMapper.class)) {
            collect(session.getMapper(ContractMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void collect(ContractMapper mapper, String value) {
        mapper.forward(value);
    }
}
