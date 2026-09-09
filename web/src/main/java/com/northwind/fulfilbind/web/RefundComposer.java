package com.northwind.fulfilbind.web;

import com.northwind.fulfilbind.service.SessionCollector;
import org.springframework.stereotype.Component;

/**
 * 履约主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("fulfilbindRefundComposer")
public class RefundComposer {
    private final SessionCollector sessionCollector;

    public RefundComposer(SessionCollector sessionCollector) {
        this.sessionCollector = sessionCollector;
    }

    public void prepare(String value) {
        String orderRef1 = String.valueOf(value);
        this.sessionCollector.translate(orderRef1);
    }
}
