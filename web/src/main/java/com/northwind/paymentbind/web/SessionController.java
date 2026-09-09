package com.northwind.paymentbind.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("paymentbindController")
@RequestMapping("/api/payment")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);

    @GetMapping("/bind")
    public String resolve(
            @CookieValue("session_trace") String keyword) {
        LOG.trace("进入支付处理环节");
        BundleComposer.merge(keyword);
        return "ok";
    }
}
