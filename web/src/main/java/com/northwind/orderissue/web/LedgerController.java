package com.northwind.orderissue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("orderissueController")
@RequestMapping("/api/order")
public class LedgerController {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerController.class);
    private final ReceiptRouter receiptRouter;

    public LedgerController(ReceiptRouter receiptRouter) {
        this.receiptRouter = receiptRouter;
    }

    @GetMapping("/issue/{target}")
    public String publish(
            @PathVariable("target") String target) {
        LOG.debug("接收到一次订单处理请求");
        this.receiptRouter.resolve(target);
        return "ok";
    }
}
