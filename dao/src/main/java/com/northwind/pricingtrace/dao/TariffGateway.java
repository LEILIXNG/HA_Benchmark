package com.northwind.pricingtrace.dao;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 定价明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("pricingtraceTariffGateway")
public class TariffGateway {
    private static final Logger LOG = LoggerFactory.getLogger(TariffGateway.class);

    public void translate(String value) {
        LOG.trace("进入定价处理环节");
        try (SqlSession session = MapperSessions.open(TariffMapper.class)) {
            this.assemble(session.getMapper(TariffMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private void assemble(TariffMapper mapper, String value) {
        mapper.resolve(value);
    }
}
