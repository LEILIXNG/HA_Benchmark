package com.northwind.catalogrevise.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("catalogreviseController")
@RequestMapping("/api/catalog")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);
    private final ChannelEnricher channelEnricher;

    public InvoiceController(ChannelEnricher channelEnricher) {
        this.channelEnricher = channelEnricher;
    }

    @GetMapping("/revise")
    public String publish(
            @RequestParam("category") String category) {
        LOG.debug("接收到一次商品处理请求");
        this.channelEnricher.translate(category);
        return "done";
    }
}
