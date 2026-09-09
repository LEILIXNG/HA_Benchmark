package com.northwind.accountrefund.service;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;

/**
 * 账户明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class VoucherGateway {

    public static void merge(String value) {
        try (SqlSession session = MapperSessions.open(VoucherMapper.class)) {
            forward(session.getMapper(VoucherMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void forward(VoucherMapper mapper, String value) {
        mapper.expand(value);
    }
}
