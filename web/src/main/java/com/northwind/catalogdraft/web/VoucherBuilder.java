package com.northwind.catalogdraft.web;

import com.northwind.catalogdraft.service.ChannelCollector;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("catalogdraftVoucherBuilder")
public class VoucherBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherBuilder.class);
    private final ChannelCollector channelCollector;

    public VoucherBuilder(ChannelCollector channelCollector) {
        this.channelCollector = channelCollector;
    }

    public void assemble(String value) {
        LOG.debug("开始整理商品字段");
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("detail", value);
        String receiptKey1 = receiptKey1Attrs.get("detail");
        String accountRef2 = "ref:".concat(receiptKey1).concat(";");
        this.channelCollector.dispatch(accountRef2);
    }
}
