package com.northwind.reportapprove.service;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class QuoteGateway {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteGateway.class);

    public static void resolve(String value) {
        LOG.trace("进入报表处理环节");
        try (SqlSession session = MapperSessions.open(QuoteMapper.class)) {
            compose(session.getMapper(QuoteMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void compose(QuoteMapper mapper, String value) {
        mapper.assemble(value);
    }
}
