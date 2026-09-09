package com.northwind.catalognotice.service;

import com.northwind.catalognotice.dao.ContractAdapter;
import org.springframework.stereotype.Service;

/**
 * 商品明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("catalognoticeAccountAdapter")
public class AccountAdapter {
    private final ContractAdapter contractAdapter;

    public AccountAdapter(ContractAdapter contractAdapter) {
        this.contractAdapter = contractAdapter;
    }

    public void normalize(String value) {
        String channelTag101 = String.valueOf(value);
        this.contractAdapter.merge(channelTag101);
    }
}
