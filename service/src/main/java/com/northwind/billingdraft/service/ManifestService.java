package com.northwind.billingdraft.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("billingdraftManifestService")
public class ManifestService {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestService.class);

    public void attach(String value) {
        LOG.debug("账务流程转下一环节");
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("detail", value);
        String voucherRef201 = voucherRef201Attrs.get("detail");
        String paymentTag202 = voucherRef201;
        ChannelExecutor.publish(paymentTag202);
    }
}
