package com.northwind.billingrollup.dao;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class AccountGateway {
    private static final Logger LOG = LoggerFactory.getLogger(AccountGateway.class);

    public static void collect(String value) {
        LOG.debug("开始整理账务字段");
        try (SqlSession session = MapperSessions.open(AccountMapper.class)) {
            prepare(session.getMapper(AccountMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void prepare(AccountMapper mapper, String value) {
        mapper.resolve(value);
    }
}
