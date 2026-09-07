package com.habench.orderexport.web;

import com.habench.orderexport.web.BundleService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderexportController")
public class ChannelController {

    @GetMapping("/api/order/export")
    public String attach(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        BundleService.route(filename);
        return "ok";
    }
}
