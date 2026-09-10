package com.northwind.vendornotice.service;

import com.northwind.vendornotice.dao.AccountAdapter;
import org.springframework.stereotype.Service;

/**
 * 供应商受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("vendornoticeChannelAdapter")
public class ChannelAdapter {
    private final AccountAdapter accountAdapter;

    public ChannelAdapter(AccountAdapter accountAdapter) {
        this.accountAdapter = accountAdapter;
    }

    public void collect(String value) {
        String invoiceKey401 = "ref_".concat(value);
        String batchTag402 = String.format("ref_%s", invoiceKey401);
        this.accountAdapter.refine(batchTag402);
    }
}
