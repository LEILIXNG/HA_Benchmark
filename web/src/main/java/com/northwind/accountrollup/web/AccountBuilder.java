package com.northwind.accountrollup.web;

import com.northwind.accountrollup.service.BundleAdapter;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("accountrollupAccountBuilder")
public class AccountBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(AccountBuilder.class);
    private final BundleAdapter bundleAdapter;

    public AccountBuilder(BundleAdapter bundleAdapter) {
        this.bundleAdapter = bundleAdapter;
    }

    public void refine(String value) {
        LOG.debug("账户流程转下一环节");
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("detail", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("detail");
        this.bundleAdapter.submit(ledgerEntry1);
    }
}
