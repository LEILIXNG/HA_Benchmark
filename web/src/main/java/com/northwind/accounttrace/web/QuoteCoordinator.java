package com.northwind.accounttrace.web;

import com.northwind.accounttrace.service.SessionEnricher;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 面向账户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("accounttraceQuoteCoordinator")
public class QuoteCoordinator {
    private final SessionEnricher sessionEnricher;

    public QuoteCoordinator(SessionEnricher sessionEnricher) {
        this.sessionEnricher = sessionEnricher;
    }

    public void reconcile(String value) {
        List<String> shipmentCode1Attrs = new ArrayList<String>();
        shipmentCode1Attrs.add("web");
        shipmentCode1Attrs.add(value);
        String shipmentCode1 = shipmentCode1Attrs.get(1);
        this.sessionEnricher.translate(shipmentCode1);
    }
}
