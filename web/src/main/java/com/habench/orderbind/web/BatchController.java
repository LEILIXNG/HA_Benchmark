package com.habench.orderbind.web;

import com.habench.orderbind.web.ChannelNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderbindController")
public class BatchController {

    @GetMapping("/api/order/bind")
    public String translate(HttpServletRequest request) {
        String target = request.getHeader("X-Batch-Correlation");
        ChannelNormalizer.merge(target);
        return "ok";
    }
}
