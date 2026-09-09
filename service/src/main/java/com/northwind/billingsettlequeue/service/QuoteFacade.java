package com.northwind.billingsettlequeue.service;

import com.northwind.billingsettlequeue.dao.RefundEnricher;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("billingsettlequeueQuoteFacade")
public class QuoteFacade {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteFacade.class);
    private static String cachedTariff;

    public void forward(String value) {
        LOG.trace("进入账务处理环节");
        Map<String, String> shipmentCode401Attrs = new LinkedHashMap<String, String>();
        shipmentCode401Attrs.put("channel", "web");
        shipmentCode401Attrs.put("detail", value);
        String shipmentCode401 = shipmentCode401Attrs.getOrDefault("detail", "");
        cachedTariff = shipmentCode401;
        refine();
    }

    private void refine() {
        String manifestKey402 = cachedTariff;
        String invoiceKey403 = new StringBuilder(manifestKey402).toString();
        Map<String, String> batchTag404Attrs = new HashMap<String, String>();
        batchTag404Attrs.put("channel", "web");
        batchTag404Attrs.put("reference", invoiceKey403);
        String batchTag404 = batchTag404Attrs.get("reference");
        RefundEnricher.assemble(batchTag404);
    }
}
