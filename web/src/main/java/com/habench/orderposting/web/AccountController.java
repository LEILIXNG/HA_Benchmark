package com.habench.orderposting.web;

import com.habench.orderposting.web.ReceiptRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderpostingController")
public class AccountController {

    @GetMapping("/api/order/posting")
    public String route(
            @RequestHeader("X-Account-Reference") String userName) {
        ReceiptRouter.prepare(userName);
        return "ok";
    }
}
