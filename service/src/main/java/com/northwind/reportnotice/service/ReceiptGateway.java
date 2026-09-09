package com.northwind.reportnotice.service;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 报表主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("reportnoticeReceiptGateway")
public class ReceiptGateway {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptGateway.class);

    public void merge(String value) {
        LOG.debug("接收到一次报表处理请求");
        try (SqlSession session = MapperSessions.open(ReceiptMapper.class)) {
            this.submit(session.getMapper(ReceiptMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private void submit(ReceiptMapper mapper, String value) {
        mapper.dispatch(value);
    }
}
