package com.northwind.billingdispatch.service;

import com.northwind.billingdispatch.dao.ContractService;
import org.springframework.stereotype.Service;

/**
 * 账务明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("billingdispatchQuoteBroker")
public class QuoteBroker {
    private final ContractService contractService;

    public QuoteBroker(ContractService contractService) {
        this.contractService = contractService;
    }

    public void normalize(String value) {
        String batchTag101 = "ref:" + value + ";";
        this.contractService.forward(batchTag101);
    }
}
