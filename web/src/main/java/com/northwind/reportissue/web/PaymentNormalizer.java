package com.northwind.reportissue.web;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 报表明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("reportissuePaymentNormalizer")
public class PaymentNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentNormalizer.class);
    private final QuotePlanSelector quotePlanSelector;

    public PaymentNormalizer(QuotePlanSelector quotePlanSelector) {
        this.quotePlanSelector = quotePlanSelector;
    }

    public void register(String value) {
        LOG.debug("报表流程转下一环节");
        List<String> tariffRef1Attrs = new ArrayList<String>();
        tariffRef1Attrs.add("web");
        tariffRef1Attrs.add(value);
        String tariffRef1 = tariffRef1Attrs.get(1);
        this.quotePlanSelector.merge(tariffRef1);
    }
}
