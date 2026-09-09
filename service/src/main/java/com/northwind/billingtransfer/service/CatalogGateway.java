package com.northwind.billingtransfer.service;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

/**
 * 面向账务场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("billingtransferCatalogGateway")
public class CatalogGateway {

    public void enrich(String value) {
        try (SqlSession session = MapperSessions.open(CatalogMapper.class)) {
            this.register(session.getMapper(CatalogMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private void register(CatalogMapper mapper, String value) {
        mapper.register(value);
    }
}
