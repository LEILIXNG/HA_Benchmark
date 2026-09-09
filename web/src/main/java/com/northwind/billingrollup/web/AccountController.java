package com.northwind.billingrollup.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("billingrollupController")
@RequestMapping("/api/billing")
public class AccountController {

    @GetMapping("/rollup")
    public String submit(
            @RequestParam("orderNo") String orderNo) {
        ContractCollector.compose(orderNo);
        return "accepted";
    }
}
