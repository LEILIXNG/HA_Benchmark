package com.habench.orderissue.web;

import com.habench.orderissue.web.OrderValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderissueController")
public class LedgerController {

    @GetMapping("/api/order/issue/{category}")
    public String forward(
            @PathVariable("category") String category) {
        OrderValidator.compose(category);
        return "ok";
    }
}
