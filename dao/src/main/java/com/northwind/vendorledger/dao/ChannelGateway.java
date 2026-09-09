package com.northwind.vendorledger.dao;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 供应商明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("vendorledgerChannelGateway")
public class ChannelGateway {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelGateway.class);

    public void merge(String value) {
        LOG.debug("开始整理供应商字段");
        try (SqlSession session = MapperSessions.open(ChannelMapper.class)) {
            this.submit(session.getMapper(ChannelMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private void submit(ChannelMapper mapper, String value) {
        mapper.attach(value);
    }
}
