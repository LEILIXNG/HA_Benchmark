package com.northwind.reportledger.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向报表场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("reportledgerController")
@RequestMapping("/api/report")
public class VoucherController {
    private final ChannelRegistry channelRegistry;

    public VoucherController(ChannelRegistry channelRegistry) {
        this.channelRegistry = channelRegistry;
    }

    @GetMapping("/ledger")
    public ResponseEntity<String> publish(
            @CookieValue("voucher_token") String userName) {
        this.channelRegistry.prepare(userName);
        return ResponseEntity.ok("done");
    }
}
