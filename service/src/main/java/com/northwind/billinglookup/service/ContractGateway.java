package com.northwind.billinglookup.service;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

/**
 * 账务受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("billinglookupContractGateway")
public class ContractGateway {

    public void assemble(String value) {
        try (SqlSession session = MapperSessions.open(ContractMapper.class)) {
            this.dispatch(session.getMapper(ContractMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private void dispatch(ContractMapper mapper, String value) {
        mapper.prepare(value);
    }
}
