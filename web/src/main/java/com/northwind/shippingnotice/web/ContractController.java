package com.northwind.shippingnotice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("shippingnoticeController")
@RequestMapping("/api/shipping")
public class ContractController {

    @GetMapping("/notice")
    public String translate(
            @RequestParam("userName") String userName) {
        AccountAdapter.enrich(userName);
        return "done";
    }
}
