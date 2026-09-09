package com.northwind.paymentledger.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("paymentledgerController")
@RequestMapping("/api/payment")
public class TariffController {
    private static final Logger LOG = LoggerFactory.getLogger(TariffController.class);

    @GetMapping("/ledger")
    public ResponseEntity<String> reconcile(
            @CookieValue("tariff_tag") String label) {
        LOG.debug("开始整理支付字段");
        AccountCollector.route(label);
        return ResponseEntity.ok("accepted");
    }
}
