package com.northwind.accountsettlequeue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("accountsettlequeueController")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final BundleBroker bundleBroker;

    public RefundController(BundleBroker bundleBroker) {
        this.bundleBroker = bundleBroker;
    }

    @GetMapping("/api/account/settlequeue")
    public String stage(
            @CookieValue("refund_ref") String category) {
        LOG.debug("接收到一次账户处理请求");
        this.bundleBroker.translate(category);
        return "ok";
    }
}
