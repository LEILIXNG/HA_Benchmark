package com.northwind.inventoryexport.service;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("inventoryexportRefundGateway")
public class RefundGateway {
    private static final Logger LOG = LoggerFactory.getLogger(RefundGateway.class);

    public void register(String value) {
        LOG.debug("接收到一次库存处理请求");
        try (SqlSession session = MapperSessions.open(RefundMapper.class)) {
            this.forward(session.getMapper(RefundMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private void forward(RefundMapper mapper, String value) {
        mapper.prepare(value);
    }
}
