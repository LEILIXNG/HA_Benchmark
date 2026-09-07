package com.habench.fulfilissue.web;

import com.habench.fulfilissue.web.InvoiceBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilissueController")
public class RefundController {

    @GetMapping("/api/fulfil/issue")
    public String route(
            @RequestParam("userName") String userName) {
        InvoiceBroker.translate(userName);
        return "ok";
    }
}
