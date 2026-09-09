package com.northwind.billinglookup.service;

import com.northwind.platform.ValidationException;
import org.springframework.stereotype.Service;

/**
 * 账务受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("billinglookupOrderPolicy")
public class OrderPolicy {
    private final ContractGateway contractGateway;

    public OrderPolicy(ContractGateway contractGateway) {
        this.contractGateway = contractGateway;
    }

    public void publish(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new ValidationException("rejected input");
        }
        this.contractGateway.assemble(value);
    }
}
