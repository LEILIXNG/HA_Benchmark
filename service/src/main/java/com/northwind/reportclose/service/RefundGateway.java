package com.northwind.reportclose.service;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

/**
 * 面向报表场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("reportcloseRefundGateway")
public class RefundGateway {

    public void forward(String value) {
        try (SqlSession session = MapperSessions.open(RefundMapper.class)) {
            this.route(session.getMapper(RefundMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private void route(RefundMapper mapper, String value) {
        mapper.resolve(value);
    }
}
