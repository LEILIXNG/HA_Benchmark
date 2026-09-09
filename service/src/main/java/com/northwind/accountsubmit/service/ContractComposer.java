package com.northwind.accountsubmit.service;

import com.northwind.accountsubmit.dao.BatchComposer;
import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("accountsubmitContractComposer")
public class ContractComposer {
    private final BatchComposer batchComposer;

    public ContractComposer(BatchComposer batchComposer) {
        this.batchComposer = batchComposer;
    }

    public void stage(String value) {
        String channelTag101 = "ref:".concat(value).concat(";");
        String catalogKey102 = String.format("ref:%s;", channelTag101);
        this.batchComposer.compose(catalogKey102);
    }
}
