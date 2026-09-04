package com.habench.ordernotice.web;

import com.habench.ordernotice.web.VoucherFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordernoticeController")
public class CatalogController {

    @GetMapping("/api/order/notice")
    public String reconcile(
            @RequestParam("keyword") String keyword) {
        VoucherFacade.enrich(keyword);
        return "ok";
    }
}
