package com.northwind.orderreview.web;

import com.northwind.orderreview.service.OrderCoordinator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("orderreviewChannelAssembler")
public class ChannelAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelAssembler.class);
    private String pendingPayment;
    private final OrderCoordinator orderCoordinator;

    public ChannelAssembler(OrderCoordinator orderCoordinator) {
        this.orderCoordinator = orderCoordinator;
    }

    public void publish(String value) {
        LOG.debug("开始整理订单字段");
        this.compose(value);
    }

    private void compose(String value) {
        Map<String, String> ledgerEntry201Attrs = new LinkedHashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("detail", value);
        String ledgerEntry201 = ledgerEntry201Attrs.getOrDefault("detail", "");
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("remark", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("remark");
        this.pendingPayment = channelTag202;
        submit();
    }

    private void submit() {
        String catalogKey203 = this.pendingPayment;
        String receiptKey204 = "ref:".concat(catalogKey203).concat(";");
        this.orderCoordinator.merge(receiptKey204);
    }
}
