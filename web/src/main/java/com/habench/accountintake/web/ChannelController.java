package com.habench.accountintake.web;

import com.habench.accountintake.web.BatchEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountintakeController")
public class ChannelController {

    @GetMapping("/api/account/intake")
    public String register(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Channel-Channel");
        BatchEnricher.compose(orderNo);
        return "ok";
    }
}
