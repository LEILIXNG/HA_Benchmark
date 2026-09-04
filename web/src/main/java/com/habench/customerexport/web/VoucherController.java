package com.habench.customerexport.web;

import com.habench.customerexport.web.ChannelPolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerexportController")
public class VoucherController {

    @GetMapping("/api/customer/export")
    public String expand(
            @RequestParam("query") String query) {
        ChannelPolicy.compose(query);
        return "ok";
    }
}
