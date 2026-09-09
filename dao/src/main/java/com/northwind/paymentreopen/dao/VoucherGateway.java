package com.northwind.paymentreopen.dao;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;

/**
 * 支付受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class VoucherGateway {

    public static void refine(String value) {
        try (SqlSession session = MapperSessions.open(VoucherMapper.class)) {
            normalize(session.getMapper(VoucherMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void normalize(VoucherMapper mapper, String value) {
        mapper.submit(value);
    }
}
