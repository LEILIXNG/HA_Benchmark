package com.northwind.ordertrace.service;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("ordertraceQuoteGateway")
public class QuoteGateway {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteGateway.class);

    public void forward(String value) {
        LOG.debug("接收到一次订单处理请求");
        try (SqlSession session = MapperSessions.open(QuoteMapper.class)) {
            this.submit(session.getMapper(QuoteMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private void submit(QuoteMapper mapper, String value) {
        mapper.reconcile(value);
    }
}
