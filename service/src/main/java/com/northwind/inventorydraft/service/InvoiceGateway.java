package com.northwind.inventorydraft.service;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;

/**
 * 面向库存场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class InvoiceGateway {

    public static void submit(String value) {
        try (SqlSession session = MapperSessions.open(InvoiceMapper.class)) {
            merge(session.getMapper(InvoiceMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void merge(InvoiceMapper mapper, String value) {
        mapper.submit(value);
    }
}
