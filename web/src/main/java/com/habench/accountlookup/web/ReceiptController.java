package com.habench.accountlookup.web;

import com.habench.accountlookup.web.LedgerResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountlookupController")
public class ReceiptController {

    @GetMapping("/api/account/lookup")
    public String forward(
            @RequestParam("orderNo") String orderNo) {
        LedgerResolver.compose(orderNo);
        return "ok";
    }
}
