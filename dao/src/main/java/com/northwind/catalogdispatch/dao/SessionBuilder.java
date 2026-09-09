package com.northwind.catalogdispatch.dao;

import org.springframework.stereotype.Repository;

/**
 * 商品处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("catalogdispatchSessionBuilder")
public class SessionBuilder {
    private final ContractPlanSelector contractPlanSelector;

    public SessionBuilder(ContractPlanSelector contractPlanSelector) {
        this.contractPlanSelector = contractPlanSelector;
    }

    public void dispatch(String value) {
        String ledgerEntry301 = "ref:" + value + ";";
        this.contractPlanSelector.assemble(ledgerEntry301);
    }
}
