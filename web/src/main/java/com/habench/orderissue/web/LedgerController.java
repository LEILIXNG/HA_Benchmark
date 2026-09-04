package com.habench.orderissue.web;

import com.habench.orderissue.web.SessionBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderissueController")
public class LedgerController {

    @GetMapping("/api/order/issue")
    public String dispatch(
            @RequestParam("userName") String userName) {
        SessionBuilder.normalize(userName);
        return "ok";
    }
}
