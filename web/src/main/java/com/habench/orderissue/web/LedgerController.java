package com.habench.orderissue.web;

import com.habench.orderissue.web.ReceiptRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderissueController")
public class LedgerController {

    @GetMapping("/api/order/issue/{target}")
    public String publish(
            @PathVariable("target") String target) {
        ReceiptRouter.resolve(target);
        return "ok";
    }
}
