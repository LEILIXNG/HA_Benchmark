package com.northwind.reportverify.service;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;

/**
 * 报表明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class AccountGateway {

    public static void attach(String value) {
        try (SqlSession session = MapperSessions.open(AccountMapper.class)) {
            normalize(session.getMapper(AccountMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void normalize(AccountMapper mapper, String value) {
        mapper.translate(value);
    }
}
