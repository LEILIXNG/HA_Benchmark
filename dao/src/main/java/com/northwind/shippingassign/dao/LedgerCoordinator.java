package com.northwind.shippingassign.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 发运受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("shippingassignLedgerCoordinator")
public class LedgerCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerCoordinator.class);

    public void publish(String value) {
        LOG.debug("发运流程转下一环节");
        List<String> accountRef301Attrs = new ArrayList<String>();
        accountRef301Attrs.add("web");
        accountRef301Attrs.add(value);
        String accountRef301 = accountRef301Attrs.get(1);
        ContractRepository.prepare(accountRef301);
    }
}
