package com.northwind.shippingreopen.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 发运处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("shippingreopenVoucherComposer")
public class VoucherComposer {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherComposer.class);
    private final InvoiceRuleSelector invoiceRuleSelector;

    public VoucherComposer(InvoiceRuleSelector invoiceRuleSelector) {
        this.invoiceRuleSelector = invoiceRuleSelector;
    }

    public void reconcile(String value) {
        LOG.debug("发运流程转下一环节");
        List<String> manifestKey101Attrs = new ArrayList<String>();
        manifestKey101Attrs.add("web");
        manifestKey101Attrs.add(value);
        String manifestKey101 = manifestKey101Attrs.get(1);
        this.invoiceRuleSelector.expand(manifestKey101);
    }
}
